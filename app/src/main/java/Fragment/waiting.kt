package Fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.activity.OnDataChangeListener
import com.example.activity.R
import com.example.activity.data.BlueWayCore
import com.example.activity.database.DatabaseHelper
import getApiResult
import kotlin.concurrent.thread

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * 알람 기능 - 지하철 설정 5 (대기 모드) - 상단 Fragemnt
 */
class waiting : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    lateinit var befoteStation: TextView // 이전 역
    lateinit var currentStation: TextView  // 현재 역
    lateinit var afterStation: TextView  // 다음 역
    lateinit var imageViewRefresh: ImageView // 새로 고침 버튼


    // 부모 액티비티에서 구현한 리스너 인터페이스
    private var listener: OnDataChangeListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)

        // 부모 액티비티에서 리스너를 가져옴
        if (context is OnDataChangeListener) {
            listener = context
        } else {
            throw ClassCastException("$context must implement OnDataChangeListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_waiting, container, false)

        val dbHelper = DatabaseHelper(requireContext())
        val dataList = dbHelper.selectAllData()

        befoteStation = view.findViewById(R.id.befoteStation)
        currentStation = view.findViewById(R.id.currentStation)
        afterStation = view.findViewById(R.id.afterStation)
        imageViewRefresh = view.findViewById(R.id.imageViewRefresh)

        currentStation.text = BlueWayCore.getBoardingTrainData()?.arvlMsg3

        for ((index, trainInfo) in dataList.withIndex()) {
            if (trainInfo.SUBWAY_ID == 1001 && trainInfo.STATN_NM == BlueWayCore.getBoardingTrainData()?.arvlMsg3) {
                befoteStation.text = dataList[index - 1].STATN_NM
            }

            if (trainInfo.SUBWAY_ID == 1001 && trainInfo.STATN_NM == BlueWayCore.getBoardingTrainData()?.arvlMsg3) {
                afterStation.text = dataList[index + 1].STATN_NM
            }
        }



        imageViewRefresh.setOnClickListener {
            // 새로 고침 버튼이 클릭 되면 탑승 열차로 선정 했던 열차가 아직 api에 검색되는지 확인 해보고 있다면
            // 탑승 열차의 현재 위치와 도착 역까지의 남은 정거장 수를 업데이트 시켜 준다
            // 만약 일치 하는 열차가 없다면 탑승 해야 할 열차가 이미 도착 역보다 훨씬 지나가 버린 상황일 것이다
            thread {
                val lstTrain = BlueWayCore.getStationId()?.let { it1 -> getApiResult(it1) }
                lstTrain?.forEach {
                    // 이전에 검색 했었던 탑승 열차 정보가 아직 api 호출 시에 남아있는 데이터라면
                    if (it.btrainNo == (BlueWayCore.getBoardingTrainData()?.btrainNo ?: "0")) {
                        BlueWayCore.saveBoardingTrainData(it)

                        requireActivity().runOnUiThread {
                            currentStation.text = BlueWayCore.getBoardingTrainData()?.arvlMsg3
                        }


                        for ((index, trainInfo) in dataList.withIndex()) {
                            if (trainInfo.SUBWAY_ID == 1001 && trainInfo.STATN_NM == BlueWayCore.getBoardingTrainData()?.arvlMsg3) {
                                requireActivity().runOnUiThread {
                                    befoteStation.text = dataList[index - 1].STATN_NM
                                }
                            }

                            if (trainInfo.SUBWAY_ID == 1001 && trainInfo.STATN_NM == BlueWayCore.getBoardingTrainData()?.arvlMsg3) {
                                requireActivity().runOnUiThread {
                                    afterStation.text = dataList[index + 1].STATN_NM
                                }
                            }
                        }
                    }
                }
            }

            // 액티비티 입장에서도 00 정거장 전을 표시하는 텍스트 부분을 refresh 시켜줘야 하기떄문에 액티비티로 신호 전달
            listener?.onDataRefresh()
        }

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            waiting().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
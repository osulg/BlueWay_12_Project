package com.example.activity

import Fragment.alarm
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.activity.data.BlueWayCore
import com.example.activity.databinding.ActivitySub1Binding
import getApiResult
import kotlin.concurrent.thread


class Sub1Activity : AppCompatActivity() {

    private var mBinding: ActivitySub1Binding? = null
    private val binding get() = mBinding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivitySub1Binding.inflate(layoutInflater)
        setContentView(binding.root)


        //search
        val btn_search: Button = findViewById(R.id.imageViewSearchButton)
        val buttonView = findViewById<LinearLayout>(R.id.buttonView)
        btn_search.setOnClickListener {
            buttonView.removeAllViews()
            val stationId = binding.searchStation.text.toString()

//            thread {
//                val (totalCount,array20) = return_num(stationId)
//                for (num in 1..totalCount!!) {
//                    val stationButton = Button(this)
//
////                    val generatedId=View.generateViewId()
////                    stationButton.id=generatedId
//
//
//                    val layoutParams = LinearLayout.LayoutParams(
//                        LinearLayout.LayoutParams.MATCH_PARENT,
//                        LinearLayout.LayoutParams.WRAP_CONTENT
//                    )
//
//                    val resultId = main(stationId, array20[num-1])
//                    stationButton.layoutParams = layoutParams
//                    stationButton.text = resultId
//
////                    val clickedButtonStationNum=num-1
//
//                    stationButton.setOnClickListener {
////                            val updnLine= UpDown(stationId,clickedButtonStationNum)
//                        val intent = Intent(this, Sub11Activity::class.java)
//                        intent.putExtra("currentStation",stationId)
////                            intent.putExtra("currentStation",stationId)
//                        startActivity(intent)
//
//                    }
//                    runOnUiThread {
//                        buttonView.addView(stationButton)
//                    }
//                }
//            }

            thread {
                val lstTrain = getApiResult(stationId)
                for ((index, train) in lstTrain.withIndex()) {
                    val stationButton = Button(this)
                    val layoutParams = LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                    )

                    stationButton.layoutParams = layoutParams
                    stationButton.text = "${train.trainLineNm} | 현재 역 : ${train.arvlMsg2}"
                    stationButton.id = index
                    stationButton.setOnClickListener {
                        val intent = Intent(this, Sub11Activity::class.java)
                        // 싱글톤에 저장이 필요한 값들 저장
                        BlueWayCore.saveStationId(stationId)
                        BlueWayCore.saveBoardingTrainData(lstTrain[stationButton.id])
                        startActivity(intent)
                    }
                    runOnUiThread {
                        buttonView.addView(stationButton)
                    }
                }
            }

        }

        // fragment
        val fragment1 = alarm()
        supportFragmentManager.beginTransaction()
            .replace(R.id.sub1frame, fragment1)
            .addToBackStack(null)
            .commit()

        //생성된 버튼 삭제 (새로고침)
        val refreshView: Button = findViewById(R.id.ButtonRefresh)
        refreshView.setOnClickListener {
            buttonView.removeAllViews()
        }

        //Main Back
        val btn_bmain: Button = findViewById(R.id.imageViewArrow)
        btn_bmain.setOnClickListener {
            finish()
        }

    }
}
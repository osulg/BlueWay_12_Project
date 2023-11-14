package com.example.activity

import Fragment.alarm
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import com.example.activity.databinding.ActivitySub2Binding
import kotlin.concurrent.thread

class Sub2Activity : AppCompatActivity() {
    private var mBinding: ActivitySub2Binding? = null
    private val binding get() = mBinding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivitySub2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // fragment
        val btn_search: Button = findViewById(R.id.imageViewSearchButton2)
        val buttonView = findViewById<LinearLayout>(R.id.buttonView2)
        btn_search.setOnClickListener {
            buttonView.removeAllViews()
            val stationId = binding.searchStation2.text.toString()

            thread {
                val (totalCount,array20) = return_num(stationId)
                for (num in 1..totalCount!!) {
                    val stationButton = Button(this)

//                    val generatedId=View.generateViewId()
//                    stationButton.id=generatedId


                    val layoutParams = LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                    )

                    val resultId = main(stationId, array20[num-1])
                    stationButton.layoutParams = layoutParams
                    stationButton.text = resultId

//                    val clickedButtonStationNum=num-1

                    stationButton.setOnClickListener {
//                            val updnLine= UpDown(stationId,clickedButtonStationNum)
                        val intent = Intent(this, Sub21Activity::class.java)
                        intent.putExtra("currentStation",stationId)
//                            intent.putExtra("currentStation",stationId)
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
            .replace(R.id.sub2frame, fragment1)
            .addToBackStack(null)
            .commit()

        //생성된 버튼 삭제 (새로고침)
        val refreshView: Button = findViewById(R.id.imageViewRefresh2)
        refreshView.setOnClickListener {
            buttonView.removeAllViews()
        }

        //Main Back
        val btn_bmain: Button = findViewById(R.id.imageViewArrowButton)
        btn_bmain.setOnClickListener {
            finish()
        }

    }
}
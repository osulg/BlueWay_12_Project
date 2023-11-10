package com.example.activity

import Fragment.alarm
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.view.ViewCompat
import com.example.activity.databinding.ActivitySub11Binding
import com.example.activity.databinding.ActivitySub1Binding
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
            val stationId = binding.searchStation.text.toString()

            thread {
                val (totalCount,array20) = return_num(stationId)
                for (num in 1..totalCount!!) {
                    val stationButton = Button(this)
                    val layoutParams = LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                    )
                    thread {
                        val resultId = main(stationId, array20[num-1])
                        stationButton.layoutParams = layoutParams
                        stationButton.text = resultId
                        stationButton.id = ViewCompat.generateViewId()
                        runOnUiThread {
                            buttonView.addView(stationButton)
                        }
                    }
                    stationButton.setOnClickListener {
                        val intent = Intent(this, Sub11Activity::class.java)
                        startActivity(intent)
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
}
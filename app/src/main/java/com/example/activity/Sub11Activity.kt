package com.example.activity

import Fragment.alarm
import Fragment.alarmDetail
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import com.example.activity.R.id.btn_bsub1
import com.example.activity.R.id.sub11frame
import com.example.activity.R.id.sub1frame
import com.example.activity.data.BlueWayCore
import kotlin.concurrent.thread

class Sub11Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub11)

        val transaction = supportFragmentManager.beginTransaction()
        val currentFragment = supportFragmentManager.findFragmentById(R.id.sub1frame)
        if (currentFragment != null) {
            transaction.remove(alarm())

            // fragment
            val fragment11 = alarmDetail()
            supportFragmentManager.beginTransaction()
                .add(R.id.sub11frame, fragment11)
                .addToBackStack(null)
                .commit()
        }

        thread {
            val buttonView = findViewById<LinearLayout>(R.id.buttonView2Container)

//            val finalStation=intent.getStringExtra("finalStation")
//            val currentStation=intent.getStringExtra("currentStation")
            val arrayStation=upDown1()

            for (num in 0..97)
            {
                val stationButton = Button(this)

                val layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                stationButton.layoutParams = layoutParams
                stationButton.text= arrayStation[num]

                stationButton.setOnClickListener {
                    val intent = Intent(this, Sub13Activity::class.java)
//                    intent.putExtra("arriveStation",arrayStation[num])
//                    intent.putExtra("currentStation",currentStation)
                    BlueWayCore.saveArrivedStationName(arrayStation[num])
                    startActivity(intent)
                }

                runOnUiThread {
                    buttonView.addView(stationButton)
                }

//                val currentStation=intent.getStringExtra("currentStation")



            }

        }


        /*// fragment
        val fragment11 = alarm()
        supportFragmentManager.beginTransaction()
            .add(R.id.sub11frame, fragment11)
            .addToBackStack(null)
            .commit()*/

        //Sub1 Back
        val btn_bsub1: Button = findViewById(R.id.btn_bsub1)
        btn_bsub1.setOnClickListener {
            finish()
        }

    }
}
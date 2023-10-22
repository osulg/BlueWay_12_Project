package com.example.activity

import Fragment.alarm
import Fragment.alarmDetail
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.activity.R.id.btn_bsub1
import com.example.activity.R.id.sub11frame
import com.example.activity.R.id.sub1frame

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

        //Sub12 Go
        val btn_sub12: Button = findViewById(R.id.btn_sub12)
        btn_sub12.setOnClickListener {
            val intent = Intent(this, Sub12Activity::class.java)
            startActivity(intent)
        }

    }
}
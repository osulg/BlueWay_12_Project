package com.example.activity

import Fragment.alarm
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Sub13Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub13)

        val transaction = supportFragmentManager.beginTransaction()
        val currentFragment = supportFragmentManager.findFragmentById(R.id.sub12frame)
        if (currentFragment != null) {
            transaction.remove(alarm())

            // fragment
            val fragment13 = alarm()
            supportFragmentManager.beginTransaction()
                .add(R.id.sub13frame, fragment13)
                .addToBackStack(null)
                .commit()
        }

        /*// fragment
        val fragment13 = alarm()
        supportFragmentManager.beginTransaction()
            .replace(R.id.sub13frame, fragment13)
            .addToBackStack(null)
            .commit()*/

        //Sub12 Back
        val btn_bsub12: Button =findViewById(R.id.btn_bsub12)
        btn_bsub12.setOnClickListener {
            finish()
        }

        //Sub14 Go(소리)
        val btn_sub14s:Button=findViewById(R.id.btn_sub14s)
        btn_sub14s.setOnClickListener {
            val intent = Intent(this,Sub14Activity::class.java)
            startActivity(intent)
        }

        //Sub14 Go(진동)
        val btn_sub14v:Button=findViewById(R.id.btn_sub14v)
        btn_sub14v.setOnClickListener {
            val intent = Intent(this,Sub14Activity::class.java)
            startActivity(intent)
        }
    }


}
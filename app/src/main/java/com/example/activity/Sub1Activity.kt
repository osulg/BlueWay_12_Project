package com.example.activity

import Fragment.alarm
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Sub1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub1)



        // fragment
        val fragment1 = alarm()
        supportFragmentManager.beginTransaction()
            .replace(R.id.sub1frame, fragment1)
            .addToBackStack(null)
            .commit()

        //Main Back
        val btn_bmain: Button =findViewById(R.id.btn_bmain)
        btn_bmain.setOnClickListener {
            finish()
        }

        //sub11 Go
        val btn_sub11:Button=findViewById(R.id.btn_sub11)
        btn_sub11.setOnClickListener {
            val intent = Intent(this,Sub11Activity::class.java)
            startActivity(intent)
        }
    }
}
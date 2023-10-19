package com.example.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Sub2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub2)

        //Main Back
        val btn_bmain1: Button =findViewById(R.id.btn_bmain1)
        btn_bmain1.setOnClickListener {
            finish()
        }

        //sub21 Go
        val btn_sub21:Button=findViewById(R.id.btn_sub21)
        btn_sub21.setOnClickListener {
            val intent = Intent(this,Sub21Activity::class.java)
            startActivity(intent)
        }
    }
}
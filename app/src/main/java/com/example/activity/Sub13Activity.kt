package com.example.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Sub13Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub13)

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
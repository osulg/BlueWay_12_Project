package com.example.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Sub14Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub14)

        //Sub13 Back
        val btn_bsub13: Button =findViewById(R.id.btn_bsub13)
        btn_bsub13.setOnClickListener {
            finish()
        }

        //Sub15 Go
        val btn_sub15:Button=findViewById(R.id.btn_sub15)
        btn_sub15.setOnClickListener {
            val intent = Intent(this,Sub15Activity::class.java)
            startActivity(intent)
        }

    }
}
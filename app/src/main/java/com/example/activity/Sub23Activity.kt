package com.example.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Sub23Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub23)

        //Sub22 Back
        val btn_bsub22: Button =findViewById(R.id.btn_bsub22)
        btn_bsub22.setOnClickListener {
            finish()
        }

        //sub23 Go
        val btn_main3:Button=findViewById(R.id.btn_bmain3)
        btn_main3.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}
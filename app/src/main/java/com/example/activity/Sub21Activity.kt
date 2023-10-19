package com.example.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Sub21Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub21)

        //Sub2 Back
        val btn_bsub2: Button =findViewById(R.id.btn_bsub2)
        btn_bsub2.setOnClickListener {
            finish()
        }

        //sub21 Go
        val btn_sub22:Button=findViewById(R.id.btn_sub22)
        btn_sub22.setOnClickListener {
            val intent = Intent(this,Sub22Activity::class.java)
            startActivity(intent)
        }
    }
}
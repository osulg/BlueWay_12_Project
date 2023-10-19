package com.example.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.activity.R.id.btn_bsub1

class Sub11Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub11)

        //Sub1 Back
        val btn_bsub1: Button =findViewById(R.id.btn_bsub1)
        btn_bsub1.setOnClickListener {
            finish()
        }

        //Sub12 Go
        val btn_sub12:Button=findViewById(R.id.btn_sub12)
        btn_sub12.setOnClickListener {
            val intent = Intent(this,Sub12Activity::class.java)
            startActivity(intent)
        }
    }
}
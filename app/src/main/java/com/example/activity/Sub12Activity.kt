package com.example.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Sub12Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub12)

        //Sub11 Back
        val btn_bsub11: Button =findViewById(R.id.btn_bsub11)
        btn_bsub11.setOnClickListener {
            finish()
        }

        // Sub13 Go1
        val btn_select1:Button=findViewById(R.id.btn_select1)
        btn_select1.setOnClickListener {
            val intent = Intent(this,Sub13Activity::class.java)
            startActivity(intent)
        }

        // Sub13 Go2
        val btn_select2:Button=findViewById(R.id.btn_select2)
        btn_select2.setOnClickListener {
            val intent = Intent(this,Sub13Activity::class.java)
            startActivity(intent)
        }

        // Sub13 Go3
        val btn_select3:Button=findViewById(R.id.btn_select3)
        btn_select3.setOnClickListener {
            val intent = Intent(this,Sub13Activity::class.java)
            startActivity(intent)
        }
    }
}
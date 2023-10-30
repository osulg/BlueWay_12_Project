package com.example.activity

import Fragment.alarm
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Sub12Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub12)

        val transaction = supportFragmentManager.beginTransaction()
        val currentFragment = supportFragmentManager.findFragmentById(R.id.sub11frame)
        if (currentFragment != null) {
            transaction.remove(alarm())

            // fragment
            val fragment12 = alarm()
            supportFragmentManager.beginTransaction()
                .add(R.id.sub12frame, fragment12)
                .addToBackStack(null)
                .commit()
        }

        /*// fragment
        val fragment12 = alarm()
        supportFragmentManager.beginTransaction()
            .replace(R.id.sub12frame, fragment12)
            .addToBackStack(null)
            .commit()*/

        //Sub11 Back
        val btn_bsub11: Button =findViewById(R.id.btn_bsub11)
        btn_bsub11.setOnClickListener {
            finish()
        }

        // Sub13 Go1
        val btn_select1:Button=findViewById(R.id.firstButton)
        btn_select1.setOnClickListener {
            val intent = Intent(this,Sub13Activity::class.java)
            startActivity(intent)
        }

        // Sub13 Go2
        val btn_select2:Button=findViewById(R.id.secondButton)
        btn_select2.setOnClickListener {
            val intent = Intent(this,Sub13Activity::class.java)
            startActivity(intent)
        }

        // Sub13 Go3
        val btn_select3:Button=findViewById(R.id.thirdButton)
        btn_select3.setOnClickListener {
            val intent = Intent(this,Sub13Activity::class.java)
            startActivity(intent)
        }
    }
}
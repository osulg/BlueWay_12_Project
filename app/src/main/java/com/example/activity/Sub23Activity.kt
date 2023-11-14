package com.example.activity

import Fragment.alarm
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Sub23Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub23)

        val transaction = supportFragmentManager.beginTransaction()
        val currentFragment = supportFragmentManager.findFragmentById(R.id.sub22frame)
        if (currentFragment != null) {
            transaction.remove(alarm())

            // fragment
            val fragment23 = alarm()
            supportFragmentManager.beginTransaction()
                .add(R.id.sub23frame, fragment23)
                .addToBackStack(null)
                .commit()

        }

        /*// fragment
        val fragment23 = alarm()
        supportFragmentManager.beginTransaction()
            .replace(R.id.sub23frame, fragment23)
            .addToBackStack(null)
            .commit()*/

        //sub23 Go
        val btn_main3:Button=findViewById(R.id.btn_sub23)
        btn_main3.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}
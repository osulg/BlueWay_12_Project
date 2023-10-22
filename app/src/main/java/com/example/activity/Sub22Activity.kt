package com.example.activity

import Fragment.alarm
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Sub22Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub22)

        val transaction = supportFragmentManager.beginTransaction()
        val currentFragment = supportFragmentManager.findFragmentById(R.id.sub21frame)
        if (currentFragment != null) {
            transaction.remove(alarm())

            // fragment
            val fragment22 = alarm()
            supportFragmentManager.beginTransaction()
                .add(R.id.sub22frame, fragment22)
                .addToBackStack(null)
                .commit()

        }

        /*// fragment
        val fragment22 = alarm()
        supportFragmentManager.beginTransaction()
            .replace(R.id.sub22frame, fragment22)
            .addToBackStack(null)
            .commit()*/

        //Sub21 Back
        val btn_bsub21: Button =findViewById(R.id.btn_bsub21)
        btn_bsub21.setOnClickListener {
            finish()
        }

        //sub23 Go
        val btn_sub23:Button=findViewById(R.id.btn_sub23)
        btn_sub23.setOnClickListener {
            val intent = Intent(this,Sub23Activity::class.java)
            startActivity(intent)
        }
    }
}
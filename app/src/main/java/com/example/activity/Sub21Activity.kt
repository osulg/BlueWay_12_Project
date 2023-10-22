package com.example.activity

import Fragment.alarm
import Fragment.alarmDetail
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Sub21Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub21)

        val transaction = supportFragmentManager.beginTransaction()
        val currentFragment = supportFragmentManager.findFragmentById(R.id.sub2frame)
        if (currentFragment != null) {
            transaction.remove(alarm())

            // fragment
            val fragment21 = alarmDetail()
            supportFragmentManager.beginTransaction()
                .add(R.id.sub21frame, fragment21)
                .addToBackStack(null)
                .commit()

        }

        /*// fragment
        val fragment21 = alarm()
        supportFragmentManager.beginTransaction()
            .replace(R.id.sub21frame, fragment21)
            .addToBackStack(null)
            .commit()*/

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
package com.example.activity

import Fragment.alarm
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

/**
 * 알람 기능 - 지하철 설정 6 (알람 활성화)
 */
class Sub15Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub15)

        val transaction = supportFragmentManager.beginTransaction()
        val currentFragment = supportFragmentManager.findFragmentById(R.id.sub14frame)
        if (currentFragment != null) {
            transaction.remove(alarm())

            // fragment
            val fragment15=alarm()
            supportFragmentManager.beginTransaction()
                .add(R.id.sub15frame, fragment15)
                .addToBackStack(null)
                .commit()
        }

        /*// fragment
        val fragment15=alarm()
        supportFragmentManager.beginTransaction()
            .replace(R.id.sub15frame, fragment15)
            .addToBackStack(null)
            .commit()*/

        //Main Go
        val btn_main2: Button =findViewById(R.id.btn_bmain2)
        btn_main2.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finishAffinity()
        }
    }
}
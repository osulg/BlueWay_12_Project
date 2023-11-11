package com.example.activity

import Fragment.alarm
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.widget.Button
import android.widget.Toast

class Sub14Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub14)

        val transaction = supportFragmentManager.beginTransaction()
        val currentFragment = supportFragmentManager.findFragmentById(R.id.sub13frame)
        if (currentFragment != null) {
            transaction.remove(alarm())

            // fragment
            val fragment14 = alarm()
            supportFragmentManager.beginTransaction()
                .add(R.id.sub14frame, fragment14)
                .addToBackStack(null)
                .commit()

        }

        /*// fragment
        val fragment14 = alarm()
        supportFragmentManager.beginTransaction()
            .replace(R.id.sub14frame, fragment14)
            .addToBackStack(null)
            .commit()*/

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

        // 소리 및 진동 구현
        val isSoundButton = intent.getBooleanExtra("isSoundButton",false)
        var mp1: MediaPlayer = MediaPlayer.create(this,R.raw.alarmsound)
        val vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator

        if(isSoundButton){
            mp1.start()
            Toast.makeText(this, "Sound Button Clicked", Toast.LENGTH_LONG).show()
        }
        else{
            //vibrator.vibrate(vibrationEffect)
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                vibrator.vibrate(VibrationEffect.createOneShot(5000, VibrationEffect.DEFAULT_AMPLITUDE))
            }
            else{
                vibrator.vibrate(5000)
            }
            Toast.makeText(this, "Vibration Button Clicked", Toast.LENGTH_LONG).show()
        }
    }
}
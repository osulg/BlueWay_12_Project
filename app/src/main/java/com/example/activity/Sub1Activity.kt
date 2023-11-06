package com.example.activity

import Fragment.alarm
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.activity.databinding.ActivitySub11Binding
import com.example.activity.databinding.ActivitySub1Binding
import kotlin.concurrent.thread


class Sub1Activity : AppCompatActivity() {

    private var mBinding:ActivitySub1Binding?=null
    private val binding get()=mBinding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding=ActivitySub1Binding.inflate(layoutInflater)
        setContentView(binding.root)


        //search
        val btn_search:Button=findViewById(R.id.imageViewSearchButton)

        btn_search.setOnClickListener{
            val stationId=binding.searchStation.text.toString()
            thread {
                var resultId=main(stationId)
                runOnUiThread{ Toast.makeText(this@Sub1Activity, resultId, Toast.LENGTH_LONG).show()}
            }
        }

        // fragment
        val fragment1 = alarm()
        supportFragmentManager.beginTransaction()
            .replace(R.id.sub1frame, fragment1)
            .addToBackStack(null)
            .commit()

        //Main Back
        val btn_bmain: Button =findViewById(R.id.imageViewArrow)
        btn_bmain.setOnClickListener {
            finish()
        }

        //sub11 Go
        val btn_sub11:Button=findViewById(R.id.btn_sub11)
        btn_sub11.setOnClickListener {
            val intent = Intent(this,Sub11Activity::class.java)
            startActivity(intent)
        }
    }
}
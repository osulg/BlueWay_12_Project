package com.example.activity

import Fragment.select
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.selects.select
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    //private lateinit var viewModel: viewModel1

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Base_Theme_Activity)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment = select()
        supportFragmentManager.beginTransaction()
            .replace(R.id.imageView26, fragment)
            .commit()

        thread {
            val result=main()
            runOnUiThread{ Toast.makeText(this@MainActivity, "API 샘플 테스트:${result}", Toast.LENGTH_LONG).show()}
        }


        /*val fragment2 = select()
        supportFragmentManager.beginTransaction()
            .replace(R.id.imageView, fragment2)
            .commit()*/

        /*val fragment3 = select()
        supportFragmentManager.beginTransaction()
            .replace(R.id.textView, fragment3)
            .addToBackStack(null)
            .commit()

        val fragment4 = select()
        supportFragmentManager.beginTransaction()
            .replace(R.id.textView12, fragment4)
            .addToBackStack(null)
            .commit()*/


        //Sub1 Go
        val btn_sub1:Button=findViewById(R.id.btn_sub1)
        btn_sub1.setOnClickListener {
            val intent = Intent(this,Sub1Activity::class.java)
            startActivity(intent)
        }

        //Sub2 Go
        val btn_sub2:Button=findViewById(R.id.btn_sub2)
        btn_sub2.setOnClickListener {
            val intent = Intent(this,Sub2Activity::class.java)
            startActivity(intent)
        }

    }
}


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
import android.widget.TextView
import android.widget.Toast
import com.example.activity.data.BlueWayCore
import com.example.activity.database.DatabaseHelper
import kotlin.math.abs

/**
 * 알람 기능 - 지하철 설정 4 & 지하철 설정 5 (대기 모드)
 */

// 자식 프래그먼트의 신호 값을 받기위한 리스너 인터페이스
interface OnDataChangeListener {
    fun onDataRefresh()
}
class Sub14Activity : AppCompatActivity(), OnDataChangeListener {

    lateinit var howManyNumber : TextView // 몇 정거장 전
    lateinit var directionName : TextView // XX행 (방면)

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

        directionName = findViewById(R.id.directionName)
        howManyNumber = findViewById(R.id.howManyNumber)

        directionName.text = BlueWayCore.getBoardingTrainData()?.trainLineNm?.split("-")?.get(0)?.trim() ?: "XX행"

        val boardingName = BlueWayCore.getBoardingTrainData()?.arvlMsg3
        val arriveName = BlueWayCore.getArrivedStationName()

        var boardingPositionIndex = 0
        var arrivePositionIndex = 0

        val dbHelper = DatabaseHelper(this@Sub14Activity)
        val dataList = dbHelper.selectAllData()
        for ((index, trainInfo) in dataList.withIndex()) {
            if (trainInfo.SUBWAY_ID != 1001)
                continue

            if(trainInfo.STATN_NM == boardingName) {
                boardingPositionIndex = index
            }

            if(trainInfo.STATN_NM == arriveName) {
                arrivePositionIndex = index
            }
        }

        print("탑승 열차 현재 역 : $boardingName , 도착역 : $arriveName\n")
        print("탑승 열차 현재 역 index : $boardingPositionIndex , 도착역 index : $arrivePositionIndex\n")
        howManyNumber.text = "${abs(arrivePositionIndex - boardingPositionIndex)}"


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
    }

    override fun onDataRefresh() {
        // 자식 프래그먼트로 부터 리프레쉬 버튼 클릭 신호를 받는다
        val boardingName = BlueWayCore.getBoardingTrainData()?.arvlMsg3
        val arriveName = BlueWayCore.getArrivedStationName()

        var boardingPositionIndex = 0
        var arrivePositionIndex = 0

        val dbHelper = DatabaseHelper(this@Sub14Activity)
        val dataList = dbHelper.selectAllData()
        for ((index, trainInfo) in dataList.withIndex()) {
            if (trainInfo.SUBWAY_ID != 1001)
                continue

            if(trainInfo.STATN_NM == boardingName) {
                boardingPositionIndex = index
            }

            if(trainInfo.STATN_NM == arriveName) {
                arrivePositionIndex = index
            }
        }

        print("탑승 열차 현재 역 : $boardingName , 도착역 : $arriveName\n")
        print("탑승 열차 현재 역 index : $boardingPositionIndex , 도착역 index : $arrivePositionIndex\n")
        howManyNumber.text = "${abs(arrivePositionIndex - boardingPositionIndex)}"


    }
}
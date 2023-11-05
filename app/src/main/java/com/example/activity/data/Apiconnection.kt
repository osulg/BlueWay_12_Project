package com.example.activity.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Apiconnection {
    companion object{
        private  const val  Base_URL="http://swopenapi.seoul.go.kr/api/subway/"
        private var INSTANCE: Retrofit?=null


        fun getInstance():Retrofit{
            if (INSTANCE ==null){
                INSTANCE =Retrofit.Builder()
                    .baseUrl(Base_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return  INSTANCE!!
        }
    }
}
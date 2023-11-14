package com.example.activity.data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface SubwayService {
    @GET("nearest_station")
    fun getRealtimeArrival(
        @Query("lat") lat: String,
        @Query("lon") lon: String,
        @Query("key") key: String
    ): Call<RealtimeArrival>
}
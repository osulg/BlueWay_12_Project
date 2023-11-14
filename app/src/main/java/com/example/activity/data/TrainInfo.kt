package com.example.activity.data

/**
 * 열차 정보 (sqlite db)
 */
data class TrainInfo(
    val SUBWAY_ID: Int,     // ex) 1001
    val STATN_ID: Int,      // ex) 1001000100
    val STATN_NM: String,   // ex) 소요산
    val LINE_NUMBER: String // ex) 1호선
)

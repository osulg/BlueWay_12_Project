package com.example.activity

import android.widget.Button
import com.google.gson.JsonParser
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder

fun main(): String? {

    var station="서울"
    val urlBuilder = StringBuilder("http://swopenAPI.seoul.go.kr/api/subway/") /*URL*/
    urlBuilder.append(
        "/" + URLEncoder.encode(
            "566945517364687439357769727444",
            "UTF-8"
        )
    ) /*인증키 (sample사용시에는 호출시 제한됩니다.)*/
    urlBuilder.append("/" + URLEncoder.encode("json", "UTF-8")) /*요청파일타입 (xml,xmlf,xls,json) */
    urlBuilder.append(
        "/" + URLEncoder.encode(
            "realtimeStationArrival",
            "UTF-8"
        )
    ) /*서비스명 (대소문자 구분 필수입니다.)*/
    urlBuilder.append("/" + URLEncoder.encode("0", "UTF-8")) /*요청시작위치 (sample인증키 사용시 5이내 숫자)*/
    urlBuilder.append(
        "/" + URLEncoder.encode(
            "10",
            "UTF-8"
        )
    ) /*요청종료위치(sample인증키 사용시 5이상 숫자 선택 안 됨)*/
    // 상위 5개는 필수적으로 순서바꾸지 않고 호출해야 합니다.

    // 서비스별 추가 요청 인자이며 자세한 내용은 각 서비스별 '요청인자'부분에 자세히 나와 있습니다.
    urlBuilder.append("/" + URLEncoder.encode("${station}", "UTF-8")) /* 서비스별 추가 요청인자들 */
    val url = URL(urlBuilder.toString())
    val conn = url.openConnection() as HttpURLConnection
    conn.requestMethod = "GET"
    conn.setRequestProperty("Content-type", "application/xml")
    println("Response code: " + conn.responseCode) /* 연결 자체에 대한 확인이 필요하므로 추가합니다.*/
    val rd: BufferedReader

    // 서비스코드가 정상이면 200~300사이의 숫자가 나옵니다.
    rd = if (conn.responseCode >= 200 && conn.responseCode <= 300) {
        BufferedReader(InputStreamReader(conn.inputStream))
    } else {
        BufferedReader(InputStreamReader(conn.errorStream))
    }
    val sb = StringBuilder()
    var line: String?
    while (rd.readLine().also { line = it } != null) {
        sb.append(line)
    }
    rd.close()
    conn.disconnect()

    val parser = JsonParser()
    val jsonObject = parser.parse(sb.toString()).asJsonObject
    val specificData1 = jsonObject.get("realtimeArrivalList").asJsonArray[0].asJsonObject.get("trainLineNm").asString
    return specificData1

}
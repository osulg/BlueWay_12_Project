import com.example.activity.data.RealtimeArrival
import com.google.gson.Gson
import com.google.gson.JsonParser
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder

fun getApiResult(stationId: String): List<RealtimeArrival> {
    val apiKey = "7764737a4c7468643535684a414f50"
    val baseUrl = "http://swopenAPI.seoul.go.kr/api/subway"
    val serviceType = "realtimeStationArrival"
    val start = 0
    val end = 50

    val urlString = "$baseUrl/$apiKey/json/$serviceType/$start/$end/${URLEncoder.encode(stationId, "UTF-8")}"

    val json = sendHttpGetRequest(urlString)

    return parseJsonResponse(json)
}

fun sendHttpGetRequest(urlString: String): String? {
    val url = URL(urlString)
    val conn = url.openConnection() as HttpURLConnection
    conn.requestMethod = "GET"
    conn.setRequestProperty("Content-type", "application/xml")

    val responseCode = conn.responseCode
    println("Response code: $responseCode")

    val inputStream = if (responseCode >= 200 && responseCode <= 300) {
        conn.inputStream
    } else {
        conn.errorStream
    }

    val rd = BufferedReader(InputStreamReader(inputStream))
    val sb = StringBuilder()
    var line: String?

    while (rd.readLine().also { line = it } != null) {
        sb.append(line)
    }

    rd.close()
    conn.disconnect()

    return sb.toString()
}

fun parseJsonResponse(json: String?): List<RealtimeArrival> {
    val lstRealtimeArrival = ArrayList<RealtimeArrival>()

    val parser = JsonParser()
    val jsonObject = parser.parse(json).asJsonObject
    val arrivalJsonList = jsonObject.getAsJsonArray("realtimeArrivalList")
    if (arrivalJsonList.size() > 0) {
//        val trainLineNm = arrivalList[0].asJsonObject.get("trainLineNm").asString
//        return trainLineNm

        for (item in arrivalJsonList) {
            if (item.asJsonObject.get("subwayId").asString.equals("1001"))
                lstRealtimeArrival.add(Gson().fromJson(item, RealtimeArrival::class.java))
        }
    }

    return lstRealtimeArrival
}

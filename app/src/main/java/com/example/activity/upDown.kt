package com.example.activity
import kotlin.math.abs
fun upDown1(): Array<String>
{
    //상행 역
    val soyosan="소요산"
    val yangju="양주"
    val dongdu="동두천"
    val yongsan="용산"
    val kwangwoon="광운대"
    val chri="청량리"
    val jungbu="의정부"

    //하행 역
    val incheon="인천"
    val sinchang="신창"
    val seodongtan="서동탄"
    val dongincheon="동인천"
    val cheonan="천안"

    val line_1_98:Array<String>

    line_1_98=arrayOf("신창" ,"온양온천","배방" ,"탕정", "아산", "쌍용", "봉명", "천안", "두정","직산",
        "성환", "평택", "평택지제" ,"서정리", "송탄", "진위", "오산", "오산대", "세마", "병점", "세류", "수원", "화서",
        "성균관대", "의왕", "당정", "군포", "금정", "명학", "안양", "관악", "금천구청", "독산", "가산디지털단지", "구로",
        "신도림", "영등포", "신길", "대방", "노량진", "용산", "남영", "서울", "시청", "종각", "종로3가", "종로5가", "동대문",
        "동묘앞", "신설동", "제기동", "청량리", "회기", "외대앞", "신이문", "석계", "광운대", "월계", "녹천", "창동", "방학",
        "도봉", "도봉산", "망월사", "회룡", "의정부", "가능", "녹양", "양주", "덕계", "덕정", "지행", "동두천중앙", "보산",
        "동두천", "소요산", "인천", "동인천", "도원", "제물포", "도화", "주안", "간석", "동암", "백운", "부평", "부개", "송내",
        "중동", "부천","소사", "역곡", "온수", "오류동", "개봉", "구일", "광명", "서동탄")


//    val finalStationSplit= Stationstring?.split("행")
//    val finalStation=finalStationSplit?.get(0)

//    var curStationnum=0
//    var finStationnum=0
//    var count=100
//    var userStation=arrayOfNulls<String>(count)

//    if ((finalStation==soyosan)||(finalStation==yangju)||(finalStation==dongdu)
//        ||(finalStation==yongsan)||(finalStation==kwangwoon)||(finalStation==chri)||(finalStation==jungbu))
//    {
//        for (i in 0..75)
//        {
//            if (currentStation==line_1_sinchang_soyosan76[i])
//            {
//                curStationnum=i
//                for (i in 0..75)
//                {
//                    if (finalStation==line_1_sinchang_soyosan76[i])
//                    {
//                        finStationnum=i
//                        break
//                    }
//                }
//                break
//            }
//        }
//
//        count=abs(finStationnum-curStationnum)
//
//        userStation=arrayOfNulls<String>(count+1)
//
//        var k=0
//
//        for (i in curStationnum..finStationnum)
//        {
//            userStation[k]=line_1_sinchang_soyosan76[i]
//            k++
//        }
//
//    }
//    else if ((finalStation==incheon)||(finalStation==sinchang)||(finalStation==seodongtan)
//        ||(finalStation==dongincheon)||(finalStation==cheonan))
//    {
//        for (i in 0..75)
//        {
//            if (currentStation==line_1_sinchang_soyosan76[i])
//            {
//                curStationnum=i
//                for (i in 0..75)
//                {
//                    if (finalStation==line_1_sinchang_soyosan76[i])
//                    {
//                        finStationnum=i
//                        break
//                    }
//                }
//                break
//            }
//        }
//
//        var k=0
//
//        count=abs(finStationnum-curStationnum)
//
//        userStation=arrayOfNulls<String>(count+1)
//
//
//        for (i in finStationnum..curStationnum)
//        {
//            userStation[k]=line_1_sinchang_soyosan76[curStationnum-k]
//            k++
//        }
//
//    }

    return line_1_98
}
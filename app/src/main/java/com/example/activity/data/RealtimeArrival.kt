package com.example.activity.data

data class RealtimeArrival(
    val arvlCd: String, // 도착코드 (0:진입, 1:도착, 2:출발, 3:전역출발, 4:전역진입, 5:전역도착, 99:운행중)
    val arvlMsg2: String, // 첫번째도착메세지 (도착, 출발 , 진입 등)
    val arvlMsg3: String, // 두번째도착메세지 (종합운동장 도착, 12분 후 (광명사거리) 등)
    val barvlDt: String, // 열차도착예정시간 (단위:초)
    val beginRow: Any,
    val bstatnId: String, // 종착지하철역ID
    val bstatnNm: String, // 종착지하철역명
    val btrainNo: String, // 열차번호 (현재운행하고 있는 호선별 열차번호)
    val btrainSttus: String, // 열차종류 (급행,ITX,일반,특급)
    val curPage: Any,
    val endRow: Any,
    val ordkey: String, // 도착예정열차순번 (상하행코드(1자리), 순번(첫번째, 두번째 열차 , 1자리), 첫번째 도착예정 정류장 - 현재 정류장(3자리), 목적지 정류장, 급행여부(1자리))

    val pageRow: Any,
    val recptnDt: String,
    val rowNum: Int,
    val selectedCount: Int,
    val statnFid: String, // 이전지하철역ID
    val statnId: String, // 지하철역ID
    val statnList: String, // 연계지하철역ID //(1002000233, 1007000000)
    val statnNm: String, // 지하철역명
    val statnTid: String, // 다음지하철역ID
    val subwayHeading: Any,
    val subwayId: String,
    val subwayList: String, // 연계호선ID (1002, 1007 등 연계대상 호선ID)
    val subwayNm: Any,
    val totalCount: Int,
    val trainCo: Any,
    val trainLineNm: String,
    val trnsitCo: String,
    val updnLine: String
)

//{
//    "beginRow": null,
//    "endRow": null,
//    "curPage": null,
//    "pageRow": null,
//    "totalCount": 16,
//    "rowNum": 4,
//    "selectedCount": 5,
//    "subwayId": "1001",
//    "subwayNm": null,
//    "updnLine": "상행",
//    "trainLineNm": "청량리행 - 시청방면",
//    "subwayHeading": null,
//    "statnFid": "1001000134",
//    "statnTid": "1001000132",
//    "statnId": "1001000133",
//    "statnNm": "서울",
//    "trainCo": null,
//    "trnsitCo": "4",
//    "ordkey": "01001청량리0",
//    "subwayList": "1001,1004,1063,1065",
//    "statnList": "1001000133,1004000426,1063080313,1065006501",
//    "btrainSttus": "일반",
//    "barvlDt": "180",
//    "btrainNo": "0508",
//    "bstatnId": "9",
//    "bstatnNm": "청량리",
//    "recptnDt": "2023-11-07 23:51:37",
//    "arvlMsg2": "전역 도착",
//    "arvlMsg3": "남영",
//    "arvlCd": "5"
//},
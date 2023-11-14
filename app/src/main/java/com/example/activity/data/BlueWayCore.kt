package com.example.activity.data

object BlueWayCore {
    private var stationId: String? = null
    private var realtimeArrival: RealtimeArrival? = null
    private var arrivedStationName: String? = null
    init {
        // 이 부분은 클래스가 로드될 때 실행되는 초기화 블록입니다.
        println("Singleton instance is created.")
        // 다른 초기화 작업을 수행할 수 있습니다.
    }

    fun saveStationId(_stationId: String) {
        stationId = _stationId
    }

    fun getStationId(): String? {
        return stationId
    }

    fun saveBoardingTrainData(_realtimeArrival: RealtimeArrival) {
        if (realtimeArrival != null) {

        }
        realtimeArrival = _realtimeArrival
    }

    fun saveArrivedStationName(_stationName: String) {
        arrivedStationName = _stationName
    }

    fun getBoardingTrainData() : RealtimeArrival? {
        return realtimeArrival
    }

    fun getArrivedStationName() : String? {
        return arrivedStationName
    }
}
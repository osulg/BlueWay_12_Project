package com.example.activity.database

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.example.activity.data.TrainInfo
import java.io.FileOutputStream
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream

class DatabaseHelper(private val context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "train_info.db"
        private const val DATABASE_VERSION = 1
        private const val TABLE_NAME = "tb_train"
    }

    init {
        // 생성자에서 데이터베이스를 복사
        copyDatabaseFromAssets()
    }

    fun selectAllData(): List<TrainInfo> {
        val data = mutableListOf<TrainInfo>()

        try {
            val db = openDatabase()

            val query = "SELECT * FROM $TABLE_NAME"
            val cursor: Cursor = db.rawQuery(query, null)

            if (cursor.moveToFirst()) {
                do {
                    val SUBWAY_ID = cursor.getInt(cursor.getColumnIndexOrThrow("SUBWAY_ID"))
                    val STATN_ID = cursor.getInt(cursor.getColumnIndexOrThrow("STATN_ID"))
                    val STATN_NM = cursor.getString(cursor.getColumnIndexOrThrow("STATN_NM"))
                    val LINE_NUMBER = cursor.getString(cursor.getColumnIndexOrThrow("호선이름"))

                    // 데이터클래스 객체를 생성하여 리스트에 추가
                    data.add(TrainInfo(SUBWAY_ID, STATN_ID, STATN_NM, LINE_NUMBER))
                } while (cursor.moveToNext())
            }

            cursor.close()
            closeDatabase(db)
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return data
    }

    private fun copyDatabaseFromAssets() {
        val dbPath = context.getDatabasePath(DATABASE_NAME).absolutePath

        try {
            // assets 폴더에서 데이터베이스 파일 열기
            val inputStream: InputStream = context.assets.open(DATABASE_NAME)

            // 데이터베이스 파일로 복사
            val outputStream: OutputStream = FileOutputStream(dbPath)

            inputStream.copyTo(outputStream)

            inputStream.close()
            outputStream.close()

            Log.d("DatabaseHelper", "Database copied successfully")
        } catch (e: IOException) {
            e.printStackTrace()
            Log.e("DatabaseHelper", "Error copying database")
        }
    }

    override fun onCreate(db: SQLiteDatabase) {
        // 필요한 경우 테이블을 생성하거나 초기화할 수 있습니다.
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // 데이터베이스 스키마를 업그레이드하는 경우 처리할 코드를 작성합니다.
    }

    fun openDatabase(): SQLiteDatabase {
        return try {
            // 데이터베이스를 읽기 전용 모드로 열기
            val dbPath = context.getDatabasePath(DATABASE_NAME).absolutePath
            SQLiteDatabase.openDatabase(dbPath, null, SQLiteDatabase.OPEN_READONLY)
        } catch (e: SQLiteException) {
            e.printStackTrace()
            throw e
        }
    }

    fun closeDatabase(db: SQLiteDatabase) {
        db.close()
    }
}
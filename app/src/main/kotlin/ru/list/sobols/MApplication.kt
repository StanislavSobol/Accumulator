package ru.list.sobols

import android.app.Application
import android.util.Log

class MApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Log.d("SSS", "mapplication o")
    }


}
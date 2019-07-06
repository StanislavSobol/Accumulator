package ru.list.sobols

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.widget.FrameLayout

class MainActivity : AppCompatActivity() {

    private var mFrameHolder: FrameLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mFrameHolder = findViewById(R.id.mainActivityFrameHolder)
    }
}

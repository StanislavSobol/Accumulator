package ru.list.sobols

import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), IMainRouter {


    private var mFrameHolder: FrameLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mFrameHolder = findViewById(R.id.mainActivityFrameHolder)
        toMvvmFragment()
    }

    override fun toMvvmFragment() {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.mainActivityFrameHolder, MvpMainFragment.newInstance())
                .commit()
    }
}

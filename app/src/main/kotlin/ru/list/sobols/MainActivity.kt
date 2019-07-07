package ru.list.sobols

import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import ru.list.sobols.mvppart.MvpPartMainFragment

class MainActivity : AppCompatActivity(), IMainRouter {


    private var mFrameHolder: FrameLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mFrameHolder = findViewById(R.id.mainActivityFrameHolder)
        if (savedInstanceState == null) {
            toMvvmFragment()
        }
    }

    override fun toMvvmFragment() {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.mainActivityFrameHolder, MvpPartMainFragment.newInstance())
                .commit()
    }
}

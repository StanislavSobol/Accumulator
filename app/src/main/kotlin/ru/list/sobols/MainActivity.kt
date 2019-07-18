package ru.list.sobols

import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import ru.list.sobols.mvppart.houses.MvpPartHousesFragment
import ru.list.sobols.mvvmpart.MvvmPartHousesFragment

class MainActivity : AppCompatActivity(), IMainRouter {

    private var mFrameHolder: FrameLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mFrameHolder = findViewById(R.id.mainActivityFrameHolder)
        if (savedInstanceState == null) {
            toMvvmHousesFragment()
        }
    }

    override fun toMvpHousesFragment() {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.mainActivityFrameHolder, MvpPartHousesFragment.newInstance())
                .commit()
    }

    override fun toMvvmHousesFragment() {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.mainActivityFrameHolder, MvvmPartHousesFragment.newInstance())
                .commit()
    }
}

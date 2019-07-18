package ru.list.sobols

import android.app.Application
import ru.list.sobols.api.IRetrofitApi
import ru.list.sobols.di.AppComponent
import ru.list.sobols.di.DaggerAppComponent
import javax.inject.Inject

class MApplication : Application() {
    //    @Inject
//    lateinit var appContext: Context
    @Inject
    lateinit var iRetrofitApi: IRetrofitApi

    private lateinit var daggerAppComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        daggerAppComponent = DaggerAppComponent
                .builder()
                .appContext(this.applicationContext)
//                .application(this)
                .build()
        daggerAppComponent.inject(this)
    }

    companion object {
        lateinit var instance: MApplication

        fun getDaggerComponents(): AppComponent {
            return instance.daggerAppComponent
        }
    }
}
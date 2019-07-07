package ru.list.sobols

import android.app.Application
import android.util.Log
import ru.list.sobols.api.Api
import ru.list.sobols.di.AppComponent
import ru.list.sobols.di.DaggerAppComponent
import ru.list.sobols.di.InjectedStub
import javax.inject.Inject

class MApplication : Application() {

    @Inject
    lateinit var stub: InjectedStub
    //    @Inject
//    lateinit var appContext: Context
    @Inject
    lateinit var api: Api

    private lateinit var daggerAppComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        daggerAppComponent = DaggerAppComponent
                .builder()
                .appContext(this.applicationContext)
//                .retrofit(Client())
                .build()
        daggerAppComponent.inject(this)

        Log.d("SSS", "-------------------------------------------------------------------")
        Log.d("SSS", "stub = $stub")
//        Log.d("SSS", "context1 = $appContext")
        Log.d("SSS", "context2 = " + applicationContext)
        Log.d("SSS", "api = " + api)
    }
}
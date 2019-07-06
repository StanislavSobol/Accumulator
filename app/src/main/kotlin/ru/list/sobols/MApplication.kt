package ru.list.sobols

import android.app.Application
import ru.list.sobols.di.AppComponents
import ru.list.sobols.di.AppModules
import ru.list.sobols.di.DaggerAppComponents
import ru.list.sobols.di.InjectedStub
import javax.inject.Inject

class MApplication : Application() {

    @Inject
    lateinit var stub: InjectedStub

    private lateinit var daggerAppComponents: AppComponents

    override fun onCreate() {
        super.onCreate()
        daggerAppComponents = DaggerAppComponents.builder().appModules(AppModules()).build()
        daggerAppComponents.inject(this)
    }
}
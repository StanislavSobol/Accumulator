package ru.list.sobols.di

import dagger.Component
import ru.list.sobols.MApplication
import javax.inject.Singleton

@Singleton
@Component(modules = [(AppModules::class)])
interface AppComponents {
    fun inject(mApplication: MApplication)
}
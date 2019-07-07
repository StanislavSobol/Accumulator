package ru.list.sobols.di

import dagger.Module
import dagger.Provides
import ru.list.sobols.MApplication
import javax.inject.Singleton

@Module
class AppModule {
    @Provides
    fun provedStub() = InjectedStub()

    @Provides
    @Singleton
    fun provideApplication(application: MApplication) = application.applicationContext
}
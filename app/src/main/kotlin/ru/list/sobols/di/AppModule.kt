package ru.list.sobols.di

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.list.sobols.api.Client
import javax.inject.Singleton

@Module
class AppModule {
    @Provides
    fun provedStub() = InjectedStub()

    @Provides
    @Singleton
    fun provideApplication(appContext: Context) = appContext

    @Provides
    @Singleton
    fun provideApi() = Client().api
}
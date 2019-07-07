package ru.list.sobols.di

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.list.sobols.api.Api
import ru.list.sobols.api.Client
import ru.list.sobols.interactor.IInteractor
import ru.list.sobols.interactor.Interactor
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

    @Provides
    @Singleton
    fun provideInteractor(api: Api): IInteractor = Interactor(api)
}
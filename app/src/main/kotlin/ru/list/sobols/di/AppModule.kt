package ru.list.sobols.di

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.list.sobols.api.IRetrofitApi
import ru.list.sobols.api.RetrofitClient
import ru.list.sobols.interactor.IInteractor
import ru.list.sobols.interactor.Interactor
import javax.inject.Singleton

@Module
class AppModule {
    @Provides
    @Singleton
    fun provideApplication(appContext: Context) = appContext

    @Provides
    @Singleton
    fun provideRetrofitApi() = RetrofitClient().iRetrofitApi

    @Provides
    @Singleton
    fun provideInteractor(iRetrofitApi: IRetrofitApi): IInteractor = Interactor(iRetrofitApi)
}
package ru.list.sobols.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.list.sobols.MApplication
import ru.list.sobols.interactor.IInteractor
import javax.inject.Singleton

@Singleton
@Component(modules = [(AppModule::class)])
interface AppComponent {

    fun interactor(): IInteractor

    fun inject(body: MApplication)

    @Component.Builder
    interface Builder {
        fun build(): AppComponent

        @BindsInstance
        fun appContext(appContext: Context): Builder
//
//        @BindsInstance
//        fun application(application: Application): Builder
    }
}
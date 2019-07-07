package ru.list.sobols.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.list.sobols.MApplication
import javax.inject.Singleton


@Singleton
@Component(modules = [(AppModule::class)])
interface AppComponent {
    fun inject(mApplication: MApplication)

    @Component.Builder
    interface Builder {
        fun build(): AppComponent

        @BindsInstance
        fun appContext(appContext: Context): Builder
//
//        @BindsInstance
//        fun retrofit(client: Client): Builder
    }
}
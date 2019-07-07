package ru.list.sobols.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.list.sobols.MApplication
import ru.list.sobols.mvppart.MvpPartMainFragment
import javax.inject.Singleton

@Singleton
@Component(modules = [(AppModule::class)])
interface AppComponent {

    fun inject(body: MApplication)
    fun inject(body: MvpPartMainFragment)

    @Component.Builder
    interface Builder {
        fun build(): AppComponent

        @BindsInstance
        fun appContext(appContext: Context): Builder
    }
}
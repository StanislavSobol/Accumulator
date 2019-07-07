package ru.list.sobols.di

import dagger.BindsInstance
import dagger.Component
import ru.list.sobols.MApplication
import ru.list.sobols.api.Client
import javax.inject.Singleton


@Singleton
@Component(modules = [(AppModule::class)])
interface AppComponent {
    fun inject(mApplication: MApplication)

    @Component.Builder
    interface Builder {
        fun build(): AppComponent

        @BindsInstance
        fun appContext(application: MApplication): Builder

        @BindsInstance
        fun retrofit(client: Client): Builder
    }
}
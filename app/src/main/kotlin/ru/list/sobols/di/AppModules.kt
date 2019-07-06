package ru.list.sobols.di

import dagger.Module
import dagger.Provides

@Module
class AppModules {
    @Provides
    fun provedStub() = InjectedStub()
}
package ru.list.sobols.di

import dagger.Component
import ru.list.sobols.mvvmpart.MvvmPartHousesFragment

@MvvmPartScope
@Component(
        modules = [(MvvmPartModule::class)],
        dependencies = [(AppComponent::class)]
)
interface MvvmPartComponent {
    fun inject(body: MvvmPartHousesFragment)
}
package ru.list.sobols.di

import dagger.Component
import ru.list.sobols.mvppart.houses.MvpPartHousesFragment

@MvpPartScope
@Component(
        modules = [(MvpPartModule::class)],
        dependencies = [(AppComponent::class)]
)
interface MvpPartComponent {

    fun inject(body: MvpPartHousesFragment)
}
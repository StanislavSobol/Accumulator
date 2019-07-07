package ru.list.sobols.di

import dagger.Component
import ru.list.sobols.mvppart.MvpPartMainFragment

@MvpPartScope
@Component(
        modules = [(MvpPartModule::class)],
        dependencies = [(AppComponent::class)]
)
interface MvpPartComponent {

    // fun interactor() : IInteractor

    fun inject(body: MvpPartMainFragment)

}
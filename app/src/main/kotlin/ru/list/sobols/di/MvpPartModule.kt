package ru.list.sobols.di

import dagger.Module
import dagger.Provides
import ru.list.sobols.interactor.IInteractor
import ru.list.sobols.mvppart.MvpPartMainPresenter

@Module
class MvpPartModule {

    @MvpPartScope
    @Provides
    fun provideMvpPartPresenter(interactor: IInteractor) = MvpPartMainPresenter(interactor)
}
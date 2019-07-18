package ru.list.sobols.di

import dagger.Module
import dagger.Provides
import ru.list.sobols.interactor.IInteractor
import ru.list.sobols.mvvmpart.MvvmPartHousesViewmodelFactory

@Module
class MvvmPartModule {

//    @MvvmPartScope
//    @Provides
//    fun provideMvvmPartHousesViewModel(interactor: IInteractor) = MvvmPartHousesViewModel(interactor)

    @MvvmPartScope
    @Provides
    fun prov(interactor: IInteractor): MvvmPartHousesViewmodelFactory {
        return MvvmPartHousesViewmodelFactory(interactor)
    }
}
package ru.list.sobols.mvvmpart;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import ru.list.sobols.interactor.IInteractor;

public class MvvmPartHousesViewmodelFactory implements ViewModelProvider.Factory {


    private IInteractor interactor;

    public MvvmPartHousesViewmodelFactory(@NonNull IInteractor interactor) {
        this.interactor = interactor;
    }


    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new MvvmPartHousesViewModel(interactor);
    }
}

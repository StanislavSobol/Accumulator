package ru.list.sobols.mvvmpart;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import ru.list.sobols.interactor.IInteractor;
import ru.list.sobols.model.HouseListItemDisplayModel;

public class MvvmPartHousesViewModel extends ViewModel {

    private IInteractor interactor;

    public MvvmPartHousesViewModel(@NonNull IInteractor interactor) {
        this.interactor = interactor;
    }

    private MutableLiveData<HouseListItemDisplayModel> liveData;

    public LiveData<HouseListItemDisplayModel> subscribeToHouses() {
        if (liveData == null) {
            liveData = new MutableLiveData<>();
        }
        return liveData;
    }

}

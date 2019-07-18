package ru.list.sobols.mvvmpart;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import ru.list.sobols.interactor.IInteractor;
import ru.list.sobols.model.HouseListItemDisplayModel;
import ru.list.sobols.mvppart.houses.IMvpPartHousesAdapterDelegate;

public class MvvmPartHousesViewModel extends ViewModel {

    private IInteractor interactor;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    private MutableLiveData<List<IMvpPartHousesAdapterDelegate>> liveData;

    public MvvmPartHousesViewModel(@NonNull IInteractor interactor) {
        this.interactor = interactor;
    }

    public LiveData<List<IMvpPartHousesAdapterDelegate>> getLiveData() {
        return liveData;
    }

    public LiveData<List<IMvpPartHousesAdapterDelegate>> subscribeToHouses() {
        if (liveData == null) {
            liveData = new MutableLiveData<>();
            compositeDisposable.add(
                    interactor.getHouses()
                            .subscribeOn(Schedulers.io())
                            .map(HouseListItemDisplayModel.Companion::listFromHouseModels)
                            .subscribe(items -> liveData.postValue(items), throwable -> {
                            })
            );
        }
        return liveData;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.dispose();
    }
}

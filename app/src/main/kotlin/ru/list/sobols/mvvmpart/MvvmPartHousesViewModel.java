package ru.list.sobols.mvvmpart;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import ru.list.sobols.interactor.IInteractor;
import ru.list.sobols.model.HouseListItemDisplayModel;
import ru.list.sobols.mvppart.houses.IMvpPartHousesAdapterDelegate;

public class MvvmPartHousesViewModel extends ViewModel {

    private IInteractor interactor;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    private MutableLiveData<Boolean> progressLiveData;
    private MutableLiveData<List<IMvpPartHousesAdapterDelegate>> housesLiveData;

    public MvvmPartHousesViewModel(@NonNull IInteractor interactor) {
        this.interactor = interactor;
    }

    public MutableLiveData<Boolean> getProgressLiveData() {
        if (progressLiveData == null) {
            progressLiveData = new MutableLiveData<>();
        }
        return progressLiveData;
    }

    public LiveData<List<IMvpPartHousesAdapterDelegate>> subscribeToHouses() {
        if (housesLiveData == null) {
            housesLiveData = new MutableLiveData<>();
            compositeDisposable.add(
                    interactor.getHouses()
                            .delay(2, TimeUnit.SECONDS)
                            .doOnSubscribe(disposable -> progressLiveData.postValue(true))
                            .doOnSuccess(disposable -> progressLiveData.postValue(false))
                            .doOnError(disposable -> progressLiveData.postValue(false))
                            .subscribeOn(Schedulers.io())
                            .map(HouseListItemDisplayModel.Companion::listFromHouseModels)
                            .subscribe(items -> housesLiveData.postValue(items), throwable -> {
                            })
            );
        }
        return housesLiveData;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.dispose();
    }
}

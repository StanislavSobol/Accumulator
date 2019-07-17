package ru.list.sobols.mvppart.houses

import moxy.InjectViewState
import ru.list.sobols.di.MvpPartScope
import ru.list.sobols.interactor.IInteractor
import ru.list.sobols.model.HouseModel
import ru.list.sobols.mvppart.MvpPartBasePresenter
import ru.list.sobols.utils.fromIoToMain
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@MvpPartScope
@InjectViewState
class MvpPartHousesPresenter @Inject constructor(val interactor: IInteractor) :
        MvpPartBasePresenter<IMvpPartHousesView>() {

    public override fun onFirstViewAttach() {
        subscribeToHouses()
    }

    fun onSwipeToRefresh() {
        subscribeToHouses()
    }

    private fun subscribeToHouses() {
        interactor.getHouses()
                .delay(2, TimeUnit.SECONDS)
                .fromIoToMain()
                .map { items -> convertHousesToListItems(items) }
                .showProgress()
                .subscribe(
                        { items -> viewState.showItems(items) },
                        { throwable -> viewState.showError(throwable) })
                .unsubscribeOnDestroy()
    }

    private fun convertHousesToListItems(houseModels: List<HouseModel>): List<IMvpPartHousesAdapterDelegate> {
        val result = mutableListOf<IMvpPartHousesAdapterDelegate>()
        var region: String? = null

        houseModels.sortedBy { item -> item.region }.forEach { item ->
            run {
                if (region == null || region != item.region) {
                    result.add(RegionListItemModel(item.region))
                    result.add(HouseListItemModel(item.name, item.region))
                    region = item.region
                } else {
                    result.add(HouseListItemModel(item.name, item.region))
                }
            }
        }

        return result
    }

}

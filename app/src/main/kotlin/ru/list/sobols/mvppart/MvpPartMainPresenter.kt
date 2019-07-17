package ru.list.sobols.mvppart

import moxy.InjectViewState
import ru.list.sobols.di.MvpPartScope
import ru.list.sobols.interactor.IInteractor
import ru.list.sobols.model.HouseModel
import ru.list.sobols.utils.fromIoToMain
import javax.inject.Inject

@MvpPartScope
@InjectViewState
class MvpPartMainPresenter @Inject constructor(val interactor: IInteractor) :
        BasePresenter<IMvpPartMainView>() {

    public override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        interactor.getHouses()
                .fromIoToMain()
                .map { items -> convertHousesToListItems(items) }
                .subscribe(
                        { items -> viewState.showItems(items) },
                        { throwable -> viewState.showError(throwable) })
                .unsubscribeOnDestroy()
    }

    private fun convertHousesToListItems(houseModels: List<HouseModel>): List<IMvpPartMainAdapterDelegate> {
        val result = mutableListOf<IMvpPartMainAdapterDelegate>()
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
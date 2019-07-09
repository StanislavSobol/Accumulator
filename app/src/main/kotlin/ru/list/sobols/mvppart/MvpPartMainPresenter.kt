package ru.list.sobols.mvppart

import moxy.InjectViewState
import ru.list.sobols.di.MvpPartScope
import ru.list.sobols.interactor.IInteractor
import ru.list.sobols.utils.fromIoToMain
import javax.inject.Inject

@MvpPartScope
@InjectViewState
class MvpPartMainPresenter @Inject constructor(val interactor: IInteractor) :
        BasePresenter<IMvpPartMainView>() {

    public override fun onFirstViewAttach() {
        super.onFirstViewAttach()
//        Log.d("SSS", "onFirstViewAttach interactor = $interactor")
        interactor.getHouses()
                .fromIoToMain()
                .subscribe(
                        { items -> viewState.showItems(items) },
                        { throwable -> viewState.showError(throwable) })
                .unsubscribeOnDestroy()
    }
}
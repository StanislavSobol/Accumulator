package ru.list.sobols.mvppart

import android.util.Log
import moxy.InjectViewState
import ru.list.sobols.interactor.IInteractor
import javax.inject.Inject

@InjectViewState
class MvpPartMainPresenter @Inject constructor(val interactor: IInteractor) :
        BasePresenter<IMvpPartMainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        Log.d("SSS", "interactor = $interactor")
    }
}
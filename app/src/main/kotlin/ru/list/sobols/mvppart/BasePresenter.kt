package ru.list.sobols.mvppart

import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import moxy.MvpPresenter

abstract class BasePresenter<T : IMvpPartBaseView> : MvpPresenter<T>() {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun onDestroy() {
        compositeDisposable.clear()
        super.onDestroy()
    }

    protected fun Disposable.unsubscribeOnDestroy() {
        compositeDisposable.add(this)
    }

//    protected fun Disposable.showProgress(): Disposable {
//        return compositeDisposable
//    }

    protected fun <T> Single<T>.showProgress(): Single<T> {
        return this
                .doOnSubscribe { viewState.showProgress() }
                .doOnSuccess { viewState.hideProgress() }
                .doOnError { viewState.hideProgress() }
    }
}
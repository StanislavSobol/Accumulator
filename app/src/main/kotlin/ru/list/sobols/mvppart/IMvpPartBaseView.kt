package ru.list.sobols.mvppart

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

interface IMvpPartBaseView : MvpView {

    @StateStrategyType(AddToEndSingleStrategy::class, tag = PROGRESS_TAG)
    fun showProgress()

    @StateStrategyType(AddToEndSingleStrategy::class, tag = PROGRESS_TAG)
    fun hideProgress()

    companion object {
        const val PROGRESS_TAG = "progressTag"
    }
}
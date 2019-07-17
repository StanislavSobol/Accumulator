package ru.list.sobols.mvppart

import moxy.MvpView
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

interface IMvpPartMainView : MvpView {

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showItems(items: List<IMvpPartMainAdapterDelegate>)

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showError(throwable: Throwable?)

}
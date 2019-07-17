package ru.list.sobols.mvppart

import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

interface IMvpPartMainView : IMvpPartBaseView {

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showItems(items: List<IMvpPartMainAdapterDelegate>)

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showError(throwable: Throwable?)

}
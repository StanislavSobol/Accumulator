package ru.list.sobols.mvppart.houses

import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType
import ru.list.sobols.mvppart.IMvpPartBaseView

interface IMvpPartHousesView : IMvpPartBaseView {

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showItems(items: List<IMvpPartHousesAdapterDelegate>)

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showError(throwable: Throwable?)

}
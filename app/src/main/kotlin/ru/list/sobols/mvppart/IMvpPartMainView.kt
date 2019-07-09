package ru.list.sobols.mvppart

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType
import ru.list.sobols.model.HouseModel

interface IMvpPartMainView : MvpView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showItems(items: List<HouseModel>?)

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showError(throwable: Throwable?)
}
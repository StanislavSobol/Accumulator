package ru.list.sobols.interactor

import io.reactivex.Single
import ru.list.sobols.model.HouseModel

interface IInteractor {
    fun getHouses(): Single<List<HouseModel>>
}
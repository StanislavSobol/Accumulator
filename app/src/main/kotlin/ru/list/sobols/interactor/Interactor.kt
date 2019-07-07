package ru.list.sobols.interactor

import io.reactivex.Single
import ru.list.sobols.api.Api
import ru.list.sobols.model.HouseModel
import javax.inject.Inject

class Interactor @Inject constructor(val api: Api) : IInteractor {

    override fun getHouses(): Single<List<HouseModel>> {
        return api.getHouses()
    }
}
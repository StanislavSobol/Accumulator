package ru.list.sobols.interactor

import io.reactivex.Single
import ru.list.sobols.api.IRetrofitApi
import ru.list.sobols.model.HouseModel
import javax.inject.Inject

class Interactor @Inject constructor(val iRetrofitApi: IRetrofitApi) : IInteractor {

    override fun getHouses(): Single<List<HouseModel>> {
        return iRetrofitApi.getHouses()
    }
}
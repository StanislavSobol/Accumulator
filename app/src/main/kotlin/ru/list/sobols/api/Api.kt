package ru.list.sobols.api

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import ru.list.sobols.model.HouseModel

interface Api {
    @GET("user/{id}")
    fun getBook(@Path("id") id: Int): Single<String>

    @GET("houses")
    fun getHouses(): Single<List<HouseModel>>
}
package ru.list.sobols.api

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {
    @GET("user/{id}")
    fun getBook(@Path("id") id: Int): Single<String>
}
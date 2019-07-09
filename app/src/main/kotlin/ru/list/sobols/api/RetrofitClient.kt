package ru.list.sobols.api

import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import ru.list.sobols.BuildConfig

class RetrofitClient {

    var iRetrofitApi: IRetrofitApi

    private val baseUrl: String = "https://anapioficeandfire.com/api/"
    private val retrofit: Retrofit

    init {
        val level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().setLevel(level)
        val okHttpClient = OkHttpClient.Builder().addInterceptor(interceptor).build()
        retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .build()

        iRetrofitApi = retrofit.create(IRetrofitApi::class.java)
    }
}
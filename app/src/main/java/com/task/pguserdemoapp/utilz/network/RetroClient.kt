package com.task.pguserdemoapp.utilz.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class RetroClient {


    companion object {
        private val BASE_URL = "https://apextechies.com/mypg/index.php/"
        private var retrofit: Retrofit? = null
        fun getRetrofit(): Retrofit? {

            if (retrofit == null) {
                val builder = OkHttpClient.Builder()
                val okHttpClient = builder.build()

                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(okHttpClient)
                    .build()

            }

            return retrofit
        }
    }

}
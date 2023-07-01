package com.fuadhev.findmovie.network

import com.fuadhev.findmovie.utils.Constant
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitClient {

    private var INSTANCE: Retrofit? = null

    fun getInstance(): Retrofit {

        if (INSTANCE == null) {

            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

            val clientBuilder = OkHttpClient.Builder()
//                .addInterceptor(object: Interceptor{
//                    override fun intercept(chain: Interceptor.Chain): Response {
//                        val original: Request = chain.request()
//
//                        val request: Request = original.newBuilder()
//                            .header("User-Agent", "Your-App-Name")
//                            .header("Accept", "application/vnd.yourapi.v1.full+json")
//                            .method(original.method, original.body)
//                            .build()
//
//                        return chain.proceed(request)
//                    }
//
//                })
                .addInterceptor(loggingInterceptor)
                .build()

            INSTANCE = Retrofit.Builder().baseUrl(Constant.BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .client(clientBuilder)
                .build()

        }

        return INSTANCE!!
    }
}
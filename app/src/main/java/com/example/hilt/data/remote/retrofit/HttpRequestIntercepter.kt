package com.example.hilt.data.remote.retrofit

import okhttp3.Interceptor
import okhttp3.Response

internal class HttpRequestIntercepter: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.proceed(
            chain.request()
                .newBuilder()
                .build()
        )
    }
}
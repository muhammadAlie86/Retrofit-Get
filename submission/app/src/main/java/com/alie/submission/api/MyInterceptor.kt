package com.alie.submission.api

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class MyInterceptor : Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response {
        val request : Request = chain.request()
            .newBuilder()
            .addHeader("User-Agent","request")
            .addHeader("Authorization","token  470e4e29150a38d08efef864adc498f4d76a9578")
            .build()
        return chain.proceed(request)
    }

}
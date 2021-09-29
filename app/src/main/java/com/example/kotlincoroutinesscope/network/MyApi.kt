package com.example.kotlincoroutinesscope.network

import com.example.kotlincoroutinesscope.model.UserList
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface MyApi {
    @GET("user")
    suspend fun getUsersList(): List<UserList>

    companion object {
        operator fun invoke(): MyApi {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://5de620aa9c4220001405b262.mockapi.io/api/v1/")
                .build()
                .create(MyApi::class.java)
        }
    }
}
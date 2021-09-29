package com.example.kotlincoroutinesscope.repositories

import com.example.kotlincoroutinesscope.model.UserList
import com.example.kotlincoroutinesscope.network.MyApi

class ViewModelScopeUserRepository {
    suspend fun fetchUsers(): List<UserList> {
        val response = MyApi.invoke().getUsersList()
        return response

    }
}
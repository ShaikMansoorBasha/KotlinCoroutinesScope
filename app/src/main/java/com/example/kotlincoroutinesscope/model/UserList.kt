package com.example.kotlincoroutinesscope.model

import com.google.gson.annotations.SerializedName

class UserList(
    @SerializedName("id") val id: Int,
    @SerializedName("createdAt") val createdAt: String,
    @SerializedName("name") val name: String,
    @SerializedName("avatar") val avatar: String,
    @SerializedName("email") val email: String,
    @SerializedName("phone") val phone: String
)
package com.lupin.myfirstmvvm.Data.remote

import com.google.gson.JsonObject
import com.lupin.myfirstmvvm.Data.entities.Todo
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("todos/{id}")
    suspend fun getTodo(@Path("id") todoId:Int):Todo

}
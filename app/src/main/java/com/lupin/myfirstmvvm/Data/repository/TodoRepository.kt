package com.lupin.myfirstmvvm.Data.repository

import com.google.gson.JsonObject
import com.lupin.myfirstmvvm.Data.Result
import com.lupin.myfirstmvvm.Data.entities.Todo
import com.lupin.myfirstmvvm.Data.remote.RemoteDataSource

interface TodoRepository {
    suspend fun getTodo(): Result<Todo>
}
package com.lupin.myfirstmvvm.Data.repository.impl

import com.google.gson.JsonObject
import com.lupin.myfirstmvvm.Data.remote.ApiManager
import com.lupin.myfirstmvvm.Data.repository.TodoRepository
import com.lupin.myfirstmvvm.Data.Result
import com.lupin.myfirstmvvm.Data.entities.Todo
import com.lupin.myfirstmvvm.Data.remote.RemoteDataSource
import java.lang.Exception

class TodoServiceImpl : TodoRepository,RemoteDataSource(){
    override suspend fun getTodo():Result<Todo>{
        return call(ApiManager.callApi.getTodo(1))
    }

}
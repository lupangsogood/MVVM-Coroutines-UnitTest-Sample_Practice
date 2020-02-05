package com.lupin.myfirstmvvm.Data.repository.impl

import com.lupin.myfirstmvvm.Data.entities.Todo
import com.lupin.myfirstmvvm.Data.remote.ApiManager
import com.lupin.myfirstmvvm.Data.repository.TodoRepository
import com.lupin.myfirstmvvm.Util.UseCaseResult
import java.lang.Exception

class TodoServiceImpl : TodoRepository{
    override suspend fun getTodo(): UseCaseResult<Todo> {
        return try {
            val result = ApiManager.callApi.getTodo(3)
            UseCaseResult.Success(result)
        }catch (error:Exception){
            UseCaseResult.Error(error)
        }
    }

}
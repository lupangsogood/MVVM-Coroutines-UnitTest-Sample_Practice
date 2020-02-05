package com.lupin.myfirstmvvm.Data.repository

import com.lupin.myfirstmvvm.Data.entities.Todo
import com.lupin.myfirstmvvm.Util.UseCaseResult

interface TodoRepository {
    suspend fun getTodo():UseCaseResult<Todo>
}
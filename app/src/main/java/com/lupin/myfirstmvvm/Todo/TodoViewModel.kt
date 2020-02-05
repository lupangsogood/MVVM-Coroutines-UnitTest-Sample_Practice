package com.lupin.myfirstmvvm.Todo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lupin.myfirstmvvm.BaseViewModel
import com.lupin.myfirstmvvm.Data.entities.Todo
import com.lupin.myfirstmvvm.Data.repository.TodoRepository
import com.lupin.myfirstmvvm.Data.repository.impl.TodoServiceImpl
import com.lupin.myfirstmvvm.Util.UseCaseResult
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber


class TodoViewModel(val todoService:TodoServiceImpl) : BaseViewModel(){

    init {
        Timber.d("ViewModel Created")
    }
    private val _todoList = MutableLiveData<Todo>()
    val todoList : LiveData<Todo>
        get() = _todoList

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage : LiveData<String>
        get() = _errorMessage

    suspend fun fetchTodoList() = withContext(IO){
       val result = todoService.getTodo()
        withContext(Main){
            when(result){
                is UseCaseResult.Success -> _todoList.value = result.data
                is UseCaseResult.Error -> _errorMessage.value = result.exception.message
            }
        }
    }
}
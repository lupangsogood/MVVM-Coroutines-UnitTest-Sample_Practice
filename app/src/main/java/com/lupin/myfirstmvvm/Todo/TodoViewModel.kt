package com.lupin.myfirstmvvm.Todo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.lupin.myfirstmvvm.BaseViewModel
import com.lupin.myfirstmvvm.Data.Result
import com.lupin.myfirstmvvm.Data.entities.Todo
import com.lupin.myfirstmvvm.Data.repository.impl.TodoServiceImpl
import com.lupin.myfirstmvvm.SharePreference.Sharepreference
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.withContext
import timber.log.Timber


class TodoViewModel(val todoService:TodoServiceImpl,val sharePref:Sharepreference?) : BaseViewModel(){

    init {
        Timber.d("ViewModel Created")
        sharePref?.putString("123","456")
        Timber.d(sharePref?.getString("123"))
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
            when(result.isSuccessful()){
                 true  -> {
                     _todoList.value = result.data
                        Timber.d("SUCCESS")
                 }
                 false -> {_errorMessage.value = result.message
                     Timber.d("ERROR")
                 }
            }
        }
    }


}
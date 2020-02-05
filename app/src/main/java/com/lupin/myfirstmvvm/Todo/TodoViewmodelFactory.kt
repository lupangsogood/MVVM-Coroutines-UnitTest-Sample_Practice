package com.lupin.myfirstmvvm.Todo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.lupin.myfirstmvvm.Data.repository.TodoRepository
import com.lupin.myfirstmvvm.Data.repository.impl.TodoServiceImpl
import java.lang.IllegalArgumentException

class TodoViewmodelFactory :ViewModelProvider.Factory{


    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TodoViewModel::class.java)){
            return TodoViewModel(TodoServiceImpl()) as T
        }
        throw IllegalArgumentException("Unknow Viewmodel Class")
    }
}
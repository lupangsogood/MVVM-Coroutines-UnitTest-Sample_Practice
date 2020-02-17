package com.lupin.myfirstmvvm.DI

import com.lupin.myfirstmvvm.Data.repository.TodoRepository
import com.lupin.myfirstmvvm.Data.repository.impl.TodoServiceImpl
import com.lupin.myfirstmvvm.Todo.TodoViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val applicationModule = module {

    single { TodoServiceImpl() }
    single<TodoRepository> {get()}
    viewModel { TodoViewModel(get()) }
}
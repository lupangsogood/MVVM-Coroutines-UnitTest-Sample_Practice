package com.lupin.myfirstmvvm.DI

import com.lupin.myfirstmvvm.Data.remote.RemoteDataSource
import com.lupin.myfirstmvvm.Data.repository.TodoRepository
import com.lupin.myfirstmvvm.Data.repository.impl.TodoServiceImpl
import com.lupin.myfirstmvvm.SharePreference.Sharepreference
import com.lupin.myfirstmvvm.Todo.TodoViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val applicationModule = module {

    single {Sharepreference(get())}
    single{TodoServiceImpl()}
    factory <RemoteDataSource> { TodoServiceImpl() }
    viewModel { TodoViewModel(get(),get()) }
}
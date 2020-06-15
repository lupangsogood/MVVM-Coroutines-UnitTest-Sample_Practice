package com.lupin.myfirstmvvm.Todo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.lupin.myfirstmvvm.Data.repository.TodoRepository
import com.lupin.myfirstmvvm.Data.repository.impl.TodoServiceImpl
import com.lupin.myfirstmvvm.SharePreference.Sharepreference
import java.lang.IllegalArgumentException

//-------------- ******* ใช้ในกรณีที่ไม่ได้มีการใช่ DI ตัวอื่นๆ เช่น KOIN หรือ Dagger2
//class TodoViewmodelFactory :ViewModelProvider.Factory{
////    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
////        if (modelClass.isAssignableFrom(TodoViewModel::class.java)){
////            return TodoViewModel(TodoServiceImpl(), Sharepreference(null)) as T
////        }
////        throw IllegalArgumentException("Unknow Viewmodel Class")
////    }
//}
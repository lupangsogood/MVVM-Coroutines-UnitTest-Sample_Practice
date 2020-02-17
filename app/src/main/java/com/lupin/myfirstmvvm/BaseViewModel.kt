package com.lupin.myfirstmvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancelChildren
import timber.log.Timber
import java.util.logging.Logger
import kotlin.coroutines.CoroutineContext

open class BaseViewModel: ViewModel(){

    private fun cancelJob(){
        viewModelScope.coroutineContext.cancelChildren()
    }

    override fun onCleared() {
        cancelJob()
        Timber.d("ViewModel Cleared")
        super.onCleared()
    }

}
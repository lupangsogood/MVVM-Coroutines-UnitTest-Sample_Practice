package com.lupin.myfirstmvvm.Todo

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.lupin.myfirstmvvm.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber

class TodoActivity : Fragment(){

//    val viewModel : TodoViewModel by inject()

    private lateinit var viewModel : TodoViewModel
    private lateinit var viewModelFactory : TodoViewmodelFactory
    lateinit var rootView : View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_todo,container,false)
        viewModelFactory = TodoViewmodelFactory()
        viewModel = ViewModelProviders.of(this,viewModelFactory).get(TodoViewModel::class.java)

        viewModel.errorMessage.observe(this, Observer {
            Timber.d("TEST ERROR MESSAGE = $it")
        })

        viewModel.todoList.observe(this, Observer {
            Timber.d(it.toString())
        })

        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        CoroutineScope(Dispatchers.IO).launch {
            getTodoList()
        }
    }

     private suspend fun getTodoList(){
            viewModel.fetchTodoList()
    }


}
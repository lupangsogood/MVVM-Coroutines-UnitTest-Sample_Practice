package com.lupin.myfirstmvvm.Todo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.lupin.myfirstmvvm.R
import com.lupin.myfirstmvvm.Util.launchOnIoThread
import com.lupin.myfirstmvvm.databinding.FragmentTodoBinding
import kotlinx.android.synthetic.main.fragment_todo.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber


class TodoScreen : Fragment(){

    val todoViewModel : TodoViewModel by viewModel()

    lateinit var rootView : View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_todo,container,false)
        todoViewModel.errorMessage.observe(this, Observer {
            Timber.d("TEST ERROR MESSAGE = ${it}")
            txt1.text = it
        })

        todoViewModel.todoList.observe(this, Observer {
            Timber.d(it.toString())
            txt1.text = it.toString()
        })
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        launchOnIoThread{
            getTodoList()
        }
    }
    suspend fun getTodoList(){
         todoViewModel.fetchTodoList()

    }


}
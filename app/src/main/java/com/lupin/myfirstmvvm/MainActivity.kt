package com.lupin.myfirstmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.lupin.myfirstmvvm.R
import com.lupin.myfirstmvvm.Todo.TodoActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManger = supportFragmentManager.beginTransaction()
        fragmentManger.replace(R.id.mainContainer,TodoActivity())
        fragmentManger.commit()
    }
}

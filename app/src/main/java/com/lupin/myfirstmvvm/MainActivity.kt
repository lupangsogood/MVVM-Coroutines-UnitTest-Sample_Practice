package com.lupin.myfirstmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lupin.myfirstmvvm.Todo.TodoScreen

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManger = supportFragmentManager.beginTransaction()
        fragmentManger.replace(R.id.mainContainer,TodoScreen())
        fragmentManger.commit()
    }
}

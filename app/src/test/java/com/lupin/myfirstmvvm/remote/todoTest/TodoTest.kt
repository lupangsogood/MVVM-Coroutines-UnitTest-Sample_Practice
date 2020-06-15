package com.lupin.myfirstmvvm.remote.todoTest

import android.content.Context
import com.lupin.myfirstmvvm.DI.applicationModule
import com.lupin.myfirstmvvm.Data.entities.Todo
import com.lupin.myfirstmvvm.Data.remote.ApiService
import com.lupin.myfirstmvvm.Data.repository.impl.TodoServiceImpl
import com.lupin.myfirstmvvm.KoinTestRule
import com.lupin.myfirstmvvm.SharePreference.Sharepreference
import com.lupin.myfirstmvvm.Todo.TodoScreen
import com.lupin.myfirstmvvm.Todo.TodoViewModel
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.mockk
import io.mockk.verify
import kotlinx.android.synthetic.main.fragment_todo.*
import kotlinx.coroutines.*
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Rule
import org.koin.core.context.startKoin
import org.koin.test.KoinTest
import org.koin.test.inject
import org.mockito.MockitoAnnotations
import kotlin.test.Test
import kotlin.test.assertEquals

class TodoTest :KoinTest{

//    val screen = mockk<TodoScreen>(relaxed = true)
//    val viewModel = mockk<TodoViewModel>(relaxed = true)
//    val service = mockk<TodoServiceImpl>(relaxed = true)
    private val viewModel : TodoViewModel by inject()
    private  val service : TodoServiceImpl by  inject()
    val getTodoApi : ApiService by inject()

    @ObsoleteCoroutinesApi
    private val mainThreadSurrogate = newSingleThreadContext("UI thread")

    init {
        Dispatchers.Main
    }

//    @Rule @JvmField var koinRule = KoinTestRule()
    @ObsoleteCoroutinesApi
    @ExperimentalCoroutinesApi
    @Before
    fun setup(){
        startKoin { modules(applicationModule) }
        MockitoAnnotations.initMocks(this)
        Dispatchers.setMain(mainThreadSurrogate)
    }
    @Test
    fun getTodo(){
        val data = Todo(
            id = 1,
            title = "delectus aut autem\"",
            completed = false
        )

        val data2 = Todo(
            id = 123123,
            title = "delectus aut autem",
            completed = false
        )
        coEvery { getTodoApi.getTodo(1) }returns data
        assertEquals(expected = data2,actual = data)
    }

    @Test
     fun `should return true when data == output`() = runBlocking {
        val output = service.getTodo()
        val data = Todo(
            id = 1,
            title = "delectus aut autem",
            completed = false
        )
       assertEquals(expected = data.toString(),actual = output.data.toString())
    }
}
package com.lupin.myfirstmvvm

import android.app.Activity
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.accessibility.AccessibilityChecks
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import com.google.android.apps.common.testing.accessibility.framework.AccessibilityCheck
import com.lupin.myfirstmvvm.DI.applicationModule
import com.lupin.myfirstmvvm.Data.entities.Todo
import com.lupin.myfirstmvvm.Data.remote.ApiService
import com.lupin.myfirstmvvm.Data.repository.impl.TodoServiceImpl
import com.lupin.myfirstmvvm.Todo.TodoScreen
import com.lupin.myfirstmvvm.Todo.TodoViewModel
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.core.context.startKoin
import kotlin.test.assertEquals

@LargeTest
class ExampleInstrumentedTest  {

    val screen = mockk<TodoScreen>(relaxed = true)
    val viewModel = mockk<TodoViewModel>(relaxed = true)
    val service = mockk<TodoServiceImpl>(relaxed = true)
    val getTodoApi = mockk<ApiService>(relaxed = true)

    @Rule @JvmField
    var mActivityTestRule  = ActivityTestRule(MainActivity::class.java)

companion object{
    @ExperimentalCoroutinesApi
    @ObsoleteCoroutinesApi
    @Before
    fun setup(){
        startKoin { modules(applicationModule) }
        AccessibilityChecks.enable()
            .setRunChecksFromRootView(true)
    }
}

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.lupin.myfirstmvvm", appContext.packageName)
    }

    @Test
    fun todoScreen(){
        val data = Todo(
            id = 1,
            title = "delectus aut autem",
            completed = false
        )
        coEvery { viewModel.fetchTodoList() }
        onView(withId(R.id.txt1)).check(matches(withText(data.toString())))
    }
}

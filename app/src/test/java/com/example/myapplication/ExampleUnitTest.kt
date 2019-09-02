package com.example.myapplication

import android.content.Context
import com.example.myapplication.API.ApiServices
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before
import com.example.myapplication.Model.RegisterModel
import com.example.myapplication.Model.User
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    //lateinit var instrumentationContext: Context
    private lateinit var presenter : MainViewModel

    @Mock
    private lateinit var view : MainViewModel.MainView

    @Before
    fun setup() {
        view = mock(MainViewModel.MainView::class.java)
        presenter = MainViewModel(view)

     //   instrumentationContext = InstrumentationRegistry.getInstrumentation().context
    }

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun testApi() {
        presenter.callApi()

        verify(view).showEmail("amir1.aa@gmail.com")
    }
}

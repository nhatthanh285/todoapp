package com.dat.androidhmi.composetodolist.features.host.ui

import app.cash.turbine.test
import com.dat.androidhmi.composetodolist.BaseViewModelTest
import com.dat.androidhmi.composetodolist.features.host.data.IHostEnvironment
import com.dat.androidhmi.composetodolist.features.host.ui.HostViewModel
import com.dat.androidhmi.composetodolist.model.Theme
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Test
import kotlin.time.ExperimentalTime

@ExperimentalTime
@ExperimentalCoroutinesApi
class HostViewModelTest : BaseViewModelTest() {

    @Test
    fun init() = runTest {
        val environment = object : IHostEnvironment {
            override fun getTheme(): Flow<Theme> {
                return flow { emit(Theme.SUNRISE) }
            }
        }

        val viewModel = HostViewModel(environment)

        viewModel.state.test {
            Assert.assertEquals(Theme.SUNRISE, awaitItem().theme)

            cancelAndConsumeRemainingEvents()
        }
    }

}

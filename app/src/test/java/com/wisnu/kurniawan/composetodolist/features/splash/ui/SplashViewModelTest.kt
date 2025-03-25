package com.dat.androidhmi.composetodolist.features.splash.ui

import com.dat.androidhmi.composetodolist.BaseViewModelTest
import com.dat.androidhmi.composetodolist.features.splash.data.ISplashEnvironment
import com.dat.androidhmi.composetodolist.features.splash.ui.SplashViewModel
import com.dat.androidhmi.composetodolist.model.Credential
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.time.ExperimentalTime

@ExperimentalTime
@ExperimentalCoroutinesApi
class SplashViewModelTest : BaseViewModelTest() {

    @Test
    fun appLaunchLoggedIn() = runTest {
        val splashEnvironment = buildFakeSplashEnvironment(Credential("qwe-123"))
        val splashViewModel = SplashViewModel(splashEnvironment)

//        splashViewModel.effect.test {
//            splashViewModel.dispatch(SplashAction.AppLaunch)
//
//            Assert.assertEquals(SplashEffect.NavigateToDashboard, awaitItem())
//
//            cancelAndConsumeRemainingEvents()
//        }
    }

    @Test
    fun appLaunchNotLoggedIn() = runTest {
        val splashEnvironment = buildFakeSplashEnvironment(Credential(""))
        val splashViewModel = SplashViewModel(splashEnvironment)

//        splashViewModel.effect.test {
//            splashViewModel.dispatch(SplashAction.AppLaunch)
//
//            Assert.assertEquals(SplashEffect.NavigateToLogin, awaitItem())
//
//            cancelAndConsumeRemainingEvents()
//        }
    }

    private fun buildFakeSplashEnvironment(credential: Credential): ISplashEnvironment {
        return object : ISplashEnvironment {
            override fun getCredential(): Flow<Credential> {
                return flow { emit(credential) }
            }
        }
    }

}

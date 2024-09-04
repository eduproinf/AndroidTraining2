package com.cepaleon.androidtraining2.features.login

import androidx.lifecycle.ViewModel
import com.cepaleon.androidtraining2.features.login.data.LoginDataRepository
import com.cepaleon.androidtraining2.features.login.data.remote.LoginMockRemoteDataSource
import com.cepaleon.androidtraining2.features.login.domain.LoginRepository
import com.cepaleon.androidtraining2.features.login.domain.SigninUseCase
import com.cepaleon.androidtraining2.features.login.presentation.LoginViewModel

class LoginFactory {

    // Atributos de clase
    private val loginMockRemoteDataSource: LoginMockRemoteDataSource = provideLoginMockRemoteDataSource()
    private val loginRepository: LoginRepository = provideLoginDataRepository()
    private val signinUseCase: SigninUseCase = provideSigninUseCase()


    // Métodos de clase
    fun provideLoginViewModel(): LoginViewModel {
        return LoginViewModel(signinUseCase)
    }

    private fun provideLoginMockRemoteDataSource(): LoginMockRemoteDataSource {
        return LoginMockRemoteDataSource()
    }

    private fun provideLoginDataRepository(): LoginDataRepository{
        return LoginDataRepository(loginMockRemoteDataSource)
    }

    fun provideSigninUseCase(): SigninUseCase {
        return SigninUseCase(loginRepository)
    }

}
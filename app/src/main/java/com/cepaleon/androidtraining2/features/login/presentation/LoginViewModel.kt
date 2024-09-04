package com.cepaleon.androidtraining2.features.login.presentation

import androidx.lifecycle.ViewModel
import com.cepaleon.androidtraining2.features.login.domain.SigninUseCase

class LoginViewModel(private val signinUseCase: SigninUseCase) : ViewModel () {

    fun validateClicked(username: String, password: String): Boolean {
        /* val useCase = SigninUseCase()
        useCase.invoke() */
        return signinUseCase.invoke(username, password)
    }

}
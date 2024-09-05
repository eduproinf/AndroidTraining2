package com.cepaleon.androidtraining2.features.login.presentation

import androidx.lifecycle.ViewModel
import com.cepaleon.androidtraining2.features.login.domain.DeleteUsernameUseCase
import com.cepaleon.androidtraining2.features.login.domain.GetUsernameUseCase
import com.cepaleon.androidtraining2.features.login.domain.SaveUsernameUseCase
import com.cepaleon.androidtraining2.features.login.domain.SigninUseCase

class LoginViewModel(
    private val signinUseCase: SigninUseCase,
    private val saveUsernameUseCase: SaveUsernameUseCase,
    private val deleteUsernameUseCase: DeleteUsernameUseCase,
    private val getUsernameUseCase: GetUsernameUseCase
) : ViewModel () {

    fun validateClicked(username: String, password: String, isRememberChecked: Boolean): Boolean {
        if (isRememberChecked){
            saveUsernameUseCase.invoke(username)
        } else {
            deleteUsernameUseCase.invoke()
        }
        return signinUseCase.invoke(username, password)
    }

    fun onResume(): String?{
        return getUsernameUseCase.invoke ()
    }

}
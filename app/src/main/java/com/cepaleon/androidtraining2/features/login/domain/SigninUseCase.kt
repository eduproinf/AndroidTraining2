package com.cepaleon.androidtraining2.features.login.domain

import com.cepaleon.androidtraining2.features.login.LoginFactory

class SigninUseCase (private val loginRepository: LoginRepository) {

    operator fun invoke(username: String, password: String):Boolean {
        return loginRepository.isValid(username,password)

    }
}
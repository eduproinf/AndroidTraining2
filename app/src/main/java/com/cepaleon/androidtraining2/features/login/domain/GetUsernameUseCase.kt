package com.cepaleon.androidtraining2.features.login.domain

class GetUsernameUseCase(private val loginRepository: LoginRepository) {

    //fun isValid (username: String, password: String): Boolean
    operator fun invoke(): String? {
        return loginRepository.getUsername()
    }
}
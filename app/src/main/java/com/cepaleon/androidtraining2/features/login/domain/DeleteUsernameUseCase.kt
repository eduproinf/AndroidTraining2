package com.cepaleon.androidtraining2.features.login.domain

class DeleteUsernameUseCase(private val loginRepository: LoginRepository) {

    //fun isValid (username: String, password: String): Boolean
    operator fun invoke() {
        loginRepository.deleteUsername()
    }
}
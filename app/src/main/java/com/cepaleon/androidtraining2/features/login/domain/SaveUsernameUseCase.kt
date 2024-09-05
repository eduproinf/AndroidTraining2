package com.cepaleon.androidtraining2.features.login.domain

class SaveUsernameUseCase (private val loginRepository: LoginRepository) {

    //fun isValid (username: String, password: String): Boolean
    operator fun invoke (username: String) {
      loginRepository.saveUsername (username)
    }
}
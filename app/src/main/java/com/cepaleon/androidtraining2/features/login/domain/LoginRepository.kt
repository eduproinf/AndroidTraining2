package com.cepaleon.androidtraining2.features.login.domain

interface LoginRepository {

    fun isValid(username: String, password:String): Boolean
}
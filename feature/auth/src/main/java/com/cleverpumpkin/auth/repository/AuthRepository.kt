package com.cleverpumpkin.auth.repository

interface AuthRepository {
    fun yandexAuth(yandexToken: String)


    fun getToken() : String

    fun canLogin(): Boolean
}

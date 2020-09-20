package com.jcabarique.tallernavegacionlogin.repository.api

import com.jcabarique.tallernavegacionlogin.data.LoginPost
import com.jcabarique.tallernavegacionlogin.data.Usuario
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

class LoginAPiService {
    private val loginApi = Retrofit.Builder()
        .baseUrl("https://movil-api.herokuapp.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(LoginApi::class.java)

    suspend fun signin(usuario: Usuario) : LoginPost{
        return loginApi.signin(usuario.email, usuario.password)
    }


    suspend fun signup(usuario: Usuario): LoginPost {
        return loginApi.signup(usuario.email, usuario.password, usuario.username, usuario.name)
    }
}
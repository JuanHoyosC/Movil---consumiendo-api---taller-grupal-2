package com.jcabarique.tallernavegacionlogin.repository.api

import com.jcabarique.tallernavegacionlogin.data.Courses
import com.jcabarique.tallernavegacionlogin.data.LoginPost
import com.jcabarique.tallernavegacionlogin.data.Usuario
import com.jcabarique.tallernavegacionlogin.recurso.PreferenceProvider
import com.jcabarique.tallernavegacionlogin.repository.MyRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

class LoginAPiService {
    private val loginApi = Retrofit.Builder()
        .baseUrl("https://movil-api.herokuapp.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(LoginApi::class.java)

    var dbId= MyRepository.getUsuario()
    private val courseApi = Retrofit.Builder()
        .baseUrl("https://movil-api.herokuapp.com/$dbId/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(CourseApi::class.java)

    suspend fun signin(usuario: Usuario) : LoginPost{
        return loginApi.signin(usuario.email, usuario.password)
    }


    suspend fun signup(usuario: Usuario): LoginPost {
        return loginApi.signup(usuario.email, usuario.password, usuario.username, usuario.name)
    }

    suspend fun getCourses():List<Courses> {
        val token = PreferenceProvider.getToken()
        return courseApi.getCourse( "Bearer "+token)
    }
}
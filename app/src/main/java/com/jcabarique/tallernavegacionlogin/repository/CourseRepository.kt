package com.jcabarique.tallernavegacionlogin.repository

import com.jcabarique.tallernavegacionlogin.data.Usuario
import com.jcabarique.tallernavegacionlogin.repository.api.LoginAPiService

object CourseRepository {
    private val apiService = LoginAPiService()

    suspend fun getCourses() = apiService.getCourses()
}
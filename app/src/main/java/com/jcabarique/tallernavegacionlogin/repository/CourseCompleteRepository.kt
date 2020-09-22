package com.jcabarique.tallernavegacionlogin.repository

import com.jcabarique.tallernavegacionlogin.repository.api.LoginAPiService

object CourseCompleteRepository {
    private val apiService = LoginAPiService()
    suspend fun getCoursesComplete() = apiService.getCoursesComplete()
}
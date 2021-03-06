package com.jcabarique.tallernavegacionlogin.repository

import com.jcabarique.tallernavegacionlogin.repository.api.GlobalAPiService

object CourseRepository {
    private val apiService = GlobalAPiService()

    suspend fun getCourses() = apiService.getCourses()
    suspend fun setCourse() = apiService.setCourse()


}
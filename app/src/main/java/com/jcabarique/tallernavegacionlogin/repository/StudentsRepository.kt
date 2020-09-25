package com.jcabarique.tallernavegacionlogin.repository

import com.jcabarique.tallernavegacionlogin.repository.api.GlobalAPiService

object StudentsRepository {
    private val apiService = GlobalAPiService()

    suspend fun getStudents() = apiService.getStudents()
    suspend fun getStudent() = apiService.getStudent()
    suspend fun setStudent() = apiService.setStudent()
}
package com.jcabarique.tallernavegacionlogin.repository

import com.jcabarique.tallernavegacionlogin.repository.api.GlobalAPiService

object ProfessorRepository {
    private val apiService = GlobalAPiService()

    suspend fun getProfessors() = apiService.getProfessors()
    suspend fun getProfessor() = apiService.getProfessor()
}
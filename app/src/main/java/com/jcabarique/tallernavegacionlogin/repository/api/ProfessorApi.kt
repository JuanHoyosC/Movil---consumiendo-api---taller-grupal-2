package com.jcabarique.tallernavegacionlogin.repository.api

import com.jcabarique.tallernavegacionlogin.data.CourseCompleteData
import com.jcabarique.tallernavegacionlogin.data.Professor
import com.jcabarique.tallernavegacionlogin.data.Student
import retrofit2.http.GET
import retrofit2.http.Header

interface ProfessorApi {

    @GET("professors")
    suspend fun getProfessors(
        @Header("Authorization") authToken:String
    ): List<Professor>

    @GET(".")
    suspend fun getProfessor(
        @Header("Authorization") authToken:String
    ): Student
}
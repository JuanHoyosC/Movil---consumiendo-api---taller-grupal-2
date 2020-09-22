package com.jcabarique.tallernavegacionlogin.repository.api

import com.jcabarique.tallernavegacionlogin.data.CourseComplete
import retrofit2.http.GET
import retrofit2.http.Header

interface CourseCompleteApi {
    @GET("")
    suspend fun getCoursesComplete(
        @Header("Authorization") authToken:String
    ): CourseComplete
}
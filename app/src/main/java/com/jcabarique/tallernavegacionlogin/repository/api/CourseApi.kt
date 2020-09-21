package com.jcabarique.tallernavegacionlogin.repository.api

import com.jcabarique.tallernavegacionlogin.data.Courses
import com.jcabarique.tallernavegacionlogin.recurso.PreferenceProvider
import com.jcabarique.tallernavegacionlogin.repository.MyRepository
import retrofit2.http.*


interface CourseApi {
        @GET("courses")
        suspend fun getCourse(
           @Header("Authorization") authToken:String
        ): List<Courses>

}
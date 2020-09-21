package com.jcabarique.tallernavegacionlogin.repository.api

import com.jcabarique.tallernavegacionlogin.data.Courses
import com.jcabarique.tallernavegacionlogin.recurso.PreferenceProvider
import com.jcabarique.tallernavegacionlogin.repository.MyRepository
import retrofit2.http.*


interface CourseApi {
        @GET("courses")
        suspend fun getCourses(
           @Header("Authorization") authToken:String
        ): List<Courses>

        @POST("courses")
        suspend fun setCourse(
            @Header("Authorization") authToken:String
        )

}
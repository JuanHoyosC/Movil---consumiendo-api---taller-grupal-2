package com.jcabarique.tallernavegacionlogin.repository.api


import com.jcabarique.tallernavegacionlogin.data.LoginPost
import com.jcabarique.tallernavegacionlogin.data.Student
import com.jcabarique.tallernavegacionlogin.data.StudentPost
import com.jcabarique.tallernavegacionlogin.data.Students
import retrofit2.http.*

interface StudentApi {


    @GET("students")
    suspend fun getStudents(
        @Header("Authorization") authToken:String
    ): List<Students>

    @GET(".")
    suspend fun getStudent(
        @Header("Authorization") authToken:String
    ): Student


    @FormUrlEncoded
    @POST("students")
    suspend fun setStudent(
        @Header("Authorization") authToken: String,
        @Field("courseId") courseId: String
    ): StudentPost
}
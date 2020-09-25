package com.jcabarique.tallernavegacionlogin.repository.api

import com.jcabarique.tallernavegacionlogin.data.LoginPost
import retrofit2.http.*

interface LoginApi {

    @FormUrlEncoded
    @POST("signin")
     suspend fun signin(
        @Field("email") email: String,
        @Field("password") password: String
    ): LoginPost

    @FormUrlEncoded
    @POST("signup")
    suspend fun signup(
        @Field("email") email: String,
        @Field("password") password: String,
        @Field("username") username: String,
        @Field("name") name: String

    ): LoginPost

}
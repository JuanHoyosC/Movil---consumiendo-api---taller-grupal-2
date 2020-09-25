package com.jcabarique.tallernavegacionlogin.repository.api

import com.jcabarique.tallernavegacionlogin.data.Students
import retrofit2.http.GET
import retrofit2.http.Header

interface Reiniciar {

    @GET("restart")
    suspend fun reiniciar(
        @Header("Authorization") authToken:String
    )

}
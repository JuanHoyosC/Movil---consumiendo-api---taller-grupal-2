package com.jcabarique.tallernavegacionlogin.repository

import com.jcabarique.tallernavegacionlogin.repository.api.GlobalAPiService

object ReiniciarRepository {
    private val apiService = GlobalAPiService()
    suspend fun reinciar() = apiService.reiniciar()
}
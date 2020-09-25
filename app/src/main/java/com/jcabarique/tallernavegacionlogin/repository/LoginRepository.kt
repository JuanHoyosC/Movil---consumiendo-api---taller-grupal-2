package com.jcabarique.tallernavegacionlogin.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jcabarique.tallernavegacionlogin.recurso.PreferenceProvider
import com.jcabarique.tallernavegacionlogin.repository.api.GlobalAPiService
import com.jcabarique.tallernavegacionlogin.data.Usuario

object LoginRepository {

    private val apiService = GlobalAPiService()

    suspend fun signin(usuario: Usuario) = apiService.signin(usuario)
    suspend fun signup(usuario: Usuario) = apiService.signup(usuario)


    var logged = MutableLiveData<Boolean>()
    var stateLogged : Boolean = false

    init {
        stateLogged = PreferenceProvider.getValue()!!
        logged.value = stateLogged;
    }

    fun getLogged() = logged as LiveData<Boolean>

    fun setLogged(state: Boolean){
        stateLogged = state
        logged.value = stateLogged;
        PreferenceProvider.setValue(state)
    }
}
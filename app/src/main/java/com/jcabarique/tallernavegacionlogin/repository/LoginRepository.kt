package com.jcabarique.tallernavegacionlogin.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jcabarique.tallernavegacionlogin.recurso.PreferenceProvider

object LoginRepository {
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
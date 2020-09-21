package com.jcabarique.tallernavegacionlogin.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jcabarique.tallernavegacionlogin.data.User
import com.jcabarique.tallernavegacionlogin.recurso.PreferenceProvider

object MyRepository {

    fun getUsuario() = PreferenceProvider.getUsuario();
    fun getToken() = PreferenceProvider.getToken();
    fun setUser(user: User) = PreferenceProvider.setUser(user)
    fun getEmail()  = PreferenceProvider.getEmail();
    fun getClave() = PreferenceProvider.getClave();

}

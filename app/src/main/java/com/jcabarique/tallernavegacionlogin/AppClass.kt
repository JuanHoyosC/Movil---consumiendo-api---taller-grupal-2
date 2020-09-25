package com.jcabarique.tallernavegacionlogin

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.jcabarique.tallernavegacionlogin.data.User
import com.jcabarique.tallernavegacionlogin.recurso.PreferenceProvider

class AppClass : Application() {
    override fun onCreate() {
        super.onCreate()
        PreferenceProvider.initialize(this)
    }
}





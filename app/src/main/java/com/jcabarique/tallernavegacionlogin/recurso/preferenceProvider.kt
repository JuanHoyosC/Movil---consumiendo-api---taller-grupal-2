package com.jcabarique.tallernavegacionlogin.recurso

import android.content.Context
import android.content.SharedPreferences
import com.jcabarique.tallernavegacionlogin.data.User


class PreferenceProvider {
    companion object {
        lateinit var preference: SharedPreferences
        fun initialize(context: Context) {
            preference = context.getSharedPreferences("myAppPrefs", Context.MODE_PRIVATE)
        }

        fun setValue(value: Boolean) {
            preference.edit().putBoolean("logged", value).apply()
        }


        fun getValue(): Boolean? {
            return preference.getBoolean("logged", false)
        }

        fun setUser(user: User) {
            preference.edit().putString("usuario", user.usuario).apply()
            preference.edit().putString("clave", user.clave).apply()
        }

        fun getUsuario(): String {
            return preference.getString("usuario", "Juan").toString()
        }

        fun getClave(): String {
            return preference.getString("clave", "1234").toString()
        }

    }
}
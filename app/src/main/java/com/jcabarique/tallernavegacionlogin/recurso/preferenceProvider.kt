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
            preference.edit().putString("token", user.token).apply()
            preference.edit().putString("email", user.email).apply()
            preference.edit().putString("clave", user.clave).apply()

        }

        fun getUsuario(): String {
            return preference.getString("usuario", "Juan").toString()
        }

        fun getToken(): String {
            return preference.getString("token", "1234").toString()
        }

        fun getEmail(): String {
            return preference.getString("email", "Juan").toString()
        }

        fun setIdCourse(value: String) {
            preference.edit().putString("idCourse", value).apply()
        }

        fun setIdStudent(value: String) {
            preference.edit().putString("idStudent", value).apply()
        }

        fun setCourse(value: String) {
            preference.edit().putString("nameCourse", value).apply()
        }

        fun setProfessor(value: String) {
            preference.edit().putString("professor", value).apply()
        }

        fun setIdProfessor(value: String) {
            preference.edit().putString("idProfessor", value).apply()
        }

        fun getCourse(): String {
            return preference.getString("nameCourse", "1234").toString()
        }

        fun getProfessor(): String {
            return preference.getString("professor", "1234").toString()
        }

        fun getIdProfessor(): String {
            return preference.getString("idProfessor", "1234").toString()
        }

        fun getIdCourse(): String {
            return preference.getString("idCourse", "1234").toString()
        }

        fun getIdStudent(): String {
            return preference.getString("idStudent", "1234").toString()
        }

        fun getClave(): String {
            return preference.getString("clave", "1234").toString()
        }

    }
}
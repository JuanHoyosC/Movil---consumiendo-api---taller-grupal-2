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
    fun setIdCourse(idCourse: String) = PreferenceProvider.setIdCourse(idCourse)
    fun getIdCourse() = PreferenceProvider.getIdCourse()
    fun setCourse(curso: String) = PreferenceProvider.setCourse(curso)
    fun getCourse() = PreferenceProvider.getCourse()
    fun setIdStudent(idStudent: String) = PreferenceProvider.setIdStudent(idStudent)
    fun getIdStudent() = PreferenceProvider.getIdStudent()
    fun setProfessor(professor: String) = PreferenceProvider.setProfessor(professor)
    fun getProfessor() = PreferenceProvider.getProfessor()
    fun setIdProfessor(idProfessor: String) = PreferenceProvider.setIdProfessor(idProfessor)
    fun getIdProfessor() = PreferenceProvider.getIdProfessor()
}

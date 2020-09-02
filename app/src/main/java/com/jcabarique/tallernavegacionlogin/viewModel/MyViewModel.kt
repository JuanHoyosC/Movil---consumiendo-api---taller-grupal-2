package com.jcabarique.tallernavegacionlogin.viewModel

import androidx.lifecycle.ViewModel
import com.jcabarique.tallernavegacionlogin.data.User
import com.jcabarique.tallernavegacionlogin.repository.MyRepository

class MyViewModel: ViewModel() {
    private val myRepository = MyRepository

    fun getUsuario() = MyRepository.getUsuario()
    fun getClave() = MyRepository.getClave()
    fun setUser(user: User) =  MyRepository.setUser(user)



}
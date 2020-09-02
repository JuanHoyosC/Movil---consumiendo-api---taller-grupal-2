package com.jcabarique.tallernavegacionlogin.viewModel


import androidx.lifecycle.ViewModel
import com.jcabarique.tallernavegacionlogin.repository.LoginRepository

class LoginViewModel: ViewModel() {
    private val loginRepository = LoginRepository
    fun getLogged() = loginRepository.getLogged()
    fun setLogged(state: Boolean){
        loginRepository.setLogged(state)
    }
}
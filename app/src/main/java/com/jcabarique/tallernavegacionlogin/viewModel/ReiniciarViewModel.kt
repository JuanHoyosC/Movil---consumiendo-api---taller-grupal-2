package com.jcabarique.tallernavegacionlogin.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jcabarique.tallernavegacionlogin.data.User
import com.jcabarique.tallernavegacionlogin.data.Usuario
import com.jcabarique.tallernavegacionlogin.repository.LoginRepository
import com.jcabarique.tallernavegacionlogin.repository.MyRepository
import com.jcabarique.tallernavegacionlogin.repository.ReiniciarRepository
import kotlinx.coroutines.launch

class ReiniciarViewModel : ViewModel(){
    private val reiniciarRepository = ReiniciarRepository
    private val myRepository = MyRepository
    private val loginRepository = LoginRepository

    fun reiniciar() {
        val usuario = Usuario(myRepository.getEmail(), myRepository.getClave())
        viewModelScope.launch {
            val theReturnPost = loginRepository.signin(usuario)
            if (theReturnPost.token.length !== 0) {
                val user = User(theReturnPost.username, theReturnPost.token, theReturnPost.email, usuario.password);
                //Se manda el usuario y el token al preference
                myRepository.setUser(user);
                val theReturnPost = reiniciarRepository.reinciar()
            }
        }
    }

}
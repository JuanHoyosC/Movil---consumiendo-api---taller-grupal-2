package com.jcabarique.tallernavegacionlogin.viewModel


import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jcabarique.tallernavegacionlogin.data.User
import com.jcabarique.tallernavegacionlogin.data.Usuario
import com.jcabarique.tallernavegacionlogin.repository.LoginRepository
import com.jcabarique.tallernavegacionlogin.repository.MyRepository
import kotlinx.android.synthetic.main.fragment_login.view.*
import kotlinx.coroutines.launch
import java.io.IOException


class LoginViewModel: ViewModel() {
    private val loginRepository = LoginRepository
    private val myRepository = MyRepository

    fun getLogged() = loginRepository.getLogged()

    fun setLogged(state: Boolean){
        loginRepository.setLogged(state)
    }


    fun signin(usuario: Usuario, it: View) {
       viewModelScope.launch {
            try {

                val theReturnPost = loginRepository.signin(usuario)
                Log.d("Mensaje", theReturnPost.token + " " + theReturnPost.username)
                if  (theReturnPost.token.length !== 0) {
                    val user = User(theReturnPost.username, theReturnPost.token, theReturnPost.email, usuario.password);
                    //Se manda el usuario y el token al preference
                    myRepository.setUser(user);
                    setLogged(true);

                }else{
                    setLogged(false);
                    it.errorLogin.text = "El usuario o la contraseña son incorrectos";
                }
            } catch (e: IOException) {
                // handle failure to read error
            }
        }
    }


    fun signup(usuario: Usuario) {
        viewModelScope.launch {
            val theReturnPost = loginRepository.signup(usuario)

        }
    }

}
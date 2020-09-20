package com.jcabarique.tallernavegacionlogin.viewModel


import android.util.Log
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jcabarique.tallernavegacionlogin.data.LoginPost
import com.jcabarique.tallernavegacionlogin.data.User
import com.jcabarique.tallernavegacionlogin.repository.LoginRepository
import com.jcabarique.tallernavegacionlogin.data.Usuario
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
            val theReturnPost = loginRepository.signin(usuario)
            Log.d("Mensaje", theReturnPost.token + " " + theReturnPost.name)
            if  (theReturnPost.token.length !== 0) {
                val user = User(theReturnPost.name, theReturnPost.token);
                //Se manda el usuario y el token al preference
                myRepository.setUser(user);
                setLogged(true);

            }else{
                setLogged(false);
                it.errorLogin.text = "El usuario o la contraseña son incorrectos";
            }
        }
    }


    fun signup(usuario: Usuario) {
        viewModelScope.launch {
            val theReturnPost = loginRepository.signup(usuario)

        }
    }

}
package com.jcabarique.tallernavegacionlogin.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.jcabarique.tallernavegacionlogin.R
import com.jcabarique.tallernavegacionlogin.data.Usuario
import com.jcabarique.tallernavegacionlogin.viewModel.LoginViewModel
import com.jcabarique.tallernavegacionlogin.viewModel.MyViewModel
import kotlinx.android.synthetic.main.fragment_signup.view.*

// TODO: Rename parameter arguments, choose names that match

class Signup : Fragment() {


    val myViewModel: MyViewModel by activityViewModels()
    val loginViewModel: LoginViewModel by activityViewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_signup, container, false)

        view.buttonRegistrarse.setOnClickListener {
            val usuario: EditText = view.usuarioInput1
            val clave: EditText = view.claveInput1
            val username: EditText = view.username
            val nombre: EditText = view.name

            if (usuario.text.toString().length !== 0 && clave.text.toString().length !== 0){
                val usuario = Usuario(
                    usuario.text.toString(),
                    clave.text.toString(),
                    username.text.toString(),
                    nombre.text.toString()
                )
                loginViewModel.signup(usuario);
                Navigation.findNavController(view).navigate(R.id.action_signup_to_login)
            }else{
                view.errorSignUp.text = "Los campos deben ser llenados"
            }

        }
        return view
    }


}
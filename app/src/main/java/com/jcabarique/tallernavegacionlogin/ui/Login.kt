package com.jcabarique.tallernavegacionlogin.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.jcabarique.tallernavegacionlogin.R
import com.jcabarique.tallernavegacionlogin.data.Usuario
import com.jcabarique.tallernavegacionlogin.viewModel.LoginViewModel
import com.jcabarique.tallernavegacionlogin.viewModel.MyViewModel
import kotlinx.android.synthetic.main.fragment_login.view.*

class Login : Fragment() {
    val loginViewModel: LoginViewModel by activityViewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_login, container, false)

        view.navegarSignUp.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_login_to_signup)
        }

        val navController = findNavController()
        loginViewModel.getLogged().observe(viewLifecycleOwner, Observer { logged ->
            if (logged == true) {
                navController.navigate(R.id.action_login_to_home3)
            }
        })

        view.buttonIngresar.setOnClickListener {
            val email: EditText = view.usuarioInput
            val clave: EditText = view.claveInput

            val usuario = Usuario(email.text.toString(),clave.text.toString())
            loginViewModel.signin(usuario, view)


        }

        return view
    }


}
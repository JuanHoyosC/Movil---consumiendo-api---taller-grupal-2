package com.jcabarique.tallernavegacionlogin.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.jcabarique.tallernavegacionlogin.R
import com.jcabarique.tallernavegacionlogin.data.Usuario
import com.jcabarique.tallernavegacionlogin.viewModel.CourseViewModel
import com.jcabarique.tallernavegacionlogin.viewModel.LoginViewModel
import com.jcabarique.tallernavegacionlogin.viewModel.MyViewModel
import kotlinx.android.synthetic.main.fragment_home.view.*


class Home : Fragment() {
    val loginViewModel: LoginViewModel by activityViewModels()
    val courseViewModel: CourseViewModel by activityViewModels()
    val myViewModel: MyViewModel by activityViewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_home, container, false)
        view.textUsuario.text = "Bienvenido " + myViewModel.getUsuario()
        val navController = findNavController()
        loginViewModel.getLogged().observe(viewLifecycleOwner, Observer { logged ->
            if (logged == false) {
                navController.navigate(R.id.action_home3_to_login)
            }
        })

        view.findViewById<Button>(R.id.button).setOnClickListener {
            navController.navigate(R.id.action_home3_to_todos)
        }

        view.findViewById<Button>(R.id.btnCursos).setOnClickListener {
            val usuario = Usuario(myViewModel.getEmail(), myViewModel.getClave())
            loginViewModel.signin(usuario, view)
            navController.navigate(R.id.action_home3_to_course)
        }

        view.findViewById<Button>(R.id.buttonCrear).setOnClickListener {
            val usuario = Usuario(myViewModel.getEmail(), myViewModel.getClave())
            loginViewModel.signin(usuario, view)
            courseViewModel.setCourse();
        }

        view.buttonSalir.setOnClickListener {
           loginViewModel.setLogged(false)
        }
        return view
    }


}
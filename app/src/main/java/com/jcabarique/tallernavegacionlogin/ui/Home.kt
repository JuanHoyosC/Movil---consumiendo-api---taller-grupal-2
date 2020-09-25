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
import com.jcabarique.tallernavegacionlogin.viewModel.ReiniciarViewModel
import kotlinx.android.synthetic.main.fragment_home.view.*


class Home : Fragment() {
    val loginViewModel: LoginViewModel by activityViewModels()
    val courseViewModel: CourseViewModel by activityViewModels()
    val reiniciarViewModel: ReiniciarViewModel by activityViewModels()
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


        view.findViewById<Button>(R.id.btnCursos).setOnClickListener {
            courseViewModel.loginCourse()
            courseViewModel.allCourses.clear()
            navController.navigate(R.id.action_home3_to_coursesFragment)
        }

        view.findViewById<Button>(R.id.btnReiniciar).setOnClickListener {
            val usuario = Usuario(myViewModel.getEmail(), myViewModel.getClave())
            reiniciarViewModel.reiniciar()
            view.textReinicio.text = "Se reinicio la DB"
            view.textAgregado.text = ""
        }


        view.findViewById<Button>(R.id.buttonCrear).setOnClickListener {
            val usuario = Usuario(myViewModel.getEmail(), myViewModel.getClave())
            courseViewModel.setCourse();
            view.textReinicio.text = ""
            view.textAgregado.text = "Se agrego un curso"
        }

        view.buttonSalir.setOnClickListener {
           loginViewModel.setLogged(false)
        }
        return view
    }


}
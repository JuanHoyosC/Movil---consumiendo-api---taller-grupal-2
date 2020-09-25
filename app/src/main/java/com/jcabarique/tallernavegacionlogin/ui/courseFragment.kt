package com.jcabarique.tallernavegacionlogin.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.jcabarique.tallernavegacionlogin.R
import com.jcabarique.tallernavegacionlogin.data.Usuario
import com.jcabarique.tallernavegacionlogin.repository.MyRepository
import com.jcabarique.tallernavegacionlogin.viewModel.*
import kotlinx.android.synthetic.main.fragment_course.view.*


class courseFragment : Fragment() {

    private val myRepository = MyRepository
    val studentsViewModel: StudentsViewModel by activityViewModels()
    val professorViewModel: ProfessorViewModel by activityViewModels()
    val loginViewModel: LoginViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_course, container, false)
        view.textCourse.text = myRepository.getCourse()

        val navController = findNavController()
        view.findViewById<Button>(R.id.btnVerEstudiantes).setOnClickListener {

            studentsViewModel.students.clear()
            studentsViewModel.loginStudents()
            navController.navigate(R.id.action_courseFragment_to_studentsFragment)
        }

        view.findViewById<Button>(R.id.btnAgregar).setOnClickListener {
            studentsViewModel.postAStudent();
            view.textStudentNuevo.text = "Se creo un nuevo usuario"
        }

        view.findViewById<Button>(R.id.btnProfessor).setOnClickListener {

            professorViewModel.professor.clear()
            professorViewModel.allProfessor.clear()
            professorViewModel.loginProffesor()

            navController.navigate(R.id.action_courseFragment_to_professorFragment)
        }
        return view
    }

}
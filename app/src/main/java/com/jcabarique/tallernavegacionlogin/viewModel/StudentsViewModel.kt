package com.jcabarique.tallernavegacionlogin.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jcabarique.tallernavegacionlogin.data.Student
import com.jcabarique.tallernavegacionlogin.data.Students
import com.jcabarique.tallernavegacionlogin.data.User
import com.jcabarique.tallernavegacionlogin.data.Usuario
import com.jcabarique.tallernavegacionlogin.repository.LoginRepository
import com.jcabarique.tallernavegacionlogin.repository.MyRepository
import com.jcabarique.tallernavegacionlogin.repository.StudentsRepository
import kotlinx.coroutines.launch

class StudentsViewModel: ViewModel() {
    private val myRepository = MyRepository
    private val repository = StudentsRepository
    private val loginRepository = LoginRepository

    val students = mutableListOf<Students>()
    val studentsLiveData = MutableLiveData<List<Students>>()
    val student = mutableListOf<Student>()
    val studentLiveData = MutableLiveData<List<Student>>()

    fun loginStudents() {
        val usuario = Usuario(myRepository.getEmail(), myRepository.getClave())
        viewModelScope.launch {
            val theReturnPost = loginRepository.signin(usuario)

            if (theReturnPost.token.length !== 0) {
                val user = User(theReturnPost.username, theReturnPost.token, theReturnPost.email, usuario.password);
                //Se manda el usuario y el token al preference
                myRepository.setUser(user);
                getStudents()
            }
        }
    }

    private fun getStudents() {
        viewModelScope.launch {
                //Se manda el usuario y el token al preference
                students.addAll(repository.getStudents())
                studentsLiveData.postValue(students)
        }
    }

     fun loginStudent() {
         val usuario = Usuario(myRepository.getEmail(), myRepository.getClave())
         viewModelScope.launch {
             val theReturnPost = loginRepository.signin(usuario)

             if (theReturnPost.token.length !== 0) {
                 val user = User(
                     theReturnPost.username,
                     theReturnPost.token,
                     theReturnPost.email,
                     usuario.password
                 );
                 //Se manda el usuario y el token al preference

                 getStudent()
             }
         }

    }

    private fun getStudent() {
        Log.d("mensaje", "mensaje log")
        viewModelScope.launch {
            student.addAll(repository.getStudent())
            studentLiveData.postValue(student)
        }
    }

    fun postAStudent() {
        val usuario = Usuario(myRepository.getEmail(), myRepository.getClave())
        viewModelScope.launch {
            val theReturnPost = loginRepository.signin(usuario)
            if (theReturnPost.token.length !== 0) {
                val user = User(theReturnPost.username, theReturnPost.token, theReturnPost.email, usuario.password)
                myRepository.setUser(user);
                repository.setStudent()
            }
        }
    }

}
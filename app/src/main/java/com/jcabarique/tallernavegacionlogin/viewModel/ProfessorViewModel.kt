package com.jcabarique.tallernavegacionlogin.viewModel

import android.os.Handler
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jcabarique.tallernavegacionlogin.data.*
import com.jcabarique.tallernavegacionlogin.repository.LoginRepository
import com.jcabarique.tallernavegacionlogin.repository.MyRepository
import com.jcabarique.tallernavegacionlogin.repository.ProfessorRepository
import kotlinx.coroutines.launch

class ProfessorViewModel : ViewModel() {
    private val myRepository = MyRepository
    private val professorRepository = ProfessorRepository
    val allProfessor = mutableListOf<Professor>()
    val professor = mutableListOf<Student>()
    val allProfessorLiveData = MutableLiveData<List<Student>>()
    private val loginRepository = LoginRepository

    init {
        professor.clear()
        allProfessor.clear()
    }

    fun loginProffesor()  {
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
                myRepository.setUser(user);
                getProfessors()
            }
        }
    }

    fun getProfessors(){
        viewModelScope.launch {
            allProfessor.clear()
            allProfessor.addAll(professorRepository.getProfessors())
            for (item in allProfessor) {
                if(("Profesor: " + item.name) == myRepository.getProfessor()){
                    myRepository.setIdProfessor(item.id.toString())
                     viewModelScope.launch {
                         professor.clear()
                         professor.addAll(professorRepository.getProfessor())
                         allProfessorLiveData.postValue(professor)
                     }
                }
            }
        }
    }


}
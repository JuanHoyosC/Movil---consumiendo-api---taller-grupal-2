package com.jcabarique.tallernavegacionlogin.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jcabarique.tallernavegacionlogin.data.Courses
import com.jcabarique.tallernavegacionlogin.data.User
import com.jcabarique.tallernavegacionlogin.data.Usuario
import com.jcabarique.tallernavegacionlogin.repository.CourseRepository
import com.jcabarique.tallernavegacionlogin.repository.LoginRepository
import com.jcabarique.tallernavegacionlogin.repository.MyRepository
import kotlinx.coroutines.launch

class CourseViewModel: ViewModel(){

    private val myRepository = MyRepository
    private val courseRepository = CourseRepository
    val allCourses = mutableListOf<Courses>()
    val allCoursesLiveData = MutableLiveData<List<Courses>>()
    private val loginRepository = LoginRepository

    init {
        allCourses.clear()
    }

    fun setCourse() {
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
                myRepository.setUser(user);
                //Se manda el usuario y el token al preference
                val theReturnCourse = courseRepository.setCourse()
            }
        }
    }

    fun loginCourse() {
        val usuario = Usuario(myRepository.getEmail(), myRepository.getClave())
        viewModelScope.launch {
            val theReturnPost = loginRepository.signin(usuario)

            if (theReturnPost.token.length !== 0) {
                val user = User(theReturnPost.username, theReturnPost.token, theReturnPost.email, usuario.password);
                //Se manda el usuario y el token al preference
                myRepository.setUser(user);
                getCourses()
            }
        }
    }

    fun getCourses(){
        viewModelScope.launch {
            allCourses.addAll(courseRepository.getCourses())
            allCoursesLiveData.postValue(allCourses)
        }
    }

}
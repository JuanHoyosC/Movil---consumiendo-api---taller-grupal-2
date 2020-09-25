package com.jcabarique.tallernavegacionlogin.repository.api

import android.os.Handler
import android.util.Log
import com.jcabarique.tallernavegacionlogin.data.*
import com.jcabarique.tallernavegacionlogin.recurso.PreferenceProvider
import com.jcabarique.tallernavegacionlogin.repository.MyRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GlobalAPiService {
    var dbId= MyRepository.getUsuario()
    var idCourse = MyRepository.getIdCourse()
    var idStudent = MyRepository.getIdStudent()
    var idProfessor = MyRepository.getIdProfessor()
    var student = mutableListOf<Student>()
    var professor = mutableListOf<Student>()

    private val loginApi = Retrofit.Builder()
        .baseUrl("https://movil-api.herokuapp.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(LoginApi::class.java)


    private val courseApi = Retrofit.Builder()
        .baseUrl("https://movil-api.herokuapp.com/$dbId/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(CourseApi::class.java)


    private val professorApi = Retrofit.Builder()
        .baseUrl("https://movil-api.herokuapp.com/$dbId/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ProfessorApi::class.java)

    private val StudentsApi = Retrofit.Builder()
        .baseUrl("https://movil-api.herokuapp.com/$dbId/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(StudentApi::class.java)



    private val StudentApi1 = Retrofit.Builder()
        .baseUrl("https://movil-api.herokuapp.com/$dbId/students/$idStudent/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(StudentApi::class.java)

    private val professorApi1 =  Retrofit.Builder()
            .baseUrl("https://movil-api.herokuapp.com/$dbId/professors/$idProfessor/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ProfessorApi::class.java)


    private val ReiniciarApi = Retrofit.Builder()
        .baseUrl("https://movil-api.herokuapp.com/$dbId/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(Reiniciar::class.java)

    suspend fun signin(usuario: Usuario) : LoginPost {
        return loginApi.signin(usuario.email, usuario.password)
    }


    suspend fun signup(usuario: Usuario): LoginPost {
        return loginApi.signup(usuario.email, usuario.password, usuario.username, usuario.name)
    }

    suspend fun getCourses(): List<Courses> {
        val token = PreferenceProvider.getToken()
        return courseApi.getCourses( "Bearer " + token)
    }

    suspend fun setCourse(){
        val token = PreferenceProvider.getToken()
        return courseApi.setCourse( "Bearer " + token)
    }


    suspend fun getStudents(): List<Students> {
        val token = PreferenceProvider.getToken()
        return StudentsApi.getStudents( "Bearer " + token)
    }

    suspend fun getProfessors(): List<Professor> {
        val token = PreferenceProvider.getToken()
        return professorApi.getProfessors( "Bearer " + token)
    }

    suspend fun setStudent(): StudentPost {
        val token = PreferenceProvider.getToken()
        return StudentsApi.setStudent( "Bearer " + token, idCourse)
    }

    suspend fun getStudent(): List<Student> {
        val token = PreferenceProvider.getToken()
        Log.d("token", token)
        idStudent = MyRepository.getIdStudent()
        Log.d("idStuden", idStudent)

        student.clear()
        student.add(StudentApi1.getStudent( "Bearer " + token))
        return student
    }

    suspend fun getProfessor(): List<Student> {
        val token = PreferenceProvider.getToken()
        idProfessor = MyRepository.getIdProfessor()
        Log.d("mensaje de que", idProfessor)

        professor.clear()
        professor.add(professorApi1.getProfessor( "Bearer " + token))
        return professor
    }

    suspend fun reiniciar() {
        val token = PreferenceProvider.getToken()
        return ReiniciarApi.reiniciar("Bearer "+ token)
    }


}
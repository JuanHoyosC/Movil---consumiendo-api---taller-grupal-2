package com.jcabarique.tallernavegacionlogin.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jcabarique.tallernavegacionlogin.data.Courses
import com.jcabarique.tallernavegacionlogin.repository.CourseRepository
import com.jcabarique.tallernavegacionlogin.repository.api.Todo
import kotlinx.coroutines.launch

class CourseViewModel: ViewModel(){

    private val courseRepository = CourseRepository
    val allCourses = mutableListOf<Courses>()
    val allCoursesLiveData = MutableLiveData<List<Courses>>()

    init {
        getCourses()
    }


    fun getCourses(){
        viewModelScope.launch {
            val theReturnCourse = courseRepository.getCourses()
            allCourses.addAll(courseRepository.getCourses())
            allCoursesLiveData.postValue(allCourses)
        }
    }
}
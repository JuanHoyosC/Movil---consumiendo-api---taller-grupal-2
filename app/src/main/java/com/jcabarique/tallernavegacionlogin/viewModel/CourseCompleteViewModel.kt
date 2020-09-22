package com.jcabarique.tallernavegacionlogin.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jcabarique.tallernavegacionlogin.data.CourseComplete
import com.jcabarique.tallernavegacionlogin.repository.CourseCompleteRepository
import kotlinx.coroutines.launch

class CourseCompleteViewModel:ViewModel() {
    private val courseCompleteRepository = CourseCompleteRepository
    val CourseComplete = mutableListOf<CourseComplete>()
    val CourseCompleteLiveData = MutableLiveData<List<CourseComplete>>()

    init{
        getCoursesComplete()
    }

    fun getCoursesComplete(){
        viewModelScope.launch {
            val theReturnCourseComplete = courseCompleteRepository.getCoursesComplete()
            CourseComplete.add(theReturnCourseComplete)
            CourseCompleteLiveData.postValue(CourseComplete)
        }
    }


}
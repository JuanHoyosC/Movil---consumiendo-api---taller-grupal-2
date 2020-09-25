package com.jcabarique.tallernavegacionlogin.data

data class CourseCompleteData (
    val name : String,
    val profesor: Professor,
    val students: List<Students>
)
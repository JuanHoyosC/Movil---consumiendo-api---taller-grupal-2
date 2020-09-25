package com.jcabarique.tallernavegacionlogin.data

data class StudentPost (
    val dbID: String,
    val courseID: String,
    val personID: Long,
    val createdAt: String,
    val updatedAt: String,
    val id: Int
){
    var error: String = ""
}
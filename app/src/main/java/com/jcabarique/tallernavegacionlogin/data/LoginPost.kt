package com.jcabarique.tallernavegacionlogin.data

data class LoginPost (
    val type: String,
    val token : String,
    val username: String,
    val name: String,
    val email: String
)
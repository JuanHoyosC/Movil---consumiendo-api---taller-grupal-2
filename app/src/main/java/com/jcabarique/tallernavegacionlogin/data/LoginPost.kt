package com.jcabarique.tallernavegacionlogin.data

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer

data class LoginPost (
    val type: String,
    val token : String,
    val username: String,
    val name: String,
    val email: String
) {
    var error: String = ""
}
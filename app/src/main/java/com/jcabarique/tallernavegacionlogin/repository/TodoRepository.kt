package com.jcabarique.tallernavegacionlogin.repository

import com.jcabarique.tallernavegacionlogin.repository.api.Todo
import com.jcabarique.tallernavegacionlogin.repository.api.TodosApiService

class TodoRepository {

    private val apiService = TodosApiService()

    suspend fun getTodos() = apiService.getTodos()

    suspend fun getTodo(index : Int) = apiService.getTodo(index)

    suspend fun postATodo(todo: Todo) = apiService.postATodo(todo)

}
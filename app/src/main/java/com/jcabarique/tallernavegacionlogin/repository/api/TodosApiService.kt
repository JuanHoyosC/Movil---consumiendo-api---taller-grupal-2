package com.jcabarique.tallernavegacionlogin.repository.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TodosApiService {
    private val todosApi = Retrofit.Builder()
    .baseUrl("https://jsonplaceholder.typicode.com/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()
    .create(TodosApi::class.java)

    suspend fun getTodos(): List<Todo> {
        return todosApi.getTodos()
    }

    suspend fun getTodo(index : Int): Todo {
        return todosApi.getTodo(index)
    }

    suspend fun postATodo(todo: Todo): Todo {
        return todosApi.postATodo(todo)
    }
}
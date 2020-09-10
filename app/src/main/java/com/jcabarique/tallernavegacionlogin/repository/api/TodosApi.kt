package com.jcabarique.tallernavegacionlogin.repository.api

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface TodosApi {
        @GET("todos/")
        suspend fun getTodos(): List<Todo>

        @GET("todos/{index}/")
        suspend fun getTodo(@Path("index") index: Int): Todo

        @POST("todos/")
        suspend fun postATodo(@Body post: Todo): Todo
}



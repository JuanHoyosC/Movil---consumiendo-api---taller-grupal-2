package com.jcabarique.tallernavegacionlogin.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jcabarique.tallernavegacionlogin.repository.TodoRepository
import com.jcabarique.tallernavegacionlogin.repository.api.Todo
import kotlinx.coroutines.launch

class TodoViewModel: ViewModel() {

    private val repository = TodoRepository()
    val todos = mutableListOf<Todo>()
    val todosLiveData = MutableLiveData<List<Todo>>()

    init {
        getTodos()
    }

    private fun getTodos() {
        viewModelScope.launch {
            todos.addAll(repository.getTodos())
            todosLiveData.postValue(todos)
        }
    }


    fun getTodo() {
        viewModelScope.launch {
            val post = repository.getTodo(todos.size+1)
            todos.add(post)
            todosLiveData.postValue(todos)
        }
    }

    fun postATodo(todo: Todo) {
        viewModelScope.launch {
            val theReturnPost = repository.postATodo(todo)
            todos.add(theReturnPost)
            todosLiveData.postValue(todos)
        }
    }

}
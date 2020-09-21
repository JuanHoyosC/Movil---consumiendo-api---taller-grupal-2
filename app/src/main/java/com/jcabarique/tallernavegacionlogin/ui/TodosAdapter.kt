package com.jcabarique.tallernavegacionlogin.ui

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jcabarique.tallernavegacionlogin.R
import com.jcabarique.tallernavegacionlogin.repository.api.Todo
import kotlinx.android.synthetic.main.list_item_todo.view.*


class TodosAdapter(val todos: ArrayList<Todo>): RecyclerView.Adapter<TodosAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_todo, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return todos.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(todos[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(todo: Todo) {
            if(todo.completed) {
                itemView.tittle.setBackgroundColor(Color.parseColor("#FF5233"))
                itemView.completed.setBackgroundColor(Color.parseColor("#3390FF"))
            }
            itemView.tittle.text = todo.title
            itemView.completed.text = todo.completed.toString()
        }
    }
}
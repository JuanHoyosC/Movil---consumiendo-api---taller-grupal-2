package com.jcabarique.tallernavegacionlogin.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.jcabarique.tallernavegacionlogin.R
import com.jcabarique.tallernavegacionlogin.repository.api.Todo
import com.jcabarique.tallernavegacionlogin.viewModel.TodoViewModel
import kotlinx.android.synthetic.main.fragment_todos.view.*


class Todos : Fragment() {

    val todoViewModel: TodoViewModel by activityViewModels()
    private val adapter = TodosAdapter(ArrayList())
    lateinit var todos : List<Todo>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_todos, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // requireView gets the root view for the fragment's layout
        // (the one returned by onCreateView).
        requireView().posts_recycler.adapter = adapter
        requireView().posts_recycler.layoutManager = LinearLayoutManager(requireContext())

        // get the live data and start observing
        todoViewModel.todosLiveData.observe(getViewLifecycleOwner(), Observer {
            adapter.todos.clear()
            adapter.todos.addAll(it)
            adapter.notifyDataSetChanged()
        })

    }


}
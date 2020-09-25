package com.jcabarique.tallernavegacionlogin.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.jcabarique.tallernavegacionlogin.R
import com.jcabarique.tallernavegacionlogin.data.Student
import com.jcabarique.tallernavegacionlogin.data.Students
import com.jcabarique.tallernavegacionlogin.viewModel.StudentsViewModel
import kotlinx.android.synthetic.main.fragment_courses.view.*


class StudentFragment : Fragment() {


    val studentsViewModel : StudentsViewModel by activityViewModels()
    private val adapter = StudentAdapter(ArrayList())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        studentsViewModel.loginStudent()
        studentsViewModel.student.clear()
        return inflater.inflate(R.layout.fragment_student, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // requireView gets the root view for the fragment's layout
        // (the one returned by onCreateView).
        requireView().courses_recycler.adapter = adapter
        requireView().courses_recycler.layoutManager = LinearLayoutManager(requireContext())

        // get the live data and start observing
        studentsViewModel.studentLiveData.observe(getViewLifecycleOwner(), Observer {
            adapter.student.clear()
            adapter.student.addAll(it)
            adapter.notifyDataSetChanged()
        })

    }
}
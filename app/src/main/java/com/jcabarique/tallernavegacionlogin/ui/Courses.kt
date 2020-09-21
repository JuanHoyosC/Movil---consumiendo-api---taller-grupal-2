package com.jcabarique.tallernavegacionlogin.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.jcabarique.tallernavegacionlogin.R
import com.jcabarique.tallernavegacionlogin.data.Courses
import com.jcabarique.tallernavegacionlogin.viewModel.CourseViewModel
import kotlinx.android.synthetic.main.fragment_courses.view.*

class Course : Fragment() {

    val courseViewModel : CourseViewModel by activityViewModels()
    private val adapter = CoursesAdapter(ArrayList())
    lateinit var courses: List<Courses>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_courses, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // requireView gets the root view for the fragment's layout
        // (the one returned by onCreateView).
        requireView().courses_recycler.adapter = adapter
        requireView().courses_recycler.layoutManager = LinearLayoutManager(requireContext())

        // get the live data and start observing
        courseViewModel.allCoursesLiveData.observe(getViewLifecycleOwner(), Observer {
            adapter.courses .clear()
            adapter.courses.addAll(it)
            adapter.notifyDataSetChanged()
        })

    }

}
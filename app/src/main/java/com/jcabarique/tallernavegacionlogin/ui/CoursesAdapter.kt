package com.jcabarique.tallernavegacionlogin.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.jcabarique.tallernavegacionlogin.R
import com.jcabarique.tallernavegacionlogin.data.Courses
import com.jcabarique.tallernavegacionlogin.repository.MyRepository
import kotlinx.android.synthetic.main.list_item_course.view.*


class CoursesAdapter (val courses: ArrayList<Courses>): RecyclerView.Adapter<CoursesAdapter.ViewHolder>() {
    private val myRepository = MyRepository
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_course, parent, false)

        view.findViewById<CardView>(R.id.cardStudent).setOnClickListener {
            myRepository.setIdCourse(it.idCourse.text.toString())
            myRepository.setCourse(it.nameStudent2.text.toString())
            myRepository.setProfessor(it.usernameStudent2.text.toString())
            view.findNavController().navigate(R.id.action_coursesFragment_to_courseFragment)

        }
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return courses.size
    }



    override fun onBindViewHolder(holder: CoursesAdapter.ViewHolder, position: Int) {
        holder.bind(courses[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(course: Courses) {
            itemView.idCourse.text = course.id.toString()
            itemView.usernameStudent2.text = "Profesor: " + course.professor
            itemView.nameStudent2.text = "Nombre: " + course.name
            itemView.phoneStudent2.text = "Numero de estudiantes: " + course.students
        }
    }

}
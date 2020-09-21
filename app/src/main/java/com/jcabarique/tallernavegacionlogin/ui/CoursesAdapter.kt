package com.jcabarique.tallernavegacionlogin.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jcabarique.tallernavegacionlogin.R
import com.jcabarique.tallernavegacionlogin.data.Courses
import kotlinx.android.synthetic.main.list_item_course.view.*
import kotlinx.android.synthetic.main.list_item_todo.view.*

class CoursesAdapter (val courses: ArrayList<Courses>): RecyclerView.Adapter<CoursesAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_course, parent, false)
        return ViewHolder(view)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(course: Courses) {
            itemView.idCourse.text = course.id.toString()
            itemView.profesor.text = course.professor
            itemView.nameCourse.text = course.name
            itemView.numStudents.text = course.students.toString()
        }
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
        return courses.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
        holder.bind(courses[position])
    }

}
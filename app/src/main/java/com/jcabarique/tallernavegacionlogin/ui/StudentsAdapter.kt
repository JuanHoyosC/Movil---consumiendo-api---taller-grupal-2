package com.jcabarique.tallernavegacionlogin.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.jcabarique.tallernavegacionlogin.R
import com.jcabarique.tallernavegacionlogin.data.Students
import com.jcabarique.tallernavegacionlogin.repository.MyRepository
import com.jcabarique.tallernavegacionlogin.viewModel.CourseViewModel
import com.jcabarique.tallernavegacionlogin.viewModel.StudentsViewModel
import kotlinx.android.synthetic.main.list_item_course.view.*


class StudentsAdapter (val students: ArrayList<Students>): RecyclerView.Adapter<StudentsAdapter.ViewHolder>() {
    private val myRepository = MyRepository


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_students, parent, false)

        view.findViewById<CardView>(R.id.cardStudent).setOnClickListener {

            myRepository.setIdStudent(it.idCourse.text.toString())
            Log.d("idadaprern", it.idCourse.text.toString())
            view.findNavController().navigate(R.id.action_studentsFragment_to_studentFragment)
        }

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return students.size
    }



    override fun onBindViewHolder(holder: StudentsAdapter.ViewHolder, position: Int) {
        holder.bind(students[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(student: Students) {
            itemView.idCourse.text =  student.id.toString()
            itemView.nameStudent2.text = "Nombre: " + student.name
            itemView.usernameStudent2.text = "Correo: " + student.emaill
            itemView.phoneStudent2.text = "Username: " + student.username
        }
    }

}
package com.jcabarique.tallernavegacionlogin.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jcabarique.tallernavegacionlogin.R
import com.jcabarique.tallernavegacionlogin.data.Student
import com.jcabarique.tallernavegacionlogin.repository.MyRepository
import kotlinx.android.synthetic.main.list_item_course.view.nameStudent2
import kotlinx.android.synthetic.main.list_item_course.view.usernameStudent2
import kotlinx.android.synthetic.main.list_item_student.view.*

class StudentAdapter (val student: ArrayList<Student>): RecyclerView.Adapter<StudentAdapter.ViewHolder>() {
    private val myRepository = MyRepository


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_student, parent, false)


        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return student.size
    }



    override fun onBindViewHolder(holder: StudentAdapter.ViewHolder, position: Int) {
        holder.bind(student[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(student: Student) {
            itemView.nameStudent2.text = "Nombre: "  + student.name
            itemView.usernameStudent2.text = "Username: "  + student.username
            itemView.emailStudent.text = "Email: "  + student.email
            itemView.cityStudent.text = "Ciudad: "  + student.city
            itemView.phoneStudent2.text = "Telefono: " + student.phone
            itemView.countryStudent.text = "Pais: " + student.country
            itemView.birthdayStudent.text = "Cumpleaños: " +  student.birthday

        }
    }

}
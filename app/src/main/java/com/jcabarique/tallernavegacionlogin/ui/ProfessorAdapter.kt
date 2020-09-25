package com.jcabarique.tallernavegacionlogin.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.jcabarique.tallernavegacionlogin.R
import com.jcabarique.tallernavegacionlogin.data.Courses
import com.jcabarique.tallernavegacionlogin.data.Student
import com.jcabarique.tallernavegacionlogin.repository.MyRepository
import kotlinx.android.synthetic.main.list_item_course.view.*
import kotlinx.android.synthetic.main.list_item_course.view.nameStudent2
import kotlinx.android.synthetic.main.list_item_course.view.phoneStudent2
import kotlinx.android.synthetic.main.list_item_course.view.usernameStudent2
import kotlinx.android.synthetic.main.list_item_student.view.*

class ProfessorAdapter (val professor: ArrayList<Student>): RecyclerView.Adapter<ProfessorAdapter.ViewHolder>() {
    private val myRepository = MyRepository


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_professor, parent, false)


        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return professor.size
    }



    override fun onBindViewHolder(holder: ProfessorAdapter.ViewHolder, position: Int) {
        holder.bind(professor[position])
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
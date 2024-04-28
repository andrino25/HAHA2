package com.intprog.haha2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class StudentDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_details)
        
        val intent = intent

        val name = intent.getStringExtra("name").toString()
        val idNum = intent.getStringExtra("idNumber").toString()
        val course = intent.getStringExtra("course").toString()
        val age = intent.getStringExtra("age").toString()

        val nameView  = findViewById<TextView>(R.id.detailsName)
        val idNumView  = findViewById<TextView>(R.id.detailsIdNumber)
        val courseView  = findViewById<TextView>(R.id.detailsCourse)
        val ageView  = findViewById<TextView>(R.id.detailsAge)

        nameView.text = name
        idNumView.text = idNum
        ageView.text = age
        courseView.text = course

    }
}
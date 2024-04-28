package com.intprog.haha2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {

    val students = mutableListOf<CustomListItem>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.listView)
        val adapter = CustomAdapter(this, students)
        listView.adapter = adapter

        val addBtn = findViewById<Button>(R.id.addButton)
        val idNum = findViewById<EditText>(R.id.idNum)
        val name = findViewById<EditText>(R.id.name)
        val age = findViewById<EditText>(R.id.age)
        val course = findViewById<EditText>(R.id.course)

        addBtn.setOnClickListener {

            val id = idNum.text.toString()
            val name = name.text.toString()
            val age = age.text.toString().toIntOrNull() ?: 0
            val course = course.text.toString()

            if (id.isEmpty() && name.isEmpty() && age.toString().isEmpty() && course.isEmpty()){

                Toast.makeText(this, "Please fucking enter all fucking fields", Toast.LENGTH_SHORT).show()

            }else{

                students.add(CustomListItem(id, name, course, age))
                adapter.notifyDataSetChanged()
            }

        }

        listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            // Create intent to start DetailsActivity
            val intent = Intent(this, StudentDetails::class.java)

            // Get the selected item from the ListView
            val selectedItem = students[position]

            // Add the data as extras to the intent
            intent.putExtra("name", selectedItem.name)
            intent.putExtra("idNumber", selectedItem.idNumber)
            intent.putExtra("course", selectedItem.course)
            intent.putExtra("age", selectedItem.age.toString())

            // Start DetailsActivity
            startActivity(intent)
        }



    }
}
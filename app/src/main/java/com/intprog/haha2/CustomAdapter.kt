package com.intprog.haha2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(context: Context, data: List<CustomListItem>) :
    ArrayAdapter<CustomListItem>(context, R.layout.items, data) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var itemView = convertView
        val viewHolder: ViewHolder

        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.items, parent, false)
            viewHolder = ViewHolder(itemView)
            itemView.tag = viewHolder
        } else {
            viewHolder = itemView.tag as ViewHolder
        }

        val currentItem = getItem(position)

       // viewHolder.ageTextView.text = currentItem?.age.toString()
        //viewHolder.nametextView.text = currentItem?.name
        viewHolder.idNumberTextView.text = currentItem?.idNumber
        //viewHolder.courseView.text = currentItem?.course

        return itemView!!
    }

    private class ViewHolder(view: View) {
        //val courseView: EditText = view.findViewById(R.id.course)
        //val nametextView: EditText = view.findViewById(R.id.name)
        val idNumberTextView: TextView = view.findViewById(R.id.idHolder)
        //val ageTextView: EditText = view.findViewById(R.id.age)
    }

}

data class CustomListItem(
    val idNumber: String,
    val name: String,
    val course: String,
    val age: Int
)
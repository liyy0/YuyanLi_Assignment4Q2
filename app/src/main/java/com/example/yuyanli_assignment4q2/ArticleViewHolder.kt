package com.example.yuyanli_assignment4q2

import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    val title: TextView = itemView.findViewById(R.id.title)
    val description: TextView = itemView.findViewById(R.id.description)
    init {
        itemView.setOnClickListener {
            val position: Int = adapterPosition
            Toast.makeText(itemView.context, "You clicked on item # ${position}", Toast.LENGTH_SHORT).show()
        }
    }
}
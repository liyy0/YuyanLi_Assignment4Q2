package com.example.yuyanli_assignment4q2

import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    fun bind(article: Article, onArticleClicked: (article: Article) -> Unit){
        val title: TextView = itemView.findViewById(R.id.title)
        val description: TextView = itemView.findViewById(R.id.description)
        title.text = article.title
        description.text = article.description
        itemView.setOnClickListener{
            onArticleClicked(article)
        }
    }
}
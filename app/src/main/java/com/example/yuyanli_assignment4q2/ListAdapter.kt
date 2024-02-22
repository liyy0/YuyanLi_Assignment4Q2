package com.example.yuyanli_assignment4q2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ListAdapter(private val articles: List<Article>,
    private val onCrimeClicked: (article: Article) -> Unit
    ): RecyclerView.Adapter<ArticleViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_news, parent, false)
        return ArticleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article = articles[position]
        holder.bind(article, onCrimeClicked)
    }

    override fun getItemCount(): Int {
        return articles.size
    }


}

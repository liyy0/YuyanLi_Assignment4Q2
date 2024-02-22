 package com.example.yuyanli_assignment4q2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

 class detail_page : AppCompatActivity() {
     // https://github.com/cronocode/IntentRecyclerView/tree/master/app/src/main/java/com/cronocode/intentrecyclerview
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_page)

        val title = intent.getStringExtra("title")
        val content = intent.getStringExtra("content")
        val titleView = findViewById<TextView>(R.id.titleTextView)
        val contentView = findViewById<TextView>(R.id.contentTextView)
        titleView.text = title
        contentView.text = content
    }
}
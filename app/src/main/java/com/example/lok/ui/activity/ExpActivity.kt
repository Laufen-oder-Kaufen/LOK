package com.example.lok.ui.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.lok.R
import com.example.lok.ui.adapter.ExpAdapter

class ExpActivity() : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.exp_popup)
        val enemyList = intent.extras!!.getIntegerArrayList("enemies")
        val listView = findViewById<ListView>(R.id.exp_popup)
        val homeBtn = findViewById<Button>(R.id.home_btn)
        listView.adapter = ExpAdapter(this, enemyList!!)

        homeBtn.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

}
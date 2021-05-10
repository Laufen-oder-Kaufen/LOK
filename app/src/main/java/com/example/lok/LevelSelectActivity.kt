package com.example.lok

import android.os.Bundle
import android.widget.GridView
import androidx.appcompat.app.AppCompatActivity
import com.example.lok.ui.adapter.LevelSelecterAdapter

class LevelSelectActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.level_selecter)
        val grid = findViewById<GridView>(R.id.levels)
        grid.adapter = LevelSelecterAdapter(this, 5)
    }

}
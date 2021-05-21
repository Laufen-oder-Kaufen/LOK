package com.example.lok.ui.activity

import android.os.Bundle
import android.widget.GridView
import androidx.appcompat.app.AppCompatActivity
import com.example.lok.R
import com.example.lok.TestData
import com.example.lok.ui.adapter.LevelSelecterAdapter

class LevelSelectActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.level_selecter_layout)
        val prog = TestData().companion.Player.level
        val grid = findViewById<GridView>(R.id.levels)
        grid.adapter = LevelSelecterAdapter(this)
    }

}
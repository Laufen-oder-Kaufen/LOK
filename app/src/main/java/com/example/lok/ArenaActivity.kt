package com.example.lok

import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import android.os.Bundle
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import com.example.lok.ui.adapter.ArenaAdapter

class ArenaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.arena)
        val heroContainer = findViewById<ListView>(R.id.heroes)
        val enemyContainer = findViewById<ListView>(R.id.enemies)
        heroContainer.adapter = ArenaAdapter(this, "hero")
        enemyContainer.adapter = ArenaAdapter(this, "enemy")
    }

    fun giveInfo(info : String){
        val textBox = findViewById<TextView>(R.id.arenaTextBox)
        textBox.text = info
    }
}
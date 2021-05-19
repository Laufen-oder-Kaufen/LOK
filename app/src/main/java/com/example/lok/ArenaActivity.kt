package com.example.lok

import android.content.Intent
import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.view.get
import com.example.lok.ui.adapter.ArenaAdapter

class ArenaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.arena)
        val heroContainer = findViewById<ListView>(R.id.heroes)
        val enemyContainer = findViewById<ListView>(R.id.enemies)
        val btn = findViewById<Button>(R.id.button)
        heroContainer.adapter = ArenaAdapter(this, "hero")
        enemyContainer.adapter = ArenaAdapter(this, "enemy")
        btn.setOnClickListener{
            Intent(this, ExpActivity::class.java).also {
                startActivity(it, null)
            }
        }
    }

    fun calcExp(enemiesKilled : ListView) : Int{
        val exp : Int = 1200
        return exp
    }
}
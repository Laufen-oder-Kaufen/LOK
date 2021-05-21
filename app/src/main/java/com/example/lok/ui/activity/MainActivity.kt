package com.example.lok.ui.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.lok.R
import com.example.lok.TestData
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val EXTRA_LEVEL_PROGRESS : Int = TestData().companion.Player.level
        val fab: FloatingActionButton = findViewById(R.id.fab)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)

        fab.setOnClickListener{

            val intent = Intent(this, LevelSelectActivity::class.java)
            startActivity(intent)
            Toast.makeText(applicationContext, "Starte Battle Arena", Toast.LENGTH_LONG).show()
        }

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        navView.setupWithNavController(navController)
    }
}
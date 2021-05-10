package com.example.lok

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fab: FloatingActionButton = findViewById(R.id.fab)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)

        fab.setOnClickListener{

            Intent(this, LevelSelectActivity::class.java).also {
                startActivity(it, null)
            }
//            val lvlView = layoutInflater.inflate(R.layout.level_selecter, null)
//            val lvlGrid = lvlView.findViewById<GridView>(R.id.levels)
//            lvlGrid.adapter = LevelSelecterAdapter(this, 5)
//            val popup = PopupWindow(lvlView, ConstraintLayout.LayoutParams.WRAP_CONTENT, ConstraintLayout.LayoutParams.WRAP_CONTENT)
//            popup.showAtLocation(it, Gravity.CENTER, 0, 0)

//            val lvlGrid = lvlView.findViewById<GridView>(R.id.levels)
//            lvlGrid.adapter = LevelSelecterAdapter(this, 5)
//            val popup = PopupWindow(lvlView, ConstraintLayout.LayoutParams.WRAP_CONTENT, ConstraintLayout.LayoutParams.WRAP_CONTENT)
//            if(lvlView.parent != null){
//                popup.dismiss()
//            } else{
//                popup.showAtLocation(lvlView, Gravity.CENTER, 0, 0)
//            }
            Toast.makeText(applicationContext, "Starte Battle Arena", Toast.LENGTH_LONG).show()
        }

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        navView.setupWithNavController(navController)
    }
}
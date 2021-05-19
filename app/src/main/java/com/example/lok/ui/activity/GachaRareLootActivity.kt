package com.example.lok.ui.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.lok.Item
import com.example.lok.R
import com.example.lok.TestData

class GachaRareLootActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.gacha_common_loot_layout)
        val image = findViewById<ImageView>(R.id.gacha_common_image)
        val name = findViewById<TextView>(R.id.gacha_common_name)
        val rarity = findViewById<TextView>(R.id.gacha_common_rarity)
        val btn = findViewById<Button>(R.id.button)
        val loot = getLoot()

        image.setImageResource(loot.image)
        name.text = loot.name
        rarity.text = loot.rarity

        TestData().companion.myItems.add(loot.id)

        btn.setOnClickListener {
            Intent(this, MainActivity::class.java).also {
                startActivity(it, null)
            }
        }

    }

    fun getLoot() : Item {
        val random : Int
        random = (0..6).random()
        return TestData().companion.getGachaItem(random, "rare")
    }

}
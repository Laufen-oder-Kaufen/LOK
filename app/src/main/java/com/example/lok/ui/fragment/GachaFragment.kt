package com.example.lok.ui.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.lok.R
import com.example.lok.ui.activity.GachaCommonLootActivity
import com.example.lok.ui.activity.GachaRareLootActivity

class GachaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.gacha_fragment, container, false)
        val commonChest = view.findViewById<ImageView>(R.id.common)
        val rareChest = view.findViewById<ImageView>(R.id.rare)

        commonChest.setOnClickListener{
            Intent(requireContext(), GachaCommonLootActivity::class.java).also {
                startActivity(it)
            }
        }
        rareChest.setOnClickListener{
            Intent(requireContext(), GachaRareLootActivity::class.java).also {
                startActivity(it)
            }
        }

        return view
    }

}
package com.example.lok.ui.shop

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lok.R

class ShopFragment : Fragment() {

    private val names1 = arrayListOf<String>(
        "Ritter", "Magier", "Heiler", "Tank", "Bauer", "Paladin",
        "Name", "Name", "Name","Name", "Name", "Name",
        "Name", "Name", "Name",)
    private val images1 = arrayOf(
        R.drawable.con6, R.drawable.con7, R.drawable.con8,
        R.drawable.con10, R.drawable.con11, R.drawable.con12,
        R.drawable.con20, R.drawable.con21, R.drawable.con22,
        R.drawable.con23, R.drawable.con24, R.drawable.con25,
        R.drawable.con26, R.drawable.con27, R.drawable.con28)

    private var namesList = mutableListOf<String>()
    private var imagesList = mutableListOf<Int>()

    companion object {
        fun newInstance() = ShopFragment()
    }

    private lateinit var viewModel: ShopViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.shop_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ShopViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
package com.example.lok.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.lok.R
import android.widget.TextView
import com.example.lok.TestData


class ShopFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.shop_fragment, container, false)
        val btn1 = view.findViewById<Button>(R.id.btn1)
        val btn5 = view.findViewById<Button>(R.id.btn5)
        val btn10 = view.findViewById<Button>(R.id.btn10)
        val btn25 = view.findViewById<Button>(R.id.btn25)
        val btn50 = view.findViewById<Button>(R.id.btn50)
        val btn100 = view.findViewById<Button>(R.id.btn100)
        var diamonds = view.findViewById<TextView>(R.id.myDiamonds)
        diamonds.text = TestData().companion.getDiamonds().toString()

        btn1.setOnClickListener{
            TestData().companion.buyDiamonds(1)
            it.invalidate()
        }
        btn5.setOnClickListener{
            TestData().companion.buyDiamonds(5)
            it.refreshDrawableState()
        }
        btn10.setOnClickListener{
            TestData().companion.buyDiamonds(10)
            it.requestLayout()
        }
        btn25.setOnClickListener{
            TestData().companion.buyDiamonds(25)
        }
        btn50.setOnClickListener{
            TestData().companion.buyDiamonds(50)
        }
        btn100.setOnClickListener{
            TestData().companion.buyDiamonds(100)
        }
        return view
    }
}
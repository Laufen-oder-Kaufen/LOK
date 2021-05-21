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
        val keybtn1 = view.findViewById<Button>(R.id.keybtn1)
        val keybtn5 = view.findViewById<Button>(R.id.keybtn5)
        val keybtn10 = view.findViewById<Button>(R.id.keybtn10)
        val keybtn25 = view.findViewById<Button>(R.id.keybtn25)

        btn1.setOnClickListener{
            TestData().companion.buy("diamonds",1)
            it.invalidate()
        }
        btn5.setOnClickListener{
            TestData().companion.buy("diamonds",5)
            it.refreshDrawableState()
        }
        btn10.setOnClickListener{
            TestData().companion.buy("diamonds",10)
            it.requestLayout()
        }
        btn25.setOnClickListener{
            TestData().companion.buy("diamonds",25)
        }
        keybtn1.setOnClickListener{
            TestData().companion.buy("keys",1)
            it.invalidate()
        }
        keybtn5.setOnClickListener{
            TestData().companion.buy("keys",5)
            it.refreshDrawableState()
        }
        keybtn10.setOnClickListener{
            TestData().companion.buy("keys",10)
            it.requestLayout()
        }
        keybtn25.setOnClickListener{
            TestData().companion.buy("keys",25)
        }
        return view
    }
}
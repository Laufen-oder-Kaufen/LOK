package com.example.lok.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.lok.R
import com.example.lok.TestData

class ItemAdapter(context : Context) : BaseAdapter() {

    private val mContext : Context

    init{
        mContext = context
    }

    override fun getCount(): Int {
        return TestData().companion.myItems.size
    }

    override fun getItem(position: Int): Any {
        return 1
    }

    override fun getItemId(position: Int): Long {
        return 1
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val inflater = LayoutInflater.from(mContext)
        val data = TestData().companion
        val item = data.getMyItem(data.myItems[position])
        val element = inflater.inflate(R.layout.item_gridview_element, parent, false)
        val name = element.findViewById<TextView>(R.id.item_name)
        val image = element.findViewById<ImageView>(R.id.item_image)

        name.text = item.name
        image.setImageResource(item.image)

        return element
    }

}
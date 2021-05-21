package com.example.lok.ui.adapter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import com.example.lok.ui.activity.ArenaActivity
import com.example.lok.R
import com.example.lok.TestData

class LevelSelecterAdapter(context : Context) : BaseAdapter() {

    private val mContext : Context

    init {
        mContext = context
    }

    override fun getCount(): Int {
        return 39
    }

    override fun getItem(position: Int): Any {
        return "Test String"
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val layoutInflater: LayoutInflater = LayoutInflater.from(mContext)
        val view = layoutInflater.inflate(R.layout.level_selecter_element, null)
        val prog = TestData().companion.Player.prog
        val lvlnr = view.findViewById<TextView>(R.id.levelnr)
        val lvlstatus = view.findViewById<ImageView>(R.id.levelimg)

        lvlnr.text = (position + 1).toString()
        if (prog < position + 1){
            lvlstatus.setImageResource(R.drawable.lockedlevel)
            lvlnr.text = ""
        }else{
            lvlstatus.setImageResource(R.drawable.levelcard)
            view.setOnClickListener{
                val intent = Intent(mContext, ArenaActivity::class.java)
                val b : Bundle = Bundle()
                if(position + 1 == TestData().companion.Player.prog){
                    b.putInt("key", 1)
                }else{
                    b.putInt("key", 0)
                }
                b.putInt("level", position + 1)
                intent.putExtras(b)
                startActivity(mContext, intent, null)
            }
        }

        return view
    }
}
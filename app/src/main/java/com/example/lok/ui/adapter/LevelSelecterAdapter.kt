package com.example.lok.ui.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import com.example.lok.ui.activity.ArenaActivity
import com.example.lok.R

class LevelSelecterAdapter(context : Context, lvlprog : Int) : BaseAdapter() {

    private val mContext : Context
    private val mLvlprog : Int

    init {
        mContext = context
        mLvlprog = lvlprog
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
        val lvlnr = view.findViewById<TextView>(R.id.levelnr)
        val lvlstatus = view.findViewById<ImageView>(R.id.levelimg)

        lvlnr.text = (position + 1).toString()
        if (mLvlprog < position + 1){
            lvlstatus.setImageResource(R.drawable.lockedlevel)
        }else{
            lvlstatus.setImageResource(R.drawable.levelcard)
        }

        view.setOnClickListener{
            Intent(mContext, ArenaActivity::class.java).also {
                startActivity(mContext, it, null)
            }
        }

        return view
    }
}
package com.example.lok.ui.adapter

import Hero
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.lok.R
import com.example.lok.TestData

class CharacterAdapter(context: Context, count: Int, state: String): BaseAdapter() {

    private val mState : String
    private val mContext : Context
    private val mCount : Int

    private val names = arrayListOf<String>(
        "Ritter", "Magier", "Heiler", "Tank", "Bauer", "Paladin",
        "Name", "Name", "Name","Name", "Name", "Name",
        "Name", "Name", "Name",)
    private val images = arrayOf(
        R.drawable.con6, R.drawable.con7, R.drawable.con8,
        R.drawable.con10, R.drawable.con11, R.drawable.con12,
        R.drawable.con20, R.drawable.con21, R.drawable.con22,
        R.drawable.con23, R.drawable.con24, R.drawable.con25,
        R.drawable.con26, R.drawable.con27, R.drawable.con28)

    init{
        this.mContext = context
        this.mCount = count
        this.mState = state
    }

    // rendering each row
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val data : TestData = TestData()
        val layoutInflater:LayoutInflater = LayoutInflater.from(mContext)
        val rowMain = layoutInflater.inflate(R.layout.row_team, parent, false)
        // val collapsable = rowMain.findViewById<ConstraintLayout>(R.id.collapsable)
        val imageView = rowMain.findViewById<ImageView>(R.id.row_team_image)
        val nameTextView = rowMain.findViewById<TextView>(R.id.row_team_name)
        val heroes: List<Hero>

        if(mState == "active"){
            heroes = data.companion.activeTeam
        } else{
            heroes = data.companion.heroes
        }
        imageView.setImageResource(heroes.get(position).image)
        nameTextView.text = heroes.get(position).name

        imageView.setOnClickListener{
//            if(collapsable.visibility == View.GONE){
//                collapsable.visibility = View.VISIBLE
//            } else{
//                collapsable.visibility = View.GONE
//            }
            val view = layoutInflater.inflate(R.layout.popup,null)
            view.findViewById<ImageView>(R.id.popup_image).setImageResource(heroes.get(position).image)
            view.findViewById<TextView>(R.id.popup_name_text).text = heroes.get(position).name
            view.findViewById<TextView>(R.id.popup_class_text).text = heroes.get(position).type
            view.findViewById<TextView>(R.id.stats_maxhp).text = heroes.get(position).maxHP.toString()
            view.findViewById<TextView>(R.id.stats_strength).text = heroes.get(position).str.toString()
            view.findViewById<TextView>(R.id.stats_defense).text = heroes.get(position).def.toString()
            view.findViewById<TextView>(R.id.stats_magic).text = heroes.get(position).mag.toString()
            view.findViewById<TextView>(R.id.stats_magicdefense).text = heroes.get(position).mdf.toString()
            view.findViewById<TextView>(R.id.stats_agility).text = heroes.get(position).agi.toString()
            view.findViewById<TextView>(R.id.stats_luck).text = heroes.get(position).luk.toString()

            val popup = PopupWindow(view, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
            popup.showAtLocation(view, Gravity.CENTER, 0, 0)
            val closeBtn = view.findViewById<Button>(R.id.popup_close_button)
            closeBtn.setOnClickListener{
                popup.dismiss()
            }
        }

        return rowMain
    }

    override fun getItem(position: Int): Any {
        return "Test String"
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    // how many rows in my list
    override fun getCount(): Int {
        return mCount
    }

}
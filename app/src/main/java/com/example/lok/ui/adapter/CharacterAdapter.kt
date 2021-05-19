package com.example.lok.ui.adapter

import com.example.lok.Hero
import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.lok.R
import com.example.lok.TestData
import java.lang.IndexOutOfBoundsException

class CharacterAdapter(context: Context, count: Int, state: String): BaseAdapter() {

    private val mState : String
    private val mContext : Context
    private val mCount : Int

    init{
        this.mContext = context
        this.mCount = count
        this.mState = state
    }

    // rendering each row
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val data = TestData()
        val layoutInflater:LayoutInflater = LayoutInflater.from(mContext)
        val rowMain = layoutInflater.inflate(R.layout.team_griedview_element, parent, false)
        val imageView = rowMain.findViewById<ImageView>(R.id.row_team_image)
        val nameTextView = rowMain.findViewById<TextView>(R.id.row_team_name)
        val heroes: List<Int>

        if(mState == "active"){
            heroes = data.companion.activeTeam
        } else{
            heroes = data.companion.myHeroes
        }
        val myHero: Hero = data.companion.getHero(heroes[position])
        try {
            imageView.setImageResource(myHero.image)
            nameTextView.text = myHero.name
            imageView.setOnClickListener{
                val view = layoutInflater.inflate(R.layout.popup, null)
                view.findViewById<ImageView>(R.id.popup_image).setImageResource(myHero.image)
                view.findViewById<TextView>(R.id.popup_name_text).text = myHero.name
                view.findViewById<TextView>(R.id.popup_class_text).text = myHero.type
                view.findViewById<TextView>(R.id.stats_maxhp).text = myHero.maxHP.toString()
                view.findViewById<TextView>(R.id.stats_strength).text = myHero.str.toString()
                view.findViewById<TextView>(R.id.stats_defense).text = myHero.def.toString()
                view.findViewById<TextView>(R.id.stats_magic).text = myHero.mag.toString()
                view.findViewById<TextView>(R.id.stats_magicdefense).text = myHero.mdf.toString()
                view.findViewById<TextView>(R.id.stats_agility).text = myHero.agi.toString()
                view.findViewById<TextView>(R.id.stats_luck).text = myHero.luk.toString()
                if(mState == "active"){
                    view.findViewById<Button>(R.id.add_del_button).text = "DEL"
                }else{
                    view.findViewById<Button>(R.id.add_del_button).text = "ADD"
                }

                val popup = PopupWindow(view, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
                popup.showAtLocation(view, Gravity.CENTER, 0, 0)
                val closeBtn = view.findViewById<Button>(R.id.popup_close_button)
                closeBtn.setOnClickListener{
                    popup.dismiss()
                }
                val addDelButton = view.findViewById<Button>(R.id.add_del_button)
                addDelButton.setOnClickListener{
                    if (mState == "active"){
                        data.companion.myHeroes.add(myHero.id)
                        data.companion.activeTeam.remove(myHero.id)
                        popup.dismiss()
                    }else{
                        Toast.makeText(mContext, "You need at least 1 com.example.lok.Hero", Toast.LENGTH_LONG).show()
                    }
                    if(mState == "all") {
                        data.companion.myHeroes.remove(myHero.id)
                        data.companion.activeTeam.add(myHero.id)
                        popup.dismiss()
                    }else{
                        Toast.makeText(mContext, "Team already full", Toast.LENGTH_LONG).show()
                    }
                    popup.dismiss()
                }
            }
        }catch(exception: IndexOutOfBoundsException){
            exception.stackTrace
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
package com.example.lok.ui.adapter

import android.content.Context
import android.content.Context.WINDOW_SERVICE
import android.util.DisplayMetrics
import android.view.*
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.lok.R
import com.example.lok.TestData

class ExpAdapter(context : Context, exp : Int) : BaseAdapter() {

    private val mContext : Context
    private var mExp : Int

    init{
        mContext = context
        mExp = exp
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Any {
        TODO("Not yet implemented")
    }

    override fun getItemId(position: Int): Long {
        TODO("Not yet implemented")
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val layoutInflater = LayoutInflater.from(mContext)
        val view = layoutInflater.inflate(R.layout.exp_popup_element, null)
        val data = TestData().companion.activeTeam
        val myHero = TestData().companion.getHero(data[position])
        val image = view.findViewById<ImageView>(R.id.image)
        val maxHP = view.findViewById<TextView>(R.id.maxHP_txt)
        val strength = view.findViewById<TextView>(R.id.strength_txt)
        val defense = view.findViewById<TextView>(R.id.defense_txt)
        val magic = view.findViewById<TextView>(R.id.magic_txt)
        val magicDef = view.findViewById<TextView>(R.id.magicdef_txt)
        val agility = view.findViewById<TextView>(R.id.agility_txt)
        val luck = view.findViewById<TextView>(R.id.luck_txt)
        val xpToLevelUp = view.findViewById<ImageView>(R.id.exp_curr)
        val xpTxt = view.findViewById<TextView>(R.id.exp_txt)
        val display = DisplayMetrics()
        val window = mContext.getSystemService(WINDOW_SERVICE) as WindowManager
        @Suppress("DEPRECATION")
        window.defaultDisplay.getMetrics(display)

        image.setImageResource(myHero.image)
        maxHP.text = myHero.maxHP.toString()
        strength.text = myHero.str.toString()
        defense.text = myHero.def.toString()
        magic.text = myHero.mag.toString()
        magicDef.text = myHero.mdf.toString()
        agility.text = myHero.agi.toString()
        luck.text = myHero.luk.toString()
        xpTxt.text = "+ " + mExp.toString() + " EXP"
        xpToLevelUp.layoutParams.width = myHero.exp

        myHero.exp += mExp
        xpToLevelUp.layoutParams.width = myHero.exp
        xpToLevelUp.layoutParams.width += display.widthPixels * (mExp / 1000)
        if(xpToLevelUp.layoutParams.width >= display.widthPixels){
            xpToLevelUp.layoutParams.width = 1
            xpTxt.text = "LEVEL UP"
            mExp -= 1000
            xpToLevelUp.layoutParams.width += display.widthPixels * (mExp / 1000)
        }
        return view
    }
}
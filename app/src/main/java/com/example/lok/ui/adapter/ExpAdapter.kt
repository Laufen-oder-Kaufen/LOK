package com.example.lok.ui.adapter

import android.content.Context
import android.content.Context.WINDOW_SERVICE
import android.util.DisplayMetrics
import android.view.*
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.lok.Hero
import com.example.lok.Monster
import com.example.lok.R
import com.example.lok.TestData
import kotlin.math.roundToInt

class ExpAdapter(context : Context, enemies : ArrayList<Int>) : BaseAdapter() {

    private val mContext : Context
    private val mEnemies : ArrayList<Int>

    init{
        mContext = context
        mEnemies = enemies
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
        println("EXPADAPTER DA!")
        var exp : Int = calcExp(mEnemies)
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
        val xpCurr = view.findViewById<ImageView>(R.id.exp_curr)
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
        xpTxt.text = "+ " + exp.toString()
        addExp(myHero, exp)

        if(checkIfLvlUp(myHero, exp)){
            val tempXp = exp - (myHero.expToLvlUp - myHero.exp)
            myHero.levelUp()
            myHero.exp = tempXp
            xpTxt.text = "+ " + exp.toString() + " **LEVEL UP**"
        }
        xpCurr.layoutParams.width = (myHero.exp / myHero.expToLvlUp) * display.widthPixels
        println("exp " + myHero.exp)
        println("exp to lvl up " + myHero.expToLvlUp)
        println("display width " + display.widthPixels)
        println("xpcurr width " + xpCurr.layoutParams.width)



        return view
    }

    fun calcExp(enemies : ArrayList<Int>) : Int{
        var exp = 0
        var monster : Monster
        var multi : Float

        // calculate the exp
        for(n in enemies){
            monster = TestData().companion.getEnemy(n)
            if(monster.rarity == "1"){
                multi = 1.03F
            }
            if(monster.rarity == "2"){
                multi = 1.04F
            }
            if(monster.rarity == "3"){
                multi = 1.05F
            }
            if(monster.rarity == "4"){
                multi = 1.06F
            }
            if(monster.rarity == "5"){
                multi = 1.07F
            }
            if(monster.rarity == "C"){
                multi = 1.08F
            }
            if(monster.rarity == "U"){
                multi = 1.1F
            }
            if(monster.rarity == "R"){
                multi = 1.11F
            }
            if(monster.rarity == "L"){
                multi = 1.13F
            }else{
                multi = 1F
            }
            exp += (multi * (monster.str + monster.def + monster.maxHP + monster.mag + monster.mdf)).roundToInt()
        }
        println("XP EARNED: " + exp.toString())
        return exp
    }

    fun addExp(hero : Hero, exp : Int){
        hero.exp += exp
    }

    fun checkIfLvlUp(hero: Hero, exp: Int) : Boolean{
        return (hero.exp + exp) >= hero.expToLvlUp
    }
}
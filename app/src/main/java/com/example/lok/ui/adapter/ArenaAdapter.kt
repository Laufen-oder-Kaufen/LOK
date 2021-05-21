package com.example.lok.ui.adapter

import android.content.Context
import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import com.example.lok.*
import com.example.lok.TestData.Companion.heroes
import java.util.*

class ArenaAdapter(context: Context, state: String) : BaseAdapter() {

    val mContext : Context
    val mState : String

    init {
        this.mContext = context
        this.mState = state
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Any {
        if(mState == "hero"){
            return TestData().companion.getHero(position)
        }else{
            return TestData().companion.getEnemy(position)
        }
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val data = TestData().companion
        val layoutInflater = LayoutInflater.from(mContext)
        val slotItem = layoutInflater.inflate(R.layout.arena_participant, parent, false)
        val fighterImg = slotItem.findViewById<ImageView>(R.id.participant_image)
        val statusImg = slotItem.findViewById<ImageView>(R.id.status_icon)
        val status = slotItem.findViewById<ImageView>(R.id.status)
        val hero : Hero
        val enemy : Monster
        var newHP : Int


            if (mState == "hero"){
                hero = data.getHero(data.activeTeam[position])
                fighterImg.setImageResource(hero.image)
                val percentage : Float =  ((hero.currHP.toFloat()/hero.maxHP.toFloat()))
                newHP = (percentage * 345).toInt()

                if(newHP <= 1){
                    newHP = 1
                    statusImg.setImageResource(R.drawable.skull)
                    val gray = ColorMatrix()
                    gray.setSaturation(0f)
                    val cf = ColorMatrixColorFilter(gray)
                    fighterImg.colorFilter = cf
                    fighterImg.imageAlpha = 128
                }
                status.layoutParams.width = newHP


            }else{
                enemy = data.getEnemy(data.myEnemies[position])
                fighterImg.setImageResource(enemy.image)
                val percentage : Float =  enemy.currHP.toFloat()/enemy.maxHP.toFloat()
                newHP = (percentage * 345).toInt()

                if(newHP <= 1){
                    newHP = 1
                    statusImg.setImageResource(R.drawable.skull)
                    val gray = ColorMatrix()
                    gray.setSaturation(0f)
                    val cf = ColorMatrixColorFilter(gray)
                    fighterImg.colorFilter = cf
                    fighterImg.imageAlpha = 128
                }
                status.layoutParams.width = newHP
            }



            slotItem.setOnClickListener{
                newHP -= 10
                if(newHP <= 1){
                    newHP = 1
                    statusImg.setImageResource(R.drawable.skull)
                    val gray = ColorMatrix()
                    gray.setSaturation(0f)
                    val cf = ColorMatrixColorFilter(gray)
                    fighterImg.colorFilter = cf
                    fighterImg.imageAlpha = 128
                }
                status.layoutParams.width = newHP
                status.requestLayout()
            }
        return slotItem
    }
}
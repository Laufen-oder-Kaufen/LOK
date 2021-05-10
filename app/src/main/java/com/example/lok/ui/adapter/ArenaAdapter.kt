package com.example.lok.ui.adapter

import Hero
import Monster
import android.content.Context
import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import com.example.lok.R
import com.example.lok.TestData

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
        TODO("Not yet implemented")
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
                hero = data.getHero(data.myHeroes[position])
                fighterImg.setImageResource(hero.image)
                newHP = (345 * (hero.currHP / hero.maxHP))
                status.layoutParams.width = newHP
            }else{
                enemy = data.getEnemy(data.myEnemies[position])
                fighterImg.setImageResource(enemy.image)
                newHP = (345 * (enemy.currHP / enemy.maxHP))
                status.layoutParams.width = newHP
            }

            slotItem.setOnClickListener{
                newHP -= 50
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
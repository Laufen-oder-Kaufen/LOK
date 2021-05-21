package com.example.lok.ui.activity

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.lok.Actor
import com.example.lok.Hero
import com.example.lok.Monster
import com.example.lok.R
import com.example.lok.TestData.Companion.activeTeam
import com.example.lok.TestData.Companion.getEnemy
import com.example.lok.TestData.Companion.getHero
import com.example.lok.TestData.Companion.myEnemies
import com.example.lok.TestData.Companion.myHeroes
import com.example.lok.ui.adapter.ArenaAdapter
import java.util.*

class ArenaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.arena)
        val heroContainer = findViewById<ListView>(R.id.heroes)
        val enemyContainer = findViewById<ListView>(R.id.enemies)
        heroContainer.adapter = ArenaAdapter(this, "hero")
        enemyContainer.adapter = ArenaAdapter(this, "enemy")
        var hero1 = getHero(activeTeam[0])
        var hero2 = getHero(activeTeam[1])
        var hero3 = getHero(activeTeam[2])
        val heroList = ArrayList<Hero>()
        heroList.add(hero1)
        heroList.add(hero2)
        heroList.add(hero3)
        val enemyList = ArrayList<Monster>()
        enemyList.add(getEnemy(101))
        enemyList.add(getEnemy(102))
        enemyList.add(getEnemy(103))
        val battleSequence = LinkedList<Actor>()
        for (i in heroList.indices) {
            battleSequence.add(heroList[i])
        }
        for (i in enemyList.indices) {
            battleSequence.add(enemyList[i])
        }

     //   levelUp(getEnemy(101), 1)
     //   levelUp(getEnemy(102), 1)
     //   levelUp(getEnemy(103), 1)

        val fightBtn = findViewById<ImageButton>(R.id.fightBtn)
        fightBtn.setOnClickListener{
                if(enemyList.size == 0) { // Fehlerhaft? Es soll ja nur eine Runde durchgehen.
                    Intent(this, ExpActivity::class.java).also {
                        for (n in activeTeam.indices) {
                            getHero(activeTeam.get(n)).currHP = getHero(activeTeam.get(n)).maxHP
                            startActivity(it, null)
                        }
                        for (n in myEnemies.indices) {
                            getEnemy(myEnemies.get(n)).currHP = getEnemy(myEnemies.get(n)).maxHP
                            startActivity(it, null)
                        }
                    }
                }
                if (heroList.size == 0){

                    Intent(this, MainActivity::class.java).also{
                        for (n in activeTeam.indices) {
                            getHero(activeTeam.get(n)).currHP = getHero(activeTeam.get(n)).maxHP
                            startActivity(it, null)
                        }
                        for (n in myEnemies.indices) {
                            getEnemy(myEnemies.get(n)).currHP = getEnemy(myEnemies.get(n)).maxHP
                            startActivity(it, null)
                        }
                        startActivity(it, null)
                    }
                }

                    Collections.sort(battleSequence, Comparator.comparingInt { obj: Actor -> obj.agi }.reversed())
                    fight(heroList, enemyList, battleSequence)
                    heroContainer.adapter = ArenaAdapter(this, "hero")
                    enemyContainer.adapter = ArenaAdapter(this, "enemy")
            }
    }


        fun archerEnemyVictim(victimList: ArrayList<Monster>): Monster {
            var hp = 100000
            var index = 0
            for (i in victimList.indices) {
                if (victimList[i].currHP < hp) {
                    hp = victimList[i].currHP
                    index = i
                }
            }
            return victimList[index]
        }

        fun archerHeroVictim(victimList: ArrayList<Hero>): Hero {
            var hp = 100000
            var index = 0
            for (i in victimList.indices) {
                if (victimList[i].currHP < hp) {
                    hp = victimList[i].currHP
                    index = i
                }
            }
            return victimList[index]
        }

        fun isCritical(actor: Actor, victim: Actor): Boolean {
            val baseCritChance = 1.0
            val baseCritEvade = 0.5
            val actorCritChance = baseCritChance + actor.luk * 0.3
            val victimCritEvade = baseCritEvade + victim.luk * 0.1
            val random = Random()
            val rn = random.nextInt(100).toDouble()
            return if (rn <= actorCritChance - victimCritEvade) {
                true
            } else false
        }

        fun fight(heroes: ArrayList<Hero>, enemies: ArrayList<Monster>, battleSequence: LinkedList<Actor>) {
            println("Start Battle!")
                var i = 0
                while (i < battleSequence.size) {
                    if (heroes.size == 0) {
                        break
                    }
                    if (enemies.size == 0) {
                        break
                    }

                    val actor = battleSequence[i]
                    var victim = battleSequence[i] // this is just for initialization purposes
                    val actorType = actor.javaClass.typeName
                    var victimType = ""
                    var damage = 0
                    val r = Random()
                    var rn = 0
                    if (actorType == "com.example.lok.Hero") {
                        victimType = "com.example.lok.Monster"
                    }
                    if (actorType == "com.example.lok.Monster") {
                        victimType = "com.example.lok.Hero"
                    }
                    if (victimType == "com.example.lok.Monster") {
                        rn = r.nextInt(enemies.size)
                         if (actor.type.contains("A")) {
                             victim = archerEnemyVictim(enemies)
                        } else victim = enemies[rn]
                    }
                    if (victimType == "com.example.lok.Hero") {
                        rn = r.nextInt(heroes.size)
                         if (actor.type.contains("A")) {
                             victim =  archerHeroVictim(heroes)
                        } else victim = heroes[rn]
                    }
                    if (actor.type.contains("M") == true) {
                        println("Magic attack!")
                        damage = (actor.mag - victim.mdf / 4 + Math.round(actor.mag * 0.5)).toInt()
                    }
                    if (actor.type.contains("M") == false) {
                        damage = actor.str - victim.def / 4
                    }
                    if (isCritical(actor, victim)) {
                        damage = Math.round(damage * 1.5).toInt()
                        println("CRITICAL DAMAGE")
                    }
                    if (damage <= 0) {
                        damage = 1
                    } //Negative damage would otherwise heal the victim
                    victim.currHP = victim.currHP - damage
                    println(actor.name + " greift " + victim.name + " an. Schaden: " + damage)
                    if (victim.currHP <= 0) {
                        if (battleSequence.indexOf(victim) < battleSequence.indexOf(actor)) {
                            i-- //otherwise it would skip the last actor in the battle sequence
                        }
                        println("Es stirbt: " + victim.name)
                        battleSequence.removeIf { Character: Actor -> Character.currHP <= 0 }
                        //After every death the linked list is updated (might be useless because linked list)
                        Collections.sort(battleSequence, Comparator.comparingInt { obj: Actor -> obj.agi }.reversed())

                        if (victimType == "com.example.lok.Monster") {
                            enemies.remove(victim)
                        }
                        if (victimType == "com.example.lok.Hero") {
                            heroes.remove(victim)
                        }
                    }
                    i++




                }
            }
    fun levelUp(actor: Actor, level: Int) {
        println("Level UP")
        var multiplicator = 0.0
        if (actor.getRarity().equals("1")) {
            multiplicator = 0.03
        }
        if (actor.getRarity().equals("2")) {
            multiplicator = 0.04
        }
        if (actor.getRarity().equals("3")) {
            multiplicator = 0.05
        }
        if (actor.getRarity().equals("4")) {
            multiplicator = 0.06
        }
        if (actor.getRarity().equals("5")) {
            multiplicator = 0.07
        }
        if (actor.getRarity().equals("C")) {
            multiplicator = 0.08
        }
        if (actor.getRarity().equals("U")) {
            multiplicator = 0.10
        }
        if (actor.getRarity().equals("R")) {
            multiplicator = 0.11
        }
        if (actor.getRarity().equals("L")) {
            multiplicator = 0.13
        }
        println(actor.toString())
        for (i in 0 until level) {
            actor.maxHP= actor.getMaxHP() + Math.round(actor.getMaxHP() * multiplicator).toInt()
            actor.currHP= actor.getMaxHP()
            actor.str = actor.str + Math.round(actor.str * multiplicator).toInt()
            if (Math.round(actor.str * multiplicator) <1) {
                actor.str = actor.str + 1
            }
            actor.def = actor.def + Math.round(actor.def * multiplicator).toInt()
            actor.mag= actor.mag + Math.round(actor.mag * multiplicator).toInt()
            if (Math.round(actor.mag * multiplicator) <1) {
                actor.mag=actor.mag + 1
            }
            actor.mdf=  actor.mdf + Math.round(actor.mdf * multiplicator).toInt()

            actor.agi= actor.agi + Math.round(actor.agi * multiplicator / 4).toInt()
            if (Math.round(actor.agi * multiplicator) <1) {
                actor.agi = actor.agi + 1
            }
            println(actor.toString())
        }
    }
        }

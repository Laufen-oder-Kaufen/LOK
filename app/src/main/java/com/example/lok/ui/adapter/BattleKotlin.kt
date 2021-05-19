package com.example.lok.ui.adapter

import com.example.lok.Actor
import com.example.lok.Hero
import com.example.lok.Monster
import java.sql.SQLException
import java.util.*

object BattleKotlin {

    fun prepare2(activeHeroList: ArrayList<Hero>) {
        println("Prepare Battle...")
        val enemyList = ArrayList<Monster>()
        val Bat = Monster("Bat", 101, "W", "C", 20, 15, 0, 5, 5, 10, 5, 20, 20)
        enemyList.add(Bat)
        enemyList.add(Bat)
        enemyList.add(Bat)
        val battleSequence = LinkedList<Actor>()
        for (i in activeHeroList.indices) {
            battleSequence.add(activeHeroList[i])
        }
        for (i in enemyList.indices) {
            battleSequence.add(enemyList[i])
        }
        Collections.sort(battleSequence, Comparator.comparingInt { obj: Actor -> obj.agi }.reversed())
        fight(activeHeroList, enemyList, battleSequence)
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
        println("actorCritChance $actorCritChance/ victimCritEvade $victimCritEvade/ RN: $rn")
        return if (rn <= actorCritChance - victimCritEvade) {
            true
        } else false
    }

    fun fight(heroes: ArrayList<Hero>, enemies: ArrayList<Monster>, battleSequence: LinkedList<Actor>) {
        println("Start Battle!")
        while (heroes.size > 0) {
            var i = 0
            while (i < battleSequence.size) {
                val actor = battleSequence[i]
                var victim = battleSequence[i] // this is just for initialization purposes
                val actorType = actor.javaClass.typeName
                var victimType = ""
                var damage = 0
                val r = Random()
                var rn = 0
                if (actorType == "Hero") {
                    victimType = "Monster"
                }
                if (actorType == "Monster") {
                    victimType = "Hero"
                }
                if (victimType == "Monster") {
                    rn = r.nextInt(enemies.size)
                    victim = if (actor.type.contains("A") == true) {
                        archerEnemyVictim(enemies)
                    } else enemies[rn]
                }
                if (victimType == "Hero") {
                    rn = r.nextInt(heroes.size)
                    victim = if (actor.type.contains("A") == true) {
                        archerHeroVictim(heroes)
                    } else heroes[rn]
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
                    battleSequence.removeIf { Character: Actor -> Character.currHP <= 0 }
                    println("Es stirbt: " + victim.name)
                    if (victimType == "Enemy") {
                        enemies.remove(victim)
                    }
                    if (victimType == "Hero") {
                        heroes.remove(victim)
                    }
                    //After every death the linked list is updated (might be useless because linked list)
                    Collections.sort(battleSequence, Comparator.comparingInt { obj: Actor -> obj.agi }
                        .reversed())
                }
                if (enemies.size == 0) break
                if (heroes.size == 0) break
                i++
            }
            if (heroes.size == 0) {
                break
            }
            if (enemies.size == 0) {
            }
        }
    }
}
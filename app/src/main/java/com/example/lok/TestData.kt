package com.example.lok

import Hero
import Monster
import java.util.ArrayList

class TestData {

    companion object{

        private val images = arrayOf(
            R.drawable.con6, R.drawable.con7, R.drawable.con8,
            R.drawable.con10, R.drawable.con11, R.drawable.con12,
            R.drawable.con20, R.drawable.con21, R.drawable.con22,
            R.drawable.con23, R.drawable.con24, R.drawable.con25,
            R.drawable.con26, R.drawable.con27, R.drawable.con28)

        val warrior = Hero(4, "Sir Grauselig", images.get(0), images.get(0), "Warrior",
            100, 100, 15, 12, 0, 3, 8, 8)
        val magician = Hero(1, "Grindelwald", images.get(5), images.get(5), "Magician",
            100, 100, 5, 5, 15, 13, 4, 12)
        val ninja = Hero(2,"Yamato", images.get(1), images.get(1), "Ninja",
            100, 100, 10, 8, 5, 5, 15, 15)
        val tank = Hero(3, "Hulk", images.get(3), images.get(3), "Tank",
            200, 170, 25, 20, 0, 0, 2, 8)
        val warrior2 = Hero(41, "Mrs Grauselig", images.get(2), images.get(2), "Warrior",
            100, 85, 15, 12, 0, 3, 8, 8)
        val magician2 = Hero(11, "Grantelwald", images.get(8), images.get(8), "Magician",
            100, 85, 5, 5, 15, 13, 4, 12)
        val ninja2 = Hero(21,"Shusui", images.get(9), images.get(9), "Ninja",
            100, 85, 10, 8, 5, 5, 15, 15)
        val tank2 = Hero(31, "Harvel", images.get(11), images.get(11), "Tank",
            200, 170, 25, 20, 0, 0, 2, 8)
        val warrior3 = Hero(42, "Mrs Grauselig Sr", images.get(2), images.get(2), "Warrior",
            100, 85, 15, 12, 0, 3, 8, 8)
        val magician3 = Hero(12, "Grantelwald Sr", images.get(8), images.get(8), "Magician",
            100, 85, 5, 5, 15, 13, 4, 12)
        val ninja3 = Hero(22,"Shusui Sr", images.get(9), images.get(9), "Ninja",
            100, 85, 10, 8, 5, 5, 15, 15)
        val tank3 = Hero(32, "Harvel Sr", images.get(11), images.get(11), "Tank",
            200, 170, 25, 20, 0, 0, 2, 8)
        val nullHero = Hero(999, "NULL", images.get(14), images.get(14), "NULL",
            0,100,0,0,0,0,0,0)

        val enemy1 = Monster(101, "Harvel", images.get(11), images.get(11), "NULL",
            100,100,0,0,0,0,0,0)
        val enemy2 = Monster(102, "Trump", images.get(3), images.get(3), "NULL",
            100,100,0,0,0,0,0,0)
        val enemy3 = Monster(103, "Pikachu", images.get(12), images.get(12), "NULL",
            100,100,0,0,0,0,0,0)
        val nullEnemy = Monster(199, "NULL", images.get(14), images.get(14), "NULL",
            0,0,0,0,0,0,0,0)

        val heroes = arrayListOf<Hero>(warrior, warrior2, warrior3, magician, magician2, magician3,
            ninja, ninja2, ninja3, tank, tank2, tank3)
        val enemies = arrayListOf<Monster>(enemy1, enemy2, enemy3)
        val activeTeam = arrayListOf<Int>(32, 22, 12, 42)
        val myHeroes = arrayListOf<Int>(4, 1, 2, 3, 41, 11, 21)
        val myEnemies = arrayListOf<Int>(101, 102, 103)

        fun getHero(heroId: Int): Hero {
            var myHero: Hero = nullHero
            for (hero: Hero in heroes ){
                val id: Int = hero.id
                if(id == heroId){
                    myHero = hero
                }
            }
            return myHero
        }

        fun getEnemy(enemyId: Int): Monster {
            var myEnemy: Monster = nullEnemy
            for (enemy: Monster in enemies ){
                val id: Int = enemy.id
                if(id == enemyId){
                    myEnemy = enemy
                }
            }
            return myEnemy
        }
    }

    var companion = Companion

}
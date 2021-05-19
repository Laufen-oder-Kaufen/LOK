package com.example.lok

class TestData {

    /**
     * TODO:
     * Alle Helden und com.example.lok.Monster werden in jeweiligen Klassen festgehalten und via ID abgerufen
     * Es wird vom Server abgefragt, welche Helden man besitzt + die jeweiligen Ausrüstungsgegenstände und Level
     *
     * Aktives Team wird vom Server gelesen und anschließend auf dem Server gespeichert
     *
     *
     * **/

    companion object{

        private val images = arrayOf(
            R.drawable.con6, R.drawable.con7, R.drawable.con8,
            R.drawable.con10, R.drawable.con11, R.drawable.con12,
            R.drawable.con20, R.drawable.con21, R.drawable.con22,
            R.drawable.con23, R.drawable.con24, R.drawable.con25,
            R.drawable.con26, R.drawable.con27, R.drawable.con28)

  /**      val warrior = Hero(
            4, "Sir Grauselig", images.get(0), images.get(0), "Warrior",
            100, 100, 15, 12, 0, 3, 8, 8
        ) **/

        var nullHero = Hero("NULL", 0, "W", "C", 0, 0, 0, 0, 0, 0, 0, images.get(8), images.get(8), 0)
        var nullEnemy = Monster("NULL", 0, "W", "C", 0, 0, 0, 0, 0, 0, 0, images.get(9), images.get(9))

        var Claude = Hero("Claude", 1, "W", "C", 40, 15, 0, 5, 5, 5, 5, images.get(1), images.get(1),0)
        var Clive = Hero("Clive", 2, "A", "C", 30, 12, 0, 10, 10, 15, 15, images.get(2), images.get(2),0)
        var Claudia = Hero("Claudia", 3, "M", "C", 25, 0, 15, 5, 20, 5, 5, images.get(3), images.get(3),0)
        var Ulfred = Hero("Ulfred", 4, "W", "U", 40, 15, 0, 15, 5, 5, 5, images.get(4), images.get(4),0)

        var Bat = Monster("Bat", 101, "W", "C", 40, 15, 0, 5, 5, 5, 5, images.get(12), images.get(12))
        var Goblin = Monster("Goblin", 102, "W", "C", 40, 15, 0, 5, 5, 5, 5, images.get(13), images.get(13))
        var Zombie = Monster("Zombie", 103, "W", "C", 40, 15, 0, 5, 5, 5, 5, images.get(14), images.get(14))

  /**      val spielerdaten = {name, id, gold, level, erfahrung} //jup
        var aktive Helden = {33, 2, 5} // auch geladen
        var heldenbesitz = {33,2,5,7,3,8,336} // auch geladen
        heldenlevel {(33, 10, 500),(20, 110, 800)} // muss vom Server geladen werden

        Objekt SPIELERDATEN = {
            spielerdaten, aktiveHelden, heldenBesitz, heldenLevel

        } **/


        var diamonds = 0



        val heroes = arrayListOf<Hero>(Claude, Clive, Claudia, Ulfred)
        val enemies = arrayListOf<Monster>(Bat, Goblin, Zombie)
        val activeTeam = arrayListOf<Int>(1,2,3)
        val myHeroes = arrayListOf<Int>(4)
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
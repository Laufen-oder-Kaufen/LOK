package com.example.lok

class TestData {

    var companion = Companion

    /**
     * TODO:
     * Alle Helden und com.example.lok.Monster werden in jeweiligen Klassen festgehalten und via ID abgerufen
     * Es wird vom Server abgefragt, welche Helden man besitzt + die jeweiligen Ausrüstungsgegenstände und Level
     *
     * Aktives Team wird vom Server gelesen und anschließend auf dem Server gespeichert
     *
     *
     * **/

    companion object {

        private val nullIcon = R.drawable.x

        private val images = arrayOf(
            R.drawable.con6, R.drawable.con7, R.drawable.con8,
            R.drawable.con10, R.drawable.con11, R.drawable.con12,
            R.drawable.con20, R.drawable.con21, R.drawable.con22,
            R.drawable.con23, R.drawable.con24, R.drawable.con25,
            R.drawable.con26, R.drawable.con27, R.drawable.con28
        )

        private val itemImages = arrayOf(
            R.drawable.dagger1, R.drawable.dagger2, R.drawable.dagger3,
            R.drawable.potion1, R.drawable.potion2, R.drawable.potion3,
            R.drawable.helmet1, R.drawable.helmet2, R.drawable.chest1,
            R.drawable.chest2, R.drawable.shoes1, R.drawable.shoes2,
            R.drawable.gloves1, R.drawable.gloves2, R.drawable.legs1,
            R.drawable.legs2
        )

        private var diamonds = 0
        private var keys = 0

        var nullHero = Hero("NULL", 0, "W", "C", 0, 0, 0, 0, 0, 0, 0, nullIcon, nullIcon, 0)
        var nullEnemy = Monster("NULL", 0, "W", "C", 0, 0, 0, 0, 0, 0, 0, nullIcon, nullIcon)
        var nullItem = Item(0, "NULL", nullIcon, nullIcon, "C")

        var Claude = Hero("Claude", 1, "W", "C", 40, 15, 0, 5, 5, 5, 5, images.get(1), images.get(1), 0)
        var Clive = Hero("Clive", 2, "A", "C", 30, 12, 0, 10, 10, 15, 15, images.get(0), images.get(0), 0)
        var Claudia = Hero("Claudia", 3, "M", "C", 25, 0, 15, 5, 20, 5, 5, images.get(2), images.get(2), 0)
        var Ulfred = Hero("Ulfred", 4, "W", "U", 40, 15, 0, 15, 5, 5, 5, images.get(1), images.get(1), 0)
        var Usher = Hero("Usher", 5, "A", "U", 30, 12, 0, 10, 10, 15, 15, images.get(0), images.get(0), 0)
        var Urumeius = Hero("Urumeius", 6, "M", "U", 25, 0, 15, 5, 20, 5, 5, images.get(5), images.get(5), 0)
        var Reginald = Hero("Reginald", 7, "W", "R", 40, 15, 0, 15, 5, 5, 5, images.get(1), images.get(1), 0)
        var Ramon = Hero("Rámon", 8, "A", "R", 30, 12, 0, 10, 10, 15, 15, images.get(0), images.get(0), 0)
        var Rhea = Hero("Rhea", 9, "M", "R", 25, 0, 15, 5, 20, 5, 5, images.get(2), images.get(2), 0)
        var Ludwig = Hero("Ludwig", 10, "W", "L", 40, 15, 0, 15, 5, 5, 5, images.get(6), images.get(6), 0)
        var Largo = Hero("Largo", 11, "A", "L", 30, 12, 0, 10, 10, 15, 15, images.get(0), images.get(0), 0)
        var Leandra = Hero("Leandra", 12, "M", "L", 25, 0, 15, 5, 20, 5, 5, images.get(1), images.get(1), 0)

        var lowGoblin = Monster("Lower Goblin", 101, "W","1",20,10,0,10,0,10,5, images.get(12), images.get(12))
        var lowSkelMage = Monster ("Lower Skeleton Mage", 102, "M", "1", 15,0,10,5,10,5,3,images.get(9), images.get(9))
        var Bat = Monster("Lower Bat", 103, "A", "1", 15,8,0,5,5,8,8,images.get(14), images.get(14))

        var Dagger = Item(901, "Dagger", itemImages[0], itemImages[0], "C")
        val MagicDagger = Item(902, "Magical Dagger", itemImages[1], itemImages[1], "U")
        val DeathDagger = Item(903, "Dagger of Death", itemImages[2], itemImages[2], "U")
        val MagicPotion = Item(904, "Magic Potion", itemImages[3], itemImages[3], "C")
        val RevPotion = Item(905, "Potion of Revival", itemImages[4], itemImages[4], "R")
        val LvlPotion = Item(906, "Level Up Potion", itemImages[5], itemImages[5], "L")
        val Helmet1 = Item(907, "Helmet", itemImages[6], itemImages[6], "C")
        val Helmet2 = Item(908, "Hardened Helmet", itemImages[7], itemImages[7], "U")
        val Chest1 = Item(909, "Chest", itemImages[8], itemImages[8], "C")
        val Chest2 = Item(910, "Hardened Chest", itemImages[9], itemImages[9], "U")
        val Shoes1 = Item(911, "Shoes", itemImages[10], itemImages[10], "C")
        val Shoes2 = Item(912, "Hardened Shoes", itemImages[11], itemImages[11], "U")
        val Gloves1 = Item(913, "Gloves", itemImages[12], itemImages[12], "C")
        val Gloves2 = Item(914, "Hardened Gloves", itemImages[13], itemImages[13], "U")
        val Legs1 = Item(915, "Legs", itemImages[14], itemImages[14], "C")
        val Legs2 = Item(916, "Hardened Legs", itemImages[15], itemImages[15], "U")

        var ClaudeItem = Item(801, "Claude", images.get(1), images.get(1), "C")
        var CliveItem = Item(802, "Clive", images.get(0), images.get(0), "C")
        var ClaudiaItem = Item(803, "Claudia", images.get(2), images.get(2), "C")
        var UlfredItem = Item(804, "Ulfred", images.get(1), images.get(1), "U")
        var UsherItem = Item(805, "Usher", images.get(0), images.get(0), "U")
        var UrumeiusItem = Item(806, "Urumeius", images.get(5), images.get(5), "U")


        val itemList = arrayListOf<Item>(Dagger, MagicPotion, Helmet1, Chest1, Shoes1, Gloves1, Legs1, RevPotion, LvlPotion, MagicDagger, DeathDagger, Helmet2, Chest2, Shoes2,
            Gloves2, Legs2, ClaudeItem, CliveItem, ClaudiaItem,UlfredItem, UsherItem, UrumeiusItem )
        val gachaCommonLootList = arrayListOf<Item>(Dagger, MagicPotion, Helmet1, Chest1, Shoes1, Gloves1, Legs1, ClaudeItem, CliveItem, ClaudiaItem)
        val gachaRareLootList = arrayListOf<Item>(RevPotion, LvlPotion, MagicDagger, DeathDagger, Helmet2, Chest2, Shoes2, Gloves2, Legs2, UlfredItem, UsherItem, UrumeiusItem)
        val heroes = arrayListOf<Hero>(Claude, Clive, Claudia, Ulfred, Usher, Urumeius)
        val enemies = arrayListOf<Monster>(Bat, lowGoblin, lowSkelMage)
        val activeTeam = arrayListOf<Int>(1, 2, 3)
        val myHeroes = arrayListOf<Int>(4)
        val myEnemies = arrayListOf<Int>(101, 102, 103)
        val myItems = arrayListOf<Int>(901, 903, 908)

        val Player = PlayerData(1, "Tobias Test")


        fun buy(stuff: String, amount: Int) {
            if(stuff == "diamonds"){
                diamonds += amount
            }else{
                keys += amount
            }
        }

        fun spent(stuff: String, amount: Int) {
            if(stuff == "diamonds"){
                diamonds -= amount
            }else{
                keys -= amount
            }
        }

        fun getDiamonds(): Int {
            return diamonds
        }

        fun getKeys(): Int {
            return keys
        }

        fun getHero(heroId: Int): Hero {
            var myHero: Hero = nullHero
            for (hero: Hero in heroes) {
                val id: Int = hero.id
                if (id == heroId) {
                    myHero = hero
                }
            }
            return myHero
        }

        fun getEnemy(enemyId: Int): Monster {
            var myEnemy: Monster = nullEnemy
            for (enemy: Monster in enemies) {
                val id: Int = enemy.id
                if (id == enemyId) {
                    myEnemy = enemy
                }
            }
            return myEnemy
        }

        fun getMyItem(lootId: Int): Item {
            var myItem: Item = nullItem
            for (item: Item in itemList) {
                val id: Int = item.id
                if (id == lootId) {
                    myItem = item
                }
            }
            return myItem
        }

        fun getGachaItem(cycle: Int, rarity: String): Item {
            val lootList: ArrayList<Item>
            if (rarity == "rare") {
                lootList = gachaRareLootList
            } else {
                lootList = gachaCommonLootList
            }
            var myItem: Item = nullItem
            var i: Int = 0
            var random: Int
            if (rarity == "rare"){
                while (i <= cycle) {
                    random = (0..gachaRareLootList.size-1).random()
                    myItem = lootList[random]
                    i++
                }
            }
            if (rarity == "common"){
                while (i <= cycle) {
                    random = (0..gachaCommonLootList.size-1).random()
                    myItem = lootList[random]
                    i++
                }
            }
            return myItem
        }
    }
}
package com.example.lok;

import kotlin.Pair;
import kotlin.Triple;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class PlayerData {

    int id = 0;
    String name = "Johnny Tester";
    int gold = 500;
    int diamonds = 10;
    int level = 10;
    int prog = 1;
    int exp = 500;
    Triple<Integer, Integer, Integer> allHeroes; //Besteht aus: ID, Level, Erfahrung
    ArrayList<Integer> activeHeroes;
    ArrayList<Integer> availableHeroes;
    ArrayList<Triple> allHeroesList;
    ArrayList<Pair> playerItems;


    public PlayerData(int id, String name) {
        this.id = id;
        this.name = name;
        this.gold=0;
        this.diamonds=0;
        this.level=1;
        this.prog=1;
        this.exp=0;
        this.activeHeroes = null;
        this.availableHeroes = null;
        this.playerItems = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getDiamonds() {
        return diamonds;
    }

    public void setDiamonds(int diamonds) {
        this.diamonds = diamonds;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getProg() {
        return prog;
    }

    public void setProg(int prog) {
        this.prog = prog;
    }

    public void progUp() { this.prog++; }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public ArrayList<Integer> getActiveHeroes() {
        return activeHeroes;
    }

    public void setActiveHeroes(ArrayList<Integer> activeHeroes) {
        this.activeHeroes = activeHeroes;
    }

    public ArrayList<Integer> getAllHeroes() {
        return availableHeroes;
    }

    public void setAllHeroes(ArrayList<Integer> allHeroes) {
        this.availableHeroes = allHeroes;
    }

    public void setAllHeroes(Triple<Integer, Integer, Integer> allHeroes) {
        this.allHeroes = allHeroes;
    }

    public ArrayList<Integer> getAvailableHeroes() {
        return availableHeroes;
    }

    public void setAvailableHeroes(ArrayList<Integer> availableHeroes) {
        this.availableHeroes = availableHeroes;
    }

    public ArrayList<Triple> getAllHeroesList() {
        return allHeroesList;
    }

    public void setAllHeroesList(ArrayList<Triple> allHeroesList) {
        this.allHeroesList = allHeroesList;
    }

    public ArrayList<Pair> getPlayerItems() {
        return playerItems;
    }

    public void setPlayerItems(ArrayList<Pair> playerItems) {
        this.playerItems = playerItems;
    }
}

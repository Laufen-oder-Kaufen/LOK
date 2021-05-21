package com.example.lok;

import java.util.ArrayList;

public class HeroPool {

    /**
     *
     * Claude,40,15,0,15,5,5,5,C,W
     * Clive,30,12,0,10,10,15,15,C,A
     * Claudia,25,0,15,5,20,5,5,C,M
     * Ulfred,40,15,0,15,5,5,5,U,W
     * Usher,30,12,0,10,10,15,15,U,A
     * Urumeius,25,0,15,5,20,5,5,U,M
     * Reginald,40,15,0,15,5,5,5,R,W
     * Rámon,30,12,0,10,10,15,15,R,A
     * Rhea,25,0,15,5,20,5,5,R,M
     * Ludwig,40,15,0,15,5,5,5,L,W
     * Largo,30,12,0,10,10,15,15,L,A
     * Leandra,25,0,15,5,20,5,5,L,M
     * peter,6,6,6,6,6,6,6,C,M
     *
     *
     *
     */

    public static Hero buildHero(int id, int image, int icon) {

        Hero Claude = new Hero("Claude", 1, "W", "C", 40, 15, 0, 5, 5, 5, 5, image, icon);
        Hero Clive = new Hero("Clive", 2, "A", "C", 30, 12, 0, 10, 10, 15, 15, image, icon);
        Hero Claudia = new Hero("Claudia", 3, "M", "C", 25, 0, 15, 5, 20, 5, 5, image, icon);
        Hero Ulfred = new Hero("Ulfred", 4, "W", "U", 40, 15, 0, 15, 5, 5, 5, image, icon);
        Hero Usher = new Hero("Usher", 5, "A", "U", 30, 12, 0, 10, 10, 15, 15, image, icon);
        Hero Urumeius = new Hero("Urumeius", 6, "M", "U", 25, 0, 15, 5, 20, 5, 5, image, icon);
        Hero Reginald = new Hero("Reginald", 7, "W", "R", 40, 15, 0, 15, 5, 5, 5, image, icon);
        Hero Ramon = new Hero("Rámon", 8, "A", "R", 30, 12, 0, 10, 10, 15, 15, image, icon);
        Hero Rhea = new Hero("Rhea", 9, "M", "R", 25, 0, 15, 5, 20, 5, 5, image, icon);
        Hero Ludwig = new Hero("Ludwig", 10, "W", "L", 40, 15, 0, 15, 5, 5, 5, image, icon);
        Hero Largo = new Hero("Largo", 11, "A", "L", 30, 12, 0, 10, 10, 15, 15, image, icon);
        Hero Leandra = new Hero("Leandra", 12, "M", "L", 25, 0, 15, 5, 20, 5, 5, image, icon);

        ArrayList<Hero> heroArrayList = new ArrayList<Hero>();
        heroArrayList.add(Claude);
        heroArrayList.add(Clive);
        heroArrayList.add(Claudia);
        heroArrayList.add(Ulfred);
        heroArrayList.add(Usher);
        heroArrayList.add(Urumeius);
        heroArrayList.add(Reginald);
        heroArrayList.add(Ramon);
        heroArrayList.add(Rhea);
        heroArrayList.add(Ludwig);
        heroArrayList.add(Largo);
        heroArrayList.add(Leandra);
        return heroArrayList.stream().filter(x -> x.getId() == id).findFirst().get();

    }
}

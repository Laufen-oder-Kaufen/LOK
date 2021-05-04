/***
 * Class filled with suitable demo data for testing and presenting
 */
public class ActorDemoData {
    private Hero h0;
    private Hero h1;
    private Hero h2;
    private Hero h3;
    private Monster m0;
    private Monster m1;
    private Monster m2;
    private Skill demoSkill0;
    private Skill demoSkill1;
    private Skill demoSkill2;
    private Skill demoSkill3;
    private Equip e0;
    private Equip e1;
    private Equip e2;
    private Dungeon dungeon;
    private ActiveItem potion;

    public ActorDemoData() {
        h0 = new Hero();
        h1 = new Hero();
        h2 = new Hero();
        h3 = new Hero();
        m0 = new Monster();
        m1 = new Monster();
        m2 = new Monster();
        e0 = new Equip();
        e1 = new Equip();
        e2 = new Equip();
        demoSkill0 = new DemoSkill();
        demoSkill1 = new Skill() {
            @Override
            void skillEffect() {
                System.out.println("DemoSkill1 benutzt!");
            }
        };
        demoSkill2 = new Skill() {
            @Override
            void skillEffect() {
                System.out.println("DemoSkill2 benutzt!");
            }
        };
        demoSkill3 = new Skill() {
            @Override
            void skillEffect() {
                System.out.println("DemoSkill3 benutzt!");
            }
        };

        dungeon = new Dungeon() {
        };

        potion = new ActiveItem() {
            @Override
            void effect() {
                System.out.println("Potion wurde gebraucht!");
            }
        };

        init();
    }

    public Hero getH0() {
        return h0;
    }

    public Hero getH1() {
        return h1;
    }

    public Hero getH2() {
        return h2;
    }

    public Hero getH3() {
        return h3;
    }

    public Monster getM0() {
        return m0;
    }

    public Monster getM1() {
        return m1;
    }

    public Monster getM2() {
        return m2;
    }

    public Skill getDemoSkill0() {
        return demoSkill0;
    }

    public Skill getDemoSkill1() {
        return demoSkill1;
    }

    public Skill getDemoSkill2() {
        return demoSkill2;
    }

    public Skill getDemoSkill3() {
        return demoSkill3;
    }

    public Equip getE0() {
        return e0;
    }

    public Equip getE1() {
        return e1;
    }

    public Equip getE2() {
        return e2;
    }

    public Dungeon getDungeon() {
        return dungeon;
    }

    public ActiveItem getPotion() {
        return potion;
    }

    private void init() {
        h0.setName("Dolores");
        h0.setSkill(demoSkill0);
        h0.setType("warrior");
        h0.setStatBlock(999, 50, 50, 10, 5, 25, 60);
        h1.setName("Bob");
        h1.setSkill(demoSkill1);
        h1.setType("mage");
        h1.setStatBlock(400, 10, 5, 50, 50, 25, 60);
    //    h1.setMagic(true);
        h2.setName("Rupert");
        h2.setSkill(demoSkill2);
        h2.setType("healer");
        h2.setStatBlock(400, 10, 5, 50, 50, 25, 60);
    //    h2.setMagic(true);
        h3.setName("Lydia");
        h3.setSkill(demoSkill3);
        h3.setType("rogue");
        h3.setStatBlock(756, 40, 50, 10, 5, 50, 60);

        m0.setName("Slime");
        m0.setExp(30);
        m0.setStatBlock(50, 20, 20, 20, 20, 20, 20);
        m1.setName("Living Armor");
        m1.setExp(30);
        m1.setStatBlock(50, 20, 20, 20, 20, 20, 20);
        m2.setName("Raven");
        m2.setExp(30);
        m2.setStatBlock(50, 20, 20, 20, 20, 20, 20);

        e0.setName("Plattenbrust");
        e0.setType("plate");
        e0.setSlot("body");
        e0.setDef(15);
        e1.setName("Kettenhose");
        e1.setType("chain");
        e1.setSlot("legs");
        e1.setDef(5);
        e2.setName("Stab");
        e2.setType("arcane");
        e2.setSlot("main");
        e2.setMag(15);


        Monster[] monsters = {m0, m1, m2};
        Equip[] loot = {e0, e1, e2};
        dungeon.setName("Cave");
        dungeon.setMonsters(monsters);
        dungeon.setEquips(loot);
        dungeon.setStagesCount(2);
    }

}

package com.company.players;

import java.util.Random;

public class Magic extends Hero {


    public Magic(int health, int damage) {
        super(health, damage, SuperAbility.BOOST);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        Random random = new Random();
        int randomDamage = random.nextInt(3) + 1;
        if (this.getHealth() > 0) {
            for (int i = 0; i < heroes.length; i++) {
                if (heroes[i].getHealth() > 0) {
                    boss.setHealth(boss.getHealth() - randomDamage);
//                    heroes[i].setDamage(heroes[i].getDamage() + randomDamage);
                }
            }
            System.out.println(this.getClass().getSimpleName() + " increase damage for: " + randomDamage);
        }
    }
}

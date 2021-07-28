package com.company.players;

import java.util.Random;

public class Warrior extends Hero {


    public Warrior(int health, int damage) {
        super(health, damage, SuperAbility.CRITICAL_DAMAGE);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        Random random = new Random();
        int coef = random.nextInt(2) + 2;
        if (this.getHealth() > 0 && boss.getHealth() > 0)
            boss.setHealth(boss.getHealth() - (this.getDamage() * coef - this.getDamage()));
    }
}

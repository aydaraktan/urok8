package com.company.players;

import java.util.Random;

public class Golem extends Hero {

    public Golem(int health, int damage) {
        super(health, damage, SuperAbility.GOLI);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        int aliveHeroes = 0;
        Random random = new Random();
        boolean stunned = random.nextBoolean();

        if (this.getHealth() > 0) {
            for (int i = 0; i < heroes.length; i++) {
                if (heroes[i].equals(this)) {
                    continue;
                } else if (heroes[i].getHealth() > 0 && !stunned) {
                    aliveHeroes++;
                    heroes[i].setHealth(heroes[i].getHealth() + 20);
                }
            }
            if (!stunned) {
                this.setHealth(this.getHealth() - (aliveHeroes * 20));
                System.out.println("Golem принял на себя удар " + (aliveHeroes * 20));
            }
        }
    }
}

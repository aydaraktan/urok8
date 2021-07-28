package com.company.players;

import java.util.Random;

public class Thor extends Hero {

    public Thor(int health, int damage) {
        super(health, damage, SuperAbility.STUN);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {

    }

}

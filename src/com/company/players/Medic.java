package com.company.players;

public class Medic extends Hero {

    private int healPoints;

    public Medic(int health, int damage, int healPoints) {
        super(health, damage, SuperAbility.HEAL);
        this.healPoints = healPoints;
    }

    public int getHealPoints() {
        return healPoints;
    }

    public void setHealPoints(int healPoints) {
        this.healPoints = healPoints;
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        if (this.getHealth() > 0)
            for (int i = 0; i < heroes.length; i++) {
                if (!heroes[i].getAbility().equals(SuperAbility.HEAL) && heroes[i].getHealth() > 0) {
                    heroes[i].setHealth(heroes[i].getHealth() + healPoints);
                }
            }
    }
}

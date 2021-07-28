package com.company.general;

import com.company.players.*;

import java.util.Random;

public class RpgGame {

    private static Random random = new Random();

    private static boolean isStun(){
        return random.nextBoolean();
    }

    public static void start() {
        Boss boss = new Boss(800, 50);

        Warrior warrior = new Warrior(250, 10);
        Tank tank = new Tank(250, 10);
        Magic magic = new Magic(250, 10);
        Thor thor = new Thor(250, 10);
        Medic medic = new Medic(100, 10, 15);
        Medic youngMedic = new Medic(100, 10, 5);
        Golem golem = new Golem(600, 5);

        Hero[] heroes = {warrior, tank, magic, thor,golem, medic, youngMedic};

        printStatistic(boss, heroes);

        while (!isFinished(boss, heroes)) {
            if (thor.getHealth() > 0 && isStun()) {
                System.out.println("BOSS STUNNED!!!");
                heroesHit(boss, heroes);
                heroesApplySuperAbilities(boss, heroes);
                printStatistic(boss, heroes);
            } else {
                round(boss, heroes);
            }
        }
    }

    private static void round(Boss boss, Hero[] heroes) {
        bossHit(boss, heroes);
        heroesHit(boss, heroes);
        heroesApplySuperAbilities(boss, heroes);
        printStatistic(boss, heroes);
    }

    private static void printStatistic(Boss boss, Hero[] heroes) {
        System.out.println("___________________________________");
        System.out.println("Boss health: " + boss.getHealth() + " [" + boss.getDamage() + "]");
        for (int i = 0; i < heroes.length; i++) {
            //System.out.println("Hero health: " + heroes[i].getHealth());
            System.out.println(heroes[i].getClass().getSimpleName() + " health: " + heroes[i].getHealth()
                    + " [" + heroes[i].getDamage() + "]");
        }
        System.out.println("___________________________________");
    }

    private static boolean isFinished(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDied = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                allHeroesDied = false;
                break;
            }
        }
        if (allHeroesDied) {
            System.out.println("Boss won!!!");
        }
        return allHeroesDied;
    }

    private static void bossHit(Boss boss, Hero[] heroes) {

        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0) {
                /*if (heroes[i].getHealth() - boss.getDamage() < 0) {
                    heroes[i].setHealth(0);
                } else {*/
                heroes[i].setHealth(heroes[i].getHealth() - boss.getDamage());
            }

        }
    }

    private static void heroesHit(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0) {
             /*   if (boss.getHealth() - heroes[i].getDamage() < 0) {
                    boss.setHealth(0);
                } else {*/
                boss.setHealth(boss.getHealth() - heroes[i].getDamage());
            }

        }
    }

    private static void heroesApplySuperAbilities(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            heroes[i].applySuperAbility(boss, heroes);
        }
    }
}

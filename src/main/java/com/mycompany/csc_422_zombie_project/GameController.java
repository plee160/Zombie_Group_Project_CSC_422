/*
 * Author: Kyson, Philip, Alex, and Katie
 * Date: 02/13/2026
 * Class: CSC 422 100
 * Project: Zombie Wars
 * File Name: GameController.java
 * Description: Controls the flow of the Zombie Wars game.
 */

package com.mycompany.csc_422_zombie_project;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameController {
    private List<Survivor> survivors = new ArrayList<>();
    private List<Zombie> zombies = new ArrayList<>();
    private Random random = new Random();

    private WeaponCache weaponCache = new WeaponCache();

    private int nextId = 0;

    int childCount = 0;
    int teacherCount = 0;
    int soldierCount = 0;

    int commonInfectedCount = 0;
    int tankCount = 0;

    // Initialize game
    public void startGame() {
        generateCharacters();
        assignWeapons();   
        printHeader();
        runCombat();
        generateReport();
    }

    // Method that randomly generates each character and updates their count.
    private void generateCharacters() {
        int children = random.nextInt(10);
        int teachers = random.nextInt(10);
        int soldiers = random.nextInt(10);

        int commonInfected = random.nextInt(6);
        int tanks = random.nextInt(6);

        for (int i = 0; i < children; i++) {
            survivors.add(new childCharacter(nextId++));
            childCount++;
        }

        for (int i = 0; i < teachers; i++) {
            survivors.add(new teacherCharacter(nextId++));
            teacherCount++;
        }

        for (int i = 0; i < soldiers; i++) {
            survivors.add(new soldierCharacter(nextId++));
            soldierCount++;
        }

        for (int i = 0; i < commonInfected; i++) {
            zombies.add(new commonInfectedCharacter(nextId++));
            commonInfectedCount++;
        }

        for (int i = 0; i < tanks; i++) {
            zombies.add(new tankCharacter(nextId++));
            tankCount++;
        }
    }

    // Assign weapons 
    private void assignWeapons() {
        System.out.println("\nAssigning weapons...");
        for (Survivor s : survivors) {
            Weapon w = weaponCache.getRandomWeapon();
            s.setWeapon(w);
            System.out.println(s.getCharacterName() + " " + s.getId() + " picked up a " + w.getName());
        }
    }

    // Method to print the head for the game, shows the amount of survivors and zombies.
    private void printHeader() {
        System.out.println("\nWe have " + survivors.size() + " survivors trying to make it to safety"
                + " (" + childCount + " children, " + teacherCount + " teachers, " + soldierCount + " soldiers)\n");

        System.out.println("But there are " + zombies.size() + " zombies waiting for them"
                + " (" + commonInfectedCount + " common infected, " + tankCount + " tanks)\n");
    }

    // Method that simulates the combat between zombies and survivors.
    private void runCombat() {

        while (!survivors.isEmpty() && !zombies.isEmpty()) {

            if (random.nextBoolean()) {
                // Survivor attacks
                Survivor attacker = survivors.get(random.nextInt(survivors.size()));
                Zombie target = zombies.get(random.nextInt(zombies.size()));

                attacker.attackTarget(target); 

                if (!target.isAlive()) {
                    zombies.remove(target);
                }

            } else {
                // Zombie attacks
                Zombie attacker = zombies.get(random.nextInt(zombies.size()));
                Survivor target = survivors.get(random.nextInt(survivors.size()));

                target.takeDamage(attacker.getAttackDamage());

                if (!target.isAlive()) {
                    System.out.println("   " +
                            attacker.getCharacterName() + " " + attacker.getId() +
                            " killed " +
                            target.getCharacterName() + " " + target.getId()
                    );
                    survivors.remove(target);
                    System.out.println();
                }
            }
        }
    }

    // Method that prints the results of the game.
    private void generateReport() {
        if (survivors.isEmpty())
            System.out.println("\nNone of the survivors made it.\n");
        else
            System.out.println("\nIt seems " + survivors.size() + " have made it to safety.\n");
    }
}

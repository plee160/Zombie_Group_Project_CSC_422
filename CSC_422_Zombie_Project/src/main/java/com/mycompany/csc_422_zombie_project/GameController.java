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

    private int nextId = 0;

    int childCount = 0;
    int teacherCount = 0;
    int soldierCount = 0;

    int commonInfectedCount = 0;
    int tankCount = 0;

    // Initialize game
    public void startGame() {
        generateCharacters();
        printHeader();
        runCombat();
        generateReport();
    }

    // Method that randomly generates each character and updates their count.
    private void generateCharacters() {
        int children = random.nextInt(3);
        int teachers = random.nextInt(5);
        int soldiers = random.nextInt(5);

        int commonInfected = random.nextInt(4);
        int tanks = random.nextInt(8);

        for (int i = 0; i < children; i++)
            survivors.add(new childCharacter(nextId++));
            childCount++;
        for (int i = 0; i < teachers; i++)
            survivors.add(new teacherCharacter(nextId++));
        for (int i = 0; i < soldiers; i++)
            teacherCount++;
            survivors.add(new soldierCharacter(nextId++));
            soldierCount++;

        for (int i = 0; i < commonInfected; i++)
            zombies.add(new commonInfectedCharacter(nextId++));
            commonInfectedCount++;
        for (int i = 0; i < tanks; i++)
            zombies.add(new tankCharacter(nextId++));
            tankCount++;
    }

    // Method to print the head for the game, shows the amount of survivors and zombies.
    private void printHeader() {
        System.out.println("We have " + survivors.size() + " survivors trying to make it to safety" + " (" + childCount + 
                            " children, " + teacherCount + " teachers, " + soldierCount + " soldiers)\n");
        System.out.println("But there are " + zombies.size() + " zombies waiting for them" + " (" + commonInfectedCount + " common infected, "
                            + tankCount + " tanks)\n");
    }

    // Method that simulates the combat between zombies and survivors.
    private void runCombat() {

        while (!survivors.isEmpty() && !zombies.isEmpty()) {

            if (random.nextBoolean()) {
                Survivor attacker = survivors.get(random.nextInt(survivors.size()));
                Zombie target = zombies.get(random.nextInt(zombies.size()));

                target.takeDamage(attacker.getAttackDamage());

                if (!target.isAlive()) {
                    System.out.println("   " +
                        attacker.getCharacterName() + " " + attacker.getId() +
                        " killed " +
                        target.getCharacterName() + " " + target.getId()
                    );
                    zombies.remove(target);
                }
            } else {
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

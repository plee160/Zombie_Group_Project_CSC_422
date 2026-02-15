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
import java.util.Scanner;

public class GameController {

    private List<Survivor> survivors = new ArrayList<>();
    private List<Zombie> zombies = new ArrayList<>();
    private Random random = new Random();
    private Scanner scanner = new Scanner(System.in);

    private boolean gameStarted = false;
    private boolean survivorTurn = true;

    // Start the program
    public void start() {
        showMenu();
    }

    // Main menu
    private void showMenu() {
        
            System.out.println("\n+=====================+");
            System.out.println("  WELCOME TO ZOMBIE WARS");
            System.out.println("+=====================+");
        
       while (true) {
            if (!gameStarted) {
                System.out.println("1. Start Game");
            } else {
                System.out.println("1. Next Turn");
            }

            System.out.println("2. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    if (!gameStarted) {
                        startGame();
                    } else {
                        nextTurn();
                    }
                    break;

                case 2:
                    System.out.println("Exiting game. Goodbye!");
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    // Initialize game
    private void startGame() {

        survivors.clear();
        zombies.clear();

        generateCharacters();

        gameStarted = true;
        survivorTurn = true;

        System.out.println("\nGame Started!");
        System.out.println("Survivors: " + survivors.size());
        System.out.println("Zombies: " + zombies.size());
    }

    // Create characters
    private void generateCharacters() {

        survivors.add(new soldierCharacter());
        survivors.add(new teacherCharacter());
        survivors.add(new childCharacter());

        zombies.add(new commonInfectedCharacter());
        zombies.add(new tankCharacter());
    }

    // Take turns per character
    private void nextTurn() {

        if (survivors.isEmpty() || zombies.isEmpty()) {
            generateReport();
            gameStarted = false;
            return;
        }

        if (survivorTurn) {

            Survivor attacker =
                    survivors.get(random.nextInt(survivors.size()));
            Zombie target =
                    zombies.get(random.nextInt(zombies.size()));

            attacker.attackTarget(target);

            System.out.println(attacker.getCharacterName() + " attacks "
                    + target.getCharacterName()
                    + " for " + attacker.getAttackDamage() + " damage.");

            if (!target.isAlive()) {
                zombies.remove(target);
                System.out.println(target.getCharacterName() + " has died.");
            }

            survivorTurn = false;

        } else {

            Zombie zombieAttacker =
                    zombies.get(random.nextInt(zombies.size()));
            Survivor targetSurvivor =
                    survivors.get(random.nextInt(survivors.size()));

            zombieAttacker.attackTarget(targetSurvivor);

            System.out.println(zombieAttacker.getCharacterName() + " attacks "
                    + targetSurvivor.getCharacterName()
                    + " for " + zombieAttacker.getAttackDamage() + " damage.");

            if (!targetSurvivor.isAlive()) {
                survivors.remove(targetSurvivor);
                System.out.println(targetSurvivor.getCharacterName() + " has died.");
            }

            survivorTurn = true;
        }
    }

    // Final report
    private void generateReport() {

        System.out.println("\n+==== GAME OVER ====+");

        if (survivors.isEmpty()) {
            System.out.println("Zombies win!");
        } else {
            System.out.println("Survivors win!");
        }

        System.out.println("Survivors left: " + survivors.size());
        System.out.println("Zombies left: " + zombies.size());
    }
}

/*
 * Author: Kyson, Philip, Alex, and Katie
 * Date: 02/13/2026
 * Class: CSC 422 100
 * Project: Zombie Wars
 * File Name: GameController.java
 * Description: Controls the flow of the Zombie Wars game, like menus, character generation,
 * combat logic, and the final report.
 *
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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

    // Method to start the game.
    public void start() {
        showMenu();
    }

    // Method that displays the main menu.
    private void showMenu() {
        while (true) {
            System.out.println("+=====================+");
            System.out.println("WELCOME TO ZOMBIE WARS");
            System.out.println("+=====================+");
     
            if (!gameStarted) {
                System.out.println("1. Start Game");
            }
            else {
                System.out.println("1. Next Turn");
            }
        
            System.out.println("2.Exit");
            System.out.print("Choose an option: ");
                
        int choice = scanner.nextInt();
     
        switch (choice) {
            case 1:
                if (!gameStarted){
                 startGame();
                }
                else {
                    nextTurn();
                }
                break;
            case 2:
                System.out.println("Exiting game.Goodbye!");
                break;
            default:
                System.out.println("Invalid choice, try again.");
     }

    // Method to start the game logic.
    private void startGame() {
        survivors.clear();
        zombies.clear();

        generateCharacters();
        gameStarted = true;
        survivorTurn = true;
    
        System.out.println("\nGame started!");
        System.out.println("Survivors: " + survivors.size());
        System.out.println("Zombies: " + zombies.size());
    }
    
    // Method to create initial survivors and zombies.
    private void generateCharacters() {
        survivors.add(new soldierCharacter());
        survivors.add(new teacherCharacter());
        survivors.add(new childCharacter());
        
        zombies.add(new commonInfectedCharacter());
        zombies.add(new tankCharacter());
    }
    
    // Runs the main combat loop.
    private void runGameLoop() {
        while (!survivors.isEmpty() && !zombies.isEmpty()) {
            Survivor attacker = survivors.get(random.nextInt(survivors.size()));
            Zombie target = zombies.get(random.nextInt(zombies.size()));
            
            // Survivor attacks zombie (subtract health from zombie).
            attacker.attackTarget(targetZombie);
            
            System.out.println(attacker.getCharacterName() + "attacks "
            + target.getCharacterName()
            + "for " + attacker.getAttackDamage() + " damage.");
            
            if (!target.isAlive()) {
                zombies.remove(target);
                System.out.println(target.getCharacterName() + " has died.");
            }
            survivorTurn = false;
            
            // Zombie attacks a survivor (subtract health from survivor).
            Zombie zombieAttacker = zombies.get(random.nextInt(zombies.size()));
            Survivor targetSurvivor = survivors.get(random.nextInt(survivors.size()));
            
            System.out.println(attacker.getCharacterName() + " attacks "
            + target.getCharacterName()
            + " for " + attacker.getAttackDamage() + " damage.");
            
            if (!target.isAlive()) {
                survivors.remove(target);
                System.out.println(target.getCharacterName() + " has dies.");
            }
            
            survivorTurn = true;
                }
        
        System.out.println("\nSurvivors left: " + survivors.size());
        System.out.println("Zombies left: " + zombies.size());
    }

    // Displays end-of-game results
    private void generateReport() {
        System.out.println("\n+==== GAME OVER ====+");
        
        if (survivors.isEmpty()) {
            System.out.println("Zombies win!");
        }
        else {
            System.out.println("Survivors win!");
        }
        
        System.out.println("Survivors left: " + survivors.size());
        System.out.println("Zombies left: " + zombies.size());
        }
        }
    

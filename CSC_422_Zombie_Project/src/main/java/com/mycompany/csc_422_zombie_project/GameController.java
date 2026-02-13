/*
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

    public void start() {
        showMenu();
    }

    //Main Menu - start the game
    private void showMenu() {
        System.out.println("+=====================+");
        System.out.println("WELCOME TO ZOMBIE WARS");
        System.out.println("+=====================+");
        System.out.println("1. Start Game");
        System.out.println("2. Exit");
     
     int choice = scanner.nextInt();
     
     switch (choice) {
         case 1:
             startGame();
             break;
         case 2:
             System.out.println("Exiting game.Goodbye!");
             break;
         default:
             System.out.println("Invalid choice, try again.");
             showMenu();
     }
     }
    
    private void startGame() {
        generateCharacters();
        runGameLoop();
        generateReport();
    }
    
    //Generate random survivors and zombies
    private void generateCharacters() {
        survivors.add(new soldierCharacter());
        survivors.add(new teacherCharacter());
        survivors.add(new childCharacter());
        
        zombies.add(new commonInfecterCharacter());
        zombies.add(new tankCharacter());
        
        System.out.println("\nGame started!");
        System.out.println("Survivors: "+ survivors.size());
        System.out.println("Zombies: " + zombies.size());
    }
    
    //Main game loop:
    private void runGameLoop() {
        while (!survivors.isEmpty() && !zombies.isEmpty()) {
            Survivor attacker = survivors.get(random.nextInt(survivors.size()));
            Zombie targetZombie = zombies.get(random.nextInt(zombies.size()));
            
            //survivor attacks zombie (subtract health from zombie)
            attacker.attackTarget(targetZombie);
            
            if (!targetZombie.isAlive()) {
                zombies.remove(targetZombie);
                System.out.println(targetZombie.getCharacterName() + "has died.");
            }
            
            if (zombies.isEmpty()) {
                break;
            }
            
            //zombie attacks a survivor (subtract health from survivor)
            Zombie zombieAttacker = zombies.get(random.nextInt(zombies.size()));
            Survivor targetSurvivor = survivors.get(random.nextInt(survivors.size()));
            
            zombieAttacker.attackTarget(targetSurvivor);
            
            if (!targetSurvivor.isAlive()) {
                survivors.remove(targetSurvivor);
                System.out.println(targetSurvivor.getCharacterName() + "has died.");
            }
        }
    }
       
    //Generate a report
    //display who survived
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
    

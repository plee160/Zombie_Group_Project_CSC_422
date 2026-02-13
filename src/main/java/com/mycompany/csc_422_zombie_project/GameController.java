/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.csc_422_zombie_project;
import java.util.ArrayList;

/**
 *
 * @author Phili
 */
public class GameController {
    private ArrayList<Character> zList = new ArrayList<>();
    private ArrayList<Character> sList = new ArrayList<>();
    //Main Menu - start the game
    
    //Generate a random list of survivors and zombies
    
    //Main game loop:
    //survivor attacks zombie (subtract health from zombie)
    //zombie attacks a survivor (subtract health from survivor)
    //end loop when either zombies or survivors are dead
    public void addZombie(Zombie zom) {
        zList.add(zom);
    }
    
    public void addSurvivor(Survivor surv) {
        sList.add(surv);
    }
    
    public void getStats() {
        Character chara = sList.get(0);
        System.out.println("Name: " + chara.getCharacterName());
        System.out.println("Health: " + chara.getHealth());
        System.out.println("Attack: " + chara.getAttack());
        
    }
    
    public void battle() {
        
        while (!sList.isEmpty() && !zList.isEmpty()) {
            
        
            String currS = sList.get(0).getCharacterName();
            String currZ = zList.get(0).getCharacterName();
            int zHealth = zList.get(0).getHealth();
            int zAttack = zList.get(0).getAttack();
            int sHealth = sList.get(0).getHealth();
            int sAttack = sList.get(0).getAttack();
        
        
            int sHealth2 = sHealth - zAttack; //Survivovor Gets Attacked
            System.out.println(currZ + " Attacks " + currS + "! \n" + currS + " Losses "  + zAttack + " Health!");
            sList.get(0).setHealth(sHealth2);   //Set New Survivor Health
            sHealth = sList.get(0).getHealth();
            if (sHealth == 0) {
                System.out.println(currS + " Reached 0 Health and Died!");
                sList.remove(0);
            } else {
                System.out.println("Remaining Health: "  + sHealth);
            }
        }
        if (sList.isEmpty()) {
            System.out.println("There were no Survivors....");
        } else {
            System.out.println();                                 //Method for Remainin Survivors Message
        }
        
    }
    
    //Generate a report:
    //display who survived
}

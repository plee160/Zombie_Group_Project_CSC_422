/*
 * Author: Kyson, Philip, Alex, and Katie
 * Date: 02/13/2026
 * Class: CSC 422 100
 * Project: Zombie Wars
 * File Name: tankCharacter.java
 * Description: Represents a tank zombie with high health and attack damage.
 */
package com.mycompany.csc_422_zombie_project;

public class tankCharacter extends Zombie{
    
    public tankCharacter() {
        super(150, 20, "Tank");
    }

    @Override
    public String getCharacterType() {
        return "Zombie";
    }

    @Override
    public void  getCharacterDescription(){
        System.out.println("Character type: " + getCharacterType() + "\nHeath: " + getHealth() 
        + "\n Attack damage: " + getAttackDamage() + "Character name: " + getCharacterName());
    }
}

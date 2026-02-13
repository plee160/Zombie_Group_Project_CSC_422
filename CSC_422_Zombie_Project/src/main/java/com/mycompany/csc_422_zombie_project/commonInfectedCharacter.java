/*
 * Author: Kyson, Philip, Alex, and Katie
 * Date: 02/13/2026
 * Class: CSC 422 100
 * Project: Zombie Wars
 * File Name: commonInfectedCharacter.java
 * Description: Represents a common infected zombie.
 */
package com.mycompany.csc_422_zombie_project;

public class commonInfectedCharacter extends Zombie{
    
    public commonInfectedCharacter() {
        super(30, 5, "commonInfected");
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

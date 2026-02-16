/*
 * Author: Kyson, Philip, Alex, and Katie
 * Date: 02/13/2026
 * Class: CSC 422 100
 * Project: Zombie Wars
 * File Name: childCharacter.java
 * Description: Represents a child survivor with low health and attack damage.
 */
package com.mycompany.csc_422_zombie_project;

public class childCharacter extends Survivor {
    
    public childCharacter(int id) {
        super(id, 20, 2, "Child");
    }

    @Override
    public String getCharacterType() {
        return "Survivor";
    }

    @Override
    public void  getCharacterDescription(){
        System.out.println("Character type: " + getCharacterType() + "\nHeath: " + getHealth() 
        + "\n Attack damage: " + getAttackDamage() + "Character name: " + getCharacterName());
    }
}

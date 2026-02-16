/*
 * Author: Kyson, Philip, Alex, and Katie
 * Date: 02/13/2026
 * Class: CSC 422 100
 * Project: Zombie Wars
 * File Name: soldierCharacter.java
 * Description: Represents a soldier survivor with high health and attack damage.
 */
package com.mycompany.csc_422_zombie_project;

public class soldierCharacter extends Survivor{
    
    public soldierCharacter(int id) {
        super(id, 100, 10, "Soldier");
    }

    @Override
    public String getCharacterType() {
        return "Survivor";
    }

    @Override
    public void  getCharacterDescription(){
        System.out.println("Character type: " + getCharacterType() + "\nHeath: " + getHealth() 
        + "\nAttack damage: " + getAttackDamage() + "\nCharacter name: " + getCharacterName());
    }
}

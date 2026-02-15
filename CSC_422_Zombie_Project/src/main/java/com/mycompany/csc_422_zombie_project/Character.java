/*
 * Author: Kyson, Philip, Alex, and Katie
 * Date: 02/13/2026
 * Class: CSC 422 100
 * Project: Zombie Wars
 * File Name: Character.java
 * Description: Abstract base class that represents any character in the game
 * Both Survivors and Zombies inherit from this class.
 *
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.csc_422_zombie_project;

public abstract class Character {
    
    protected int health;
    protected int attackDamage;
    protected String characterName;

    // Constructor used by subclasses.
    protected Character(int health, int attackDamage, String characterName) {
        this.health = health;
        this.attackDamage = attackDamage;
        this.characterName = characterName;
    }

    // Method to check if the character is still alive.
    public boolean isAlive() {
        return health > 0;
    }

    // Method that reduces health when taking damage.
    public void takeDamage(int Damage) {
        health -= Damage;
        if (health <= 0) {
            health = 0;
        }
    }
    
    // Method to attack another chacter if the target is alive.
    public void attackTarget(Character target) {
        if (!this.isAlive() || !target.isAlive()) {
            System.out.println("Character is not alive or target is not alive.");
        }else {
            target.takeDamage(this.attackDamage);
        }
    }

    // Method to return characters name.
    public String getCharacterName() {
        return characterName;
    } 

    // Method to return attack damage.
    public int getAttackDamage() {
        return attackDamage;
    }

    // Method to get character's health.
    public int getHealth() {
        return health;
    }

    public abstract String getCharacterType();

    public abstract void getCharacterDescription();
}

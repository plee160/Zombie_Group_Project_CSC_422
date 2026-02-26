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
    protected int id;
    protected int health;
    protected int attackDamage;
    protected String characterName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    

    protected Character(int id, int health, int attackDamage, String characterName) {
        this.id = id;
        this.health = health;
        this.attackDamage = attackDamage;
        this.characterName = characterName;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) {
            health = 0;
        }
    }

    public void attackTarget(Character target) {

        if (!this.isAlive() || !target.isAlive()) {
            System.out.println("Character is not alive or target is not alive.");
            return;
        }

        // Zombies attack
        if (!(this instanceof Survivor)) {
            target.takeDamage(this.attackDamage);
            return;
        }

        // Survivors attack
        Survivor survivor = (Survivor) this;

        if (survivor.getWeapon() == null) {
            System.out.println(survivor.getCharacterName() + " has no weapon!");
            return;
        }

        Weapon w = survivor.getWeapon();

        // Check weapon accuracy
        if (Math.random() > w.getAccuracy()) {
            System.out.println(survivor.getCharacterName() + " missed with " + w.getName());
            return;
        }

        //Accurate shot/hit
        target.takeDamage(w.getDamage());
        System.out.println(survivor.getCharacterName() + " hit " + target.getCharacterName()
                + " with " + w.getName() + " for " + w.getDamage() + " damage!");

        if (!target.isAlive()) {
            System.out.println(target.getCharacterName() + " was killed by "
                    + survivor.getCharacterName() + " using " + w.getName());
        }
    }

    public String getCharacterName() {
        return characterName;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public int getHealth() {
        return health;
    }

    public abstract String getCharacterType();

    public abstract void getCharacterDescription();
}

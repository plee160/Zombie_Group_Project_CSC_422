/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.csc_422_zombie_project;

/**
 *
 * @author Phili
 */
public abstract class Character {
    
    protected int health;
    protected int attackDamage;
    protected String characterName;

    protected Character(int health, int attackDamage, String characterName) {
        this.health = health;
        this.attackDamage = attackDamage;
        this.characterName = characterName;
    }

    public boolean isAlice() {
        return health > 0;
    }

    public void takeDamage(int Damage) {
        health -= Damage;
        if (health <= 0) {
            health = 0;
        }
    }

    public void attackTarget(Character target) {
        if (!this.isAlice() || !target.isAlice()) {
            System.out.println("Character is not alive or target is not alive.");
        }else {
            target.takeDamage(this.attackDamage);
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

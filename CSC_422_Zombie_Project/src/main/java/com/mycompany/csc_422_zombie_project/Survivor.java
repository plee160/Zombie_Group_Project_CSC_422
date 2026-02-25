/*
 * Author: Kyson, Philip, Alex, and Katie
 * Date: 02/13/2026
 * Class: CSC 422 100
 * Project: Zombie Wars
 * File Name: Survivor.java
 * Description: Abstract class that represents survivor characters. 
 * All survivor types inherit from this class.
 * 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.csc_422_zombie_project;

public abstract class Survivor extends Character {
    
    protected Weapon weapon;
    
    public Survivor (int health, int attackDamage, String characterName) {
        super(health, attackDamage, characterName);
    }
    
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Weapon getWeapon() {
        return weapon;
    }
    
    @Override
    public String getCharacterType() {
        return "Survivor";
    }

}

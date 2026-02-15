/*
 * Author: Kyson, Philip, Alex, and Katie
 * Date: 02/13/2026
 * Class: CSC 422 100
 * Project: Zombie Wars
 * File Name: Zombie.java
 * Description: Abstract class that represents zombie characters.
 *
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.csc_422_zombie_project;

public abstract class Zombie extends Character {
    public Zombie (int health, int attackDamage, String characterName) {
        super(health, attackDamage, characterName);
    }

    @Override
    public String getCharacterType() {
        return "Zombie";
    }
    
}

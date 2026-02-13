/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.csc_422_zombie_project;

/**
 *
 * @author Phili
 */
public abstract class Survivor extends Character {
    public Survivor (int health, int attackDamage, String characterName) {
        super(health, attackDamage, characterName);
    }

    @Override
    public String getCharacterType() {
        return "Survivor";
    }

}

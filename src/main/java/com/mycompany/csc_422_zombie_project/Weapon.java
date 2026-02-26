/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.csc_422_zombie_project;

/**
 *
 * @author alexs
 */
public class Weapon {
    
    private String name;
    private int damage;
    private double accuracy;
    
    public Weapon(String name, int damage, double accuracy) {
        this.name = name;
        this.damage = damage;
        this.accuracy = accuracy;
    }
    
    public String getName() {
        return name;
    }
    
    public int getDamage() {
        return damage;
    }
    
    public double getAccuracy() {
        return accuracy;
    }
}


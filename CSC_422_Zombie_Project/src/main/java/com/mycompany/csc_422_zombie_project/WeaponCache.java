/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.csc_422_zombie_project;

/**
 *
 * @author alexs
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WeaponCache {
    
    private List<Weapon> weapons = new ArrayList<>();
    private Random rand = new Random();
    
    public WeaponCache() {
        weapons.add(new Weapon("Shotgun", 25, 0.6));
        weapons.add(new Weapon("Submachine Gun", 15, 0.8));
        weapons.add(new Weapon("Assault Rifle", 20, 0.75));
        weapons.add(new Weapon("Pistol", 10, 0.9));
        weapons.add(new Weapon("Axe", 18, 0.85));
        weapons.add(new Weapon("Crowbar", 12, 0.9));
        weapons.add(new Weapon("Frying Pan", 8, 0.95));
    }
    
    public Weapon getRandomWeapon() {
        return weapons.get(rand.nextInt(weapons.size()));
    }
}

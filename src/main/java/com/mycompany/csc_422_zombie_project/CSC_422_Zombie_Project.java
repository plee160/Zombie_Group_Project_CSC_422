/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.csc_422_zombie_project;

/**
 *
 * @author Phili
 */
public class CSC_422_Zombie_Project {
    public static void main(String[] args) {
        GameController test = new GameController();
        
        soldierCharacter soldier = new soldierCharacter();
        commonInfectedCharacter common = new commonInfectedCharacter();
        
        
        test.addSurvivor(soldier);
        test.addZombie(common);

        test.battle();
    }
}

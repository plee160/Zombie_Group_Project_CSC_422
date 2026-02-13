/*
 * Author: 
 * Date: 02/13/2026
 * Class: CSC 422 100
 * Project: Zombie Wars
 * File Name: CSC_422_Zombie_Project
 * Description: This is the main driver class for the Zombie Wars Game. It creates the GameController and starts the game.
 *
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.csc_422_zombie_project;

// Starts the game.
public class CSC_422_Zombie_Project {
     public static void main(String[] args) {
        GameController game = new GameController();
        game.start();
    }
}

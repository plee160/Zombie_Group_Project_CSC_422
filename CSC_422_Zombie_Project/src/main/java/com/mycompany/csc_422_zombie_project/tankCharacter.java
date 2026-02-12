package com.mycompany.csc_422_zombie_project;

public class tankCharacter extends Zombie{
    
    public tankCharacter() {
        super(150, 20, "Tank");
    }

    @Override
    public String getCharacterType() {
        return "Zombie";
    }

    @Override
    public void  getCharacterDescription(){
        System.out.println("Character type: " + getCharacterType() + "\nHeath: " + getHealth() 
        + "\n Attack damage: " + getAttackDamage() + "Character name: " + getCharacterName());
    }
}

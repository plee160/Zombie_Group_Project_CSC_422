package com.mycompany.csc_422_zombie_project;

public class soldierCharacter extends Survivor{
    
    public soldierCharacter() {
        super(100, 10, "Soldier");
    }

    @Override
    public String getCharacterType() {
        return "Survivor";
    }

    @Override
    public void  getCharacterDescription(){
        System.out.println("Character type: " + getCharacterType() + "\nHeath: " + getHealth() 
        + "\nAttack damage: " + getAttackDamage() + "\nCharacter name: " + getCharacterName());
    }
}

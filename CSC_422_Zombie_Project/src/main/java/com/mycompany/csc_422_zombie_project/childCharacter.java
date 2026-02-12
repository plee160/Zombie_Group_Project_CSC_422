package com.mycompany.csc_422_zombie_project;

public class childCharacter extends Survivor {
    
    public childCharacter() {
        super(20, 2, "Child");
    }

    @Override
    public String getCharacterType() {
        return "Survivor";
    }

    @Override
    public void  getCharacterDescription(){
        System.out.println("Character type: " + getCharacterType() + "\nHeath: " + getHealth() 
        + "\n Attack damage: " + getAttackDamage() + "Character name: " + getCharacterName());
    }
}

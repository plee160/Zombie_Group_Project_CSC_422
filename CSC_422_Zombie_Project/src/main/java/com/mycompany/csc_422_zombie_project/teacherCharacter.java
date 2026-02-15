package com.mycompany.csc_422_zombie_project;

public class teacherCharacter extends Survivor{
    
    public teacherCharacter() {
        super(50, 5, "Teacher");
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

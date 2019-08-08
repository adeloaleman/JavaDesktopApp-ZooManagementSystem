/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctzoo.model.animals;

import java.util.ArrayList;

/**
 *
 * @author Familia Bracho
 */
public class CreateInsect extends Animal implements Insect {
    
    private int isVennon; 
    
    
    public CreateInsect(String specie, String name, String dateOfBirth, String dateOfArrival, int gender, Medication medication, Vacine vacine) {
        super(specie, name, dateOfBirth, dateOfArrival, gender, medication, vacine);
    
    }
    
    @Override
    public void createOffpring(String name, String dateOfBirth, String dateOfArrival, int gender, Medication medication, Vacine vacine) {
        getOffsprings().add(new CreateInsect(this.getSpecie(), name, dateOfBirth, dateOfArrival, gender, medication, vacine));
    }

    public int getIsVennon() {
        return isVennon;
    }

    public void setIsVennon(int isVennon) {
        this.isVennon = isVennon;
    }
    
    public ArrayList<String> toArrayList(){
        ArrayList<String> list = super.toArrayList();
        list.add(isVennon(isVennon));
        return list;
    }
    
    public ArrayList<String> nameVariables(){
        ArrayList<String> names = super.nameVariables();
        names.add("isVennon");
        return names;
    }
    
}

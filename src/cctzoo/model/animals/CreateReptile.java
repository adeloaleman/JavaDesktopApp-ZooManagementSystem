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
public class CreateReptile extends Animal implements Reptile  {
    
    private int isVennon; 
    
    public CreateReptile(String specie, String name, String dateOfBirth, String dateOfArrival, int gender, Medication medication, Vacine vacine) {
        super(specie, name, dateOfBirth, dateOfArrival, gender, medication, vacine);
    
    }

    @Override
    public void createOffpring(String name, String dateOfBirth, String dateOfArrival, int gender, Medication medication, Vacine vacine) {
        getOffsprings().add(new CreateReptile(this.getSpecie(), name, dateOfBirth, dateOfArrival, gender, medication, vacine));
    }

    public int getIsVennon() {
        return isVennon;
    }

    public void setIsVennon(int isVennon) {
        this.isVennon = isVennon;
    }
    
    @Override
    public ArrayList<String> toArrayList(){
        ArrayList<String> list = super.toArrayList();
        list.add(isVennon(isVennon));
        return list;
    }
    
    @Override
    public ArrayList<String> nameVariables(){
        ArrayList<String> names = super.nameVariables();
        names.add("isVennon");
        return names;
    }
    
}

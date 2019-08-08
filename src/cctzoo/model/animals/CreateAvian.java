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
public class CreateAvian extends Animal implements Avian {
    
    private int canFly;
    private int hasFeeders;
    
    
    public CreateAvian(String specie, String name, String dateOfBirth, String dateOfArrival, int gender, Medication medication, Vacine vacine) {
        super(specie, name, dateOfBirth, dateOfArrival, gender, medication, vacine);
    
    }
    
    @Override
    public void createOffpring(String name, String dateOfBirth, String dateOfArrival, int gender, Medication medication, Vacine vacine) {
        getOffsprings().add(new CreateAvian(this.getSpecie(), name, dateOfBirth, dateOfArrival, gender, medication, vacine));
    }

    public int getCanFligh() {
        return canFly;
    }

    public void setCanFligh(int canFly) {
        this.canFly = canFly;
    }

    public int getHasFeeders() {
        return hasFeeders;
    }

    public void setHasFeeders(int hasFeeders) {
        this.hasFeeders = hasFeeders;
    }
    
    
    public ArrayList<String> toArrayList(){
        ArrayList<String> list = super.toArrayList();
        list.add(canFly(canFly));
        list.add(hasFeeders(hasFeeders));
        return list;
    }
    
    
    public ArrayList<String> nameVariables(){
        ArrayList<String> names = super.nameVariables();
        names.add("canFly");
        names.add("hasFeeders");
        return names;
    }
    
    
    
}

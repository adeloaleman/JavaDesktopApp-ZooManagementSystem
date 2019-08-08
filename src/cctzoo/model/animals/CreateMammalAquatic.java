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
public class CreateMammalAquatic extends Animal implements Mammal, Aquatic  {
    
    private int furry;
    private int canBeOutSideWatter; 
    
    public CreateMammalAquatic(String specie, String name, String dateOfBirth, String dateOfArrival, int gender, Medication medication, Vacine vacine) {
        super(specie, name, dateOfBirth, dateOfArrival, gender, medication, vacine);
        
    }
    
    @Override
    public void createOffpring(String name, String dateOfBirth, String dateOfArrival, int gender, Medication medication, Vacine vacine) {
        getOffsprings().add(new CreateMammalAquatic(this.getSpecie(), name, dateOfBirth, dateOfArrival, gender, medication, vacine));
    }

    public int getFurry() {
        return furry;
    }

    public void setFurry(int furry) {
        this.furry = furry;
    }

    public int getCanBeOutSideWatter() {
        return canBeOutSideWatter;
    }

    public void setCanBeOutSideWatter(int canBeOutSideWatter) {
        this.canBeOutSideWatter = canBeOutSideWatter;
    }
    
     public ArrayList<String> toArrayList(){
        ArrayList<String> list = super.toArrayList();
        list.add(hasFur(furry));
        list.add(canBeOutsideWatter(canBeOutSideWatter));
        return list;
    }
    
    public ArrayList<String> nameVariables(){
        ArrayList<String> names = super.nameVariables();
        names.add("furry");
        names.add("canBeOutSideWatter");
        return names;
    }
    
    
}

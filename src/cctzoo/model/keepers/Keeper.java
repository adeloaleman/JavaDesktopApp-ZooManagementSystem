/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctzoo.model.keepers;

import cctzoo.model.animals.Animal;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Familia Bracho
 */
public class Keeper implements Serializable {
    private static int id;
    private final int pps; 
    private String name; 
    private String dateOfBirth;
    private int maxAnimal = 10;
    private int maxTypes  = 3;
    
    private int countAnimals = 0;
    private int countTypes   = 0;
    
    private ArrayList<String> qualification;
    
    private ArrayList<Animal> keeperAnimals;
    
    public Keeper() {
        pps = id;
        id++;
    }
    
    public Keeper(String name, String dateOfBirth) {
        pps = id;
        id++;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.qualification = new ArrayList<String>();
        this.keeperAnimals = new ArrayList<Animal>();
    }
    
    public void addQualification(String q) {
        qualification.add(q);
    }
    
    public ArrayList<String> getQualification() {
        return qualification;
    }
    
    public ArrayList<Animal> getkeeperAnimals() {
        return keeperAnimals;
    }
    
    public int getPps() {
        return pps;
    }
    
    public String getName() {
        return name;
    }
    
    public String getDateOfBirth() {
        return dateOfBirth;
    }
    
    public void addAnimal(Animal a) {
        keeperAnimals.add(a);
    }
    
    public String toStringKeeperQualification(){
        String var = "";
        if (getQualification().size() != 0){
            for (int i = 0 ; i < getQualification().size() ; i++){
                if (i == getQualification().size() - 1){
                    var += getQualification().get(i);
                }else{
                    var += getQualification().get(i)+", ";
                }
            }
        }else{
            var = "No qualifications";
        }
        return var;
    }
    
    public String toStringKeeperAnimals(){
        String var = "";
        if (getkeeperAnimals().size() != 0){
            for (int i = 0 ; i < getkeeperAnimals().size() ; i++){
                if (i == getkeeperAnimals().size() - 1){
                    var += getkeeperAnimals().get(i).getExhibitionNumb();
                }else{
                    var += getkeeperAnimals().get(i).getExhibitionNumb()+", ";
                }
            }
        }else{
            var = "No animals";
        }
        return var;
    }
    
    public String toString(){
        return "Keeper «"+getPps()+"»:                                      \n"
                    +"\tName:            «"+getName()+"»                    \n"
                    +"\tDate of birth:   «"+getDateOfBirth() +"»            \n"
                    +"\tQualifications:  «"+toStringKeeperQualification()+"»\n"
                    +"\tAnimals:         «"+toStringKeeperAnimals()+"»      \n";
    }
    
    public ArrayList<String> toArrayList(){
        ArrayList<String> list = new ArrayList<String>();
        list.add(String.valueOf(getPps()));
        list.add(getName());
        list.add(getDateOfBirth());
        list.add(toStringKeeperQualification());
        list.add(toStringKeeperAnimals());
        return list;
    }
    
    public ArrayList<String> nameVariables(){
        ArrayList<String> names = new ArrayList<String>();
        names.add("pps");
        names.add("name");
        names.add("dateOfBirth");
        names.add("qualification");
        names.add("keeperAnimals");
        return names;
    }
    
    public void setStaticVariable(int i) {
        this.id = i; 
    }
    
}

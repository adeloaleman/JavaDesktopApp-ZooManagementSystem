/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctzoo.model.animals;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Familia Bracho
 */
public class Medication implements Serializable {
    private int id;
    private final int serial; 
    private ArrayList<String> medicationName;
    
    public Medication() {
        serial = id; 
        id++;
        medicationName = new ArrayList<>();
    }
    
    public Medication(String name) {
        serial = id; 
        id++;
        medicationName = new ArrayList<>();
        medicationName.add(name); 
    }
    
    public void addMedication(String name) {
        medicationName.add(name); 
    }
    
    public void addMedication(ArrayList<String> medication) {
        for (String m : medication) {
            this.medicationName.add(m);
        }
    }

    public ArrayList<String> getMedicationName() {
        return medicationName;
    }
    
    public String toString(){
        String var = "";
        if (getMedicationName().size() != 0){
            for (int i = 0 ; i < getMedicationName().size() ; i++){
                if (i == getMedicationName().size() - 1){
                    var += String.valueOf(getMedicationName().get(i));
                }else{
                    var += String.valueOf(getMedicationName().get(i))+", ";
                }
            }
        }
        return var;
    }
}

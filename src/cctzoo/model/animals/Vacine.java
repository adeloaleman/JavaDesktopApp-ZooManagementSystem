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
public class Vacine implements Serializable {
    private int id;
    private final int serial; 
    private ArrayList<String> vacineName;
    
    public Vacine() {
        serial = id; 
        id++;
        vacineName = new ArrayList<>(); 
    }
    
    public Vacine(String name) {
        serial = id; 
        id++;
        vacineName = new ArrayList<>();
        vacineName.add(name); 
    }
    
    public void addVacine(String name) {
        vacineName.add(name); 
    }

    public ArrayList<String> getVacineName() {
        return vacineName;
    }

    public String toString(){
        String var = "";
        if (getVacineName().size() != 0){
            for (int i = 0 ; i < getVacineName().size() ; i++){
                if (i == getVacineName().size() - 1){
                    var += String.valueOf(getVacineName().get(i));
                }else{
                    var += String.valueOf(getVacineName().get(i))+", ";
                }
            }
        }
        return var;
    }    

    public void addVacine(ArrayList<String> vac) {
        for (String v : vac) {
            this.vacineName.add(v);
        }
    }
} 
       


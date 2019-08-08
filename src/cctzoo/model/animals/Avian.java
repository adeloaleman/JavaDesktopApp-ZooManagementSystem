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
public interface Avian {

    default String canFly(int t) {
        return t == 1 ? "Yes" : "No"; 
    }
    
    default String hasFeeders(int t) {
        return t == 1 ? "Yes" : "No"; 
    }
    
    public ArrayList<String> toArrayList();
      
    public ArrayList<String> nameVariables();
}

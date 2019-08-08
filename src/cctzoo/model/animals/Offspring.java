/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctzoo.model.animals;

import cctzoo.model.keepers.Keeper;

/**
 *
 * @author Familia Bracho
 */
public interface Offspring {
    
    public void createOffpring(String name, String dateOfBirth, String dateOfArrival, int gender, Medication medication, Vacine vacine);
}

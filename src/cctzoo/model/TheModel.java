/**
 * Class The Model
 * 
 * Purpose:
 * 
 * Responsible for creating the instances of the setUp and search classes 
 * 
 * In this class we have methods for serialization and deserialization which will be the methods responsible for storing the data and getting it back  
 * 
 */
package cctzoo.model;

import cctzoo.model.SetUp;
import cctzoo.model.animals.Animal;
import cctzoo.model.keepers.Keeper;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Adelo Vieira (2017276), Asmer Bracho (2016328) and Miguelantonio Guerra (2016324)
 */
public class TheModel  {
    
    /**
     * Instances for the class are described as follow 
     */
    private SetUp setup; // instance to access the methods in SetUp class 
    private Search search; // instance to access the methods in Search class 
    private File file; // file used for serialization of animals  
    private File file2; // file used for serialization of keepers 
    private ArrayList<Animal> listAnimals; // we need a list of animals
    private ArrayList<Keeper> listKeepers; // we need a list to hold our keepers 
    
    /**
     * 
     * @return 
     */
    public ArrayList<Animal> getListAnimals() {
        return listAnimals;
    }
    
    /**
     * 
     * @return 
     */
    public ArrayList<Keeper> getListKeepers() {
        return listKeepers;
    }
     
    /**
     * Constructor of TheModel, which it doesn't take any parameters 
     * 
     * We initialize the setup and search instances 
     */
    public TheModel() {
        
        setup  = new SetUp();
        search = new Search();
        
        // As soon as TheModel in run. It will look for two files (.ser) 
        try {
             file = new File("animalsData.ser"); // create a new file for animal 
             file2 = new File("keepersData.ser"); // create a new file for keepers
             
             boolean exits = file.createNewFile();
             boolean exits2 = file2.createNewFile();
             
             if (!exits && !exits2) { // if the files exits 
                deserialization(); // then retrieve the data 
                
             } else { // if the files do not exits, It means there is not data. Then Create it 
                setup.setListMedication(50);
                setup.setListVacine(50);
                setup.setListAnimals(200);
                setup.setListKeepers(30);
                
                // after creatint the data assign the list of animals and keepers created in setup class to the listAnimals and listOfKeepers. 
                listAnimals = setup.getMyAnimals(); 
                listKeepers = setup.getMyKeepers();
                
             }
        // Catch any Error, if any.         
        } catch (IOException ex) {
            System.out.println("Exception Occurred:");
	    ex.printStackTrace();
        }

    }
    
    /**
     * This Method take the data within the Arrays listAnimal and listKeepers and serialize then inside the files animalData.ser and keepersData.ser respectively 
     * 
     */
    public void serialization() {
        
            FileOutputStream fileOut = null;
        try {
            // we will need:
            // 1) FileOutputStream
            fileOut = new FileOutputStream(file);
            FileOutputStream fileOut2 = new FileOutputStream(file2);
            // 2) ObjectOutputStream - and pass on the FileOutputStream
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            ObjectOutputStream out2 = new ObjectOutputStream(fileOut2);
            // now we will need to write the object 
            out.writeObject(listAnimals);
            out.flush();
            // Close file
            out.close();
            out2.writeObject(listKeepers);
            out2.flush();
            // Close file
            out2.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TheModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TheModel.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fileOut.close();
            } catch (IOException ex) {
                Logger.getLogger(TheModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            
            
    }
    
    /**
     * This Method take the data Within the files animalData.ser and keepersData.ser and copy it into the the Arrays listAnimal and listKeepers. 
     * 
     * At the end of this method we use the setSatatic variable, to set the id in the class Animal so we can keep track of the last exhibition number without creating redundancy 
     */
    public void deserialization()  {
            
            FileInputStream fileIn = null;
        try {
            fileIn = new FileInputStream("animalsData.ser");
            FileInputStream fileIn2 = new FileInputStream("keepersData.ser");
            // 2) ObjectInputStream - Pass on the FileImputStream 
            ObjectInputStream in = new ObjectInputStream(fileIn);
            ObjectInputStream in2 = new ObjectInputStream(fileIn2);
            try {
                listAnimals = (ArrayList<Animal>) in.readObject();
                in.close();
                listKeepers = (ArrayList<Keeper>) in2.readObject();
                in2.close();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(TheModel.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }
            // setup the static variable in both Animals and keepers
            listAnimals.get(0).setStaticVariable(listAnimals.size());
            listKeepers.get(0).setStaticVariable(listKeepers.size());
           
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TheModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TheModel.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fileIn.close();
            } catch (IOException ex) {
                Logger.getLogger(TheModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}

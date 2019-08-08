/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctzoo.model;
import java.util.ArrayList;
/**
 *
 * @author Familia Bracho
 */



public class SearchAnimal {
    
    // 
    public void searchAnimalBySpecies(SetUp lista, String species){
        for(int i = 0 ; i < lista.getMyAnimals().size() ; i++){
            if(lista.getMyAnimals().get(i).getSpecie() == species){
            // if(lista.getMyAnimals().get(i).getSpecie().equals("species")){
                System.out.println(lista.getMyAnimals().get(i));
            }
        }
    }
    
    // Overloading:
    // Search offsprings of a particular Animal
    public void searchOffsprings(SetUp lista, int exhibitionNumb){
        for(int i = 0 ; i < lista.getMyAnimals().size() ; i++){
            if(lista.getMyAnimals().get(i).getExhibitionNumb() == exhibitionNumb){
                for(int j = 0 ; j < lista.getMyAnimals().get(i).getOffsprings().size() ; j++){
                    System.out.println(lista.getMyAnimals().get(i).getOffsprings().get(j));
                }
            }
        }
    }
    // Search all animal with offsprings
    public void searchOffsprings(SetUp lista){
        for(int i = 0 ; i < lista.getMyAnimals().size() ; i++){
            if(lista.getMyAnimals().get(i).getOffsprings().size() != 0){
                System.out.println(lista.getMyAnimals().get(i));
            }
        }
    }
    
    public void searchParent(SetUp lista, int exhibitionNumb){
        for(int i = 0 ; i < lista.getMyAnimals().size() ; i++){
                for(int j = 0 ; j < lista.getMyAnimals().get(i).getOffsprings().size() ; j++){
                    if(lista.getMyAnimals().get(i).getOffsprings().get(j).getExhibitionNumb() == exhibitionNumb){
                        System.out.println(lista.getMyAnimals().get(i));
                    }
                }
        }
    }
        
//    public void searchAnimalByKeaper(SetUp lista, String keaper) {
//    }
    
}

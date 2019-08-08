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

import cctzoo.model.animals.Animal;
import cctzoo.model.keepers.Keeper;
import java.util.ArrayList;
import static javafx.scene.input.KeyCode.T;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Search {

//Search Animal 
//
//* By Specie
//* See Offsprings
//* By Type

//* By keeper 
//* Whild Search
//* By date of Arrival
//
//Search Keeper
//
//* By Animals
//* By Qualification
//* by date of birth
//* Whild search
        
    
    // 
    public ArrayList<Animal> searchAnimalByTypes(ArrayList<Animal> list, String type) {
        
        ArrayList<Animal> listSearch = new ArrayList<Animal>();
        String typeName;
        
        for (Animal a : list) {
            
            for (Class s : a.getClass().getInterfaces()) {
                
                typeName = s.getSimpleName();
                
                if (typeName.matches(type)) {
                    listSearch.add(a);
                }
                break;
                
            }
            
        }
        
        return listSearch;
        
        
    }
    
    
    public ArrayList<Animal> searchAnimalBySpecies(ArrayList<Animal> list, String species){
        ArrayList<Animal> listSearch = new ArrayList<Animal>();
        for(Animal a : list) {
            if(a.getSpecie().matches(species)) {
                listSearch.add(a);
            }
        }
        return listSearch;
    }
    
    public ArrayList<Animal> searchAnimalByNames(ArrayList<Animal> list, String name){
        ArrayList<Animal> listSearch = new ArrayList<Animal>();
        for(Animal a : list) {
            if(a.getName().matches(name)) {
                listSearch.add(a);
            }
        }
        return listSearch;
    }    
    
    // Search all offsprings
    public ArrayList<Animal> searchOffsprings(ArrayList<Animal> list){
        ArrayList<Animal> listSearch = new ArrayList<Animal>();
        for(int i = 0 ; i < list.size() ; i++){
            for(int j = 0 ; j < list.get(i).getOffsprings().size() ; j++ ){
                //System.out.println(list.get(i));
                listSearch.add(list.get(i).getOffsprings().get(j));
            }
        }
        return listSearch;
    }
    
    // Search offsprings of a particular Animal
    public ArrayList<Animal> searchOffsprings(ArrayList<Animal> list, int exhibitionNumb){
        ArrayList<Animal> listSearch = new ArrayList<Animal>();
        for(int i = 0 ; i < list.size() ; i++){
            if(list.get(i).getExhibitionNumb() == exhibitionNumb){
                for(int j = 0 ; j < list.get(i).getOffsprings().size() ; j++){
                    //System.out.println(list.get(i).getOffsprings().get(j));
                    listSearch.add(list.get(i).getOffsprings().get(j));
                }
                
            }
        }
        return listSearch;
    }
    
    // Search all animals that are Parents (All Animals with offsprings)
    public ArrayList<Animal> searchParents(ArrayList<Animal> list){
        ArrayList<Animal> listSearch = new ArrayList<Animal>();
        for(int i = 0 ; i < list.size() ; i++){
            if(list.get(i).getOffsprings().size() != 0){
                //System.out.println(list.get(i));
                listSearch.add(list.get(i));
            }
        }
        return listSearch;
    }
    
    // Search Parents of a particular animal
    public ArrayList<Animal> searchParents(ArrayList<Animal> list, int exhibitionNumb){
        ArrayList<Animal> listSearch = new ArrayList<Animal>();
        for(int i = 0 ; i < list.size() ; i++){
            for(int j = 0 ; j < list.get(i).getOffsprings().size() ; j++){
                if(list.get(i).getOffsprings().get(j).getExhibitionNumb() == exhibitionNumb){
                    //System.out.println(list.get(i));
                    listSearch.add(list.get(i));
                }
            }
        }
        return listSearch;
    }
    
    public ArrayList<Keeper> searchKeeperByNames(ArrayList<Keeper> list, String name){
        ArrayList<Keeper> listSearch = new ArrayList<Keeper>();
        for(Keeper a : list) {
            if(a.getName().matches(name)) {
                listSearch.add(a);
            }
        }
        return listSearch;
    }
    
    public ArrayList<Keeper> searchKeeperByQualifications(ArrayList<Keeper> list, String qualification) {
        ArrayList<Keeper> listSearch = new ArrayList<>();
        String qualificationName;
        
        for (Keeper a : list) {
            
            for (String s : a.getQualification()) {
                
                qualificationName = s;
                
                if (qualificationName.matches(qualification)) {
                    listSearch.add(a);
                }
                break;
                
            }
            
        }
        
        return listSearch;
    }
    
    public ArrayList<Animal> searchAnimalByKeeper(ArrayList<Animal> list, ArrayList<String> qualification) {
        ArrayList<Animal> listSearch = new ArrayList<>();
        
        for (String q : qualification) {
            
            for (Animal a : list) {
                
                for (Class c : a.getClass().getInterfaces()) {
                    
                    if (q.matches(c.getSimpleName())) {
                        listSearch.add(a);
                    }
                    
                }
                
            }
            
        }
        
        return listSearch;
    }
    
    
    public void printConsole(ArrayList<?> listObjs) {
        if (listObjs.size() > 0){
            if(listObjs.get(0) instanceof Animal){
                ArrayList<Animal> list = (ArrayList<Animal>) listObjs;
                for(int i = 0 ; i < list.size() ; i++){
                    //System.out.println(list.get(i));
                }
            }else{
                if(listObjs.get(0) instanceof Keeper){
                    ArrayList<Keeper> list = (ArrayList<Keeper>) listObjs;
                    for(int i = 0 ; i < list.size() ; i++){
                        //System.out.println(list.get(i));
                    }
                }
            }
        }
    }
    
    
    
    
    public String[][] dataToString(ArrayList<?> listaObjs, String[] instanceNames, String[] columnsNames) {
        if (listaObjs.size() > 0){

            if(listaObjs.get(0) instanceof Animal){
                ArrayList<Animal> lista = (ArrayList<Animal>) listaObjs;

                int m = lista.size();

                int zz = columnsNames.length;
                String[][] stockArr = new String[m][zz];
                for (int i = 0 ; i < m ; i++){
                    int nn = lista.get(i).toArrayList().size();
                    int j=0, s=0;
                    while (s < zz && j < nn){
                        if(lista.get(i).nameVariables().contains(instanceNames[s])){
                            j++;
                            if(lista.get(i).nameVariables().get(j-1) == instanceNames[s]){
                                stockArr[i][s] = lista.get(i).toArrayList().get(j-1);
                                s++;
                                j=0;
                            }
                            
                        }else{
                            stockArr[i][s] = "";
                            s++;
                        }
                    }
                }
                //toJFrame(stockArr, columnsNames);
                
                return stockArr;
                
            }else{
                ArrayList<Keeper> lista = (ArrayList<Keeper>) listaObjs;

                int m = lista.size();
                int n = lista.get(0).toArrayList().size();
                for (int i = 0 ; i < lista.size() ; i++) {
                    if (n < lista.get(i).toArrayList().size()){
                        n = lista.get(i).toArrayList().size();
                    }
                }

                int zz = columnsNames.length;
                String[][] stockArr = new String[m][zz];
                for (int i = 0 ; i < m ; i++){
                    int nn = lista.get(i).toArrayList().size();
                    int j=0, s=0;
                    while (s < zz && j < nn){
                        j++;
                        if(lista.get(i).nameVariables().get(j-1) == instanceNames[s]){
                            stockArr[i][s] = lista.get(i).toArrayList().get(j-1);
                            s++;
                            j=0;
                        }
                    }
                }
                //toJFrame(stockArr, columnsNames);

                return stockArr;            
            }
        }else{
            String[][] stockArr =  new String[0][0];
            
            //toJFrame(stockArr, columnsNames);
            
            return stockArr;
        }
        
    }
    
    
    
    
    public void toJFrame(String[][] stockArr, String[] columnsNames){
        JFrame frame = new JFrame();
        frame.setSize(500,500);

        JTable tabla = new JTable(stockArr, columnsNames);
        JScrollPane barrapanel = new JScrollPane(tabla);
        frame.add(barrapanel);

        frame.setVisible(true);
    }
    
    
}


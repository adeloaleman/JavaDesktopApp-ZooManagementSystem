/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctzoo.view.animals;

import cctzoo.view.generic.CalendarPanel;
import cctzoo.view.generic.CheckBoxPanel;
import cctzoo.view.generic.ComboBoxFieldsPanel;
import cctzoo.view.generic.GenericButton;
import cctzoo.view.generic.Header;
import cctzoo.view.generic.ImageLabel;
import cctzoo.view.generic.MainFrame;
import cctzoo.view.generic.TextFieldPanel;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author guerr
 */
public class AddAnimalFrame extends MainFrame {
    
    private ComboBoxFieldsPanel medication;
    private ComboBoxFieldsPanel vaccine;
    private ComboBoxFieldsPanel type;
    private ComboBoxFieldsPanel specie;
    private ComboBoxFieldsPanel gender;
    private Header header;
    private final ImageLabel addAnimalImageLabel;
    private TextFieldPanel addAnimalName;
    private final ImageLabel addAnimalImageLabel2;
    private CalendarPanel addAnimalDayOfBirth;
    private CalendarPanel addAnimalDayOfArrival;
    private GenericButton addAnimalButton;
    private GenericButton resetAnimalButton;
    private final ImageLabel addAnimalImageLabel3;
    private CheckBoxPanel extraCharacteristics;
    
    public AddAnimalFrame(String frameTitle, int frameWidth, int frameHeight, String iconName) {
        super(frameTitle, frameWidth, frameHeight, iconName);
        
        this.header = new Header(frameWidth, 110, "Add Animal", "src/cctzoo/view/images/addanimal.png", "src/cctzoo/view/images/back.png", "Go Back");
        this.add(this.header);
        
        this.addAnimalImageLabel = new ImageLabel(20, 70, 173, 200, "src/cctzoo/view/images/addditto.png");
        this.add(this.addAnimalImageLabel.getImageLabel());
        
        this.type = new ComboBoxFieldsPanel(this.setTypesFields(), "Type", 200, 70, 60);
        this.add(this.type);
        this.type.setEnabled(true);
        this.type.getFieldOne().setEnabled(true);
        
        ArrayList<String> list = new ArrayList<>();
        this.specie = new ComboBoxFieldsPanel(list, "Specie", 200, 130, 60);
        this.add(this.specie);
        this.specie.setEnabled(true);
        this.specie.getFieldOne().setEnabled(true);
        
        this.addAnimalName = new TextFieldPanel(340, 70, 190, 60, "Name ");
        this.add(this.addAnimalName);
        this.addAnimalName.setEnabled(true);
        this.addAnimalName.getTextField().setEnabled(true);
        
        ArrayList<String> genders = new ArrayList<String>();
        genders.add("male");
        genders.add("female");
        this.gender = new ComboBoxFieldsPanel(genders, "Gender", 340, 130, 60);
        this.add(this.gender);
        this.gender.setEnabled(true);
        this.gender.getFieldOne().setEnabled(true);
        
        this.addAnimalImageLabel2 = new ImageLabel(485, 140, 40, 40, "src/cctzoo/view/images/cat.png");
        this.add(this.addAnimalImageLabel2.getImageLabel());
        
        this.addAnimalDayOfBirth = new CalendarPanel(540, 70, "Date Of Birth ", "Set day of birth of Animal");
        this.add(this.addAnimalDayOfBirth);
        this.addAnimalDayOfBirth.setEnabled(true);
        this.addAnimalDayOfBirth.getDatePicker().getComponent(0).setEnabled(true);
        this.addAnimalDayOfBirth.getDatePicker().getComponent(1).setEnabled(true);
        
        this.addAnimalDayOfArrival = new CalendarPanel(540, 130, "Date Of Arrival ", "Set day of Arrival of Animal");
        this.add(this.addAnimalDayOfArrival);
        this.addAnimalDayOfArrival.setEnabled(true);
        this.addAnimalDayOfArrival.getDatePicker().getComponent(0).setEnabled(true);
        this.addAnimalDayOfArrival.getDatePicker().getComponent(1).setEnabled(true);
        
        this.medication = new ComboBoxFieldsPanel(this.setMedicineFields(), "Medication", 200, 190);
        this.add(this.medication);
        
        this.vaccine = new ComboBoxFieldsPanel(this.setVaccineFields(), "Vaccine", 340, 190);
        this.add(this.vaccine);
        
        this.extraCharacteristics = new CheckBoxPanel(480, 190, 120, 80, "Extras ", "Add Extra Characteristics to Animal");
        this.add(this.extraCharacteristics);
        
        
        this.addAnimalButton = new GenericButton(495, 280, 90, "src/cctzoo/view/images/addanimal.png", "Add ", "Add Animal");
        this.add(this.addAnimalButton);
        this.addAnimalButton.setEnabled(true);
        
        this.resetAnimalButton = new GenericButton(50, 280, 90, "src/cctzoo/view/images/reset.png", "Reset ", "Reset Values");
        this.add(this.resetAnimalButton);
        this.resetAnimalButton.setEnabled(true);
        
        this.addAnimalImageLabel3 = new ImageLabel(610, 190, 130, 130, "src/cctzoo/view/images/snake.png");
        this.add(this.addAnimalImageLabel3.getImageLabel());
        
    }
    
    private ArrayList<String> setTypesFields() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Avian");
        list.add("Mammal");
        list.add("Reptile");
        list.add("Mammal Aquatic");
        list.add("Reptile Aquatic");
        
        return list;
    }
    
    public ArrayList<String> setSpeciesFields(String typeField) {
        ArrayList<String> list;
        
        switch (typeField) {
            case "Avian":
                String[] avianSpecies = {"Parrot", "Owl", "Tucan", "Swallow", "Sparrow", "Goose", "Potoo", "Heron", "Tern", "Bustard", "Kingfisher", "Turaco", "Eagle"}; 
                list = new ArrayList<>(Arrays.asList(avianSpecies));
                return list;
            case "Mammal":
                String[] mammalSpecies = {"Tiger", "Elephant", "Bear", "Deer", "Squirrel", "Armadillo", "Ape", "Hyena", "Lemur", "Simian", "Jirafe", "Leopard", "Ocelot"};
                list = new ArrayList<>(Arrays.asList(mammalSpecies));
                return list;
            case "Reptile":
                String[] reptileSpecies = {"Lizard", "Geckos", "Skink", "Gekkota", "Iguanidae", "Chamaleons", "Turtle", "Snake", "Lacertid", "Gila Monster", "Viper", "Tuatara"}; 
                list = new ArrayList<>(Arrays.asList(reptileSpecies));
                return list;
            case "Mammal Aquatic":
                String[] mammalAquaticSpecies = {"Dolphin", "Wale","Pinguin", "See Cow", "Otter", "Pinniped", "Rhinoceros", "Seal", "American Beaver", "Manatee", "Capibara", "Hippopotamus" }; 
                list = new ArrayList<>(Arrays.asList(mammalAquaticSpecies));
                return list;
            case "Reptile Aquatic":
                String[] reptileAquaticSpecies = {"Crocodile", "Anaconda", "Coral Snake", "North Watter Snake", "Emydidae", "Homalopsis Snake", "Salamander", "Turtle", "Busmaster"}; 
                list = new ArrayList<>(Arrays.asList(reptileAquaticSpecies));
                return list;
            default:
                return null;
        }
        
    }
    
    public ArrayList<String> setMedicineFields() {
        ArrayList<String> list;
        String[] medication = {"Lovetoin", "Trandoronate", "Afanuma", "Cortimadin", "Tetapitant", "Ablastral", "Bactaxime", "Allokyn", "Sublamin", "Nornex", "Adiline", "Veratasol"};
        list = new ArrayList<>(Arrays.asList(medication));
        return list;
    }
    
    public ArrayList<String> setVaccineFields() {
        ArrayList<String> list;
        String[] vacine = {"AVA-BioThrax", "DTaP", "PCV13", "Rabies", "RV1", "RV5", "Vaccinia", "Tenivac", "MMRV", "Typhoid-Oral", "Flulaval", "MenACWY", "MenB", "Fluzone", "Zostavax"};
        list = new ArrayList<>(Arrays.asList(vacine));
        return list;
    }

    public ComboBoxFieldsPanel getMedication() {
        return medication;
    }

    public ComboBoxFieldsPanel getVaccine() {
        return vaccine;
    }

    public ComboBoxFieldsPanel getTypeField() {
        return type;
    }

    public ComboBoxFieldsPanel getSpecie() {
        return specie;
    }

    public ComboBoxFieldsPanel getGender() {
        return gender;
    }

    public Header getHeader() {
        return header;
    }

    public TextFieldPanel getAddAnimalName() {
        return addAnimalName;
    }

    public CalendarPanel getAddAnimalDayOfBirth() {
        return addAnimalDayOfBirth;
    }

    public CalendarPanel getAddAnimalDayOfArrival() {
        return addAnimalDayOfArrival;
    }

    public GenericButton getAddAnimalButton() {
        return addAnimalButton;
    }

    public GenericButton getResetAnimalButton() {
        return resetAnimalButton;
    }

    public CheckBoxPanel getExtraCharacteristics() {
        return extraCharacteristics;
    }
    
    
    
}

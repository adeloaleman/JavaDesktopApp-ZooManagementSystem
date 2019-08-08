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

/**
 *
 * @author guerr
 */
public class UpdateAnimalFrame extends MainFrame {

    private ComboBoxFieldsPanel medication;
    private ComboBoxFieldsPanel vaccine;
    private ComboBoxFieldsPanel type;
    private ComboBoxFieldsPanel specie;
    private ComboBoxFieldsPanel gender;
    private Header header;
    private ImageLabel updateAnimalImageLabel;
    private TextFieldPanel updateAnimalName;
    private ImageLabel updateAnimalImageLabel2;
    private CalendarPanel updateAnimalDayOfBirth;
    private CalendarPanel updateAnimalDayOfArrival;
    private GenericButton updateAnimalButton;
    private ImageLabel updateAnimalImageLabel3;
    private CheckBoxPanel extraCharacteristics;
    private ViewOffspringsPanel offspringsPanel;
    private AddOffspringsPanel addOffSpringsPanel;
    private ImageLabel addOffspringImageLabel;

    public UpdateAnimalFrame() {
    }
    
    public UpdateAnimalFrame(String frameTitle, int frameWidth, int frameHeight, String iconName, String type, String specie, String gender, ArrayList<String> medication, ArrayList<String> vaccine) {
        super(frameTitle, frameWidth, frameHeight, iconName);
        
        this.header = new Header(frameWidth, 140, "Update Animal", "src/cctzoo/view/images/updateanimal.png", "src/cctzoo/view/images/back.png", "Go Back");
        this.add(this.header);
        
        this.updateAnimalImageLabel = new ImageLabel(20, 70, 173, 200, "src/cctzoo/view/images/addditto.png");
        this.add(this.updateAnimalImageLabel.getImageLabel());
        
        ArrayList<String> types = new ArrayList<>();
        types.add(type);
        this.type = new ComboBoxFieldsPanel(types, "Type", 200, 70, 60);
        this.add(this.type);
        
        ArrayList<String> species = new ArrayList<>();
        species.add(specie);
        this.specie = new ComboBoxFieldsPanel(species, "Specie", 200, 130, 60);
        this.add(this.specie);
        
        this.updateAnimalName = new TextFieldPanel(340, 70, 190, 60, "Name ");
        this.add(this.updateAnimalName);
        
        ArrayList<String> genders = new ArrayList<String>();
        genders.add(gender);
        this.gender = new ComboBoxFieldsPanel(genders, "Gender", 340, 130, 60);
        this.add(this.gender);
        
        this.updateAnimalImageLabel2 = new ImageLabel(485, 140, 40, 40, "src/cctzoo/view/images/cat.png");
        this.add(this.updateAnimalImageLabel2.getImageLabel());
        
        this.updateAnimalDayOfBirth = new CalendarPanel(540, 70, "Date Of Birth ", "Set day of birth of Animal");
        this.add(this.updateAnimalDayOfBirth);
        
        this.updateAnimalDayOfArrival = new CalendarPanel(540, 130, "Date Of Arrival ", "Set day of Arrival of Animal");
        this.add(this.updateAnimalDayOfArrival);
        
        this.medication = new ComboBoxFieldsPanel(medication, "Medication", 200, 190, 60);
        this.add(this.medication);
        this.medication.setEnabled(true);
        this.medication.getFieldOne().setEnabled(true);
        
        this.vaccine = new ComboBoxFieldsPanel(vaccine, "Vaccine", 340, 190, 60);
        this.add(this.vaccine);
        this.vaccine.setEnabled(true);
        this.vaccine.getFieldOne().setEnabled(true);
        
        this.extraCharacteristics = new CheckBoxPanel(480, 190, 120, 80, "Extras ", "Add Extra Characteristics to Animal");
        this.add(this.extraCharacteristics);
        
        
        this.updateAnimalButton = new GenericButton(495, 280, 90, "src/cctzoo/view/images/updateanimal.png", "Update", "Update Animal");
        this.add(this.updateAnimalButton);
        this.updateAnimalButton.setEnabled(true);
        
        this.updateAnimalImageLabel3 = new ImageLabel(610, 190, 130, 130, "src/cctzoo/view/images/snake.png");
        this.add(this.updateAnimalImageLabel3.getImageLabel());
        
        this.offspringsPanel = new ViewOffspringsPanel(540, 320, 200, 205, "Offsprings", "Offsprings of selected animal", 175);
        this.add(this.offspringsPanel);
        
        this.addOffSpringsPanel = new AddOffspringsPanel(20, 320, "Add a Offspring ", "Add Offspring to Animal", this.setMedicinesArrayList(), this.setVaccinesArrayList());
        this.add(this.addOffSpringsPanel);
        this.addOffSpringsPanel.setEnabled(true);
        
        this.addOffspringImageLabel = new ImageLabel(445, 330, 90, 180, "src/cctzoo/view/images/monkey.png");
        this.add(this.addOffspringImageLabel.getImageLabel());
    }

    public ComboBoxFieldsPanel getMedication() {
        return medication;
    }

    public ComboBoxFieldsPanel getVaccine() {
        return vaccine;
    }

    public ComboBoxFieldsPanel getTypes() {
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

    public ImageLabel getUpdateAnimalImageLabel() {
        return updateAnimalImageLabel;
    }

    public TextFieldPanel getUpdateAnimalName() {
        return updateAnimalName;
    }

    public ImageLabel getUpdateAnimalImageLabel2() {
        return updateAnimalImageLabel2;
    }

    public CalendarPanel getUpdateAnimalDayOfBirth() {
        return updateAnimalDayOfBirth;
    }

    public CalendarPanel getUpdateAnimalDayOfArrival() {
        return updateAnimalDayOfArrival;
    }

    public GenericButton getUpdateAnimalButton() {
        return updateAnimalButton;
    }

    public ImageLabel getUpdateAnimalImageLabel3() {
        return updateAnimalImageLabel3;
    }

    public CheckBoxPanel getExtraCharacteristics() {
        return extraCharacteristics;
    }

    private ArrayList<String> setMedicinesArrayList() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Lovetoin");
        list.add("Trandoronate");
        list.add("Afanuma");
        list.add("Cortimadin");
        list.add("Tetapitant");
        list.add("Ablastral");
        list.add("Bactaxime");
        list.add("Allokyn");
        list.add("Sublamin");
        list.add("Nornex");
        list.add("Adiline");
        list.add("Veratasol");
        
        return list;
    }

    private ArrayList<String> setVaccinesArrayList() {
        ArrayList<String> list = new ArrayList<>();
        list.add("AVA-BioThrax");
        list.add("DTaP");
        list.add("PCV13");
        list.add("Rabies");
        list.add("RV1");
        list.add("RV5");
        list.add("Vaccinia");
        list.add("Tenivac");
        list.add("MMRV");
        list.add("Typhoid-Oral");
        list.add("Flulaval");
        list.add("MenACWY");
        list.add("MenB");
        list.add("Fluzone");
        list.add("Zostavax");
        
        return list;
    }

    public ViewOffspringsPanel getOffspringsPanel() {
        return offspringsPanel;
    }

    public AddOffspringsPanel getAddOffSpringsPanel() {
        return addOffSpringsPanel;
    }
    
    
    
}

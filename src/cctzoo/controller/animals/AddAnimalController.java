/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctzoo.controller.animals;

import cctzoo.controller.TheController;
import cctzoo.model.TheModel;
import cctzoo.model.animals.Animal;
import cctzoo.model.animals.CreateAvian;
import cctzoo.model.animals.CreateMammal;
import cctzoo.model.animals.CreateMammalAquatic;
import cctzoo.model.animals.CreateReptile;
import cctzoo.model.animals.CreateReptileAquatic;
import cctzoo.model.animals.Medication;
import cctzoo.model.animals.Vacine;
import cctzoo.view.TheView;
import cctzoo.view.animals.AddAnimalFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

/**
 *
 * @author guerr
 */
public class AddAnimalController implements WindowListener {

    TheModel model;
    TheView view;
    TheController ctrl;
    AddAnimalFrame addAnimal;

    public AddAnimalController(TheModel model, TheView view, TheController ctrl) {
        this.model = model;
        this.view = view;
        this.ctrl = ctrl;

        this.addAnimal = this.view.getAddAnimal();

    }

    public void setAddAnimal(AddAnimalFrame addAnimal) {
        this.addAnimal = addAnimal;
        this.goBackButtonController();
        this.addAnimal.addWindowListener(this);
        this.addAnimalButtonController();
        this.addTypeBoxController();
        this.resetDetailsAnimalButtonController();
    }

    private void goBackButtonController() {

        addAnimal.getHeader().getGoBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (JOptionPane.showConfirmDialog(addAnimal, "Are you sure you want to go back?", "Going back?", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {

                    addAnimal.dispose();
                    view.getAdminDash().setVisible(true);
                    view.getAdminDash().validate();
                    view.getAdminDash().repaint();

                }
            }

        });
    }

    private void resetDetailsAnimalButtonController() {

        addAnimal.getResetAnimalButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                resetValues();

            }

        });
    }
    
    private void addAnimalButtonController() {

        addAnimal.getAddAnimalButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int t = addAnimal.getTypeField().getFieldOne().getSelectedIndex();
                int s = addAnimal.getSpecie().getFieldOne().getSelectedIndex();
                String n = addAnimal.getAddAnimalName().getTextField().getText();
                int difDates = addAnimal.getAddAnimalDayOfArrival().dateToInt() - addAnimal.getAddAnimalDayOfBirth().dateToInt();
                int g = addAnimal.getGender().getFieldOne().getSelectedIndex();
                int m = addAnimal.getMedication().getFieldOne().getSelectedIndex();
                int v = addAnimal.getVaccine().getFieldOne().getSelectedIndex();

                if (t == -1) {
                    JOptionPane.showMessageDialog(addAnimal, "Type has to be selected!", "Something is not right!", JOptionPane.ERROR_MESSAGE);
                } else if (s == -1) {
                    JOptionPane.showMessageDialog(addAnimal, "Specie has to selected!", "Something is not right!", JOptionPane.ERROR_MESSAGE);
                } else if (n.equals("")) {
                    JOptionPane.showMessageDialog(addAnimal, "Name cannot be empty!", "Something is not right!", JOptionPane.ERROR_MESSAGE);
                } else if (difDates < 0) {
                    JOptionPane.showMessageDialog(addAnimal, "Date of Arrival has to be after day of birth!", "Something is not right!", JOptionPane.ERROR_MESSAGE);
                } else if (g == -1) {
                    JOptionPane.showMessageDialog(addAnimal, "Gender has to be selected!", "Something is not right!", JOptionPane.ERROR_MESSAGE);
                } else if (m == -1) {
                    JOptionPane.showMessageDialog(addAnimal, "First medication has to be selected", "Something is not right!", JOptionPane.ERROR_MESSAGE);
                } else if (v == -1) {
                    JOptionPane.showMessageDialog(addAnimal, "First vaccination has to be selected!", "Something is not right!", JOptionPane.ERROR_MESSAGE);
                } else {
                    addNewAnimal();
                    JOptionPane.showMessageDialog(addAnimal, "Animal has been added to the database!", "Yey!", JOptionPane.INFORMATION_MESSAGE);
                    resetValues();
                }

            }

        });
    }
    
    private void resetValues() {
        addAnimal.getTypeField().getFieldOne().setSelectedIndex(-1);
        addAnimal.getSpecie().getFieldOne().setSelectedIndex(-1);
        addAnimal.getAddAnimalName().getTextField().setText("");
        addAnimal.getAddAnimalDayOfArrival().setDate("05/05/2018");
        addAnimal.getAddAnimalDayOfBirth().setDate("05/05/2018");
        addAnimal.getGender().getFieldOne().setSelectedIndex(-1);
        addAnimal.getMedication().getFieldOne().setSelectedIndex(-1);
        addAnimal.getMedication().getFieldTwo().setSelectedIndex(-1);
        addAnimal.getMedication().getFieldThree().setSelectedIndex(-1);
        addAnimal.getVaccine().getFieldOne().setSelectedIndex(-1);
        addAnimal.getVaccine().getFieldTwo().setSelectedIndex(-1);
        addAnimal.getVaccine().getFieldThree().setSelectedIndex(-1);
        
        addAnimal.getExtraCharacteristics().removeAll();
        addAnimal.getExtraCharacteristics().updateUI();
    }    
    
    private void addNewAnimal() {
        String type = addAnimal.getTypeField().getFieldOne().getSelectedItem().toString();
        String specie = addAnimal.getSpecie().getFieldOne().getSelectedItem().toString();
        String name = addAnimal.getAddAnimalName().getTextField().getText();
        int gender = 0;
        if (addAnimal.getGender().getFieldOne().getSelectedItem().toString().equals("Male")) {
            gender = 1;
        }
        String dob = addAnimal.getAddAnimalDayOfBirth().dateToString();
        String doa = addAnimal.getAddAnimalDayOfArrival().dateToString();
        
        ArrayList<String> medNames = getMedication();
        Medication med = new Medication();
        med.addMedication(medNames);
        
        ArrayList<String> vacNames = getVaccination();
        Vacine vac = new Vacine();
        vac.addVacine(vacNames);
        
        ArrayList<Integer> ext = getExtraCharacteristicas();
        
        Animal animal;
        
        switch (addAnimal.getTypeField().getFieldOne().getSelectedItem().toString()) {
            case "Avian":
                animal = new CreateAvian(specie, name, dob, doa, gender, med, vac);
                ((CreateAvian)animal).setCanFligh(ext.get(0));
                ((CreateAvian)animal).setHasFeeders(ext.get(1));
                model.getListAnimals().add(animal);
                break;
            case "Mammal":
                animal = new CreateMammal(specie, name, dob, doa, gender, med, vac);
                ((CreateMammal)animal).setFurry(ext.get(0));
                model.getListAnimals().add(animal);
                break;
            case "Reptile":
                animal = new CreateReptile(specie, name, dob, doa, gender, med, vac);
                ((CreateReptile)animal).isVennon(ext.get(0));
                model.getListAnimals().add(animal);
                break;
            case "Mammal Aquatic":
                animal = new CreateMammalAquatic(specie, name, dob, doa, gender, med, vac);
                ((CreateMammalAquatic)animal).setFurry(ext.get(0));
                ((CreateMammalAquatic)animal).canBeOutsideWatter(ext.get(0));
                model.getListAnimals().add(animal);
                break;
            case "Reptile Aquatic":
                animal = new CreateReptileAquatic(specie, name, dob, doa, gender, med, vac);
                ((CreateReptileAquatic)animal).isVennon(ext.get(0));
                ((CreateReptileAquatic)animal).canBeOutsideWatter(ext.get(0));
                model.getListAnimals().add(animal);
                break;
            default:
                break;
        }
    }
    
    private ArrayList<Integer> getExtraCharacteristicas() {
        ArrayList<Integer> list = new ArrayList<>();
        
        for (JCheckBox cb : addAnimal.getExtraCharacteristics().getGeneralFields()) {
            if (cb.isSelected()) {
                list.add(1);
            } else {
                list.add(0);
            }
        }
        
        return list;
    }
    
    private ArrayList<String> getMedication() {
        ArrayList<String> list = new ArrayList<>();
        list.add(addAnimal.getMedication().getFieldOne().getSelectedItem().toString());
        
        if (addAnimal.getMedication().getFieldTwo().getSelectedIndex() > -1) {
            list.add(addAnimal.getMedication().getFieldTwo().getSelectedItem().toString());
        }
        if (addAnimal.getMedication().getFieldThree().getSelectedIndex() > -1) {
            list.add(addAnimal.getMedication().getFieldThree().getSelectedItem().toString());
        }
        
        return list;
    }
    
    private ArrayList<String> getVaccination() {
        ArrayList<String> list = new ArrayList<>();
        list.add(addAnimal.getVaccine().getFieldOne().getSelectedItem().toString());
        
        if (addAnimal.getVaccine().getFieldTwo().getSelectedIndex() > -1) {
            list.add(addAnimal.getVaccine().getFieldTwo().getSelectedItem().toString());
        }
        if (addAnimal.getVaccine().getFieldThree().getSelectedIndex() > -1) {
            list.add(addAnimal.getVaccine().getFieldThree().getSelectedItem().toString());
        }
        
        return list;
    }

    private void addTypeBoxController() {

        addAnimal.getTypeField().getFieldOne().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if (addAnimal.getTypeField().getFieldOne().getSelectedIndex() > -1) {
                    addAnimal.getSpecie().addFieldsToFieldOne(addAnimal.setSpeciesFields(addAnimal.getTypeField().getFieldOne().getSelectedItem().toString()));
                    addAnimal.getExtraCharacteristics().removeAll();
                    addAnimal.getExtraCharacteristics().updateUI();
                    extraCharacteristics();
                }
                
            }

        });
    }
    
    
    private void extraCharacteristics() {
        ArrayList<String> list = new ArrayList<>();
        
        switch (addAnimal.getTypeField().getFieldOne().getSelectedItem().toString()) {
            case "Avian":
                addAnimal.getExtraCharacteristics().setAmountOfFields(2);
                list.add("Flight");
                list.add("Feathers");
                addAnimal.getExtraCharacteristics().setFieldsCheckBoxes(list);
                break;
            case "Mammal":
                addAnimal.getExtraCharacteristics().setAmountOfFields(1);
                list.add("Fur");
                addAnimal.getExtraCharacteristics().setFieldsCheckBoxes(list);
                break;
            case "Reptile":
                addAnimal.getExtraCharacteristics().setAmountOfFields(1);
                list.add("Venomous");
                addAnimal.getExtraCharacteristics().setFieldsCheckBoxes(list);
                break;
            case "Mammal Aquatic":
                addAnimal.getExtraCharacteristics().setAmountOfFields(2);
                list.add("Fur");
                list.add("Amphibian");
                addAnimal.getExtraCharacteristics().setFieldsCheckBoxes(list);
                break;
            case "Reptile Aquatic":
                addAnimal.getExtraCharacteristics().setAmountOfFields(2);
                list.add("Venomous");
                list.add("Amphibian");
                addAnimal.getExtraCharacteristics().setFieldsCheckBoxes(list);
                break;
            default:
                break;
        }
        
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        if (JOptionPane.showConfirmDialog(addAnimal, "Are you sure you want to go back?", "Going back?", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {

            addAnimal.dispose();
            view.getAdminDash().setVisible(true);
            view.getAdminDash().validate();
            view.getAdminDash().repaint();

        }
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

}

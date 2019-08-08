/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctzoo.controller.animals;

import cctzoo.controller.TheController;
import cctzoo.model.Search;
import cctzoo.model.TheModel;
import cctzoo.model.animals.Animal;
import cctzoo.model.animals.Aquatic;
import cctzoo.model.animals.CreateAquatic;
import cctzoo.model.animals.CreateAvian;
import cctzoo.model.animals.CreateInsect;
import cctzoo.model.animals.CreateMammal;
import cctzoo.model.animals.CreateMammalAquatic;
import cctzoo.model.animals.CreateReptile;
import cctzoo.model.animals.CreateReptileAquatic;
import cctzoo.view.TheView;
import cctzoo.view.animals.UpdateAnimalFrame;
import cctzoo.view.animals.ViewAnimalsFrame;
import cctzoo.view.generic.RefineByPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author guerr
 */
public class ViewAnimalsController implements WindowListener {

    ViewAnimalsFrame viewAnimals;
    boolean flag = false;
    Search searchEngine;
    UpdateAnimalFrame updateAnimal;
    int index = 0;
    TheView view;
    TheController ctrl;
    TheModel model;

    public ViewAnimalsController(TheModel model, TheView view, TheController ctrl) {

        this.model = model;
        this.view = view;
        this.ctrl = ctrl;
        this.viewAnimals = view.getViewAnimals();

    }
    
    public void setViewAnimals(ViewAnimalsFrame animalFrame) {
        
        this.viewAnimals = animalFrame;
        viewAnimals.addWindowListener(this);

        this.searchEngine = new Search();

        this.addControllerToCheckBox();

        this.addControllerToTextField();

        this.addControllerToGoBackButton();

        this.addControllerToAnimalsTable();

        this.refineButtonController();

        this.updateButtonController();
        
        this.viewAnimals.getOffspringsPanel().setVisible(false);
        
        this.viewAnimals.getAnimalView().setVisible(false);
    }

    private void addControllerToCheckBox() {

        for (int i = 0; i < viewAnimals.getRefiningTextPanel().getCheckBoxFields().getGeneralFields().length; i++) {
            viewAnimals.getRefiningTextPanel().getCheckBoxFields().getGeneralFields()[i].addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        for (int i = 0; i < viewAnimals.getRefiningTextPanel().getCheckBoxFields().getGeneralFields().length; i++) {
                            if (viewAnimals.getRefiningTextPanel().getCheckBoxFields().getGeneralFields()[i].isSelected()) {
                                viewAnimals.getRefiningTextPanel().getCheckBoxFields().disableFields(i);

                                break;
                            }
                        }
                        if (viewAnimals.getRefiningTextPanel().getCheckBoxFields().getGeneralFields()[3].isSelected()) {
                            viewAnimals.getRefiningTextPanel().getRefineByButton().setEnabled(true);
                        } else {
                            viewAnimals.getRefiningTextPanel().getRefineByTextField().enablePanelAndTextField();
                            addControllerToTextField();
                        }

                    } else {
                        viewAnimals.getRefiningTextPanel().getCheckBoxFields().enableFields();
                        viewAnimals.getRefiningTextPanel().getRefineByTextField().disablePanelAndTextField();
                        viewAnimals.getRefiningTextPanel().getRefineByButton().disableGenericButton();
                    };
                }
            });
        }

    }

    private void addControllerToTextField() {

        viewAnimals.getRefiningTextPanel().getRefineByTextField().getTextField().getDocument().addDocumentListener(new JButtonStateController(viewAnimals.getRefiningTextPanel().getRefineByButton()));

        if (viewAnimals.getRefiningTextPanel().getRefineByTextField().getTextField().getText().equals("")) {
            viewAnimals.getRefiningTextPanel().getRefineByButton().setEnabled(false);
        } else {
            viewAnimals.getRefiningTextPanel().getRefineByButton().setEnabled(true);
        }

    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        if (JOptionPane.showConfirmDialog(this.viewAnimals, "Are you sure you want to go back?", "Going back?", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {

            this.viewAnimals.dispose();
            this.view.getAdminDash().setVisible(true);
            this.view.getAdminDash().validate();
            this.view.getAdminDash().repaint();

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

    private class JButtonStateController implements DocumentListener {

        JButton button;

        JButtonStateController(JButton button) {
            this.button = button;
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            disableIfEmpty(e);
        }

        @Override
        public void insertUpdate(DocumentEvent e) {
            disableIfEmpty(e);
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            disableIfEmpty(e);
        }

        public void disableIfEmpty(DocumentEvent e) {
            button.setEnabled(e.getDocument().getLength() > 0);
        }

    }

    private void addControllerToGoBackButton() {

        viewAnimals.getHeader().getGoBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (JOptionPane.showConfirmDialog(viewAnimals, "Are you sure you want to go back?", "Going back?", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {

                    viewAnimals.dispose();
                    view.getAdminDash().setVisible(true);
                    view.getAdminDash().validate();
                    view.getAdminDash().repaint();

                }
            }

        });

    }

    private void addControllerToAnimalsTable() {
        this.viewAnimals.getAnimalsPanel().getViewAnimalsTable().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                if (event.getValueIsAdjusting()) {
                    if (viewAnimals.getAnimalsPanel().getViewAnimalsTable().getSelectedRow() > -1) {

                        resetAnimalDetails();

                        // Row clicked
                        int row = viewAnimals.getAnimalsPanel().getViewAnimalsTable().getSelectedRow();
                        // Exhibit Number
                        int en = Integer.parseInt((String) viewAnimals.getAnimalsPanel().getViewAnimalsTable().getValueAt(row, 0));
                        setAnimalCard(en);
                        index = en;
                        // Initializing the offsprings table with all the data
                        setOffspringsTable();

                    } else {
                        viewAnimals.getPlaceHolderImage().getImageLabel().setVisible(true);
                    }
                }
            }
        });
    }

    protected void setOffspringsTable() {
        viewAnimals.getOffspringsPanel().setVisible(true);
        viewAnimals.getOffspringsPanel().dataToString(viewAnimals.getAnimals().get(index).getOffsprings());
        viewAnimals.getOffspringsPanel().setData();
        viewAnimals.getUpdateAnimalButton().setEnabled(true);

    }

    protected void resetAnimalDetails() {
        if (flag == true) {

            viewAnimals.getAnimalView().removeAll();
            viewAnimals.getAnimalView().updateUI();
            viewAnimals.getOffspringsPanel().removeAllRows();

        }
        flag = true;
    }

    protected void setAnimalCard(int en) {
        viewAnimals.getPlaceHolderImage().getImageLabel().setVisible(false);
        viewAnimals.getAnimalView().setVisible(true);
        // Exhibit Number
        viewAnimals.getAnimalView().setExhibitNumber(Integer.toString(en));
        // Look For Animal Type
        String[] types = null;
        for (int i = 0; i < viewAnimals.getAnimals().get(en).getClass().getInterfaces().length; i++) {
            if (i == 0) {
                types = new String[viewAnimals.getAnimals().get(en).getClass().getInterfaces().length];
            }
            types[i] = viewAnimals.getAnimals().get(en).getClass().getInterfaces()[i].getSimpleName();
        }
        viewAnimals.getAnimalView().setType(types);
        // Specie
        String specie = viewAnimals.getAnimals().get(en).getSpecie();
        viewAnimals.getAnimalView().setSpecie(specie);
        // Name
        String name = viewAnimals.getAnimals().get(en).getName();
        viewAnimals.getAnimalView().setName(name);
        // gender
        String gender = viewAnimals.getAnimals().get(en).getGender();
        viewAnimals.getAnimalView().setGender(gender);
        // Day of birth
        String birth = viewAnimals.getAnimals().get(en).getDateOfBirth();
        viewAnimals.getAnimalView().setDayOfBirth(birth);
        // Day of Arrival
        String arrival = viewAnimals.getAnimals().get(en).getDateOfArrival();
        viewAnimals.getAnimalView().setDayOfArrival(arrival);
        // Medication
        ArrayList<String> med = viewAnimals.getAnimals().get(en).getMedication().getMedicationName();
        viewAnimals.getAnimalView().setMedication(med);
        // Vaccination
        ArrayList<String> vac = viewAnimals.getAnimals().get(en).getVacine().getVacineName();
        viewAnimals.getAnimalView().setVaccine(vac);
        // Number of Offsprings
        int no = viewAnimals.getAnimals().get(en).getOffsprings().size();
        viewAnimals.getAnimalView().setOffprings(Integer.toString(no));
        // extra details

        if (types.length == 1) {
            switch (types[0]) {
                case "Aquatic":

                    viewAnimals.getAnimalView().setExtraDetails("Amphibian", ((CreateAquatic) viewAnimals.getAnimals().get(en)).getCanBeOutSideWatter());
                    break;
                case "Avian":

                    viewAnimals.getAnimalView().setExtraDetails("Flight", ((CreateAvian) viewAnimals.getAnimals().get(en)).getCanFligh());
                    viewAnimals.getAnimalView().setExtraDetails("Feathers", ((CreateAvian) viewAnimals.getAnimals().get(en)).getHasFeeders());
                    break;
                case "Insect":

                    viewAnimals.getAnimalView().setExtraDetails("Venomous", ((CreateInsect) viewAnimals.getAnimals().get(en)).getIsVennon());
                    break;
                case "Mammal":

                    viewAnimals.getAnimalView().setExtraDetails("Fur", ((CreateMammal) viewAnimals.getAnimals().get(en)).getFurry());
                    break;
                case "Reptile":

                    viewAnimals.getAnimalView().setExtraDetails("Venomous", ((CreateReptile) viewAnimals.getAnimals().get(en)).getIsVennon());
                    break;
                default:
                    break;
            }
        } else {
            switch (types[0]) {
                case "Mammal":
                    viewAnimals.getAnimalView().setExtraDetails("Fur", ((CreateMammalAquatic) viewAnimals.getAnimals().get(en)).getFurry());
                    viewAnimals.getAnimalView().setExtraDetails("Amphibian", ((CreateMammalAquatic) viewAnimals.getAnimals().get(en)).getCanBeOutSideWatter());
                    break;
                case "Reptile":
                    viewAnimals.getAnimalView().setExtraDetails("Venomous", ((CreateReptileAquatic) viewAnimals.getAnimals().get(en)).getIsVennon());
                    viewAnimals.getAnimalView().setExtraDetails("Amphibian", ((CreateReptileAquatic) viewAnimals.getAnimals().get(en)).getCanBeOutSideWatter());
                    break;
                default:
                    break;
            }

        }
    }

    private void refineButtonController() {
        viewAnimals.getRefiningTextPanel().getRefineByButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewAnimals.getAnimalView().setVisible(false);
                viewAnimals.getOffspringsPanel().setVisible(false);
                viewAnimals.getPlaceHolderImage().getImageLabel().setVisible(true);
                if (viewAnimals.getRefiningTextPanel().getCheckBoxFields().getGeneralFields()[3].isSelected()) {
                    //viewAnimals.removeAll();
                    //SwingUtilities.updateComponentTreeUI(viewAnimals);
                    viewAnimals.invalidate();
                    viewAnimals.validate();
                    viewAnimals.repaint();
                } else {
                    viewAnimals.getPlaceHolderImage().getImageLabel().setVisible(true);
                    refineEngine();
                    viewAnimals.getUpdateAnimalButton().setEnabled(false);
                }

            }

        });
    }

    private void refineEngine() {

        viewAnimals.getAnimalsPanel().removeAllRows();
        resetAnimalDetails();
        String str = viewAnimals.getRefiningTextPanel().getRefineByTextField().getTextField().getText();
        ArrayList<Animal> list = null;

        if (viewAnimals.getRefiningTextPanel().getCheckBoxFields().getGeneralFields()[0].isSelected()) {
            list = searchEngine.searchAnimalByTypes(viewAnimals.getAnimals(), "(?i:.*" + str + ".*)");
            
            setAnimalsTable(list);
        } else if (viewAnimals.getRefiningTextPanel().getCheckBoxFields().getGeneralFields()[1].isSelected()) {
            list = searchEngine.searchAnimalBySpecies(viewAnimals.getAnimals(), "(?i:.*" + str + ".*)");
            
            setAnimalsTable(list);
        } else if (viewAnimals.getRefiningTextPanel().getCheckBoxFields().getGeneralFields()[2].isSelected()) {
            list = searchEngine.searchAnimalByNames(viewAnimals.getAnimals(), "(?i:.*" + str + ".*)");
            
            setAnimalsTable(list);
        } else if (viewAnimals.getRefiningTextPanel().getCheckBoxFields().getGeneralFields()[3].isSelected()) {
            list = searchEngine.searchAnimalByNames(viewAnimals.getAnimals(), "(?i:.*" + str + ".*)");
            
            setAnimalsTable(list);
        }

    }

    protected void setAnimalsTable(ArrayList<Animal> list) {
        viewAnimals.getAnimalsPanel().dataToString(list);
        viewAnimals.getAnimalsPanel().setData();
    }

    private void updateButtonController() {
        viewAnimals.getUpdateAnimalButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String type = typeString();
                String specie = viewAnimals.getAnimals().get(index).getSpecie();
                String gender = viewAnimals.getAnimals().get(index).getGender();
                String name = viewAnimals.getAnimals().get(index).getName();
                String dob = viewAnimals.getAnimals().get(index).getDateOfBirth();
                String doa = viewAnimals.getAnimals().get(index).getDateOfArrival();
                ArrayList<String> medicines = viewAnimals.getAnimals().get(index).getMedication().getMedicationName();
                ArrayList<String> vaccine = viewAnimals.getAnimals().get(index).getVacine().getVacineName();
                updateAnimal = new UpdateAnimalFrame("Admin - Update Animal", 760, 570, "src/cctzoo/view/images/animal.png", type, specie, gender, medicines, vaccine);

                updateAnimal.getTypes().getFieldOne().setSelectedIndex(0);
                updateAnimal.getSpecie().getFieldOne().setSelectedIndex(0);
                updateAnimal.getGender().getFieldOne().setSelectedIndex(0);
                updateAnimal.getUpdateAnimalName().getTextField().setText(name);
                updateAnimal.getUpdateAnimalDayOfBirth().setDate(dob);
                updateAnimal.getUpdateAnimalDayOfArrival().setDate(doa);
                ArrayList<String> extras = extraFields();
                updateAnimal.getExtraCharacteristics().setAmountOfFields(extras.size());
                updateAnimal.getExtraCharacteristics().setFieldsCheckBoxes(extras);
                extraFieldsValues();
                updateAnimal.getExtraCharacteristics().disableFields(updateAnimal.getExtraCharacteristics().getGeneralFields().length);
                updateAnimal.getOffspringsPanel().dataToString(viewAnimals.getAnimals().get(index).getOffsprings());
                updateAnimal.getOffspringsPanel().setData();

                viewAnimals.dispose();
                updateAnimal.setVisible(true);
                view.setUpdateAnimal(updateAnimal);
                ctrl.getUpdateAnimalCtrl().setUpdateAnimal(updateAnimal);
                ctrl.getUpdateAnimalCtrl().getIndexOfAnimal(index);

            }

        });
    }

    public String typeString() {
        StringBuilder strB = new StringBuilder();
        for (Class t : viewAnimals.getAnimals().get(index).getClass().getInterfaces()) {
            strB.append(t.getSimpleName() + " ");
        }
        return strB.toString();
    }

    private ArrayList<String> extraFields() {
        ArrayList<String> list = new ArrayList<String>();
        String[] types = null;
        for (int i = 0; i < viewAnimals.getAnimals().get(index).getClass().getInterfaces().length; i++) {
            if (i == 0) {
                types = new String[viewAnimals.getAnimals().get(index).getClass().getInterfaces().length];
            }
            types[i] = viewAnimals.getAnimals().get(index).getClass().getInterfaces()[i].getSimpleName();
        }
        if (types.length == 1) {
            switch (types[0]) {
                case "Aquatic":
                    list.add("Amphibian");
                    break;
                case "Avian":
                    list.add("Flight");
                    list.add("Feather");
                    break;
                case "Insect":
                    list.add("Venomous");
                    break;
                case "Mammal":
                    list.add("Fur");
                    break;
                case "Reptile":
                    list.add("Venomous");
                    break;
                default:
                    break;
            }
        } else {
            switch (types[0]) {
                case "Mammal":
                    list.add("Fur");
                    list.add("Amphibian");
                    break;
                case "Reptile":
                    list.add("Venomous");
                    list.add("Amphibian");
                    break;
                default:
                    break;
            }

        }
        return list;
    }

    public void extraFieldsValues() {
        ArrayList<Boolean> list = new ArrayList<>();
        String[] types = null;
        for (int i = 0; i < viewAnimals.getAnimals().get(index).getClass().getInterfaces().length; i++) {
            if (i == 0) {
                types = new String[viewAnimals.getAnimals().get(index).getClass().getInterfaces().length];
            }
            types[i] = viewAnimals.getAnimals().get(index).getClass().getInterfaces()[i].getSimpleName();
        }
        if (types.length == 1) {
            switch (types[0]) {
                case "Aquatic":
                    if (((CreateAquatic) viewAnimals.getAnimals().get(index)).getCanBeOutSideWatter() == 1) {
                        updateAnimal.getExtraCharacteristics().getGeneralFields()[0].setSelected(true);
                    } else {
                        updateAnimal.getExtraCharacteristics().getGeneralFields()[0].setSelected(false);
                    }
                    break;
                case "Avian":
                    if (((CreateAvian) viewAnimals.getAnimals().get(index)).getHasFeeders() == 1) {
                        updateAnimal.getExtraCharacteristics().getGeneralFields()[0].setSelected(true);
                    } else {
                        updateAnimal.getExtraCharacteristics().getGeneralFields()[0].setSelected(false);
                    }
                    if (((CreateAvian) viewAnimals.getAnimals().get(index)).getCanFligh() == 1) {
                        updateAnimal.getExtraCharacteristics().getGeneralFields()[1].setSelected(true);
                    } else {
                        updateAnimal.getExtraCharacteristics().getGeneralFields()[1].setSelected(false);
                    }
                    break;
                case "Insect":
                    if (((CreateInsect) viewAnimals.getAnimals().get(index)).getIsVennon() == 1) {
                        updateAnimal.getExtraCharacteristics().getGeneralFields()[0].setSelected(true);
                    } else {
                        updateAnimal.getExtraCharacteristics().getGeneralFields()[0].setSelected(false);
                    }
                    break;
                case "Mammal":
                    if (((CreateMammal) viewAnimals.getAnimals().get(index)).getFurry() == 1) {
                        updateAnimal.getExtraCharacteristics().getGeneralFields()[0].setSelected(true);
                    } else {
                        updateAnimal.getExtraCharacteristics().getGeneralFields()[0].setSelected(false);
                    }
                    break;
                case "Reptile":
                    if (((CreateReptile) viewAnimals.getAnimals().get(index)).getIsVennon() == 1) {
                        updateAnimal.getExtraCharacteristics().getGeneralFields()[0].setSelected(true);
                    } else {
                        updateAnimal.getExtraCharacteristics().getGeneralFields()[0].setSelected(false);
                    }
                    break;
                default:
                    break;
            }
        } else {
            switch (types[0]) {
                case "Mammal":
                    if (((CreateMammalAquatic) viewAnimals.getAnimals().get(index)).getFurry() == 1) {
                        updateAnimal.getExtraCharacteristics().getGeneralFields()[0].setSelected(true);
                    } else {
                        updateAnimal.getExtraCharacteristics().getGeneralFields()[0].setSelected(false);
                    }
                    if (((CreateMammalAquatic) viewAnimals.getAnimals().get(index)).getCanBeOutSideWatter() == 1) {
                        updateAnimal.getExtraCharacteristics().getGeneralFields()[1].setSelected(true);
                    } else {
                        updateAnimal.getExtraCharacteristics().getGeneralFields()[1].setSelected(false);
                    }
                    break;
                case "Reptile":
                    if (((CreateReptileAquatic) viewAnimals.getAnimals().get(index)).getIsVennon() == 1) {
                        updateAnimal.getExtraCharacteristics().getGeneralFields()[0].setSelected(true);
                    } else {
                        updateAnimal.getExtraCharacteristics().getGeneralFields()[0].setSelected(false);
                    }
                    if (((CreateReptileAquatic) viewAnimals.getAnimals().get(index)).getCanBeOutSideWatter() == 1) {
                        updateAnimal.getExtraCharacteristics().getGeneralFields()[1].setSelected(true);
                    } else {
                        updateAnimal.getExtraCharacteristics().getGeneralFields()[1].setSelected(false);
                    }
                    break;
                default:
                    break;
            }

        }

    }

}

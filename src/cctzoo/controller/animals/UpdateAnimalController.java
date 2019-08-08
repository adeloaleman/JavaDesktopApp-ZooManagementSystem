/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctzoo.controller.animals;

import cctzoo.controller.TheController;
import cctzoo.model.TheModel;
import cctzoo.model.animals.Animal;
import cctzoo.model.animals.Medication;
import cctzoo.model.animals.Vacine;
import cctzoo.view.TheView;
import cctzoo.view.animals.UpdateAnimalFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author guerr
 */
public class UpdateAnimalController implements WindowListener {

    TheView view;
    UpdateAnimalFrame updateAnimal;
    ArrayList<Animal> animals;
    TheController ctrl;
    TheModel model;
    int index = 0;

    public UpdateAnimalController(TheModel model, TheView view, TheController ctrl) {
        this.model = model;
        this.view = view;
        this.ctrl = ctrl;
        this.updateAnimal = view.getUpdateAnimal();
        this.animals = this.model.getListAnimals();

    }

    public void getIndexOfAnimal(int index) {
        this.index = index;
    }

    private void goBackButtonController() {

        updateAnimal.getHeader().getGoBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (JOptionPane.showConfirmDialog(updateAnimal, "Are you sure you want to go back?", "Going back?", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {

                    updateAnimal.dispose();

                    view.getViewAnimals().setVisible(true);

                    view.getViewAnimals().getAnimalsPanel().removeAllRows();
                    ctrl.getViewAnimalsCtrl().resetAnimalDetails();

                    ctrl.getViewAnimalsCtrl().setAnimalsTable(animals);
                    ctrl.getViewAnimalsCtrl().viewAnimals.getAnimalsPanel().getViewAnimalsTable().setRowSelectionInterval(0, index);

                    ctrl.getViewAnimalsCtrl().setAnimalCard(index);
                    ctrl.getViewAnimalsCtrl().setOffspringsTable();
                }
            }

        });
    }

    private void addChild(String name, String dob, Medication med, Vacine vac, String gender) {

        int gNum = 0;
        String[] types = null;
        for (int i = 0; i < animals.get(index).getClass().getInterfaces().length; i++) {
            if (i == 0) {
                types = new String[animals.get(index).getClass().getInterfaces().length];
            }
            types[i] = animals.get(index).getClass().getInterfaces()[i].getSimpleName();
        }
        if ("Male".equals(gender)) {
            gNum = 1;
        } else {
            gNum = 0;
        }

        animals.get(index).createOffpring(name, dob, dob, gNum, med, vac);
        int lastOff = animals.get(index).getOffsprings().size();
        animals.add(animals.get(index).getOffsprings().get(lastOff - 1));

    }

    private void addChildButtonController() {
        updateAnimal.getAddOffSpringsPanel().getAddOffspringButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String name = updateAnimal.getAddOffSpringsPanel().getAddOffspringName().getTextField().getText();
                String dob = updateAnimal.getAddOffSpringsPanel().getAddOffspringDayOfBirth().dateToString();
                int medIndex = updateAnimal.getAddOffSpringsPanel().getMedication().getFieldOne().getSelectedIndex();
                int vacIndex = updateAnimal.getAddOffSpringsPanel().getVaccine().getFieldOne().getSelectedIndex();
                int gIndex = updateAnimal.getAddOffSpringsPanel().getOffSpringGender().getFieldOne().getSelectedIndex();

                if (name.equals("")) {
                    JOptionPane.showMessageDialog(updateAnimal, "Name cannot be empty!", "Something is not right!", JOptionPane.ERROR_MESSAGE);
                } else if (medIndex == -1) {
                    JOptionPane.showMessageDialog(updateAnimal, "Choose a medicine for the child!", "Something is not right!", JOptionPane.ERROR_MESSAGE);
                } else if (vacIndex == -1) {
                    JOptionPane.showMessageDialog(updateAnimal, "Choose a vaccine for the child!", "Something is not right!", JOptionPane.ERROR_MESSAGE);
                } else if (gIndex == -1) {
                    JOptionPane.showMessageDialog(updateAnimal, "Choose a gender for the child!", "Something is not right!", JOptionPane.ERROR_MESSAGE);
                } else {
                    Medication med = new Medication();
                    med.addMedication((String) updateAnimal.getAddOffSpringsPanel().getMedication().getFieldOne().getSelectedItem());
                    Vacine vac = new Vacine();
                    vac.addVacine((String) updateAnimal.getAddOffSpringsPanel().getVaccine().getFieldOne().getSelectedItem());
                    String g = (String) updateAnimal.getAddOffSpringsPanel().getOffSpringGender().getFieldOne().getSelectedItem();
                    addChild(name, dob, med, vac, g);
                    updateOffspringsTable();
                    JOptionPane.showMessageDialog(updateAnimal, "You have added a child to the animal!", "Well Done!", JOptionPane.INFORMATION_MESSAGE);

                }
            }

        });
    }

    private void updateOffspringsTable() {
        updateAnimal.getOffspringsPanel().removeAllRows();
        updateAnimal.getOffspringsPanel().dataToString(animals.get(index).getOffsprings());
        updateAnimal.getOffspringsPanel().setData();
        updateAnimal.getUpdateAnimalButton().setEnabled(true);

    }

    public void setUpdateAnimal(UpdateAnimalFrame updateAnimal) {
        this.updateAnimal = updateAnimal;
        this.updateAnimal.addWindowListener(this);
        this.goBackButtonController();
        this.addChildButtonController();
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        if (JOptionPane.showConfirmDialog(this.view.getUpdateAnimal(), "Are you sure you want to go back?", "Going back?", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {

            updateAnimal.dispose();

            view.getViewAnimals().setVisible(true);

            view.getViewAnimals().getAnimalsPanel().removeAllRows();
            ctrl.getViewAnimalsCtrl().resetAnimalDetails();

            ctrl.getViewAnimalsCtrl().setAnimalsTable(animals);
            ctrl.getViewAnimalsCtrl().viewAnimals.getAnimalsPanel().getViewAnimalsTable().setRowSelectionInterval(0, index);

            ctrl.getViewAnimalsCtrl().setAnimalCard(index);
            ctrl.getViewAnimalsCtrl().setOffspringsTable();

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

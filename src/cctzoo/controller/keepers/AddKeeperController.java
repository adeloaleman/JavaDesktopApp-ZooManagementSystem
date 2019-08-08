/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctzoo.controller.keepers;

import cctzoo.controller.TheController;
import cctzoo.model.TheModel;
import cctzoo.model.keepers.Keeper;
import cctzoo.view.TheView;
import cctzoo.view.animals.AddAnimalFrame;
import cctzoo.view.keepers.AddKeeperFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

/**
 *
 * @author guerr
 */
public class AddKeeperController implements WindowListener {

    TheModel model;
    TheView view;
    TheController ctrl;
    AddKeeperFrame addKeeper;
    int boxesClicked = 0;

    public AddKeeperController(TheModel model, TheView view, TheController ctrl) {
        this.model = model;
        this.view = view;
        this.ctrl = ctrl;
        
    }

    public void setAddKeeper(AddKeeperFrame addKeeper) {
        this.addKeeper = addKeeper;
        this.goBackButtonController();
        this.addKeeper.addWindowListener(this);
        this.addAnimalButtonController();
        this.addControllerToCheckBox();
    }

    private void goBackButtonController() {

        addKeeper.getGoBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (JOptionPane.showConfirmDialog(addKeeper, "Are you sure you want to go back?", "Going back?", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {

                    addKeeper.dispose();
                    view.getAdminDash().setVisible(true);
                    view.getAdminDash().validate();
                    view.getAdminDash().repaint();

                }
            }

        });
    }

    private void addAnimalButtonController() {

        addKeeper.getAddKeeperButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String n = addKeeper.getKeeperName().getText();
                String dob = addKeeper.dateToString();
                JCheckBox[] q = addKeeper.getQualifications();
                boolean qualificationsSelected = false;
                for (JCheckBox a : q) {
                    System.out.println(a.isSelected());
                    if (a.isSelected()) {
                        qualificationsSelected = true;

                    }
                }

                if (n.equals("")) {
                    JOptionPane.showMessageDialog(addKeeper, "Name cannot be empty!", "Something is not right!", JOptionPane.ERROR_MESSAGE);
                } else if (dob.equals("")) {
                    JOptionPane.showMessageDialog(addKeeper, "Day of Birth cannot be empty!", "Something is not right!", JOptionPane.ERROR_MESSAGE);
                } else if (!qualificationsSelected) {
                    JOptionPane.showMessageDialog(addKeeper, "At least one Qualification has to be seleted!", "Something is not right!", JOptionPane.ERROR_MESSAGE);
                } else {
                    addKeeper(n, dob, q);
                    JOptionPane.showMessageDialog(addKeeper, "Your keeper" + n + " has been added!", "Enhorabuena!", JOptionPane.INFORMATION_MESSAGE);
                }

            }

        });
    }

    private void addKeeper(String name, String dayOfBirth, JCheckBox[] qualifications) {
        Keeper newKeeper = new Keeper(name, dayOfBirth);
        for (int i = 0; i < 5; i++) {
            switch (i) {
                case 0:
                    if (qualifications[0].isSelected()) {
                        newKeeper.addQualification("Mammal");
                    }
                case 1:
                    if (qualifications[1].isSelected()) {
                        newKeeper.addQualification("Reptile");
                    }
                case 2:
                    if (qualifications[2].isSelected()) {
                        newKeeper.addQualification("Avian");
                    }
                case 3:
                    if (qualifications[3].isSelected()) {
                        newKeeper.addQualification("Aquatic");
                    }
                case 4:
                    if (qualifications[4].isSelected()) {
                        newKeeper.addQualification("Insect");
                    }
            }

        }
        model.getListKeepers().add(newKeeper);
        resetValues();
    }

    private void resetValues() {
        addKeeper.getKeeperName().setText("");
        addKeeper.setDate("05/05/2018");
        JCheckBox[] qualifications = addKeeper.getQualifications();
        for (JCheckBox q : qualifications) {
            q.setSelected(false);
        }
    }

    private void addControllerToCheckBox() {

        for (int i = 0; i < addKeeper.getQualifications().length; i++) {
            addKeeper.getQualifications()[i].addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    System.out.println(boxesClicked);
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        for (int i = 0; i < addKeeper.getQualifications().length; i++) {

                            boxesClicked++;

                        }

                    } else {
                        for (int i = 0; i < addKeeper.getQualifications().length; i++) {

                            boxesClicked--;

                        }
                    }
                    if (boxesClicked >= 15) {
                        for (int i = 0; i < addKeeper.getQualifications().length; i++) {

                            if (!addKeeper.getQualifications()[i].isSelected()) {
                                addKeeper.getQualifications()[i].setEnabled(false);
                            }

                        }
                    } else {
                        for (int i = 0; i < addKeeper.getQualifications().length; i++) {

                            if (!addKeeper.getQualifications()[i].isSelected()) {
                                addKeeper.getQualifications()[i].setEnabled(true);
                            }

                        }
                    }
                }
            });
        }

    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        if (JOptionPane.showConfirmDialog(addKeeper, "Are you sure you want to go back?", "Going back?", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {

            addKeeper.dispose();
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

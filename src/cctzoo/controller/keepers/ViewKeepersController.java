/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctzoo.controller.keepers;

import cctzoo.controller.TheController;
import cctzoo.controller.animals.ViewAnimalsController;
import cctzoo.model.Search;
import cctzoo.model.TheModel;
import cctzoo.model.animals.Animal;
import cctzoo.model.animals.CreateAquatic;
import cctzoo.model.animals.CreateAvian;
import cctzoo.model.animals.CreateInsect;
import cctzoo.model.animals.CreateMammal;
import cctzoo.model.animals.CreateMammalAquatic;
import cctzoo.model.animals.CreateReptile;
import cctzoo.model.animals.CreateReptileAquatic;
import cctzoo.model.keepers.Keeper;
import cctzoo.view.TheView;
import cctzoo.view.animals.UpdateAnimalFrame;
import cctzoo.view.keepers.UpdateKeeperFrame;
import cctzoo.view.keepers.ViewKeepersFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author guerr
 */
public class ViewKeepersController implements WindowListener {

    TheModel model;
    TheView view;
    TheController ctrl;
    ViewKeepersFrame viewKeepers;
    UpdateKeeperFrame updateKeeper;
    boolean flag = false;
    Search searchEngine;
    int index = 0;

    public ViewKeepersController(TheModel model, TheView view, TheController ctrl) {
        this.model = model;
        this.view = view;
        this.ctrl = ctrl;
        
        searchEngine = new Search();
    }

    public ViewKeepersFrame getViewKeepers() {
        return viewKeepers;
    }

    public void setViewKeepers(ViewKeepersFrame viewKeepers) {
        this.viewKeepers = viewKeepers;
        this.addControllerToCheckBox();
        this.goBackButtonController();
        this.viewKeepers.addWindowListener(this);
        this.addControllerToKeepersTable();
        this.refineButtonController();
        this.updateButtonController();
        this.viewKeepers.getAnimalsPanel().setVisible(false);

        this.viewKeepers.getKeeperView().setVisible(false);
    }

    private void addControllerToCheckBox() {

        for (int i = 0; i < viewKeepers.getRefinePanel().getCheckBoxFields().getGeneralFields().length; i++) {
            viewKeepers.getRefinePanel().getCheckBoxFields().getGeneralFields()[i].addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        for (int i = 0; i < viewKeepers.getRefinePanel().getCheckBoxFields().getGeneralFields().length; i++) {
                            if (viewKeepers.getRefinePanel().getCheckBoxFields().getGeneralFields()[i].isSelected()) {
                                viewKeepers.getRefinePanel().getCheckBoxFields().disableFields(i);

                                break;
                            }
                        }

                        viewKeepers.getRefinePanel().getRefineByTextField().enablePanelAndTextField();
                        addControllerToTextField();

                    } else {
                        viewKeepers.getRefinePanel().getCheckBoxFields().enableFields();
                        viewKeepers.getRefinePanel().getRefineByTextField().disablePanelAndTextField();
                        viewKeepers.getRefinePanel().getRefineByButton().disableGenericButton();
                    };
                }
            });
        }

    }

    private void addControllerToTextField() {

        viewKeepers.getRefinePanel().getRefineByTextField().getTextField().getDocument().addDocumentListener(new ViewKeepersController.JButtonStateController(viewKeepers.getRefinePanel().getRefineByButton()));

        if (viewKeepers.getRefinePanel().getRefineByTextField().getTextField().getText().equals("")) {
            viewKeepers.getRefinePanel().getRefineByButton().setEnabled(false);
        } else {
            viewKeepers.getRefinePanel().getRefineByButton().setEnabled(true);
        }

    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        if (JOptionPane.showConfirmDialog(viewKeepers, "Are you sure you want to go back?", "Going back?", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {

            viewKeepers.dispose();
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

    private void goBackButtonController() {

        viewKeepers.getHeader().getGoBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (JOptionPane.showConfirmDialog(viewKeepers, "Are you sure you want to go back?", "Going back?", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {

                    viewKeepers.dispose();
                    view.getAdminDash().setVisible(true);
                    view.getAdminDash().validate();
                    view.getAdminDash().repaint();

                }
            }

        });
    }

    private void addControllerToKeepersTable() {
        this.viewKeepers.getKeepersPanel().getViewKeepersTable().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                if (event.getValueIsAdjusting()) {
                    if (viewKeepers.getKeepersPanel().getViewKeepersTable().getSelectedRow() > -1) {

                        resetAnimalDetails();

                        // Row clicked
                        int row = viewKeepers.getKeepersPanel().getViewKeepersTable().getSelectedRow();
                        // Exhibit Number
                        int en = Integer.parseInt((String) viewKeepers.getKeepersPanel().getViewKeepersTable().getValueAt(row, 0));
                        setKeeperCard(en);
                        index = en;
                        // Initializing the offsprings table with all the data
                        setAnimalsTable();

                    } else {
                        viewKeepers.getViewKeepersOnFrame().getImageLabel().setVisible(true);
                    }
                }
            }
        });
    }

    protected void setAnimalsTable() {
        viewKeepers.getAnimalsPanel().setVisible(true);
        viewKeepers.getAnimalsPanel().dataToString(viewKeepers.getKeepers().get(index).getkeeperAnimals());
        viewKeepers.getAnimalsPanel().setData();
        viewKeepers.getUpdateKeeperButton().setEnabled(true);

    }

    protected void resetAnimalDetails() {
        if (flag == true) {

            viewKeepers.getKeeperView().removeAll();
            viewKeepers.getKeeperView().updateUI();
            viewKeepers.getAnimalsPanel().removeAllRows();

        }
        flag = true;
    }

    protected void setKeeperCard(int en) {
        viewKeepers.getViewKeepersOnFrame().getImageLabel().setVisible(false);
        viewKeepers.getKeeperView().setVisible(true);
        // PPSN Number
        viewKeepers.getKeeperView().setPPSN(Integer.toString(en));
        // Name
        String name = viewKeepers.getKeepers().get(en).getName();
        viewKeepers.getKeeperView().setKeeperName(name);
        // Day of birth
        String birth = viewKeepers.getKeepers().get(en).getDateOfBirth();
        viewKeepers.getKeeperView().setDayOfBirth(birth);
        // Number of Animals
        int no = viewKeepers.getKeepers().get(en).getkeeperAnimals().size();
        viewKeepers.getKeeperView().setOffprings(Integer.toString(no));
        // Qualifications
        String[] qualifications = null;
        for (int i = 0; i < viewKeepers.getKeepers().get(en).getQualification().size(); i++) {
            if (i == 0) {
                qualifications = new String[viewKeepers.getKeepers().get(en).getQualification().size()];
            }
            qualifications[i] = viewKeepers.getKeepers().get(en).getQualification().get(i);
        }
        viewKeepers.getKeeperView().setQualifications(qualifications);
    }

    private void refineButtonController() {
        viewKeepers.getRefinePanel().getRefineByButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewKeepers.getKeeperView().setVisible(false);
                viewKeepers.getAnimalsPanel().setVisible(false);
                viewKeepers.getViewKeepersOnFrame().getImageLabel().setVisible(true);

                viewKeepers.invalidate();
                viewKeepers.validate();
                viewKeepers.repaint();
                refineEngine();

            }

        });
    }

    private void refineEngine() {

        viewKeepers.getKeepersPanel().removeAllRows();
        resetAnimalDetails();
        viewKeepers.getUpdateKeeperButton().setEnabled(false);
        String str = viewKeepers.getRefinePanel().getRefineByTextField().getTextField().getText();
        ArrayList<Keeper> list = null;

        if (viewKeepers.getRefinePanel().getCheckBoxFields().getGeneralFields()[0].isSelected()) {
            list = searchEngine.searchKeeperByNames(viewKeepers.getKeepers(), "(?i:.*" + str + ".*)");
            
            setKeepersTable(list);
        } else if (viewKeepers.getRefinePanel().getCheckBoxFields().getGeneralFields()[1].isSelected()) {
            list = searchEngine.searchKeeperByQualifications(viewKeepers.getKeepers(), "(?i:.*" + str + ".*)");
            
            setKeepersTable(list);
        }

    }

    protected void setKeepersTable(ArrayList<Keeper> list) {
        viewKeepers.getKeepersPanel().dataToString(list);
        viewKeepers.getKeepersPanel().setData();
    }
    
    private void updateButtonController() {
        viewKeepers.getUpdateKeeperButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                viewKeepers.dispose();
                
                updateKeeper = new UpdateKeeperFrame("Admin - Update Zoo Keeper", 975, 640, "images/animal.png");
                
                updateKeeper.getKeeperName().setText(model.getListKeepers().get(index).getName());
                updateKeeper.setDate(model.getListKeepers().get(index).getDateOfBirth());
                
                for (int i = 0; i < model.getListKeepers().get(index).getQualification().size(); i++) {
                    switch (model.getListKeepers().get(index).getQualification().get(i)) {
                        case "Mammal":
                            updateKeeper.getQualifications()[0].setSelected(true);
                            updateKeeper.getQualifications()[0].setEnabled(false);
                        case "Reptile":
                            updateKeeper.getQualifications()[1].setSelected(true);
                            updateKeeper.getQualifications()[1].setEnabled(false);
                        case "Avian":
                            updateKeeper.getQualifications()[2].setSelected(true);
                            updateKeeper.getQualifications()[2].setEnabled(false);
                        case "Aquatic":
                            updateKeeper.getQualifications()[3].setSelected(true);
                            updateKeeper.getQualifications()[3].setEnabled(false);
                        case "Insect":
                            updateKeeper.getQualifications()[4].setSelected(true);
                            updateKeeper.getQualifications()[4].setEnabled(false);
                    }
                }
                
                updateKeeper.getKeepersAnimalsPanel().dataToString(model.getListKeepers().get(index).getkeeperAnimals());
                updateKeeper.getKeepersAnimalsPanel().setData();
                
                updateKeeper.getAnimalsPanel().dataToString(searchEngine.searchAnimalByKeeper(model.getListAnimals(), model.getListKeepers().get(index).getQualification()));
                updateKeeper.getAnimalsPanel().setData();
                
                ctrl.getUpdateKeeperCtrl().setUpdateKeeper(updateKeeper);
                view.setUpdateKeeper(updateKeeper);
                
                updateKeeper.setVisible(true);
                updateKeeper.validate();
                updateKeeper.repaint();
                
                
            }

        });
    }

}

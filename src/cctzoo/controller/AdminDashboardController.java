/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctzoo.controller;

import cctzoo.controller.TheController;
import cctzoo.model.TheModel;
import cctzoo.view.AdminDashboard;
import cctzoo.view.TheView;
import cctzoo.view.animals.AddAnimalFrame;
import cctzoo.view.animals.ViewAnimalsFrame;
import cctzoo.view.keepers.AddKeeperFrame;
import cctzoo.view.keepers.ViewKeepersFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JOptionPane;

/**
 *
 * @author guerr
 */
public class AdminDashboardController implements WindowListener {

    TheController ctrl;
    TheView view;
    TheModel model;
    AdminDashboard adminDash;
    ViewAnimalsFrame viewAnimals;
    AddAnimalFrame addAnimal;
    AddKeeperFrame addKeeper;
    ViewKeepersFrame viewKeepers;

    public AdminDashboardController(TheModel model, TheView view, TheController ctrl) {

        this.model = model;
        this.view = view;
        this.ctrl = ctrl;
        this.adminDash = view.getAdminDash();

        this.adminDash.addWindowListener(this);
        this.goBackButtonController();
        
        this.viewAnimalsButtonController();
        
        this.addAnimalsButtonController();
        
        this.addKeepersButtonController();
        
        this.viewKeepersButtonController();

    }

    private void goBackButtonController() {

        adminDash.getLogoutButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (JOptionPane.showConfirmDialog(adminDash, "Are you sure you want to go logout?", "Logging out?", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {

                    adminDash.dispose();
                    model.serialization();

                }
            }

        });
    }
    
    private void viewAnimalsButtonController() {

        adminDash.getViewAnimalButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewAnimals = new ViewAnimalsFrame(adminDash.getView().getAnimals(), "Admin - View Animals", 975, 600, "src/cctzoo/view/images/animal.png");
                
                ctrl.getViewAnimalsCtrl().setViewAnimals(viewAnimals);
                view.setViewAnimals(viewAnimals);
                
                adminDash.dispose();
                
                viewAnimals.setVisible(true);
                viewAnimals.validate();
                viewAnimals.repaint();
            }

        });
    }

    private void addAnimalsButtonController() {

        adminDash.getAddAnimalButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addAnimal = new AddAnimalFrame("Admin - Add Animal", 760, 350, "src/cctzoo/view/images/animal.png");
                
                ctrl.getAddAnimalCtrl().setAddAnimal(addAnimal);
                view.setAddAnimal(addAnimal);
                
                adminDash.dispose();
                
                addAnimal.setVisible(true);
                addAnimal.validate();
                addAnimal.repaint();
            }

        });
    }
    
    private void addKeepersButtonController() {

        adminDash.getAddKeeperButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addKeeper = new AddKeeperFrame("Admin - Add Zoo Keeper", 460, 265, "src/cctzoo/view/images/animal.png");
                
                ctrl.getAddKeeperCtrl().setAddKeeper(addKeeper);
                view.setAddKeeper(addKeeper);
                
                adminDash.dispose();
                
                addKeeper.setVisible(true);
                addKeeper.validate();
                addKeeper.repaint();
                
            }

        });
    }
    
    private void viewKeepersButtonController() {

        adminDash.getViewKeeperButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewKeepers = new ViewKeepersFrame(view.getKeepers(), "Admin - View Keeper", 730, 460, "src/cctzoo/view/images/animal.png");
                
                ctrl.getViewKeepersCtrl().setViewKeepers(viewKeepers);
                view.setViewKeepers(viewKeepers);
                
                adminDash.dispose();
                
                viewKeepers.setVisible(true);
                viewKeepers.validate();
                viewKeepers.repaint();
            }

        });
    }
    
    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        if (JOptionPane.showConfirmDialog(adminDash, "Are you sure you want to go logout?", "Logging out?", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {

            
            adminDash.dispose();
            

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

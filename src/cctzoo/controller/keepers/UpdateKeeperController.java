/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctzoo.controller.keepers;

import cctzoo.controller.TheController;
import cctzoo.model.TheModel;
import cctzoo.view.TheView;
import cctzoo.view.keepers.UpdateKeeperFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JOptionPane;

/**
 *
 * @author guerr
 */
public class UpdateKeeperController implements WindowListener {

    TheModel model;
    TheView view;
    TheController ctrl;
    UpdateKeeperFrame updateKeeper;
    int boxesClicked = 0;

    public UpdateKeeperController(TheModel model, TheView view, TheController ctrl) {
        this.model = model;
        this.view = view;
        this.ctrl = ctrl;

    }

    public void setUpdateKeeper(UpdateKeeperFrame updateKeeper) {
        this.updateKeeper = updateKeeper;
        this.goBackButtonController();
        this.updateKeeper.addWindowListener(this);
        this.addControllerToCheckBox();
    }

    private void addControllerToCheckBox() {

        for (int i = 0; i < updateKeeper.getQualifications().length; i++) {
            updateKeeper.getQualifications()[i].addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    System.out.println(boxesClicked);
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        for (int i = 0; i < updateKeeper.getQualifications().length; i++) {

                            boxesClicked++;

                        }

                    } else {
                        for (int i = 0; i < updateKeeper.getQualifications().length; i++) {

                            boxesClicked--;

                        }
                    }
                    if (boxesClicked >= 15) {
                        for (int i = 0; i < updateKeeper.getQualifications().length; i++) {

                            if (!updateKeeper.getQualifications()[i].isSelected()) {
                                updateKeeper.getQualifications()[i].setEnabled(false);
                            }

                        }
                    } else {
                        for (int i = 0; i < updateKeeper.getQualifications().length; i++) {

                            if (!updateKeeper.getQualifications()[i].isSelected()) {
                                updateKeeper.getQualifications()[i].setEnabled(true);
                            }

                        }
                    }
                }
            });
        }
    }

    

    private void goBackButtonController() {

        updateKeeper.getGoBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (JOptionPane.showConfirmDialog(updateKeeper, "Are you sure you want to go back?", "Did you update?", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {

                    updateKeeper.dispose();
                    view.getViewKeepers().setVisible(true);
                    view.getViewKeepers().validate();
                    view.getViewKeepers().repaint();

                }
            }

        });
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        if (JOptionPane.showConfirmDialog(updateKeeper, "Are you sure you want to go back?", "Did you update?", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {

            updateKeeper.dispose();
            view.getViewKeepers().setVisible(true);
            view.getViewKeepers().validate();
            view.getViewKeepers().repaint();

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

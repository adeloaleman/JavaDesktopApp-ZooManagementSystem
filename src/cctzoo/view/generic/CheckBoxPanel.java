/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctzoo.view.generic;

import java.awt.Font;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

/**
 *
 * @author guerr
 */
public class CheckBoxPanel extends JPanel {
    
    private JCheckBox[] generalFields;
    
    public CheckBoxPanel(int xLocation, int yLocation, int width, int height, String title, String toolTipText) {
        
        this.setCheckBoxFiedsPanel(xLocation, yLocation, width, height, title, toolTipText);
        
    }
    
    private void setCheckBoxFiedsPanel(int xLocation, int yLocation, int width, int height, String title, String toolTipText) {
        this.setLayout(null);
        this.setBorder(BorderFactory.createTitledBorder(null, title, 0, 0, new Font("PLAIN", Font.BOLD, MainFrame.xCoordinate(12))));
        this.setBounds(MainFrame.xCoordinate(xLocation), MainFrame.yCoordinate(yLocation), MainFrame.xCoordinate(width), MainFrame.yCoordinate(height));
        this.setToolTipText(toolTipText);
        
    }
    
    public void setAmountOfFields(int amountOfFields) {
        this.generalFields = new JCheckBox[amountOfFields];
    }
    
    public void setFieldsCheckBoxes(ArrayList<String> fields) {
        for (int i = 0; i < generalFields.length; i++) {
            this.generalFields[i] = new JCheckBox(fields.get(i));
            this.generalFields[i].setBounds(MainFrame.xCoordinate(10), MainFrame.yCoordinate(15+20*i), MainFrame.xCoordinate(110), MainFrame.yCoordinate(20));
            this.generalFields[i].setFont(new Font("PLAIN", Font.BOLD, MainFrame.xCoordinate(12)));
            this.add(this.generalFields[i]);
        }
    }

    public JCheckBox[] getGeneralFields() {
        return generalFields;
    }
    
    public void disableFields(int index) {
        for (int i = 0; i < this.generalFields.length; i++) {
            if (i != index) {
                this.generalFields[i].setEnabled(false);
            }
        }
    }
    
    public void enableFields() {
        
        for (int i = 0; i < this.generalFields.length; i++) {
            this.generalFields[i].setEnabled(true);
        }
        
    }
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctzoo.view.animals;

import cctzoo.view.generic.CalendarPanel;
import cctzoo.view.generic.ComboBoxFieldsPanel;
import cctzoo.view.generic.GenericButton;
import cctzoo.view.generic.MainFrame;
import cctzoo.view.generic.TextFieldPanel;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 *
 * @author guerr
 */
public class AddOffspringsPanel extends JPanel {

    private TextFieldPanel addOffspringName;
    private ComboBoxFieldsPanel offSpringGender;
    private CalendarPanel addOffspringDayOfBirth;
    private ComboBoxFieldsPanel medication;
    private ComboBoxFieldsPanel vaccine;
    private GenericButton addOffspringButton;

    public AddOffspringsPanel(int xLocation, int yLocation, String title, String toolTipText, ArrayList<String> medicines, ArrayList<String> vaccines) {
        
        this.setAddOffspringsPanel(xLocation, yLocation, title, toolTipText);
        
        this.addOffspringName = new TextFieldPanel(10, 15, 190, 60, "Name ");
        this.add(this.addOffspringName);
        this.addOffspringName.setEnabled(true);
        this.addOffspringName.getTextField().setEnabled(true);
        
        ArrayList<String> genders = new ArrayList<String>();
        genders.add("male");
        genders.add("female");
        this.offSpringGender = new ComboBoxFieldsPanel(genders, "Gender", 10, 75, 60);
        this.add(this.offSpringGender);
        this.offSpringGender.setEnabled(true);
        this.offSpringGender.setEnabled(true);
        this.offSpringGender.getFieldOne().setEnabled(true);
        
        this.addOffspringDayOfBirth = new CalendarPanel(210, 15, "Date Of Birth ", "Set day of birth of Animal");
        this.add(this.addOffspringDayOfBirth);
        this.addOffspringDayOfBirth.setEnabled(true);
        this.addOffspringDayOfBirth.getDatePicker().getComponent(0).setEnabled(true);
        this.addOffspringDayOfBirth.getDatePicker().getComponent(1).setEnabled(true);
        
        this.medication = new ComboBoxFieldsPanel(medicines, "Medication", 150, 75, 60);
        this.add(this.medication);
        this.medication.setEnabled(true);
        this.medication.getFieldOne().setEnabled(true);
        
        this.vaccine = new ComboBoxFieldsPanel(vaccines, "Vaccine", 285, 75, 60);
        this.add(this.vaccine);
        this.vaccine.setEnabled(true);
        this.vaccine.getFieldOne().setEnabled(true);
        
        this.addOffspringButton = new GenericButton(25, 150, 100, "src/cctzoo/view/images/cat.png", "Add Child", "Add Offspring to Animal");
        this.add(this.addOffspringButton);
        this.addOffspringButton.setEnabled(true);
        
    }

    private void setAddOffspringsPanel(int xLocation, int yLocation, String title, String toolTipText) {
        
        this.setLayout(null);
        this.setBorder(BorderFactory.createTitledBorder(null, title, 0, 0, new Font("PLAIN", Font.BOLD, MainFrame.xCoordinate(12))));
        this.setBounds(MainFrame.xCoordinate(xLocation), MainFrame.yCoordinate(yLocation), MainFrame.xCoordinate(425), MainFrame.yCoordinate(205));
        this.setToolTipText(toolTipText);
        this.setEnabled(false);
    }

    public TextFieldPanel getAddOffspringName() {
        return addOffspringName;
    }

    public CalendarPanel getAddOffspringDayOfBirth() {
        return addOffspringDayOfBirth;
    }

    public ComboBoxFieldsPanel getMedication() {
        return medication;
    }

    public ComboBoxFieldsPanel getVaccine() {
        return vaccine;
    }

    public GenericButton getAddOffspringButton() {
        return addOffspringButton;
    }

    public ComboBoxFieldsPanel getOffSpringGender() {
        return offSpringGender;
    }
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctzoo.view.generic;

import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

/**
 *
 * @author guerr
 */
public class ComboBoxFieldsPanel extends JPanel {
    
    private JComboBox fieldOne;
    private JComboBox fieldTwo;
    private JComboBox fieldThree;
    private ArrayList<String> fields;

    public ComboBoxFieldsPanel(ArrayList<String> fields, String title, int xLocation, int yLocation) {
        this.fields = fields;
        
        this.setFieldsPanel(title, xLocation, yLocation);
        
        this.setFirstFieldComboBox(title);
        this.setSecondFieldComboBox(title);
        this.setThirdFieldComboBox(title);
           
    }
    
    public ComboBoxFieldsPanel(ArrayList<String> fields, String title, int xLocation, int yLocation, int height) {
        this.fields = fields;
        
        this.setFieldsPanel(title, xLocation, yLocation, height);
        
        this.setFirstFieldComboBox(title);
           
    }
    
    private void setFieldsPanel(String title, int xCoordinate, int yCoordinate) {
        
        this.setLayout(null);
        this.setBorder(BorderFactory.createTitledBorder(null, title, 0, 0, new Font("PLAIN", Font.BOLD, MainFrame.xCoordinate(12))));
        this.setBounds(MainFrame.xCoordinate(xCoordinate), MainFrame.yCoordinate(yCoordinate), MainFrame.xCoordinate(130), MainFrame.yCoordinate(120));
        this.setToolTipText("Select " + title + " for Animal");
        this.setEnabled(true);
    }
    
    private void setFieldsPanel(String title, int xCoordinate, int yCoordinate, int height) {
        
        this.setLayout(null);
        this.setBorder(BorderFactory.createTitledBorder(null, title, 0, 0, new Font("PLAIN", Font.BOLD, MainFrame.xCoordinate(12))));
        this.setBounds(MainFrame.xCoordinate(xCoordinate), MainFrame.yCoordinate(yCoordinate), MainFrame.xCoordinate(130), MainFrame.yCoordinate(height));
        this.setToolTipText("Select " + title + " for Animal");
        
    }
    
    private void setFirstFieldComboBox(String title) {
        this.fieldOne = new JComboBox();
        for (String item : this.fields) {
            this.fieldOne.addItem(item);
        }
        this.fieldOne.setFont(new Font("BOLD", Font.BOLD, MainFrame.xCoordinate(12)));
        this.fieldOne.setBounds(MainFrame.xCoordinate(10), MainFrame.yCoordinate(20), MainFrame.xCoordinate(110), MainFrame.yCoordinate(30));
        this.fieldOne.setRenderer(new MyComboBoxRenderer(title));
        this.fieldOne.setSelectedIndex(-1);
        
        
        this.add(this.fieldOne);
    }
    
    private void setSecondFieldComboBox(String title) {
        this.fieldTwo = new JComboBox();
        for (String item : this.fields) {
            this.fieldTwo.addItem(item);
        }
        this.fieldTwo.setFont(new Font("BOLD", Font.BOLD, MainFrame.xCoordinate(12)));        
        this.fieldTwo.setBounds(MainFrame.xCoordinate(10), MainFrame.yCoordinate(50), MainFrame.xCoordinate(110), MainFrame.yCoordinate(30));
        this.fieldTwo.setRenderer(new MyComboBoxRenderer(title));
        this.fieldTwo.setSelectedIndex(-1);
        
        
        this.add(this.fieldTwo);
    }
    
    private void setThirdFieldComboBox(String title) {
        this.fieldThree = new JComboBox();
        for (String item : this.fields) {
            this.fieldThree.addItem(item);
        }
        this.fieldThree.setFont(new Font("BOLD", Font.BOLD, MainFrame.xCoordinate(12)));
        this.fieldThree.setBounds(MainFrame.xCoordinate(10), MainFrame.yCoordinate(80), MainFrame.xCoordinate(110), MainFrame.yCoordinate(30));
        this.fieldThree.setRenderer(new MyComboBoxRenderer(title));
        this.fieldThree.setSelectedIndex(-1);
        
        this.add(this.fieldThree);
    }
    
    public void addFieldsToFieldOne(ArrayList<String> fields) {
        fieldOne.removeAllItems();
        //fieldOne.updateUI();
        for (String item : fields) {
            this.fieldOne.addItem(item);
        }
        this.fieldOne.setSelectedIndex(-1);
    }
    
    public void addFieldsToFieldTwo() {
        for (String item : this.fields) {
            this.fieldTwo.addItem(item);
        }
        this.fieldTwo.setSelectedIndex(-1);
    }
    
    public void addFieldsToFieldThree() {
        for (String item : this.fields) {
            this.fieldThree.addItem(item);
        }
        this.fieldThree.setSelectedIndex(-1);
    }

    public JComboBox getFieldOne() {
        return fieldOne;
    }

    public JComboBox getFieldTwo() {
        return fieldTwo;
    }

    public JComboBox getFieldThree() {
        return fieldThree;
    }

    class MyComboBoxRenderer extends JLabel implements ListCellRenderer {
        private String title;

        public MyComboBoxRenderer(String title)
        {
            this.title = title;
        }

        @Override
        public Component getListCellRendererComponent(JList list, Object value,
                int index, boolean isSelected, boolean hasFocus)
        {
            if (index == -1 && value == null) setText(this.title);
            else setText(value.toString());
            return this;
        }
    }
    
    
}

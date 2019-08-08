/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctzoo.view.generic;

import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author guerr
 */
public class GenericButton extends JButton {
    
    public GenericButton(int xLocation, int yLocation, int width, String imageLocation, String title, String toolTipText) {
        
        this.setGenericButton(xLocation, yLocation, width, imageLocation, title, toolTipText);
        
    }
    
    private void setGenericButton(int xLocation, int yLocation, int width, String imageLocation, String title, String toolTipText) {
        ImageIcon searchAnimalIcon = new ImageIcon(imageLocation);
        Image imgSearchAnimal = searchAnimalIcon.getImage();
        Image newImgSearchAnimal = imgSearchAnimal.getScaledInstance(MainFrame.xCoordinate(24), MainFrame.yCoordinate(24), Image.SCALE_SMOOTH);
        ImageIcon newSearchAnimalIcon = new ImageIcon(newImgSearchAnimal);
        
        this.setText(title);
        this.setIcon(newSearchAnimalIcon);
        this.setFont(new Font("BOLD", Font.BOLD, MainFrame.xCoordinate(12)));
        this.setToolTipText(toolTipText);
        this.setMargin(new Insets(0,0,0,0));
        this.setBounds(MainFrame.xCoordinate(xLocation), MainFrame.yCoordinate(yLocation), MainFrame.xCoordinate(width), MainFrame.yCoordinate(30));
        this.setEnabled(false);
    }
    
    public void disableGenericButton() {
        this.setEnabled(false);
    }
    
    public void enableGenericButton() {
        this.setEnabled(true);
    }
    
}

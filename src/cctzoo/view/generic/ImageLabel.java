/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctzoo.view.generic;

import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author guerr
 */
public class ImageLabel {

    private JLabel imageLabel;
    
    public ImageLabel(int xLocation, int yLocation, int width, int height, String imageLocation) {
        
        this.setImageLabel(xLocation, yLocation, width, height, imageLocation);
        
    }
    
    private void setImageLabel(int xLocation, int yLocation, int width, int height, String imageLocation) {
        this.imageLabel = new JLabel();
        ImageIcon imgL = new ImageIcon(imageLocation);
        Image img = imgL.getImage();
        Image newImg = img.getScaledInstance(MainFrame.xCoordinate(width), MainFrame.yCoordinate(height), Image.SCALE_SMOOTH);
        ImageIcon newIcon = new ImageIcon(newImg);
        this.imageLabel.setIcon(newIcon);
        this.imageLabel.setPreferredSize(new Dimension(MainFrame.xCoordinate(width), MainFrame.yCoordinate(height)));
        this.imageLabel.setBounds(MainFrame.xCoordinate(xLocation), MainFrame.yCoordinate(yLocation), MainFrame.xCoordinate(width), MainFrame.yCoordinate(height));
    }

    public JLabel getImageLabel() {
        return imageLabel;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctzoo.view.generic;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author guerr
 */
public class Header extends JPanel {
    
    private JLabel titleLabel;
    private JLabel imageLabel;
    private GenericButton goBackButton;
    
    public Header(int width, int titleLength, String title, String imageLocation, String buttonImageLocation, String toolTipText) {
        
        this.setUpdateHeaderPanel(width);
        this.setTitleLabel(titleLength, title);
        this.setImagePanel(imageLocation);
        this.goBackButton = new GenericButton(width-90, 15, 70, buttonImageLocation, "Back", toolTipText);
        this.add(this.goBackButton);
        this.goBackButton.setEnabled(true);
        
    }
    
    private void setUpdateHeaderPanel(int width) {
        this.setLayout(null);
        this.setBackground(Color.LIGHT_GRAY);
        this.setBounds(MainFrame.xCoordinate(0), MainFrame.yCoordinate(0), MainFrame.xCoordinate(width), MainFrame.yCoordinate(60));
    }

    private void setTitleLabel(int length, String title) {
        this.titleLabel = new JLabel(title);
        this.titleLabel.setFont(new Font("Jazz LET", Font.PLAIN, MainFrame.xCoordinate(18)));
        this.titleLabel.setBounds(MainFrame.xCoordinate(60), MainFrame.yCoordinate(15), MainFrame.xCoordinate(length), MainFrame.yCoordinate(30));
        
        this.add(this.titleLabel);
    }

    private void setImagePanel(String imageLocation) {
        this.imageLabel = new JLabel();
        ImageIcon imgL = new ImageIcon(imageLocation);
        Image img = imgL.getImage();
        Image newImg = img.getScaledInstance(MainFrame.xCoordinate(40), MainFrame.yCoordinate(40), Image.SCALE_SMOOTH);
        ImageIcon newIcon = new ImageIcon(newImg);
        this.imageLabel.setIcon(newIcon);
        this.imageLabel.setPreferredSize(new Dimension(MainFrame.xCoordinate(40), MainFrame.yCoordinate(40)));
        this.imageLabel.setBounds(MainFrame.xCoordinate(10), MainFrame.yCoordinate(10), MainFrame.xCoordinate(40), MainFrame.yCoordinate(40));
        
        this.add(this.imageLabel);
    }

    public GenericButton getGoBackButton() {
        return goBackButton;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctzoo.view.keepers;

import cctzoo.view.generic.MainFrame;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author guerr
 */
public class ViewKeeperCard extends JPanel {

    private JLabel q;
    private int initialY;
    private JTextField[] qualifications;
    private JLabel n;
    private JTextField name;
    private JLabel dob;
    private JTextField dayOfBirth;
    private JLabel a;
    private JTextField animals;
    private JLabel ppsn;
    private JTextField ppsNumber;
    
    public ViewKeeperCard(int x, int y, int deltaX, int deltaY, String title, String toolTipText) {

        this.setAnimalDetailsPanel(x, y, deltaX, deltaY, title, toolTipText);

        this.initialY = 15;

    }

    private void setAnimalDetailsPanel(int x, int y, int deltaX, int deltaY, String title, String toolTipText) {
        this.setLayout(null);
        this.setBorder(BorderFactory.createTitledBorder(null, title, 0, 0, new Font("PLAIN", Font.BOLD, MainFrame.xCoordinate(12))));
        this.setBounds(MainFrame.xCoordinate(x), MainFrame.yCoordinate(y), MainFrame.xCoordinate(deltaX), MainFrame.yCoordinate(deltaY));
        this.setToolTipText(toolTipText);
    }

    public void setQualifications(String[] qualifications) {
        this.q = new JLabel("Qualifications: ");
        this.q.setFont(new Font("PLAIN", Font.BOLD, MainFrame.xCoordinate(12)));
        this.q.setBounds(MainFrame.xCoordinate(30), MainFrame.yCoordinate(this.initialY), MainFrame.xCoordinate(120), MainFrame.yCoordinate(20));
        this.add(this.q);

        this.qualifications = new JTextField[qualifications.length];

        for (int i = 0; i < qualifications.length; i++) {
            this.qualifications[i] = new JTextField(20);
            this.qualifications[i].setText(qualifications[i]);
            this.qualifications[i].setHorizontalAlignment(SwingConstants.LEFT);
            this.qualifications[i].setBorder(null);
            this.qualifications[i].setEditable(false);
            this.qualifications[i].setFont(new Font("PLAIN", Font.ITALIC, MainFrame.xCoordinate(12)));
            this.qualifications[i].setBounds(MainFrame.xCoordinate(130), MainFrame.yCoordinate(this.initialY), MainFrame.xCoordinate(80), MainFrame.yCoordinate(20));
            this.add(this.qualifications[i]);

            this.initialY = this.initialY + 15;
        }

        this.initialY = this.initialY + 5;

    }

    public void setKeeperName(String name) {
        this.n = new JLabel("Name: ");
        this.n.setFont(new Font("PLAIN", Font.BOLD, MainFrame.xCoordinate(12)));
        this.n.setBounds(MainFrame.xCoordinate(30), MainFrame.yCoordinate(this.initialY), MainFrame.xCoordinate(80), MainFrame.yCoordinate(20));
        this.add(this.n);

        this.name = new JTextField(20);
        this.name.setText(name);
        this.name.setHorizontalAlignment(SwingConstants.LEFT);
        this.name.setBorder(null);
        this.name.setEditable(false);
        this.name.setFont(new Font("PLAIN", Font.ITALIC, MainFrame.xCoordinate(12)));
        this.name.setBounds(MainFrame.xCoordinate(130), MainFrame.yCoordinate(this.initialY), MainFrame.xCoordinate(80), MainFrame.yCoordinate(20));
        this.add(this.name);

        this.initialY = this.initialY + 20;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dob = new JLabel("Day Of Birth: ");
        this.dob.setFont(new Font("PLAIN", Font.BOLD, MainFrame.xCoordinate(12)));
        this.dob.setBounds(MainFrame.xCoordinate(30), MainFrame.yCoordinate(this.initialY), MainFrame.xCoordinate(120), MainFrame.yCoordinate(20));
        this.add(this.dob);

        this.dayOfBirth = new JTextField(20);
        this.dayOfBirth.setText(dayOfBirth);
        this.dayOfBirth.setHorizontalAlignment(SwingConstants.LEFT);
        this.dayOfBirth.setBorder(null);
        this.dayOfBirth.setEditable(false);
        this.dayOfBirth.setFont(new Font("PLAIN", Font.ITALIC, MainFrame.xCoordinate(12)));
        this.dayOfBirth.setBounds(MainFrame.xCoordinate(130), MainFrame.yCoordinate(this.initialY), MainFrame.xCoordinate(80), MainFrame.yCoordinate(20));
        this.add(this.dayOfBirth);

        this.initialY = this.initialY + 20;
    }
    
    public void setOffprings(String offprings) {
        this.a = new JLabel("Animals: ");
        this.a.setFont(new Font("PLAIN", Font.BOLD, MainFrame.xCoordinate(12)));
        this.a.setBounds(MainFrame.xCoordinate(30), MainFrame.yCoordinate(this.initialY), MainFrame.xCoordinate(120), MainFrame.yCoordinate(20));
        this.add(a);

        this.animals = new JTextField(20);
        this.animals.setText(offprings);
        this.animals.setHorizontalAlignment(SwingConstants.LEFT);
        this.animals.setBorder(null);
        this.animals.setEditable(false);
        this.animals.setFont(new Font("PLAIN", Font.ITALIC, MainFrame.xCoordinate(12)));
        this.animals.setBounds(MainFrame.xCoordinate(130), MainFrame.yCoordinate(this.initialY), MainFrame.xCoordinate(60), MainFrame.yCoordinate(20));
        this.add(this.animals);

        this.initialY = this.initialY + 20;
    }

    public void setPPSN(String exNum) {
        this.initialY = 15;
        this.ppsn = new JLabel("PPSN: ");
        this.ppsn.setFont(new Font("PLAIN", Font.BOLD, MainFrame.xCoordinate(12)));
        this.ppsn.setBounds(MainFrame.xCoordinate(30), MainFrame.yCoordinate(this.initialY), MainFrame.xCoordinate(120), MainFrame.yCoordinate(20));
        this.add(this.ppsn);

        this.ppsNumber = new JTextField(20);
        this.ppsNumber.setText(exNum);
        this.ppsNumber.setHorizontalAlignment(SwingConstants.LEFT);
        this.ppsNumber.setBorder(null);
        this.ppsNumber.setEditable(false);
        this.ppsNumber.setFont(new Font("PLAIN", Font.ITALIC, MainFrame.xCoordinate(12)));
        this.ppsNumber.setBounds(MainFrame.xCoordinate(130), MainFrame.yCoordinate(this.initialY), MainFrame.xCoordinate(60), MainFrame.yCoordinate(20));
        this.add(this.ppsNumber);

        this.initialY = this.initialY + 20;
    }

}


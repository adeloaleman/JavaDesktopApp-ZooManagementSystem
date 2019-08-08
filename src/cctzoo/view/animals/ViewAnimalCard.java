/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctzoo.view.animals;

import java.awt.Font;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import cctzoo.view.generic.MainFrame;

/**
 *
 * @author guerr
 */
public class ViewAnimalCard extends JPanel {

    private JTextField exhibitNumber;
    private JTextField[] type;
    private JTextField specie;
    private JTextField name;
    private JTextField gender;
    private JTextField dayOfBirth;
    private JTextField dayOfArrival;
    private JTextField[] medication;
    private JTextField[] vaccine;
    private JTextField offprings;
    private JLabel exNum;
    private JLabel t;
    private JLabel sp;
    private JLabel n;
    private JLabel g;
    private JLabel dob;
    private JLabel doa;
    private JLabel med;
    private JLabel vac;
    private JLabel offs;
    private int initialY;
    private JLabel exDet;
    private JTextField extraDetail;

    public ViewAnimalCard(int x, int y, int deltaX, int deltaY, String title, String toolTipText) {

        this.setAnimalDetailsPanel(x, y, deltaX, deltaY, title, toolTipText);

        this.initialY = 15;

    }

    private void setAnimalDetailsPanel(int x, int y, int deltaX, int deltaY, String title, String toolTipText) {
        this.setLayout(null);
        this.setBorder(BorderFactory.createTitledBorder(null, title, 0, 0, new Font("PLAIN", Font.BOLD, MainFrame.xCoordinate(12))));
        this.setBounds(MainFrame.xCoordinate(x), MainFrame.yCoordinate(y), MainFrame.xCoordinate(deltaX), MainFrame.yCoordinate(deltaY));
        this.setToolTipText(toolTipText);
    }

    public void setType(String[] type) {
        this.t = new JLabel("Type: ");
        this.t.setFont(new Font("PLAIN", Font.BOLD, MainFrame.xCoordinate(12)));
        this.t.setBounds(MainFrame.xCoordinate(30), MainFrame.yCoordinate(this.initialY), MainFrame.xCoordinate(120), MainFrame.yCoordinate(20));
        this.add(this.t);

        this.type = new JTextField[type.length];

        for (int i = 0; i < type.length; i++) {
            this.type[i] = new JTextField(20);
            this.type[i].setText(type[i]);
            this.type[i].setHorizontalAlignment(SwingConstants.LEFT);
            this.type[i].setBorder(null);
            this.type[i].setEditable(false);
            this.type[i].setFont(new Font("PLAIN", Font.ITALIC, MainFrame.xCoordinate(12)));
            this.type[i].setBounds(MainFrame.xCoordinate(130), MainFrame.yCoordinate(this.initialY), MainFrame.xCoordinate(80), MainFrame.yCoordinate(20));
            this.add(this.type[i]);

            this.initialY = this.initialY + 15;
        }

        this.initialY = this.initialY + 5;

    }

    public void setSpecie(String specie) {
        this.sp = new JLabel("Specie: ");
        this.sp.setFont(new Font("PLAIN", Font.BOLD, MainFrame.xCoordinate(12)));
        this.sp.setBounds(MainFrame.xCoordinate(30), MainFrame.yCoordinate(this.initialY), MainFrame.xCoordinate(80), MainFrame.yCoordinate(20));
        this.add(this.sp);

        this.specie = new JTextField(20);
        this.specie.setText(specie);
        this.specie.setHorizontalAlignment(SwingConstants.LEFT);
        this.specie.setBorder(null);
        this.specie.setEditable(false);
        this.specie.setFont(new Font("PLAIN", Font.ITALIC, MainFrame.xCoordinate(12)));
        this.specie.setBounds(MainFrame.xCoordinate(130), MainFrame.yCoordinate(this.initialY), MainFrame.xCoordinate(80), MainFrame.yCoordinate(20));
        this.add(this.specie);

        this.initialY = this.initialY + 20;
    }

    public void setName(String name) {
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

    public void setGender(String gender) {
        this.g = new JLabel("Gender: ");
        this.g.setFont(new Font("PLAIN", Font.BOLD, MainFrame.xCoordinate(12)));
        this.g.setBounds(MainFrame.xCoordinate(30), MainFrame.yCoordinate(this.initialY), MainFrame.xCoordinate(120), MainFrame.yCoordinate(20));
        this.add(this.g);

        this.gender = new JTextField(20);
        this.gender.setText(gender);
        this.gender.setHorizontalAlignment(SwingConstants.LEFT);
        this.gender.setBorder(null);
        this.gender.setEditable(false);
        this.gender.setFont(new Font("PLAIN", Font.ITALIC, MainFrame.xCoordinate(12)));
        this.gender.setBounds(MainFrame.xCoordinate(130), MainFrame.yCoordinate(this.initialY), MainFrame.xCoordinate(80), MainFrame.yCoordinate(20));
        this.add(this.gender);

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

    public void setDayOfArrival(String dayOfArrival) {
        this.doa = new JLabel("Day of Arrival: ");
        this.doa.setFont(new Font("PLAIN", Font.BOLD, MainFrame.xCoordinate(12)));
        this.doa.setBounds(MainFrame.xCoordinate(30), MainFrame.yCoordinate(this.initialY), MainFrame.xCoordinate(120), MainFrame.yCoordinate(20));
        this.add(this.doa);

        this.dayOfArrival = new JTextField(20);
        this.dayOfArrival.setText(dayOfArrival);
        this.dayOfArrival.setHorizontalAlignment(SwingConstants.LEFT);
        this.dayOfArrival.setBorder(null);
        this.dayOfArrival.setEditable(false);
        this.dayOfArrival.setFont(new Font("PLAIN", Font.ITALIC, MainFrame.xCoordinate(12)));
        this.dayOfArrival.setBounds(MainFrame.xCoordinate(130), MainFrame.yCoordinate(this.initialY), MainFrame.xCoordinate(80), MainFrame.yCoordinate(20));
        this.add(this.dayOfArrival);

        this.initialY = this.initialY + 20;
    }

    public void setMedication(ArrayList<String> medication) {
        this.med = new JLabel("Medication: ");
        this.med.setFont(new Font("PLAIN", Font.BOLD, MainFrame.xCoordinate(12)));
        this.med.setBounds(MainFrame.xCoordinate(30), MainFrame.yCoordinate(this.initialY), MainFrame.xCoordinate(120), MainFrame.yCoordinate(20));
        this.add(this.med);

        this.medication = new JTextField[medication.size()];

        for (int i = 0; i < medication.size(); i++) {
            this.medication[i] = new JTextField(20);
            this.medication[i].setText(medication.get(i));
            this.medication[i].setHorizontalAlignment(SwingConstants.LEFT);
            this.medication[i].setBorder(null);
            this.medication[i].setEditable(false);
            this.medication[i].setFont(new Font("PLAIN", Font.ITALIC, MainFrame.xCoordinate(12)));
            this.medication[i].setBounds(MainFrame.xCoordinate(130), MainFrame.yCoordinate(this.initialY), MainFrame.xCoordinate(80), MainFrame.yCoordinate(20));
            this.add(this.medication[i]);

            this.initialY = this.initialY + 15;
        }
        if (medication.size() > 0) {
            this.initialY = this.initialY + 5;
        } else {
            this.initialY = this.initialY + 20;
        }
    }

    public void setVaccine(ArrayList<String> vaccine) {
        this.vac = new JLabel("Vaccine: ");
        this.vac.setFont(new Font("PLAIN", Font.BOLD, MainFrame.xCoordinate(12)));
        this.vac.setBounds(MainFrame.xCoordinate(30), MainFrame.yCoordinate(this.initialY), MainFrame.xCoordinate(120), MainFrame.yCoordinate(20));
        this.add(this.vac);

        this.vaccine = new JTextField[vaccine.size()];

        for (int i = 0; i < vaccine.size(); i++) {
            this.vaccine[i] = new JTextField(20);
            this.vaccine[i].setText(vaccine.get(i));
            this.vaccine[i].setHorizontalAlignment(SwingConstants.LEFT);
            this.vaccine[i].setBorder(null);
            this.vaccine[i].setEditable(false);
            this.vaccine[i].setFont(new Font("PLAIN", Font.ITALIC, MainFrame.xCoordinate(12)));
            this.vaccine[i].setBounds(MainFrame.xCoordinate(130), MainFrame.yCoordinate(this.initialY), MainFrame.xCoordinate(80), MainFrame.yCoordinate(20));
            this.add(this.vaccine[i]);

            this.initialY = this.initialY + 15;
        }
        
        if (vaccine.size() > 0) {
            this.initialY = this.initialY + 5;
        } else {
            this.initialY = this.initialY + 20;
        }
    }

    public void setOffprings(String offprings) {
        this.offs = new JLabel("Offsprings: ");
        this.offs.setFont(new Font("PLAIN", Font.BOLD, MainFrame.xCoordinate(12)));
        this.offs.setBounds(MainFrame.xCoordinate(30), MainFrame.yCoordinate(this.initialY), MainFrame.xCoordinate(120), MainFrame.yCoordinate(20));
        this.add(offs);

        this.offprings = new JTextField(20);
        this.offprings.setText(offprings);
        this.offprings.setHorizontalAlignment(SwingConstants.LEFT);
        this.offprings.setBorder(null);
        this.offprings.setEditable(false);
        this.offprings.setFont(new Font("PLAIN", Font.ITALIC, MainFrame.xCoordinate(12)));
        this.offprings.setBounds(MainFrame.xCoordinate(130), MainFrame.yCoordinate(this.initialY), MainFrame.xCoordinate(60), MainFrame.yCoordinate(20));
        this.add(this.offprings);

        this.initialY = this.initialY + 20;
    }

    public void setExhibitNumber(String exNum) {
        this.initialY = 15;
        this.exNum = new JLabel("Exhibit Number: ");
        this.exNum.setFont(new Font("PLAIN", Font.BOLD, MainFrame.xCoordinate(12)));
        this.exNum.setBounds(MainFrame.xCoordinate(30), MainFrame.yCoordinate(this.initialY), MainFrame.xCoordinate(120), MainFrame.yCoordinate(20));
        this.add(this.exNum);

        this.exhibitNumber = new JTextField(20);
        this.exhibitNumber.setText(exNum);
        this.exhibitNumber.setHorizontalAlignment(SwingConstants.LEFT);
        this.exhibitNumber.setBorder(null);
        this.exhibitNumber.setEditable(false);
        this.exhibitNumber.setFont(new Font("PLAIN", Font.ITALIC, MainFrame.xCoordinate(12)));
        this.exhibitNumber.setBounds(MainFrame.xCoordinate(130), MainFrame.yCoordinate(this.initialY), MainFrame.xCoordinate(60), MainFrame.yCoordinate(20));
        this.add(this.exhibitNumber);

        this.initialY = this.initialY + 20;
    }

    public void setExtraDetails(String detail, int value) {
        this.exDet = new JLabel(detail);
        this.exDet.setFont(new Font("PLAIN", Font.BOLD, MainFrame.xCoordinate(12)));
        this.exDet.setBounds(MainFrame.xCoordinate(30), MainFrame.yCoordinate(this.initialY), MainFrame.xCoordinate(120), MainFrame.yCoordinate(20));
        this.add(this.exDet);

        this.extraDetail = new JTextField(20);
        if (value == 1) {
            this.extraDetail.setText("Yes");
        } else {
            this.extraDetail.setText("No");
        }
        this.extraDetail.setHorizontalAlignment(SwingConstants.LEFT);
        this.extraDetail.setBorder(null);
        this.extraDetail.setEditable(false);
        this.extraDetail.setFont(new Font("PLAIN", Font.ITALIC, MainFrame.xCoordinate(12)));
        this.extraDetail.setBounds(MainFrame.xCoordinate(130), MainFrame.yCoordinate(this.initialY), MainFrame.xCoordinate(60), MainFrame.yCoordinate(20));
        this.add(this.extraDetail);

        this.initialY = this.initialY + 20;
    }


}

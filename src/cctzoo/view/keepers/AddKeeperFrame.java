/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctzoo.view.keepers;

import cctzoo.view.generic.MainFrame;
import cctzoo.controller.generic.CharactersLimit;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

/**
 *
 * @author guerr
 */
public class AddKeeperFrame extends MainFrame {
    
    private JPanel header;
    private JLabel addKeeperLabel;
    private JLabel addKeeperImage;
    private JLabel addKeeperPadImage;
    private JButton goBackButton;
    private UtilDateModel model;
    private Properties p;
    private JPanel informationPanel;
    private JPanel knPanel;
    private JTextField keeperName;
    private JFormattedTextField dateField;
    private JPanel dobPanel;
    private JDatePanelImpl datePanel;
    private JDatePickerImpl datePicker;
    private final JCheckBox[] qualifications = {new JCheckBox("Mammal"), new JCheckBox("Reptile"), new JCheckBox("Avian"), new JCheckBox("Aquatic"), new JCheckBox("Insect")};
    private JPanel qualificationsPanel;
    private JButton addKeeperButton;
    
    public AddKeeperFrame(String frameTitle, int frameWidth, int frameHeight, String iconName) {
        
        super(frameTitle, frameWidth, frameHeight, iconName);
        
        // Header panel
        
        this.setAddKeeperHeader();
        this.add(header);
        
        this.setAddKeeperLabel();
        header.add(addKeeperLabel);
        
        this.setAddKeeperImage();
        header.add(addKeeperImage);
        
        this.setGoBackButton();
        header.add(goBackButton);
        
        this.setAddImageLabel();
        this.add(addKeeperPadImage);
        
        this.setInformationPanel();
        this.add(informationPanel);
        
        this.setKeeperNamePanel();
        informationPanel.add(knPanel);
        
        this.setKeeperNameTextField();
        knPanel.add(keeperName);
        
        this.setPickerPanel();
        informationPanel.add(dobPanel);
        
        this.setPickerField();        
        dobPanel.add(datePicker);
        
        this.setQualificationsPanel();
        informationPanel.add(qualificationsPanel);
        
        this.setQualificationsCheckBoxes();
        qualificationsPanel.add(qualifications[0]);
        qualificationsPanel.add(qualifications[1]);
        qualificationsPanel.add(qualifications[2]);
        qualificationsPanel.add(qualifications[3]);
        qualificationsPanel.add(qualifications[4]);
        
        this.setAddKeeperButton();
        this.add(addKeeperButton);
    }
    
    private void setAddKeeperHeader() {
        header = new JPanel();
        header.setLayout(null);
        header.setBackground(Color.LIGHT_GRAY);
        header.setBounds(MainFrame.xCoordinate(0), MainFrame.yCoordinate(0), MainFrame.xCoordinate(460), MainFrame.yCoordinate(60));
    }
    
    private void setAddKeeperLabel() {
        addKeeperLabel = new JLabel("Add a New Zoo Keeper");
        addKeeperLabel.setFont(new Font("Jazz LET", Font.PLAIN, MainFrame.xCoordinate(18)));
        addKeeperLabel.setBounds(MainFrame.xCoordinate(60), MainFrame.yCoordinate(15), MainFrame.xCoordinate(200), MainFrame.yCoordinate(30));
    }
    
    private void setAddKeeperImage() {
        addKeeperImage = new JLabel();
        ImageIcon imgL = new ImageIcon(this.getClass().getResource("/images/addkeeper.png"));
        Image img = imgL.getImage();
        Image newImg = img.getScaledInstance(MainFrame.xCoordinate(40), MainFrame.yCoordinate(40), Image.SCALE_SMOOTH);
        ImageIcon newIcon = new ImageIcon(newImg);
        addKeeperImage.setIcon(newIcon);
        addKeeperImage.setPreferredSize(new Dimension(MainFrame.xCoordinate(40), MainFrame.yCoordinate(40)));
        addKeeperImage.setBounds(MainFrame.xCoordinate(10), MainFrame.yCoordinate(10), MainFrame.xCoordinate(40), MainFrame.yCoordinate(40));
    }
    
    private void setGoBackButton() {
        ImageIcon exitIcon = new ImageIcon(this.getClass().getResource("/images/back.png"));
        Image imgExit = exitIcon.getImage();
        Image newImgExit = imgExit.getScaledInstance(MainFrame.xCoordinate(28), MainFrame.yCoordinate(28), Image.SCALE_SMOOTH);
        ImageIcon newExitIcon = new ImageIcon(newImgExit);
        goBackButton = new JButton("Back", newExitIcon);
        goBackButton.setMargin(new Insets(0,0,0,0));
        goBackButton.setBounds(MainFrame.xCoordinate(370), MainFrame.yCoordinate(15), MainFrame.xCoordinate(70), MainFrame.yCoordinate(30));
        goBackButton.setToolTipText("Go Back to Dashboard");
    }
    
    private void setAddImageLabel() {
        addKeeperPadImage = new JLabel();
        ImageIcon imgL = new ImageIcon(this.getClass().getResource("/images/addKeeperPadImage.png"));
        Image img = imgL.getImage();
        Image newImg = img.getScaledInstance(MainFrame.xCoordinate(100), MainFrame.yCoordinate(95), Image.SCALE_SMOOTH);
        ImageIcon newIcon = new ImageIcon(newImg);
        addKeeperPadImage.setIcon(newIcon);
        addKeeperPadImage.setPreferredSize(new Dimension(MainFrame.xCoordinate(100), MainFrame.yCoordinate(95)));
        addKeeperPadImage.setBounds(MainFrame.xCoordinate(10), MainFrame.yCoordinate(90), MainFrame.xCoordinate(100), MainFrame.yCoordinate(95));
    }
    
    private void setInformationPanel() {
        informationPanel = new JPanel();
        informationPanel.setLayout(null);
        informationPanel.setBorder(BorderFactory.createTitledBorder(null, "New Keeper Details ", 0, 0, new Font("PLAIN", Font.BOLD, MainFrame.xCoordinate(12))));
        informationPanel.setBounds(MainFrame.xCoordinate(120), MainFrame.yCoordinate(70), MainFrame.xCoordinate(325), MainFrame.yCoordinate(160));
    }
    
    private void setKeeperNamePanel() {
        knPanel = new JPanel(null);
        knPanel.setLayout(null);
        knPanel.setBorder(BorderFactory.createTitledBorder(null, "Name ", 0, 0, new Font("PLAIN", Font.BOLD, MainFrame.xCoordinate(12))));
        knPanel.setBounds(MainFrame.xCoordinate(10), MainFrame.yCoordinate(20), MainFrame.xCoordinate(205), MainFrame.yCoordinate(60));
        knPanel.setToolTipText("Set Name of New Keeper");
    }
    
    private void setKeeperNameTextField() {
        keeperName = new JTextField(15);
        keeperName.setFont(new Font("PLAIN", Font.PLAIN, MainFrame.xCoordinate(12)));
        keeperName.setDocument(new CharactersLimit(20, true, true));
        keeperName.setBounds(MainFrame.xCoordinate(25), MainFrame.yCoordinate(25), MainFrame.xCoordinate(160), MainFrame.yCoordinate(20));
    }
    
    private void setPickerPanel() {
        dobPanel = new JPanel(null);
        dobPanel.setLayout(null);
        dobPanel.setBorder(BorderFactory.createTitledBorder(null, "Date Of Birth ", 0, 0, new Font("PLAIN", Font.BOLD, MainFrame.xCoordinate(12))));
        dobPanel.setBounds(MainFrame.xCoordinate(10), MainFrame.yCoordinate(90), MainFrame.xCoordinate(205), MainFrame.yCoordinate(60));
        dobPanel.setToolTipText("Set day of birth of New Keeper");
    }
    
    private void setPickerField() {
        model = new UtilDateModel();
        model.setSelected(true);
        p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
	p.put("text.year", "Year");
        datePanel = new JDatePanelImpl(model, p);
        datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        datePicker.setBounds(MainFrame.xCoordinate(25), MainFrame.yCoordinate(20), MainFrame.xCoordinate(160), MainFrame.yCoordinate(30));
        dateField = datePicker.getJFormattedTextField();
        dateField.setFont(new Font("PLAIN", Font.PLAIN, MainFrame.xCoordinate(12)));
    }
    
    private void setQualificationsPanel() {
        qualificationsPanel = new JPanel(null);
        qualificationsPanel.setLayout(null);
        qualificationsPanel.setBorder(BorderFactory.createTitledBorder(null, "Qualifications ", 0, 0, new Font("PLAIN", Font.BOLD, MainFrame.xCoordinate(12))));
        qualificationsPanel.setBounds(MainFrame.xCoordinate(215), MainFrame.yCoordinate(20), MainFrame.xCoordinate(100), MainFrame.yCoordinate(130));
        qualificationsPanel.setToolTipText("Set from 1 up to 3 qualifications");
    }
    
    private void setQualificationsCheckBoxes() {
        qualifications[0].setBounds(MainFrame.xCoordinate(10), MainFrame.yCoordinate(20), MainFrame.xCoordinate(80), MainFrame.yCoordinate(20));
        qualifications[0].setFont(new Font("PLAIN", Font.BOLD, MainFrame.xCoordinate(12)));
        
        qualifications[1].setBounds(MainFrame.xCoordinate(10), MainFrame.yCoordinate(40), MainFrame.xCoordinate(80), MainFrame.yCoordinate(20));
        qualifications[1].setFont(new Font("PLAIN", Font.BOLD, MainFrame.xCoordinate(12)));
        
        qualifications[2].setBounds(MainFrame.xCoordinate(10), MainFrame.yCoordinate(60), MainFrame.xCoordinate(80), MainFrame.yCoordinate(20));
        qualifications[2].setFont(new Font("PLAIN", Font.BOLD, MainFrame.xCoordinate(12)));
        
        qualifications[3].setBounds(MainFrame.xCoordinate(10), MainFrame.yCoordinate(80), MainFrame.xCoordinate(80), MainFrame.yCoordinate(20));
        qualifications[3].setFont(new Font("PLAIN", Font.BOLD, MainFrame.xCoordinate(12)));
        
        qualifications[4].setBounds(MainFrame.xCoordinate(10), MainFrame.yCoordinate(100), MainFrame.xCoordinate(80), MainFrame.yCoordinate(20));
        qualifications[4].setFont(new Font("PLAIN", Font.BOLD, MainFrame.xCoordinate(12)));
    }

    private void setAddKeeperButton() {
        ImageIcon exitIcon = new ImageIcon(this.getClass().getResource("/images/addanimal.png"));
        Image imgExit = exitIcon.getImage();
        Image newImgExit = imgExit.getScaledInstance(MainFrame.xCoordinate(24), MainFrame.yCoordinate(24), Image.SCALE_SMOOTH);
        ImageIcon newExitIcon = new ImageIcon(newImgExit);
        addKeeperButton = new JButton("ADD", newExitIcon);
        addKeeperButton.setToolTipText("Add Keeper!");
        addKeeperButton.setMargin(new Insets(0,0,0,0));
        addKeeperButton.setBounds(MainFrame.xCoordinate(20), MainFrame.yCoordinate(200), MainFrame.xCoordinate(90), MainFrame.yCoordinate(30));
    }
    
    private static class DateLabelFormatter extends JFormattedTextField.AbstractFormatter {
        
        private String datePattern = "dd/MM/yyyy";
        private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

        
        public DateLabelFormatter() {
        }

        @Override
        public Object stringToValue(String text) throws ParseException {
            return dateFormatter.parseObject(text);
        }

        @Override
        public String valueToString(Object value) throws ParseException {
            if (value != null) {
            Calendar cal = (Calendar) value;
            return dateFormatter.format(cal.getTime());
        }

        return "";
        }
    }
    
    public String dateToString() {
        return datePicker.getModel().getDay() + "/" + (datePicker.getModel().getMonth()+1) + "/" + datePicker.getModel().getYear();
    }
    
    public void setDate(String date) {
        String[] strDate = date.split("/");
        int day = Integer.parseInt(strDate[0]);
        int month = Integer.parseInt(strDate[1]);
        int year = Integer.parseInt(strDate[2]);
        
        this.datePicker.getJFormattedTextField().setText(date);
        this.model.setDate(year, month-1, day);
        
    }
    
    public String getQualificationsAsString() {
        String qua = "";
        for (JCheckBox box : qualifications) {
            if (box.isSelected()) {
                qua = qua+box.getText() + " ";
            }
        }
        return qua;
    }

    public JButton getGoBackButton() {
        return goBackButton;
    }

    public UtilDateModel getModel() {
        return model;
    }

    public JFormattedTextField getDateField() {
        return dateField;
    }

    public JDatePanelImpl getDatePanel() {
        return datePanel;
    }

    public JDatePickerImpl getDatePicker() {
        return datePicker;
    }

    public JCheckBox[] getQualifications() {
        return qualifications;
    }

    public JButton getAddKeeperButton() {
        return addKeeperButton;
    }

    public JTextField getKeeperName() {
        return keeperName;
    }
    
}

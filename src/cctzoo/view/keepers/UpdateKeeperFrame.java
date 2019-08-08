/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctzoo.view.keepers;

import cctzoo.controller.generic.CharactersLimit;
import cctzoo.view.animals.ViewAnimalCard;
import cctzoo.view.animals.ViewAnimalsPanel;
import cctzoo.view.animals.ViewOffspringsPanel;
import cctzoo.view.generic.MainFrame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

/**
 *
 * @author guerr
 */
public class UpdateKeeperFrame extends MainFrame {

    private JPanel header;
    private JLabel updateKeeperLabel;
    private JLabel updateKeeperImage;
    private JLabel updateKeeperPadImage;
    private JButton goBackButton;
    private UtilDateModel model;
    private Properties p;
    private JPanel informationPanel;
    private JPanel kuPanel;
    private JTextField keeperName = null;
    private JFormattedTextField dateField;
    private JPanel dobPanel;
    private JDatePanelImpl datePanel;
    private JDatePickerImpl datePicker;
    private final JCheckBox[] qualifications = {new JCheckBox("Mammal"), new JCheckBox("Reptile"), new JCheckBox("Avian"), new JCheckBox("Aquatic"), new JCheckBox("Insect")};
    private JPanel qualificationsPanel;
    private JButton updateKeeperButton;
    private ViewAnimalsPanel keepersAnimalsPanel;
    private ViewAnimalsPanel animalsPanel;
    private ViewAnimalCard animalView;
    private ViewOffspringsPanel offspringsPanel;
    private JButton addAnimalToKeeperButton;

    public UpdateKeeperFrame(String frameTitle, int frameWidth, int frameHeight, String iconName) {

        super(frameTitle, frameWidth, frameHeight, iconName);

        // Header panel
        this.setUpdateKeeperHeader();
        this.add(header);

        this.setUpdateKeeperLabel();
        header.add(updateKeeperLabel);

        this.setUpdateKeeperImage();
        header.add(updateKeeperImage);

        this.setGoBackButton();
        header.add(goBackButton);

        this.setUpdateImageLabel();
        this.add(updateKeeperPadImage);

        this.setInformationPanel();
        this.add(informationPanel);

        this.setKeeperNamePanel();
        informationPanel.add(kuPanel);

        this.setKeeperNameTextField();
        kuPanel.add(keeperName);

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

        this.setUpdateKeeperButton();
        this.add(updateKeeperButton);

        this.keepersAnimalsPanel = new ViewAnimalsPanel(455, 70, 500, 160, "Keeper's Animals", "Animals being looked after by keeper", 130);;
        this.add(this.keepersAnimalsPanel);
        
        this.animalsPanel = new ViewAnimalsPanel(15, 235, 500, 360, "Animals", "Animals that keeper is qualified to look after", 330);
        this.add(this.animalsPanel);
        
        this.animalView = new ViewAnimalCard(525, 235, 220, 360, "Animal Details", "Details of Clicked Animal");
        this.add(this.animalView);
        
        this.offspringsPanel = new ViewOffspringsPanel(755, 235, 200, 320, "Offsprings", "Offsprings of selected animal", 290);
        this.add(this.offspringsPanel);
        
        this.setAddAnimalToKeeperButton();
        this.add(addAnimalToKeeperButton);

    }

    private void setUpdateKeeperHeader() {
        header = new JPanel();
        header.setLayout(null);
        header.setBackground(Color.LIGHT_GRAY);
        header.setBounds(MainFrame.xCoordinate(0), MainFrame.yCoordinate(0), MainFrame.xCoordinate(975), MainFrame.yCoordinate(60));
    }

    private void setUpdateKeeperLabel() {
        updateKeeperLabel = new JLabel("Update Zoo Keeper");
        updateKeeperLabel.setFont(new Font("Jazz LET", Font.PLAIN, MainFrame.xCoordinate(18)));
        updateKeeperLabel.setBounds(MainFrame.xCoordinate(60), MainFrame.yCoordinate(15), MainFrame.xCoordinate(200), MainFrame.yCoordinate(30));
    }

    private void setUpdateKeeperImage() {
        updateKeeperImage = new JLabel();
        ImageIcon imgL = new ImageIcon(this.getClass().getResource("/images/updatekeeper.png"));
        Image img = imgL.getImage();
        Image newImg = img.getScaledInstance(MainFrame.xCoordinate(40), MainFrame.yCoordinate(40), Image.SCALE_SMOOTH);
        ImageIcon newIcon = new ImageIcon(newImg);
        updateKeeperImage.setIcon(newIcon);
        updateKeeperImage.setPreferredSize(new Dimension(MainFrame.xCoordinate(40), MainFrame.yCoordinate(40)));
        updateKeeperImage.setBounds(MainFrame.xCoordinate(10), MainFrame.yCoordinate(10), MainFrame.xCoordinate(40), MainFrame.yCoordinate(40));
    }

    private void setGoBackButton() {
        ImageIcon exitIcon = new ImageIcon(this.getClass().getResource("/images/back.png"));
        Image imgExit = exitIcon.getImage();
        Image newImgExit = imgExit.getScaledInstance(MainFrame.xCoordinate(28), MainFrame.yCoordinate(28), Image.SCALE_SMOOTH);
        ImageIcon newExitIcon = new ImageIcon(newImgExit);
        goBackButton = new JButton("Back", newExitIcon);
        goBackButton.setMargin(new Insets(0, 0, 0, 0));
        goBackButton.setBounds(MainFrame.xCoordinate(885), MainFrame.yCoordinate(15), MainFrame.xCoordinate(70), MainFrame.yCoordinate(30));
        goBackButton.setToolTipText("Go Back to Dashboard");
    }

    private void setUpdateImageLabel() {
        updateKeeperPadImage = new JLabel();
        ImageIcon imgL = new ImageIcon(this.getClass().getResource("/images/update.png"));
        Image img = imgL.getImage();
        Image newImg = img.getScaledInstance(MainFrame.xCoordinate(100), MainFrame.yCoordinate(95), Image.SCALE_SMOOTH);
        ImageIcon newIcon = new ImageIcon(newImg);
        updateKeeperPadImage.setIcon(newIcon);
        updateKeeperPadImage.setPreferredSize(new Dimension(MainFrame.xCoordinate(100), MainFrame.yCoordinate(95)));
        updateKeeperPadImage.setBounds(MainFrame.xCoordinate(10), MainFrame.yCoordinate(90), MainFrame.xCoordinate(100), MainFrame.yCoordinate(95));
    }

    private void setInformationPanel() {
        informationPanel = new JPanel();
        informationPanel.setLayout(null);
        informationPanel.setBorder(BorderFactory.createTitledBorder(null, "Keeper Details ", 0, 0, new Font("PLAIN", Font.BOLD, MainFrame.xCoordinate(12))));
        informationPanel.setBounds(MainFrame.xCoordinate(120), MainFrame.yCoordinate(70), MainFrame.xCoordinate(325), MainFrame.yCoordinate(160));
    }

    private void setKeeperNamePanel() {
        kuPanel = new JPanel(null);
        kuPanel.setLayout(null);
        kuPanel.setBorder(BorderFactory.createTitledBorder(null, "Name ", 0, 0, new Font("PLAIN", Font.BOLD, MainFrame.xCoordinate(12))));
        kuPanel.setBounds(MainFrame.xCoordinate(10), MainFrame.yCoordinate(20), MainFrame.xCoordinate(205), MainFrame.yCoordinate(60));
        kuPanel.setToolTipText("Change Name of Keeper");
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
        dobPanel.setToolTipText("Change day of birth of Keeper");
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

    private void setUpdateKeeperButton() {
        ImageIcon exitIcon = new ImageIcon(this.getClass().getResource("/images/updateanimal.png"));
        Image imgExit = exitIcon.getImage();
        Image newImgExit = imgExit.getScaledInstance(MainFrame.xCoordinate(24), MainFrame.yCoordinate(24), Image.SCALE_SMOOTH);
        ImageIcon newExitIcon = new ImageIcon(newImgExit);
        updateKeeperButton = new JButton("Update", newExitIcon);
        updateKeeperButton.setToolTipText("Update Keeper!");
        updateKeeperButton.setMargin(new Insets(0, 0, 0, 0));
        updateKeeperButton.setBounds(MainFrame.xCoordinate(20), MainFrame.yCoordinate(200), MainFrame.xCoordinate(90), MainFrame.yCoordinate(30));
    }
    
    private void setAddAnimalToKeeperButton() {
        ImageIcon exitIcon = new ImageIcon(this.getClass().getResource("/images/addanimal.png"));
        Image imgExit = exitIcon.getImage();
        Image newImgExit = imgExit.getScaledInstance(MainFrame.xCoordinate(24), MainFrame.yCoordinate(24), Image.SCALE_SMOOTH);
        ImageIcon newExitIcon = new ImageIcon(newImgExit);
        addAnimalToKeeperButton = new JButton("Add Animal", newExitIcon);
        addAnimalToKeeperButton.setToolTipText("Add Animal to Keeper!");
        addAnimalToKeeperButton.setMargin(new Insets(0, 0, 0, 0));
        addAnimalToKeeperButton.setBounds(MainFrame.xCoordinate(800), MainFrame.yCoordinate(565), MainFrame.xCoordinate(120), MainFrame.yCoordinate(30));
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

    public String getQualificationsAsString() {
        String qua = "";
        for (JCheckBox box : qualifications) {
            if (box.isSelected()) {
                qua = qua + box.getText() + " ";
            }
        }
        return qua;
    }

    public JButton getGoBackButton() {
        return goBackButton;
    }

    public JTextField getKeeperName() {
        return keeperName;
    }

    public JFormattedTextField getDateField() {
        return dateField;
    }

    public JDatePickerImpl getDatePicker() {
        return datePicker;
    }

    public JCheckBox[] getQualifications() {
        return qualifications;
    }

    public JButton getUpdateKeeperButton() {
        return updateKeeperButton;
    }

    public ViewAnimalsPanel getKeepersAnimalsPanel() {
        return keepersAnimalsPanel;
    }

    public ViewAnimalsPanel getAnimalsPanel() {
        return animalsPanel;
    }

    public ViewAnimalCard getAnimalView() {
        return animalView;
    }

    public ViewOffspringsPanel getOffspringsPanel() {
        return offspringsPanel;
    }

    public JButton getAddAnimalToKeeperButton() {
        return addAnimalToKeeperButton;
    }
    
    public String dateToString() {
        return datePicker.getModel().getDay() + "/" + (datePicker.getModel().getMonth() + 1) + "/" + datePicker.getModel().getYear();
    }

    public void setDate(String date) {
        String[] strDate = date.split("/");
        int day = Integer.parseInt(strDate[0]);
        int month = Integer.parseInt(strDate[1]);
        int year = Integer.parseInt(strDate[2]);
        
        this.datePicker.getJFormattedTextField().setText(date);
        this.model.setDate(year, month-1, day);
        
    }

}

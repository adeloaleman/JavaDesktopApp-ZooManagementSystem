/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctzoo.view.generic;

import java.awt.Font;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Locale;
import java.util.Properties;
import javax.swing.BorderFactory;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

/**
 *
 * @author guerr
 */
public class CalendarPanel extends JPanel {

    private UtilDateModel model;
    private Properties p;
    private JDatePanelImpl datePanel;
    private JDatePickerImpl datePicker;
    private JFormattedTextField dateField;

    public CalendarPanel(int xLocation, int yLocation, String title, String toolTipText) {

        this.setPickerPanel(xLocation, yLocation, title, toolTipText);
        this.setPickerField();

    }

    private void setPickerPanel(int xLocation, int yLocation, String title, String toolTipText) {
        this.setLayout(null);
        this.setBorder(BorderFactory.createTitledBorder(null, title, 0, 0, new Font("PLAIN", Font.BOLD, MainFrame.xCoordinate(12))));
        this.setBounds(MainFrame.xCoordinate(xLocation), MainFrame.yCoordinate(yLocation), MainFrame.xCoordinate(205), MainFrame.yCoordinate(60));
        this.setToolTipText(toolTipText);
        this.setEnabled(false);
    }

    private void setPickerField() {
        this.model = new UtilDateModel();
        this.model.setSelected(true);
        this.p = new Properties();
        this.p.put("text.today", "Today");
        this.p.put("text.month", "Month");
        this.p.put("text.year", "Year");
        this.datePanel = new JDatePanelImpl(this.model, this.p);
        this.datePicker = new JDatePickerImpl(this.datePanel, new CalendarPanel.DateLabelFormatter());
        this.datePicker.setBounds(MainFrame.xCoordinate(25), MainFrame.yCoordinate(20), MainFrame.xCoordinate(160), MainFrame.yCoordinate(30));
        this.dateField = datePicker.getJFormattedTextField();
        this.dateField.setFont(new Font("PLAIN", Font.PLAIN, MainFrame.xCoordinate(12)));
        this.datePicker.getComponent(0).setEnabled(false);
        this.datePicker.getComponent(1).setEnabled(false);

        this.add(this.datePicker);
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

    public int dateToInt() {
        return (datePicker.getModel().getDay() + (datePicker.getModel().getMonth() + 1) * 30 + (datePicker.getModel().getYear()) * 365);
    }

    public JDatePickerImpl getDatePicker() {
        return datePicker;
    }

    public JFormattedTextField getDateField() {
        return dateField;
    }

}

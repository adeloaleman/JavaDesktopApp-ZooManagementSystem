/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctzoo.view.animals;

import cctzoo.model.animals.Animal;
import cctzoo.view.generic.MainFrame;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author guerr
 */
public class ViewAnimalsPanel extends JPanel {

    private JTable viewAnimalsTable = new JTable(new DefaultTableModel());
    private String[][] viewAnimalsData;
    private JScrollPane sr;
    public DefaultTableModel modelTable = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    ;

    };
    
    public ViewAnimalsPanel(int x, int y, int deltaX, int deltaY, String title, String toolTipText, int tableHeight) {

        this.setLayout(null);
        this.setBorder(BorderFactory.createTitledBorder(null, title, 0, 0, new Font("PLAIN", Font.BOLD, MainFrame.xCoordinate(12))));
        this.setBounds(MainFrame.xCoordinate(x), MainFrame.yCoordinate(y), MainFrame.xCoordinate(deltaX), MainFrame.yCoordinate(deltaY));
        this.setToolTipText(toolTipText);

        String[] colNames = {"Exh Num", "Specie", "Name", "Date Of Birth", "Date Of Arrival", "Gender"};
        modelTable.setColumnIdentifiers(colNames);

        this.viewAnimalsTable.setModel(modelTable);
        this.viewAnimalsTable.setSelectionModel(new ForcedListSelectionModel());

        viewAnimalsTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        viewAnimalsTable.getTableHeader().setResizingAllowed(false);
        viewAnimalsTable.getTableHeader().setReorderingAllowed(false);
        viewAnimalsTable.setFont(new Font("Times", Font.PLAIN, MainFrame.xCoordinate(12)));
        viewAnimalsTable.getColumnModel().getColumn(0).setPreferredWidth(MainFrame.xCoordinate(60));
        viewAnimalsTable.getColumnModel().getColumn(1).setPreferredWidth(MainFrame.xCoordinate(70));
        viewAnimalsTable.getColumnModel().getColumn(2).setPreferredWidth(MainFrame.xCoordinate(90));
        viewAnimalsTable.getColumnModel().getColumn(3).setPreferredWidth(MainFrame.xCoordinate(80));
        viewAnimalsTable.getColumnModel().getColumn(4).setPreferredWidth(MainFrame.xCoordinate(90));
        viewAnimalsTable.getColumnModel().getColumn(5).setPreferredWidth(MainFrame.xCoordinate(70));
        sr = new JScrollPane(viewAnimalsTable);
        sr.setBounds(MainFrame.xCoordinate(10), MainFrame.yCoordinate(20), MainFrame.xCoordinate(480), MainFrame.yCoordinate(tableHeight));

        this.add(sr);

    }

    public JTable getViewAnimalsTable() {
        return viewAnimalsTable;
    }

    public DefaultTableModel getModelTable() {
        return modelTable;
    }

    public void setData() {
        // Filling up table
        for (String[] viewAnimalsData1 : this.viewAnimalsData) {
            this.modelTable.addRow(viewAnimalsData1);
        }

    }

    public void dataToString(ArrayList<Animal> animals) {
        
        this.viewAnimalsData = null;
        this.viewAnimalsData = new String[animals.size()][6];

        for (int i = 0; i < animals.size(); i++) {
            String en = Integer.toString(animals.get(i).getExhibitionNumb());
            this.viewAnimalsData[i][0] = en;

            String s = animals.get(i).getSpecie();
            this.viewAnimalsData[i][1] = s;

            String n = animals.get(i).getName();
            this.viewAnimalsData[i][2] = n;

            String dob = animals.get(i).getDateOfBirth();
            this.viewAnimalsData[i][3] = dob;

            String doa = animals.get(i).getDateOfArrival();
            this.viewAnimalsData[i][4] = doa;

            String g = animals.get(i).getGender();
            this.viewAnimalsData[i][5] = g;

        }

    }

    public class ForcedListSelectionModel extends DefaultListSelectionModel {

        public ForcedListSelectionModel() {
            setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        }

        @Override
        public void clearSelection() {
        }

        @Override
        public void removeSelectionInterval(int index0, int index1) {
        }

    }
    
    public void removeAllRows() {
        int rc = this.modelTable.getRowCount();
        
        for (int i = rc-1; i >= 0; i--) {
            this.modelTable.removeRow(i);
        }
    }

    public JScrollPane getSr() {
        return sr;
    }

}

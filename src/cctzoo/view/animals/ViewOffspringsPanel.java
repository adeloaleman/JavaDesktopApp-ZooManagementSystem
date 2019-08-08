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
public class ViewOffspringsPanel extends JPanel {
    
    private JTable viewOffspringsTable = new JTable(new DefaultTableModel());
    private String[][] viewOffspringsData;
    private DefaultTableModel modelTable = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        };
    };
    
    public ViewOffspringsPanel(int x, int y, int deltaX, int deltaY, String title, String toolTipText, int tableHeight) {
        
        this.setLayout(null);
        this.setBorder(BorderFactory.createTitledBorder(null, title, 0, 0, new Font("PLAIN", Font.BOLD, MainFrame.xCoordinate(12))));
        this.setBounds(MainFrame.xCoordinate(x), MainFrame.yCoordinate(y), MainFrame.xCoordinate(deltaX), MainFrame.yCoordinate(deltaY));
        this.setToolTipText(toolTipText);
        
        String[] colNames = {"Exh Num", "Name", "Date Of Birth", "Gender"};
        modelTable.setColumnIdentifiers(colNames);
        viewOffspringsTable.setModel(modelTable);

        viewOffspringsTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        viewOffspringsTable.getTableHeader().setResizingAllowed(false);
        viewOffspringsTable.getTableHeader().setReorderingAllowed(false);
        viewOffspringsTable.setFont(new Font("PLAIN", Font.PLAIN, MainFrame.xCoordinate(12)));
        viewOffspringsTable.getColumnModel().getColumn(0).setPreferredWidth(MainFrame.xCoordinate(60));
        viewOffspringsTable.getColumnModel().getColumn(1).setPreferredWidth(MainFrame.xCoordinate(90));
        viewOffspringsTable.getColumnModel().getColumn(2).setPreferredWidth(MainFrame.xCoordinate(80));
        viewOffspringsTable.getColumnModel().getColumn(3).setPreferredWidth(MainFrame.xCoordinate(70));
        JScrollPane sr = new JScrollPane(viewOffspringsTable);
        sr.setBounds(MainFrame.xCoordinate(10), MainFrame.yCoordinate(20), MainFrame.xCoordinate(180), MainFrame.yCoordinate(tableHeight));

        this.add(sr);
        
    }

    public JTable getViewOffspringsTable() {
        return viewOffspringsTable;
    }

    public String[][] getViewOffspringsData() {
        return viewOffspringsData;
    }

    public DefaultTableModel getModelTable() {
        return modelTable;
    }
    
    public void setData() {
        // Filling up table
        for (String[] viewAnimalsData1 : this.viewOffspringsData) {
            this.modelTable.addRow(viewAnimalsData1);
        }

    }

    public void dataToString(ArrayList<Animal> animals) {
        
        this.viewOffspringsData = null;
        this.viewOffspringsData = new String[animals.size()][6];

        for (int i = 0; i < animals.size(); i++) {
            String en = Integer.toString(animals.get(i).getExhibitionNumb());
            this.viewOffspringsData[i][0] = en;

            String n = animals.get(i).getName();
            this.viewOffspringsData[i][1] = n;

            String dob = animals.get(i).getDateOfBirth();
            this.viewOffspringsData[i][2] = dob;

            String g = animals.get(i).getGender();
            this.viewOffspringsData[i][3] = g;

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
    
}

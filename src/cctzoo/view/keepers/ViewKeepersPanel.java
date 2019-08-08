/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctzoo.view.keepers;

import cctzoo.model.animals.Animal;
import cctzoo.model.keepers.Keeper;
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
public class ViewKeepersPanel extends JPanel {

    public JTable viewKeepersTable = new JTable(new DefaultTableModel());
    public String[][] viewKeepersData;
    public DefaultTableModel modelTable = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    ;

    };
    
    public ViewKeepersPanel(int x, int y, int deltaX, int deltaY, String title, String toolTipText, int tableHeight) {

        this.setLayout(null);
        this.setBorder(BorderFactory.createTitledBorder(null, title, 0, 0, new Font("PLAIN", Font.BOLD, MainFrame.xCoordinate(12))));
        this.setBounds(MainFrame.xCoordinate(x), MainFrame.yCoordinate(y), MainFrame.xCoordinate(deltaX), MainFrame.yCoordinate(deltaY));
        this.setToolTipText(toolTipText);

        String[] colNames = {"PPSN", "Name", "Date Of Birth"};
        modelTable.setColumnIdentifiers(colNames);

        this.viewKeepersTable.setModel(modelTable);
        this.viewKeepersTable.setSelectionModel(new ForcedListSelectionModel());

        viewKeepersTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        viewKeepersTable.getTableHeader().setResizingAllowed(false);
        viewKeepersTable.getTableHeader().setReorderingAllowed(false);
        viewKeepersTable.setFont(new Font("Times", Font.PLAIN, MainFrame.xCoordinate(12)));
        viewKeepersTable.getColumnModel().getColumn(0).setPreferredWidth(MainFrame.xCoordinate(70));
        viewKeepersTable.getColumnModel().getColumn(1).setPreferredWidth(MainFrame.xCoordinate(120));
        viewKeepersTable.getColumnModel().getColumn(2).setPreferredWidth(MainFrame.xCoordinate(100));
        
        JScrollPane sr = new JScrollPane(viewKeepersTable);
        sr.setBounds(MainFrame.xCoordinate(10), MainFrame.yCoordinate(20), MainFrame.xCoordinate(310), MainFrame.yCoordinate(tableHeight));

        this.add(sr);

    }

    public JTable getViewKeepersTable() {
        return viewKeepersTable;
    }

    public DefaultTableModel getModelTable() {
        return modelTable;
    }

    public void setData() {
        // Filling up table
        for (String[] viewKeepersData1 : this.viewKeepersData) {
            this.modelTable.addRow(viewKeepersData1);
        }

    }

    public void dataToString(ArrayList<Keeper> keepers) {

        this.viewKeepersData = new String[keepers.size()][3];

        for (int i = 0; i < keepers.size(); i++) {
            String ppsn = Integer.toString(keepers.get(i).getPps());
            this.viewKeepersData[i][0] = ppsn;

            String n = keepers.get(i).getName();
            this.viewKeepersData[i][1] = n;

            String dob = keepers.get(i).getDateOfBirth();
            this.viewKeepersData[i][2] = dob;

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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctzoo.view.generic;

import java.awt.Font;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 *
 * @author guerr
 */
public class RefineByPanel extends JPanel {
    
    private CheckBoxPanel checkBoxFields;
    private TextFieldPanel refineByTextField;
    private GenericButton refineByButton;    
    
    public RefineByPanel(String searchSubject, ArrayList<String> refineByFields) {
        
        this.setRefineByPanel(searchSubject);
        
        this.checkBoxFields = new CheckBoxPanel(10, 15, 110, 110, "", "Select the field you want to refine the results by");
        this.add(this.checkBoxFields);
        this.checkBoxFields.setBorder(null);
        this.checkBoxFields.setAmountOfFields(refineByFields.size());
        this.checkBoxFields.setFieldsCheckBoxes(refineByFields);
        
        this.refineByTextField = new TextFieldPanel(130, 15, 190, 100, "Insert Text ");
        this.add(this.refineByTextField);
        
        this.refineByButton = new GenericButton(45, 55, 100, "src/cctzoo/view/images/searchanimal.png", "Refine", "Refine");
        this.refineByTextField.add(this.refineByButton);
        
    }
    
    private void setRefineByPanel(String searchSubject) {
        this.setLayout(null);
        this.setBorder(BorderFactory.createTitledBorder(null, "Refine By ", 0, 0, new Font("PLAIN", Font.BOLD, MainFrame.xCoordinate(12))));
        this.setBounds(MainFrame.xCoordinate(280), MainFrame.yCoordinate(70), MainFrame.xCoordinate(330), MainFrame.yCoordinate(130));
        this.setToolTipText(searchSubject);
    }

    public CheckBoxPanel getCheckBoxFields() {
        return checkBoxFields;
    }

    public TextFieldPanel getRefineByTextField() {
        return refineByTextField;
    }

    public GenericButton getRefineByButton() {
        return refineByButton;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctzoo.view.keepers;

import cctzoo.model.keepers.Keeper;
import cctzoo.view.animals.ViewAnimalCard;
import cctzoo.view.animals.ViewAnimalsPanel;
import cctzoo.view.animals.ViewOffspringsPanel;
import cctzoo.view.generic.GenericButton;
import cctzoo.view.generic.Header;
import cctzoo.view.generic.ImageLabel;
import cctzoo.view.generic.MainFrame;
import cctzoo.view.generic.RefineByPanel;
import java.util.ArrayList;

/**
 *
 * @author guerr
 */
public class ViewKeepersFrame extends MainFrame {

    private Header header;
    private RefineByPanel refinePanel;
    private ImageLabel updateAnimalImageLabel;
    private ArrayList<String> refiningFields;
    private ViewKeepersPanel keepersPanel;
    private ArrayList<Keeper> keepers;
    private ViewKeeperCard keeperView;
    private ViewAnimalsPanel animalsPanel; 
    private ImageLabel viewKeepersOnFrame;
    private GenericButton updateKeeperButton;
    
    public ViewKeepersFrame(ArrayList<Keeper> keepers, String frameTitle, int frameWidth, int frameHeight, String iconName) {
        super(frameTitle, frameWidth, frameHeight, iconName);
        
        this.keepers = keepers;
        
        this.header = new Header(frameWidth, 300, "View/Search/Update Keeper", "src/cctzoo/view/images/viewkeeper.png", "src/cctzoo/view/images/back.png", "Go Back");
        this.add(this.header);
        
        this.updateAnimalImageLabel = new ImageLabel(20, 70, 129, 285, "src/cctzoo/view/images/zookeeper.png");
        this.add(this.updateAnimalImageLabel.getImageLabel());
        
        this.refiningFields = new ArrayList<String>();
        
        this.refiningFields.add("Name");
        this.refiningFields.add("Qualification");
        
        this.refinePanel = new RefineByPanel("Refine Keeper view by filtering data stored", refiningFields);
        this.refinePanel.setBounds(MainFrame.xCoordinate(160), MainFrame.yCoordinate(70), MainFrame.xCoordinate(330), MainFrame.yCoordinate(130));
        this.add(this.refinePanel);
        
        this.keepersPanel = new ViewKeepersPanel(160, 200, 330, 220, "Keepers", "Searched keepers", 190);
        this.add(this.keepersPanel);
        
        // Initializing the table with all the data
        this.keepersPanel.dataToString(keepers);
        this.keepersPanel.setData();
        
        // Keeper data card
        this.keeperView = new ViewKeeperCard(490, 70, 220, 150, "Keeper Details", "Details of Clicked Animal");
        this.add(this.keeperView);
        
        // Keeper's animals Table
        this.animalsPanel = new ViewAnimalsPanel(490, 220, 220, 200, "Animals", "Offsprings of selected animal", 270);
        this.animalsPanel.getSr().setBounds(MainFrame.xCoordinate(10), MainFrame.yCoordinate(20), MainFrame.xCoordinate(200), MainFrame.yCoordinate(170));
        
        this.add(this.animalsPanel);
        
        // Another Keeper Image
        this.viewKeepersOnFrame = new ImageLabel(500, 80, 210, 340, "src/cctzoo/view/images/keeperplaceholder.jpeg");
        this.add(this.viewKeepersOnFrame.getImageLabel());
        
        // Update Keeper Selected Button
        this.updateKeeperButton = new GenericButton(20, 370, 120, "src/cctzoo/view/images/updateanimal.png", "Update Keeper", "Update Selected Animal");
        this.add(this.updateKeeperButton);
        
    }

    public Header getHeader() {
        return header;
    }

    public RefineByPanel getRefinePanel() {
        return refinePanel;
    }

    public ImageLabel getUpdateAnimalImageLabel() {
        return updateAnimalImageLabel;
    }

    public ViewKeepersPanel getKeepersPanel() {
        return keepersPanel;
    }

    public ViewKeeperCard getKeeperView() {
        return keeperView;
    }

    public ArrayList<Keeper> getKeepers() {
        return keepers;
    }

    public ViewAnimalsPanel getAnimalsPanel() {
        return animalsPanel;
    }

    public ImageLabel getViewKeepersOnFrame() {
        return viewKeepersOnFrame;
    }

    public void setViewKeepersOnFrame(ImageLabel viewKeepersOnFrame) {
        this.viewKeepersOnFrame = viewKeepersOnFrame;
    }

    public GenericButton getUpdateKeeperButton() {
        return updateKeeperButton;
    }
    
    
    
}

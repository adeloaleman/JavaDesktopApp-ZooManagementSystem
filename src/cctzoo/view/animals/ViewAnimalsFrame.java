/**
 * ViewAnimalsFrame
 *
 * Purpose:
 * 
 * To create a frame that displays/search for Animals
 * 
 * This class creates objects with the following characteristics:
 * 
 * Header header
 * ImageLabel viewAnimalImage;
 * RefineByPanel refiningTextPanel;
 * ViewAnimalsPanel animalsPanel;
 * ViewAnimalCard animalView;
 * ViewOffspringsPanel offspringsPanel;
 * final ArrayList<String> refiningFields;
 * GenericButton updateAnimalButton;
 * ImageLabel viewAnimalsOnFrame;
 * 
 * This Class Extends MainFrame, that is a class that creates Frames given a input
 */

package cctzoo.view.animals;

import cctzoo.model.animals.Animal;
import cctzoo.view.generic.GenericButton;
import cctzoo.view.generic.Header;
import cctzoo.view.generic.ImageLabel;
import cctzoo.view.generic.MainFrame;
import cctzoo.view.generic.RefineByPanel;
import java.util.ArrayList;

/**
 *
 * @author Adelo Vieira (2017276), Asmer Bracho (2016328) and Miguelantonio Guerra (2016324)
 * 
 */
public class ViewAnimalsFrame extends MainFrame {
    
    private Header header;
    private ImageLabel viewAnimalImage;
    public RefineByPanel refiningTextPanel;
    private ViewAnimalsPanel animalsPanel;
    private ViewAnimalCard animalView;
    private ViewOffspringsPanel offspringsPanel;
    private final ArrayList<String> refiningFields;
    private GenericButton updateAnimalButton;
    private ImageLabel viewAnimalsOnFrame;
    private final ImageLabel placeHolderImage;
    private ArrayList<Animal> animals;
    
    /**
     * Constructor of the Class ViewAnimalsFrame to create ViewAnimalsFrame objects.
     * 
     * This constructor takes the parameters:
     * 
     * @param frameTitle String that sets the title of the frame
     * @param frameWidth int that sets the width of the frame
     * @param frameHeight int that sets the height of the frame
     * @param iconName String that points to the location of the icon of the frame
     */
    public ViewAnimalsFrame(ArrayList<Animal> animals, String frameTitle, int frameWidth, int frameHeight, String iconName) {
        
        super(frameTitle, frameWidth, frameHeight, iconName);
        
        this.animals = animals;
        
        // Header panel
        this.header = new Header(frameWidth, 260, "View/Search/Update Animals", "src/cctzoo/view/images/addanimal.png", "src/cctzoo/view/images/back.png", "Go Back to dashboard");
        this.add(header);
        
        // Animals Image
        this.viewAnimalImage = new ImageLabel(10, 40, 270, 180, "src/cctzoo/view/images/animali.png");
        this.add(viewAnimalImage.getImageLabel());
        
        // Refining By Panel
        this.refiningFields = new ArrayList<String>();
        
        this.refiningFields.add("Type");
        this.refiningFields.add("Specie");
        this.refiningFields.add("Name");
        this.refiningFields.add("Keeper");
        
        this.refiningTextPanel = new RefineByPanel("Refine Animal view by filtering data stored", refiningFields);
        this.add(this.refiningTextPanel);
        
        
        // Animals' list Panel
        this.animalsPanel = new ViewAnimalsPanel(15, 205, 500, 360, "Animals", "Searched Animals", 330);
        this.add(this.animalsPanel);
        
        // Initializing the table with all the data
        this.animalsPanel.dataToString(animals);
        this.animalsPanel.setData();
        
        
        // Another Animals Image
        this.placeHolderImage = new ImageLabel(525, 205, 430, 360, "src/cctzoo/view/images/placeholder.jpg");
        this.add(this.placeHolderImage.getImageLabel());
        this.placeHolderImage.getImageLabel();        
        
        // Animal's Description Card
        this.animalView = new ViewAnimalCard(525, 205, 220, 360, "Animal Details", "Details of Clicked Animal");
        this.add(this.animalView);
        
        // Animal's Offprings Table
        this.offspringsPanel = new ViewOffspringsPanel(755, 205, 200, 300, "Offsprings", "Offsprings of selected animal", 270);
        this.add(this.offspringsPanel);
        
        // Update Animal Selected Button
        this.updateAnimalButton = new GenericButton(800, 520, 120, "src/cctzoo/view/images/updateanimal.png", "Update Animal", "Update Selected Animal");
        this.add(this.updateAnimalButton);
        
        // Another Animals Image
        this.viewAnimalsOnFrame = new ImageLabel(590, 60, 355, 142, "src/cctzoo/view/images/zoo.png");
        this.add(this.viewAnimalsOnFrame.getImageLabel());
        
    }

    public ViewAnimalCard getAnimalView() {
        return animalView;
    }

    public RefineByPanel getRefiningTextPanel() {
        return refiningTextPanel;
    }

    public Header getHeader() {
        return header;
    }

    public ViewOffspringsPanel getOffspringsPanel() {
        return offspringsPanel;
    }

    public ImageLabel getPlaceHolderImage() {
        return placeHolderImage;
    }

    public ViewAnimalsPanel getAnimalsPanel() {
        return animalsPanel;
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    public GenericButton getUpdateAnimalButton() {
        return updateAnimalButton;
    }
    
    
    
}

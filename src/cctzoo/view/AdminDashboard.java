/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctzoo.view;

import cctzoo.view.generic.MainFrame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author guerr
 */
public class AdminDashboard extends MainFrame {
    
    private JPanel keeperPanel;
    private JButton addKeeperButton;
    private JButton updateKeeperButton;
    private JButton searchKeeperButton;
    private JButton viewKeeperButton;
    private JPanel animalPanel;
    private JButton addAnimalButton;
    private JButton updateAnimalButton;
    private JButton searchAnimalButton;
    private JButton viewAnimalButton;
    private JPanel header;
    private JButton logoutButton;
    private JLabel welcomeLabel;
    private JLabel welcomeImage;
    private TheView view;
    
    public AdminDashboard(TheView view, String title, int width, int height, String image) {
        
        super(title, width, height, image);
        
        this.view = view;
        
        /**
         * Header: Creates the header for the Admin DashBoard
         */
        
        this.setDashboardHeader();
        this.add(header);
        
        this.setWelcomeLabel();
        header.add(welcomeLabel);
        
        this.setWelcomeImage();
        header.add(welcomeImage);
        
        this.setLogOutButton();
        header.add(logoutButton);
        
        /**
         * Keeper 
         */
        
        this.setKeeperPanel();
        this.add(keeperPanel);
        
        // Add keeper button:
        
        this.setAddKeeperButton();
        keeperPanel.add(addKeeperButton);
        
        // Update keeper button:
        
        //this.setUpdateKeeperButton();
        //keeperPanel.add(updateKeeperButton);
        
        // Search keeper button:
        
        //this.setSearchKeeperButton();
        //keeperPanel.add(searchKeeperButton);
        
        // View keeper button:
        
        this.setViewKeeperButton();
        keeperPanel.add(viewKeeperButton);
        
        /**
         * Animal
         */
        
        this.setAnimalPanel();
        this.add(animalPanel);
        
        // Add Animal button:
        
        this.setAddAnimalButton();
        animalPanel.add(addAnimalButton);
        
        // Update Animal button:
        /*
        this.setUpdateAnimalButton();
        animalPanel.add(updateAnimalButton);
        
        // search animal button:
        
        this.setSearchAnimalButton();
        animalPanel.add(searchAnimalButton);
        */
        // View animal button:
        
        this.setViewAnimalButton();
        animalPanel.add(viewAnimalButton);
        
        this.setVisible(true);
        this.validate();
        this.repaint();
        
    }
    
    private void setDashboardHeader() {
        header = new JPanel();
        header.setLayout(null);
        header.setBackground(Color.LIGHT_GRAY);
        header.setBounds(MainFrame.xCoordinate(0), MainFrame.yCoordinate(0), MainFrame.xCoordinate(435), MainFrame.yCoordinate(60));
    }
    
    private void setWelcomeLabel() {
        welcomeLabel = new JLabel("Welcome Admin!");
        welcomeLabel.setFont(new Font("Jazz LET", Font.PLAIN, MainFrame.xCoordinate(18)));
        welcomeLabel.setBounds(MainFrame.xCoordinate(60), MainFrame.yCoordinate(15), MainFrame.xCoordinate(200), MainFrame.yCoordinate(30));
    }
    
    private void setWelcomeImage() {
        welcomeImage = new JLabel();
        ImageIcon imgL = new ImageIcon(this.getClass().getResource("/images/header.png"));
        Image img = imgL.getImage();
        Image newImg = img.getScaledInstance(MainFrame.xCoordinate(40), MainFrame.yCoordinate(40), Image.SCALE_SMOOTH);
        ImageIcon newIcon = new ImageIcon(newImg);
        welcomeImage.setIcon(newIcon);
        welcomeImage.setPreferredSize(new Dimension(MainFrame.xCoordinate(40), MainFrame.yCoordinate(40)));
        welcomeImage.setBounds(MainFrame.xCoordinate(10), MainFrame.yCoordinate(10), MainFrame.xCoordinate(40), MainFrame.yCoordinate(40));
    }
    
    private void setLogOutButton() {
        ImageIcon exitIcon = new ImageIcon(this.getClass().getResource("/images/exit.png"));
        Image imgExit = exitIcon.getImage();
        Image newImgExit = imgExit.getScaledInstance(MainFrame.xCoordinate(14), MainFrame.yCoordinate(14), Image.SCALE_SMOOTH);
        ImageIcon newExitIcon = new ImageIcon(newImgExit);
        
        logoutButton = new JButton("Log out", newExitIcon);
        logoutButton.setFont(new Font("PLAIN", Font.PLAIN, MainFrame.xCoordinate(18)));
        logoutButton.setActionCommand("exitButton");
        logoutButton.setToolTipText("Stop the application!");
        logoutButton.setMargin(new Insets(0,0,0,0));
        logoutButton.setBounds(MainFrame.xCoordinate(335), MainFrame.yCoordinate(15), MainFrame.xCoordinate(85), MainFrame.yCoordinate(30));
    }
    
    private void setKeeperPanel() {
        keeperPanel = new JPanel(null);
        keeperPanel.setLayout(null);
        keeperPanel.setBorder(BorderFactory.createTitledBorder(null, "Keepers: ", 0, 0, new Font("PLAIN", Font.BOLD, MainFrame.xCoordinate(12))));
        keeperPanel.setBounds(MainFrame.xCoordinate(10), MainFrame.yCoordinate(70), MainFrame.xCoordinate(200), MainFrame.yCoordinate(185));
        
        JLabel keeperImage = new JLabel();
        ImageIcon imgK = new ImageIcon(this.getClass().getResource("/images/keeper.png"));
        Image kImg = imgK.getImage();
        Image newImgK = kImg.getScaledInstance(MainFrame.xCoordinate(120), MainFrame.yCoordinate(120), Image.SCALE_SMOOTH);
        ImageIcon newIconK = new ImageIcon(newImgK);
        keeperImage.setIcon(newIconK);
        keeperImage.setPreferredSize(new Dimension(MainFrame.xCoordinate(120), MainFrame.yCoordinate(120)));
        keeperImage.setBounds(MainFrame.xCoordinate(-20), MainFrame.yCoordinate(30), MainFrame.xCoordinate(120), MainFrame.yCoordinate(120));
        
        keeperPanel.add(keeperImage);
    }
    
    private void setAddKeeperButton() {
        ImageIcon addKeeperIcon = new ImageIcon(this.getClass().getResource("/images/addkeeper.png"));
        Image imgAddKeeper = addKeeperIcon.getImage();
        Image newImgAddKeeper = imgAddKeeper.getScaledInstance(MainFrame.xCoordinate(24), MainFrame.yCoordinate(24), Image.SCALE_SMOOTH);
        ImageIcon newAddKeeperIcon = new ImageIcon(newImgAddKeeper);
        
        addKeeperButton = new JButton("ADD", newAddKeeperIcon);
        addKeeperButton.setFont(new Font("BOLD", Font.BOLD, MainFrame.xCoordinate(12)));
        addKeeperButton.setToolTipText("Add a new Keeper");
        addKeeperButton.setMargin(new Insets(0,0,0,0));
        addKeeperButton.setBounds(MainFrame.xCoordinate(90), MainFrame.yCoordinate(20), MainFrame.xCoordinate(90), MainFrame.yCoordinate(30));
    }
    
    private void setUpdateKeeperButton() {
        ImageIcon updateKeeperIcon = new ImageIcon(this.getClass().getResource("/images/updatekeeper.png"));
        Image imgUpdateKeeper = updateKeeperIcon.getImage();
        Image newImgUpdateKeeper = imgUpdateKeeper.getScaledInstance(MainFrame.xCoordinate(24), MainFrame.yCoordinate(24), Image.SCALE_SMOOTH);
        ImageIcon newUpdateKeeperIcon = new ImageIcon(newImgUpdateKeeper);
        
        updateKeeperButton = new JButton("UPDATE", newUpdateKeeperIcon);
        updateKeeperButton.setFont(new Font("BOLD", Font.BOLD, MainFrame.xCoordinate(12)));
        updateKeeperButton.setToolTipText("Update an existing Keeper");
        updateKeeperButton.setMargin(new Insets(0,0,0,0));
        updateKeeperButton.setBounds(MainFrame.xCoordinate(90), MainFrame.yCoordinate(60), MainFrame.xCoordinate(90), MainFrame.yCoordinate(30));
    }
    
    private void setSearchKeeperButton() {
        ImageIcon searchKeeperIcon = new ImageIcon(this.getClass().getResource("/images/searchkeeper.png"));
        Image imgSearchKeeper = searchKeeperIcon.getImage();
        Image newImgSearchKeeper = imgSearchKeeper.getScaledInstance(MainFrame.xCoordinate(24), MainFrame.yCoordinate(24), Image.SCALE_SMOOTH);
        ImageIcon newSearchKeeperIcon = new ImageIcon(newImgSearchKeeper);
        
        searchKeeperButton = new JButton("SEARCH", newSearchKeeperIcon);
        searchKeeperButton.setFont(new Font("BOLD", Font.BOLD, MainFrame.xCoordinate(12)));
        searchKeeperButton.setToolTipText("Search for an existing Keeper");
        searchKeeperButton.setMargin(new Insets(0,0,0,0));
        searchKeeperButton.setBounds(MainFrame.xCoordinate(90), MainFrame.yCoordinate(100), MainFrame.xCoordinate(90), MainFrame.yCoordinate(30));
    }
    
    private void setViewKeeperButton() {
        ImageIcon viewKeeperIcon = new ImageIcon(this.getClass().getResource("/images/viewkeeper.png"));
        Image imgViewKeeper = viewKeeperIcon.getImage();
        Image newImgViewKeeper = imgViewKeeper.getScaledInstance(MainFrame.xCoordinate(24), MainFrame.yCoordinate(24), Image.SCALE_SMOOTH);
        ImageIcon newViewKeeperIcon = new ImageIcon(newImgViewKeeper);
        
        viewKeeperButton = new JButton("VIEW", newViewKeeperIcon);
        viewKeeperButton.setFont(new Font("BOLD", Font.BOLD, MainFrame.xCoordinate(12)));
        viewKeeperButton.setToolTipText("View all existing Keepers");
        viewKeeperButton.setMargin(new Insets(0,0,0,0));
        viewKeeperButton.setBounds(MainFrame.xCoordinate(90), MainFrame.yCoordinate(140), MainFrame.xCoordinate(90), MainFrame.yCoordinate(30));
    }
    
    private void setAnimalPanel() {
        animalPanel = new JPanel(null);
        animalPanel.setLayout(null);
        animalPanel.setBorder(BorderFactory.createTitledBorder(null, "Animals: ", 0, 0, new Font("PLAIN", Font.BOLD, MainFrame.xCoordinate(12))));
        animalPanel.setBounds(MainFrame.xCoordinate(220), MainFrame.yCoordinate(70), MainFrame.xCoordinate(200), MainFrame.yCoordinate(185));
        
        JLabel animalImage = new JLabel();
//      ImageIcon imgA = new ImageIcon("src/cctzoo/view/images/animals.png");
        ImageIcon imgA = new ImageIcon(this.getClass().getResource("/images/animals.png"));
        
//        ImageIcon icon = new ImageIcon(this.getClass().getResource("/img/yourImage.gif"));
        
        Image aImg = imgA.getImage();
        Image newImgA = aImg.getScaledInstance(MainFrame.xCoordinate(90), MainFrame.yCoordinate(90), Image.SCALE_SMOOTH);
        ImageIcon newIconA = new ImageIcon(newImgA);
        animalImage.setIcon(newIconA);
        animalImage.setPreferredSize(new Dimension(MainFrame.xCoordinate(90), MainFrame.yCoordinate(90)));
        animalImage.setBounds(MainFrame.xCoordinate(0), MainFrame.yCoordinate(30), MainFrame.xCoordinate(100), MainFrame.yCoordinate(100));
        animalPanel.add(animalImage);
    }
    
    private void setAddAnimalButton() {
        ImageIcon addAnimalIcon = new ImageIcon(this.getClass().getResource("/images/addanimal.png"));
        Image imgAddAnimal = addAnimalIcon.getImage();
        Image newImgAddAnimal = imgAddAnimal.getScaledInstance(MainFrame.xCoordinate(24), MainFrame.yCoordinate(24), Image.SCALE_SMOOTH);
        ImageIcon newAddAnimalIcon = new ImageIcon(newImgAddAnimal);
        
        addAnimalButton = new JButton("ADD", newAddAnimalIcon);
        addAnimalButton.setFont(new Font("BOLD", Font.BOLD, MainFrame.xCoordinate(12)));
        addAnimalButton.setToolTipText("Add a new Animal");
        addAnimalButton.setMargin(new Insets(0,0,0,0));
        addAnimalButton.setBounds(MainFrame.xCoordinate(90), MainFrame.yCoordinate(20), MainFrame.xCoordinate(90), MainFrame.yCoordinate(30));
    }

    private void setUpdateAnimalButton() {
        ImageIcon updateAnimalIcon = new ImageIcon(this.getClass().getResource("/images/updateanimal.png"));
        Image imgUpdateAnimal = updateAnimalIcon.getImage();
        Image newImgUpdateAnimal = imgUpdateAnimal.getScaledInstance(MainFrame.xCoordinate(24), MainFrame.yCoordinate(24), Image.SCALE_SMOOTH);
        ImageIcon newUpdateAnimalIcon = new ImageIcon(newImgUpdateAnimal);
        
        updateAnimalButton = new JButton("UPDATE", newUpdateAnimalIcon);
        updateAnimalButton.setFont(new Font("BOLD", Font.BOLD, MainFrame.xCoordinate(12)));
        updateAnimalButton.setToolTipText("Update an existing Animal");
        updateAnimalButton.setMargin(new Insets(0,0,0,0));
        updateAnimalButton.setBounds(MainFrame.xCoordinate(90), MainFrame.yCoordinate(60), MainFrame.xCoordinate(90), MainFrame.yCoordinate(30));
    }
    
    private void setSearchAnimalButton() {
        ImageIcon searchAnimalIcon = new ImageIcon(this.getClass().getResource("/images/searchanimal.png"));
        Image imgSearchAnimal = searchAnimalIcon.getImage();
        Image newImgSearchAnimal = imgSearchAnimal.getScaledInstance(MainFrame.xCoordinate(24), MainFrame.yCoordinate(24), Image.SCALE_SMOOTH);
        ImageIcon newSearchAnimalIcon = new ImageIcon(newImgSearchAnimal);
        
        searchAnimalButton = new JButton("SEARCH", newSearchAnimalIcon);
        searchAnimalButton.setFont(new Font("BOLD", Font.BOLD, MainFrame.xCoordinate(12)));
        searchAnimalButton.setToolTipText("Search for an existing Animal");
        searchAnimalButton.setMargin(new Insets(0,0,0,0));
        searchAnimalButton.setBounds(MainFrame.xCoordinate(90), MainFrame.yCoordinate(100), MainFrame.xCoordinate(90), MainFrame.yCoordinate(30));
    }
    
    private void setViewAnimalButton() {
        ImageIcon viewAnimalIcon = new ImageIcon(this.getClass().getResource("/images/viewanimals.png"));
        Image imgViewAnimal = viewAnimalIcon.getImage();
        Image newImgViewAnimal = imgViewAnimal.getScaledInstance(MainFrame.xCoordinate(24), MainFrame.yCoordinate(24), Image.SCALE_SMOOTH);
        ImageIcon newViewAnimalIcon = new ImageIcon(newImgViewAnimal);
        
        viewAnimalButton = new JButton("VIEW", newViewAnimalIcon);
        viewAnimalButton.setFont(new Font("BOLD", Font.BOLD, MainFrame.xCoordinate(12)));
        viewAnimalButton.setToolTipText("View all existing Animals");
        viewAnimalButton.setMargin(new Insets(0,0,0,0));
        viewAnimalButton.setBounds(MainFrame.xCoordinate(90), MainFrame.yCoordinate(140), MainFrame.xCoordinate(90), MainFrame.yCoordinate(30));
    }

    public JButton getAddKeeperButton() {
        return addKeeperButton;
    }

    public JButton getUpdateKeeperButton() {
        return updateKeeperButton;
    }

    public JButton getSearchKeeperButton() {
        return searchKeeperButton;
    }

    public JButton getViewKeeperButton() {
        return viewKeeperButton;
    }

    public JButton getAddAnimalButton() {
        return addAnimalButton;
    }

    public JButton getUpdateAnimalButton() {
        return updateAnimalButton;
    }

    public JButton getSearchAnimalButton() {
        return searchAnimalButton;
    }

    public JButton getViewAnimalButton() {
        return viewAnimalButton;
    }

    public JButton getLogoutButton() {
        return logoutButton;
    }

    public TheView getView() {
        return view;
    }
    
}

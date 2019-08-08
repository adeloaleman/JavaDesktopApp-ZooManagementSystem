package cctzoo;


import cctzoo.view.animals.ViewAnimalsFrame;
import cctzoo.view.generic.RefineByPanel;
import javax.swing.SwingUtilities;

public class CCTZoo {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            
            @Override
            public void run() {
                
                new CCTZooSystem();

            }
        });

    }

}

package cctzoo.model.animals;

import java.util.ArrayList;

public interface Aquatic {
    
    default String canBeOutsideWatter(int t) {
        return t == 1 ? "Yes" : "No";
    }
    
    public ArrayList<String> toArrayList();
        
    
    public ArrayList<String> nameVariables();
        
    
}

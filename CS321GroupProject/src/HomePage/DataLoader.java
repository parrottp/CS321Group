package HomePage;

/**
 *
 * @author livweaver
 */

import java.util.*;

public class DataLoader
{
    private String sVar;
    
    /**  
    * Set the value of string.  
    * @param sVariable A variable of type string.  
    */ 
    public void setString(String sVariable) {
        sVar = sVariable;
    }
    
    /**  
    * Get the value of sVar.    
    */ 
    public String getString() {
        return sVar;
    }
    
    /**  
    * Print the value of sVar.  
    */ 
    public void printString() {
        System.out.println(sVar);
    }
}

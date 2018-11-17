package Model;

/**
 * Holds, sets, gets, and prints a String.
 * @author livweaver
 */
public class DataLoader
{
    private String sVar;
    
    /**  
    * Set the value of string.  
    * @param sVariable A variable of type string.
    * PRECONDITIONS: None. 
    * POSTCONDITIONS: this.sVar = sVariable
    */ 
    public void setString(String sVariable) {
        sVar = sVariable;
    }
    
    /**  
    * Get the value of sVar.  
    * PRECONDITIONS: None.
    * POSTCONDITIONS: None.
    */ 
    public String getString() {
        return sVar;
    }
    
    /**  
    * Print the value of sVar. 
    * PRECONDITIONS: None.
    * POSTCONDITIONS: None.
    */ 
    public void printString() {
        System.out.println(sVar);
    }
}

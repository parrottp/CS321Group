package Model;

/**
 * Holds, sets, gets, and prints a String.
 */
public class DataLoader
{
    private String sVar;
    
    /**  
    * Set the value of string.  
    * @param sVariable A variable of type string.
    * PRECONDITION: None. 
    * POSTCONDITION: this.sVar = sVariable
    */ 
    public void setString(String sVariable) {
        sVar = sVariable;
    }
    
    
    /**  
    * Get the value of sVar.  
    * @return this.sVar
    * PRECONDITION: None.
    * POSTCONDITION: None.
    */ 
    public String getString() {
        return sVar;
    }
    
    
    /**  
    * Print the value of sVar. 
    * PRECONDITION: None.
    * POSTCONDITION: None.
    */ 
    public void printString() {
        System.out.println(sVar);
    }
    
    
}

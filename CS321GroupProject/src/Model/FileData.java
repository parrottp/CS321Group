package Model;

import java.io.*;

/**
 * Creates, writes, and reads a String from a File. Uses Singleton design pattern. 
 * @author livweaver, noahe
 */
public class FileData extends DataLoader {
    
    //Private instance of FileData
    private static FileData fd;
    
    //Constructor is private so FileData can only be initialied from getInstance()
    private FileData() {}
    
    //Initializes only instance of FileData
    public static FileData getInstance() {
        if (fd == null) {
            fd = new FileData();
        }
        return fd;
    }
    
    /**  
    * Create new file, file named with username.
    * PRECONDITIONS: String fileName initialized.
    * POSTCONDITIONS: Creates new File named fileName. 
    */ 
    public String FileCreate(String fileName)
    {
        BufferedReader aReader = null;
        try 
        {
            //Create new file
            PrintWriter aWriter = new PrintWriter(fileName, "UTF-8");
            aWriter.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        
        return null;
    }
        
    
    /**  
    * Write string to file.
    * PRECONDITIONS: sVar and fileName initialized.
    * POSTCONDITIONS: String sVar appended to File fileName.
    */ 
    public String FileWrite(String sVar, String fileName)
    { 
        BufferedWriter writer;
        try 
        {
            writer = new BufferedWriter(new FileWriter(fileName, true));
            writer.write(sVar);
            writer.newLine();
            writer.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
                
        return null;
    }

    
    /**
     * Read String from File and return.
     * @param fileName input fileName
     * @return userData if read from file, or null otherwise
     * PRECONDITIONS: fileName initialized.
     * POSTCONDITIONS: If first line of File read, it is returned. 
     */
    public String FileLoad(String fileName)
    {
        BufferedReader aReader = null;
        try 
        {
            //Read file
            aReader = new BufferedReader(new FileReader(fileName));
                
            //Split string by whitespace
            String userData = aReader.readLine();
                
            aReader.close();
                
            return userData;

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
                
        return null;
    }
    
}
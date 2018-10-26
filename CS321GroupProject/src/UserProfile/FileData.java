package UserProfile;

/**
 *
 * @author livweaver
 */
import java.io.*;

public class FileData extends DataLoader 
    {
    String filename;
    
        /**  
        * Create new file, file named with username.
        */ 
        String FileCreate(String user)
        {
            BufferedReader aReader = null;
            try 
            {
                //Create new file
                filename = user + ".txt";
                PrintWriter aWriter = new PrintWriter(filename, "UTF-8");
                
                aWriter.close();
            }
            catch (IOException e)
            {

                e.printStackTrace();
            }
                
            return filename;
        }
        
        /**  
        * Write string to file.
        *
        */ 
        
        String FileWrite(String sVar)
        {
            BufferedWriter writer;
            
            try {
                writer = new BufferedWriter(new FileWriter(filename, true));            
                writer.write(sVar);
                writer.newLine();
                writer.close();
            }
            catch (IOException ex) {
                System.out.println("Input Exception");
            }
                
            return null;
        }

        /**  
        * Read string from file and return. 
        *
        */ 
        String FileLoad(String user)
        {
            BufferedReader aReader = null;
            try 
            {
                //Read file
                aReader = new BufferedReader(new FileReader(filename));
                
                //Split string by whitespace
                String userData = aReader.readLine();
                
                aReader.close();
                
                //print read string
                System.out.println(userData);
                return userData;

            }
            catch (IOException e)
            {

                e.printStackTrace();
            }
                
            return null;
        }
    }
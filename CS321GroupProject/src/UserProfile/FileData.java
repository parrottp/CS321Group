package UserProfile;

/**
 *
 * @author livweaver
 */
import java.io.*;

public class FileData extends DataLoader 
    {
    
        /**  
        * Create new file, file named with username.
        */ 
        String FileCreate(String user)
        {
            BufferedReader aReader = null;
            try 
            {
                //Create new file
                PrintWriter aWriter = new PrintWriter(user +".txt", "UTF-8");
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
        *
        */ 
        String FileWrite(String sVar, String user)
        {
            try 
            {
                //Create new file
                PrintWriter aWriter = new PrintWriter(user +".txt", "UTF-8");
                
                //Print data to file
                aWriter.println(sVar + "\n");
                aWriter.close();
            }
            catch (IOException e)
            {

                e.printStackTrace();
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
                aReader = new BufferedReader(new FileReader(user +".txt"));
                
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
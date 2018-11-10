package UserProfile;

/**
 *
 * @author livweaver
 */
import java.io.*;

public class FileData extends DataLoader {
    
        /**  
        * Create new file, file named with username.
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
        *
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
        * Read string from file and return. 
        *
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
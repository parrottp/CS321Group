package UserProfile;

/**
 *
 * @author livweaver
 */
import java.io.*;

public class FileData extends DataLoader 
    {
<<<<<<< HEAD
    String filename;
=======
>>>>>>> master
    
        /**  
        * Create new file, file named with username.
        */ 
        String FileCreate(String user)
        {
            BufferedReader aReader = null;
            try 
            {
                //Create new file
<<<<<<< HEAD
                filename = user + ".txt";
                PrintWriter aWriter = new PrintWriter(filename, "UTF-8");
                
=======
                PrintWriter aWriter = new PrintWriter(user +".txt", "UTF-8");
>>>>>>> master
                aWriter.close();
            }
            catch (IOException e)
            {

                e.printStackTrace();
            }
                
<<<<<<< HEAD
            return filename;
=======
            return null;
>>>>>>> master
        }
        
        /**  
        * Write string to file.
        *
        */ 
<<<<<<< HEAD
        
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
=======
        String FileWrite(String sVar, String user)
        {
            try(FileWriter fw = new FileWriter(user +".txt", true);
                    
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
            {
                out.println(sVar);
                
            } catch (IOException e) 
            {
                e.printStackTrace();
>>>>>>> master
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
<<<<<<< HEAD
                aReader = new BufferedReader(new FileReader(filename));
=======
                aReader = new BufferedReader(new FileReader(user +".txt"));
>>>>>>> master
                
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
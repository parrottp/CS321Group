package UserProfile;

/**
 *
 * @author livweaver
 */
public class Driver {
    public static void main(String[] args) 
    {
        //View supplemeneted here
        System.out.println("Enter Username");
        System.out.println("Enter Password");
        System.out.println("Enter Game Interested in");
        System.out.println("Enter Age");
        
        for(int i = 0; i < 4; i++)
        {
        //Read data from user
        DataLoader data = new DataLoader();
        UserInput user = new UserInput();
        data.setString(user.UserLoad());
        
        //Update data to file
        FileData file = new FileData();
        
        //Currently creates 4 files- need to consolidate into one
        file.FileCreate(data.getString());
        file.FileWrite(data.getString(),data.getString());
        }

    }
    
}

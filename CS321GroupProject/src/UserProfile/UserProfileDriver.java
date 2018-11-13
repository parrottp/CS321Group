/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserProfile;

/**
 *
 * @author livweaver
 */
public class UserProfileDriver {
    
    public static void main(String[]args)
    {
        UserProfileModel m = new UserProfileModel("Please enter firstname", "Please enter last name", "Please enter username", "Please enter password", "00/00/0000", "Please enter game");
        UserProfileView v = new UserProfileView("Create Profile");
        UserProfileController c = new UserProfileController(m,v);
        c.initialController();
    }
    
}

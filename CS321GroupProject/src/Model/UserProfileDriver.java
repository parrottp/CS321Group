/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author livweaver
 */
public class UserProfileDriver {
    
    public static void main(String[]args)
    {
        UserProfileModel m = new UserProfileModel("Please enter first name", "Please enter last name", "Please enter username", "Please enter password", "MM/DD/YYYY", "Please enter game");
        UserProfileView v = new UserProfileView("Create Profile");
        UserProfileController c = new UserProfileController(m,v);
        c.initialController();
    }
    
}

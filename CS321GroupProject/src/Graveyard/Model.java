/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graveyard;

import Model.CalculateAge;
import java.text.ParseException;

/**
 *
 * @author noahe
 */
public class Model {
    private UserData user;
    public boolean userLoaded;
    
    private String userAge;             //unsure 
    
    private String data;
    public boolean dataLoaded;
    
    private DataReader aReader;
  
    
    public void setReader(DataReader aReader) {
        this.aReader = aReader;
        this.dataLoaded = true;
    }
    
    //CALLED AFTER USER DATA IS READ FROM FILE
    public void setUser(UserData user) {
        this.user = user;
        this.userLoaded = true;
    }
    
    public void readData() {
        this.data = this.aReader.getData();
    }
    
    
    /**
     * Called by Controller when the User inputs DoB into JTextField. Sets this.userAge = User's age.
     * PRECONDITION: this.data is a valid String for DoB in the format 'MM/dd/yyyy'
     * @throws ParseException 
     */
    public void processBirthdate() throws ParseException { 
        CalculateAge input = new CalculateAge(this.data);
        input.happyBirthday();
        this.userAge = input.getAge();
    }
    
}

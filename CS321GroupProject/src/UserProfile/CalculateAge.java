/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserProfile;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author noahe
 */
public class CalculateAge {
    //private Scanner console;
    private String inputDate;
    private Date currentDay;
    private Date birthDay;
    private SimpleDateFormat sdf;
    private long timeDiff;
    private String age;


    public CalculateAge(String inputDate) throws ParseException {
        //this.console = new Scanner(System.in);      //INPUT FROM GUI
        this.inputDate = inputDate;
        this.currentDay = new Date();
        this.sdf = new SimpleDateFormat("MM/dd/yyyy");
        
        System.out.println("Please input your date of birth in this format (mm/dd/yyyy): ");
       
        this.setBirthDay();     //Locally calls setBirthDay method
        this.printTimeDiff();   //Locally calls printTimeDiff method
    }
    
    private void setBirthDay() throws ParseException {
        Date birthDay = sdf.parse(inputDate);
        
        this.birthDay = birthDay;                       //Sets local variable
    }
    
    private void setTimeDiff() {
        long timeDiff = this.currentDay.getTime() - this.birthDay.getTime();    //Calculates different between birth date and current date
        
        this.timeDiff = timeDiff;                                               //Sets local variable for time difference
    }
    
    private void printTimeDiff() {
        this.setTimeDiff();     //Locally calls setTimeDiff() method
        
        System.out.println("Years: " + (TimeUnit.DAYS.convert(this.timeDiff, TimeUnit.MILLISECONDS))/365);  
        this.age = Long.toString((TimeUnit.DAYS.convert(this.timeDiff, TimeUnit.MILLISECONDS))/365);
    }
    
    public String getAge() {
        return this.age;
    }
}

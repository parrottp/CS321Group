/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserProfile;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author noahe
 */
public class CalculateAge {
    private Scanner console;
    private String inputDate;           //INPUT FROM GUI
    private Date currentDay;
    private Date birthDay;
    private Calendar calendar;
    private SimpleDateFormat sdf;
    private long timeDiff;
    private String age;

    /**
     * Constructor
     * @param inputDate
     * @throws ParseException 
     */
    public CalculateAge(String inputDate) throws ParseException {       //INPUT COMES FROM GUI, CALLED BY VIEW WITH INPUT PARAMETER
        this.inputDate = inputDate;
        this.currentDay = new Date();
        this.calendar = new GregorianCalendar();
        this.sdf = new SimpleDateFormat("MM/dd/yyyy");
       
        this.setBirthDate();     //Locally calls setBirthDay method
        this.processAge();   //Locally calls printTimeDiff method
    }
    
    /**
     * TESTS USE CASE WITH CONSOLE INPUT
     * @throws ParseException 
     */
    public CalculateAge() throws ParseException {
        this.console = new Scanner(System.in);     
        this.currentDay = new Date();
        this.calendar = new GregorianCalendar();
        this.sdf = new SimpleDateFormat("MM/dd/yyyy");
        
        System.out.println("Please input your date of birth in this format (mm/dd/yyyy): ");
        this.inputDate = console.nextLine();
        
        this.setBirthDate();     //Locally calls setBirthDay method
        this.processAge();   //Locally calls printTimeDiff method
    }
    
    /**
     * Turns input birthDate String into Date object
     * @throws ParseException 
     */
    private void setBirthDate() throws ParseException {
        Date birthDay = sdf.parse(inputDate);
        
        this.birthDay = birthDay;                       //Sets local variable
    }
    
    /**
     * Turns birthDate and currentDate into String age
     */
    private void processAge() {
        //Calculates time difference between birth date and current date
        long timeDiff = this.currentDay.getTime() - this.birthDay.getTime();    
        
        //Sets local variable for time difference
        this.timeDiff = timeDiff;                                               
        
        //Changes time difference into years, and converts it into a String  
        this.age = Long.toString((TimeUnit.DAYS.convert(this.timeDiff, TimeUnit.MILLISECONDS))/365);
    }
    
    /**
     * Accessor for User age
     * @return User age
     */
    public String getAge() {
        return this.age;
    }
    
    /**
     * Outputs message on User's birthday
     */
    public void happyBirthday() {
        Calendar bday = new GregorianCalendar();
        Calendar cday = new GregorianCalendar();
        
        bday.setTime(this.birthDay);
        cday.setTime(this.currentDay);
        
        
        if(bday.get(Calendar.MONTH) == cday.get(Calendar.MONTH)) {         
            if (bday.get(Calendar.DAY_OF_MONTH) == cday.get(Calendar.DAY_OF_MONTH)) {
                System.out.println("HAPPY BIRTHDAY!");                                              //SEND TO GUI
            }
        }
    }
}

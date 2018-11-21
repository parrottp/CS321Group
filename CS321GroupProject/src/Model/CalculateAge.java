package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;



/**
 * Processes User input birth dates into their age, rejects invalid birth date inputs, and checks if current day is User's birthday.
 */
public class CalculateAge {
    
    //Calendar and Date variables
    private Calendar calendar;
    private SimpleDateFormat sdf;   
    private Date currentDay;        //Current Date
    private Date birthDay;          //User's Birth Date
    
    //Primitive variables
    private long timeDiff;          //Time difference between Current Date and Birth Date
    private String inputDate;       //The User input Birth Date as a String
    private String age;             //User's age as a String
    
    //Checks if input date is valid
    private boolean invalidDate = false;

    /**
     * Constructor.
     * @param inputDate User input birth date String
     * @throws ParseException 
     */
    public CalculateAge(String inputDate) throws ParseException {       
        this.inputDate = inputDate;
        this.currentDay = new Date();
        this.calendar = new GregorianCalendar();
        this.sdf = new SimpleDateFormat("MM/dd/yyyy");  //Sets the format for Data objects
        this.sdf.setLenient(false);                     //Date format has to be strictly followed
       
        //Converts input String into Date object
        this.setBirthDate();    
    }
    
    
    /**
     * Turns input birthDate String into Date object.
     * @throws ParseException 
     * PRECONDITION: this.inputDate contains a birthDate String in proper format
     * POSTCONDITION: this.birthDay updated if valid input, otherwise this.invalidDate set to true
     */
    private void setBirthDate() throws ParseException {
        try {
            //Parses String into Data object and updates this.birthDay
            Date birthDay = sdf.parse(this.inputDate);           
            this.birthDay = birthDay;                       
        }
        catch (ParseException e) {
            this.invalidDate = true;
        }
    }
    
    
    /**
     * Turns birthDate and currentDate into String age.
     * PRECONDITION: this.currentDay and this.birthDay are initialized
     * POSTCONDITION: this.timeDiff contains time difference in milliseconds, this.age contains time different in years rounded down
     */
    public void processAge() {
        //Calculates time difference between birth date and current date
        long time = this.currentDay.getTime() - this.birthDay.getTime();    
        
        //Sets local variable for time difference
        this.timeDiff = time;                                               
        
        //Changes time difference into years, and converts it into a String  
        this.age = Long.toString((TimeUnit.DAYS.convert(this.timeDiff, TimeUnit.MILLISECONDS))/365);
    }
    
    
    /**
     * Outputs message on User's birthday.
     * @return true if currentDay is User's birthDay
     * PRECONDITION: this.birthDay and this.currentDay both initialized
     * POSTCONDITION: None.
     */
    public boolean happyBirthday() {
        boolean check = false;
        
        //Creates temp GregorianCalendar objects to store and compare dates
        Calendar bday = new GregorianCalendar();
        Calendar cday = new GregorianCalendar();
        
        //Stores Dates into Calendars
        bday.setTime(this.birthDay);
        cday.setTime(this.currentDay);
        
        //Uses Calendar compare to check if day and month of currentDay and birthDay are the same
        if(bday.get(Calendar.MONTH) == cday.get(Calendar.MONTH)) {         
            if (bday.get(Calendar.DAY_OF_MONTH) == cday.get(Calendar.DAY_OF_MONTH)) {
                check = true;                                                                   
            }
        }
        
        //Returns true if today is User's birthday, returns false if today is NOT User's birthday
        return check;
    }
    
    
    /**
     * Accessor for invalidDate Boolean
     * @return true if input DoB is invalid, false otherwise
     */
    public boolean getInvalidDate() {
        return this.invalidDate;
    }
    
    
    /**
     * Accessor for User age
     * @return User age
     */
    public String getAge() {
        return this.age;
    }
    
    
}

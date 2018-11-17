package HomePage;

import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author livweaver, noahe
 */
public class HomePageController 
{
    
    private Model model;
    private HomePageView view;
    
    
    //constructor
    public HomePageController(Model m, HomePageView v)
    {
        model = m;
        view = v;
        initialView();
    }
    
    public void initialView()
    {
        view.getUsernameLabel().setText(model.getUsername());
        view.getBirthdayLabel().setText(model.getBirthday());
        view.getGameInterestLabel().setText(model.getGameInterest());
    }
    
}

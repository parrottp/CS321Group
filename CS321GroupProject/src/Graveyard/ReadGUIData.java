/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graveyard;

import Graveyard.DataReader;
import java.util.Scanner;

/**
 * Reads a String from JTextField in GUI
 * @author noahe
 */
public class ReadGUIData implements DataReader {
    String input;
    
    /**
     * Called in this way from Controller when reading Birthdate input during Registration: 
     *          aModel.setReader(new GUIReader(jTextField1.getText()));         //Reads GUIReader into Model
     *          aModel.readData();                                              //Reads data into Model from GUIReader
     *          aModel.processBirthdate();                                      //Processes data
     *          aPanel.repaint();                                               //Updates View
     * This will read the User input String into GUIReader
     * @param input 
     */
    public ReadGUIData(String input) {
        this.input = input;
    }
    
    @Override
    public String getData() {
        return this.input;
    }
    
}

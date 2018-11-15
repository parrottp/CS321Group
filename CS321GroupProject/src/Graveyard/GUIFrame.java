/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graveyard;

import Model.Model;
import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.border.EtchedBorder;

/**
 *
 * @author noahe
 */
public class GUIFrame extends JFrame {
    Model aModel =new Model();
    View viewer = new View(aModel);
    Controller controller = new Controller(aModel,viewer);
    
    
    public GUIFrame(){
        super("MVCPassive");
        setSize(1000,1000);
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        EtchedBorder eb = new EtchedBorder (EtchedBorder.LOWERED);
        viewer.setBorder(eb);
        controller.setBorder(eb);
        c.add(viewer,BorderLayout.CENTER);
        c.add(controller, BorderLayout.WEST);
        setVisible(true);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

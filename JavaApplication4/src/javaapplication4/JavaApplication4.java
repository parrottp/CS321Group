/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

/**
 *
 * @author parro
 */
public class JavaApplication4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int i = 0;
        int n = 6;
        int ct = 0;
        double sum = 0.0;
        int a[] = {1,2,3,4,5,-1};
        
        g100:
        while (true){
            
            if (i >= n) break;
          
            i++;
            
            if (a[i] < 0) ;
            
            ct = ct + 1;
            sum = sum + a[i];
        }
        
    }
    
}

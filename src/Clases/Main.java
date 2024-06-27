/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Interfaces.Ventana1;

/**
 *
 * @author veronicaluna
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Ventana1 v1 = new Ventana1();
        v1.setVisible(true);
        char ch = '}';

        // Creating a new variable of type int
        // and assigning the character value.
        int ascii = (int) ch;

        /* Java stores the ascii value there itself*/

        // Printing the ASCII value of above character
        //System.out.println("The ASCII value of " + ch
                           //+ " is: " + ascii);
        
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package constraintprogramming;

import java.util.List;

/**
 *
 * @author Antoine
 */
public class ConstraintProgramming {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
//        EX1
//        List twoPlusTwo = new TwoPlusTwo().solve();
//        
//        System.out.println(twoPlusTwo.toString());

        MagicSquares a = new MagicSquares(3);
        
        a.solve();

    }

}

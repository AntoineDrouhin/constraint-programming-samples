/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package constraintprogramming;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Antoine
 */
public class TwoPlusTwo {
    
    int nbVar = 6;
    int t, w, o, u, f, r = 0;
    
    int variables[] = {t, w, o, u, f, r};
    
    public List solve(){
        
        List<String> result = new ArrayList();
        
        int maxCount = (int) Math.pow(10,nbVar);
        
        for(int i = 0; i < maxCount; i++){
            
            //INCREMENT
            int j = 0;
            for(j=0; j < variables.length; j++){
                variables[j] = i / (int) Math.pow(10,j) % 10;
            } 
            
            int twoPlusTwo = 2 * (
                    variables[0] * 100 +
                    variables[1] * 10 +
                    variables[2]
                );
            
            int four = 
                    variables[4] * 1000 +
                    variables[2] * 100 +
                    variables[3] * 10 +
                    variables[5];
            
            if (four == twoPlusTwo) {
                String resItem = "[" + variables[0]
                        + ", " + variables[1]
                        + ", " + variables[2]
                        + ", " + variables[3]
                        + ", " + variables[4]
                        + ", " + variables[5]
                        + "]\n";
                
                result.add(resItem);
            }
        }

        return result;
    }
    
    
    
}

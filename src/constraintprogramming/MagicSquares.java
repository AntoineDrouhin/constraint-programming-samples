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
public class MagicSquares {

        int magicConstant;
        int maxValue;
        int minValue;
        int startSize;
        int [][] square;
        int side;
        
        int countIterations;
    
    public MagicSquares(int size){
        this.side = size;
        this.startSize = size * size;
        this.magicConstant = size * (size * size + 1) / 2;        
        this.maxValue = size * size;
        this.minValue = 1;
        countIterations = 0;
    }
    
    public void solve(){
        List<Integer> forbiden = new ArrayList();
        System.out.println();
//        System.out.println(findPossibilities(startSize, forbiden));
        System.out.println(
                verify(
                        findPossibilities(startSize, forbiden)
                )
            );
    }
    
    public List<int[]> verify(List<int[]> possibilities){
        
        List<int[]> result = new ArrayList();
        for(int possibilityId = 0 ; possibilityId < possibilities.size(); possibilityId++){
            int[] possibility = possibilities.get(possibilityId);
            int sum = 0;
            
            for(int i = 0; i < side; i++){
                sum += possibility[i];
            }

            //lignes
            
            //colonnes
            
            //diagonales
            
            
            //ajouter le probleme
            // retour a la casba
            
            
        }
        
        //sommer les lignes
        // sommer les diagonales
        
        return new ArrayList<int[]>();
    }
    
    
    
    public List<int[]> findPossibilities(int size, List<Integer> forbiden) {
        countIterations++;
        List<int[]> result = new ArrayList();
        List<Integer> tmpForbiden = new ArrayList();
        
        if (size == 1) {
            
            for(int i = 1; i <= maxValue; i++){
                
                  boolean error = false;
        
                // Check for forbiden value
                for(int j = 0; j < forbiden.size(); j++){
                    if (i == forbiden.get(j)) {
                        error = true;
                        break;
                    }
                }

                if(error) {
                    continue;
                }
                
                int[] res = {i};
                result.add(res);
            }
            return result;
        }
        
        for(int i = 1; i <= maxValue; i++){
            
            boolean error = false;
        
            // Check for forbiden value
            for(int j = 0; j < forbiden.size(); j++){
                if (i == forbiden.get(j)) {
                    error = true;
                    break;
                }
            }
            
            if(error) {
                continue;
            }
            
            // Set the forbiden list
            tmpForbiden.clear();
            tmpForbiden.addAll(forbiden);
            tmpForbiden.add(i);
            
            List<int[]> tmpRes = findPossibilities(size - 1, tmpForbiden);
            
            for (int[] res : tmpRes) {
                int[] tmpArray = {i};  
                result.add(this.concatArray(tmpArray, res));
            }
        }
        
        return result;
    }
    
    
    
    public int[] concatArray(int[] arr1, int[] arr2){
        int totalLength = arr1.length + arr2.length;
        int[] result = new int[totalLength];
        
        System.arraycopy(arr1, 0, result, 0, arr1.length);
        
        for(int i = arr1.length; i < totalLength; i++) {
            result[i] = arr2[i - arr1.length];
        }
        
        return result;
    }
    
    
}

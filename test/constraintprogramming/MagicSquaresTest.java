/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package constraintprogramming;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Antoine
 */
public class MagicSquaresTest {
    
    public MagicSquaresTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of solve method, of class MagicSquares.
     */
    @Test
    public void testSolve() {
        System.out.println("solve");
        MagicSquares instance = null;
        instance.solve();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findPossibilities method, of class MagicSquares.
     */
    @Test
    public void testFindPossibilities() {
        System.out.println("findPossibilities");
        int size = 2;
        List<Integer> forbiden = new ArrayList();
        forbiden.add(2);
        MagicSquares instance = new MagicSquares(3);
        List expResult = null;
        List<int[]> result = instance.findPossibilities(size, forbiden);
        for(int i = 0; i < result.size(); i++){
            System.out.println("New sol");
            for (int j = 0; j < result.get(i).length; j++){
                System.out.println("i : " + i + " ; j: " +j + " ; size: " + result.get(i).length);
                System.out.println(result.get(i)[j]);
            }
        }
        assertEquals(expResult, result);
    }

    /**
     * Test of concatArray method, of class MagicSquares.
     */
    @Test
    public void testConcatArray() {
        System.out.println("concatArray");
        int[] arr1 = {1,2,3};
        int[] arr2 = {4,5};
        MagicSquares instance = new MagicSquares(1);
        int[] expResult = {1, 2, 3, 4, 5};
        int[] result = instance.concatArray(arr1, arr2);
        assertArrayEquals(expResult, result);
    }
    
}

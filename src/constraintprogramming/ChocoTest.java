/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package constraintprogramming;

import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solution;
import org.chocosolver.solver.Solver;
import org.chocosolver.solver.constraints.nary.automata.FA.FiniteAutomaton;
import org.chocosolver.solver.search.strategy.Search;
import org.chocosolver.solver.variables.IntVar;

/**
 *
 * @author oscaramzalag
 */
public class ChocoTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //twoTwoFour();
        //SendMoreMoney();
        //piece();
        //dames();
        //carree();
        //decomposition();
        oneZeroOne();
        
    }
    
    public static void twoTwoFour() {
        Model model = new Model("TWO+TWO=FOUR");
        IntVar T = model.intVar("T", 1, 9); // T != 0
        IntVar W = model.intVar("W", 0, 9);
        IntVar O = model.intVar("O", 0, 9);
        IntVar F = model.intVar("F", 1, 9); // F != 0
        IntVar U = model.intVar("U", 0, 9);
        IntVar R = model.intVar("R", 0, 9);
        model.allDifferent(T, W, O, F, U, R).post();
        IntVar[] vars = new IntVar[]{
                       T, W, O,
                       T, W, O,
                    F, O, U, R};
        int[] coeffs = new int[]{
                                100, 10, 1,
                                100, 10, 1,
                        -1000, -100, -10, -1};
        model.scalar(vars, coeffs, "=", 0).post();
        
        Solver solver = model.getSolver();
        
        // one solution
        for (Solution s : solver.findAllSolutions()) {
            System.out.println(s);
        }

    }
        
    public static void SendMoreMoney() {
        
        Model model = new Model("SEND+MORE=MONEY");
        IntVar S = model.intVar("S", 1, 9); 
        IntVar E = model.intVar("E", 0, 9);
        IntVar N = model.intVar("N", 0, 9);
        IntVar D = model.intVar("D", 0, 9); 
        IntVar M = model.intVar("M", 1, 9);
        IntVar O = model.intVar("O", 0, 9);
        IntVar R = model.intVar("R", 0, 9);
        IntVar Y = model.intVar("Y", 0, 9);

        model.allDifferent(S, E, N, D, M, O, R, Y).post();
        IntVar[] vars = new IntVar[]{
                       S, E, N, D,
                       M, O, R, E,
                    M, O, N, E, Y};
        int[] coeffs = new int[]{
                                1000, 100, 10, 1,
                                1000, 100, 10, 1,
                        -10000, -1000, -100, -10, -1};
        model.scalar(vars, coeffs, "=", 0).post();
        
        Solver solver = model.getSolver();
        
        // one solution
        for (Solution s : solver.findAllSolutions()) {
            System.out.println(s);
        }
        
    }
    
    public static void piece() {
        
        int N = 100;
        int A = 200;
        int D = 125;
        
        Model model = new Model("");
        
        
        IntVar C200 = model.intVar("C200", 0, N);
        IntVar C100 = model.intVar("C100", 0, N);
        IntVar C50 = model.intVar("C50", 0, N);
        IntVar C20 = model.intVar("C20", 0, N); 
        IntVar C10 = model.intVar("C10", 0, N);
        IntVar C5 = model.intVar("C5", 0, N);
        
        
        
        IntVar[] vars = new IntVar[]{
            C200, C100, C50, C20, C10, C5
        };
        
        int[] coeffs = new int[]{
            200, 100, 50, 20, 10, 5
        };
        
        Solver solver = model.getSolver();      
        model.scalar(vars, coeffs, "=", A-D).post();
        
        for (Solution s : solver.findAllSolutions()) {
            System.out.println(s);
        }
    }
    
    
    public static void oneZeroOne(){
        
        int N = 7;
        
         Model model = new Model("");
        
        IntVar UNUN = model.intVar("1", 0, N);
        IntVar UNDEUX = model.intVar("1", 0, N);
        IntVar DEUXUN = model.intVar("2", 0, N);
        IntVar DEUXDEUX = model.intVar("2", 0, N); 
        IntVar TROISUN = model.intVar("3", 0, N);
        IntVar TROISDEUX = model.intVar("3", 0, N);
        IntVar QUATREUN = model.intVar("4", 0, N);
        IntVar QUATREDEUX = model.intVar("4", 0, N);
       
        model.allDifferent(UNUN, UNDEUX, DEUXUN, DEUXDEUX, TROISUN,
                TROISDEUX, QUATREUN, QUATREDEUX).post();
        
        IntVar[] vars = {
            UNDEUX, UNUN
        };
        
        int[] coeffs = new int[]{
            1,-1
        };
        
        IntVar[] vars2 = {
            DEUXUN, DEUXDEUX
        };
        
        IntVar[] vars3 = {
            TROISUN, TROISDEUX
        };
        
        IntVar[] vars4 = {
            QUATREUN, QUATREDEUX
        };
        
        Solver solver = model.getSolver();      
        model.scalar(vars, coeffs, "=", 2 ).post();
        model.scalar(vars2, coeffs, "=", 3 ).post();
        model.scalar(vars3, coeffs, "=", 4 ).post();
        model.scalar(vars4, coeffs, "=", 5 ).post();
        
        for (Solution s : solver.findAllSolutions()) {
            System.out.println(s);
        }
    }
    
        
    public static void dames() {
        
        Model model = new Model("");
        
        int N = 100;
        
        IntVar X[] = model.intVarArray("X", N, 1, N);
      
        
        model.allDifferent(X).post();
        
        for (int i = 0; i < X.length; i++) {
            for (int j = i+1; j < X.length; j++) {
                model.arithm(X[i], "!=", X[j], "+", j-i).post();
                model.arithm(X[i], "!=", X[j], "-", j-i).post();
            }
        }
        
        Solver solver = model.getSolver();
        solver.showStatistics();
        
        
        int count = 0;
        Solution solution;
        while ((solution = solver.findSolution()) != null) {
            System.out.println(solution);
            count++;
            break;
        }
        System.out.println(count);
            
        
    }
    
     public static void carree() {
        
        Model model = new Model("");
        
        int N = 4;
        
        IntVar X[] = model.intVarArray("X", N*N, 1, N*N);
      
        
        model.allDifferent(X).post();
        
        int S = N*(N*N+1)/2;
        
        IntVar[] D1 = new IntVar[N];
        IntVar[] D2 = new IntVar[N];
            
        for (int i=0; i<N; i++){
            IntVar[] L = new IntVar[N];
            IntVar[] C = new IntVar[N];
            
            for (int j=0; j<N; j++){
                L[j] = X[i*N+j];
                C[j] = X[j*N+i];
            }
            
            model.sum(L, "=", S).post();
            model.sum(C, "=", S).post();
            
            D1[i] = X[i*N+i];
            D2[i] = X[i*N+N-i-1];
        }
        
        model.sum(D1, "=", S).post();
        model.sum(D2, "=", S).post();
        
        Solver solver = model.getSolver();
        
        Solution s = solver.findSolution(); 
        for (int i=0; i<N; i++){
            for (int j=0; j<N; j++){
                System.out.printf("%4d", X[i*N+j].getValue());
            }
            System.out.println();
        }
        
    }
     
    public static void decomposition() {
         
        Model model = new Model("");
        
        int N = 10;
        
        IntVar X[] = model.intVarArray("X", N, 0, N);
        
        model.sum(X, "=", N).post();
        model.regular(X, new FiniteAutomaton("[1-N]+0*")).post();
        
        
        Solver solver = model.getSolver();
        
        int i = 0;
        for (Solution s : solver.findAllSolutions()) {
            System.out.println(s);
            i++;
        }
        System.out.println("Il y'a "+i+" solution(s) !");
         
         
    }
       
        
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package constraintprogramming;

import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solver;
import org.chocosolver.solver.variables.IntVar;

public class SendMoreMoney {

    public void solve() {
        Model model = new Model("TWO+TWO=FOUR");
        IntVar S = model.intVar("S", 1, 9);  // T != 0
        IntVar E = model.intVar("E", 0, 9);
        IntVar N = model.intVar("N", 0, 9);
        IntVar D = model.intVar("D", 1, 9);  // F != 0
        IntVar M = model.intVar("M", 0, 9);
        IntVar O = model.intVar("O", 0, 9);
        IntVar R = model.intVar("R", 0, 9);
        IntVar Y = model.intVar("Y", 0, 9);
        model.allDifferent(S, E, N, D, M, O, R, Y)
                .post();
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
        System.out.println(solver.findAllSolutions());

    }

}

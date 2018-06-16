/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package constraintprogramming;

import org.chocosolver.solver.Model;
import org.chocosolver.solver.constraints.nary.automata.FA.FiniteAutomaton;
import org.chocosolver.solver.variables.IntVar;
import org.chocosolver.solver.Solver;

/**
 *
 * @author Antoine
 */
public class Decomposition {

    public static void solve(String[] args) {
        int n = 4;
        int i;

        IntVar[] vars;

        Model model = new Model("Regualr");
        vars = model.intVarArray(n, 0, n);

        model.regular(vars, new FiniteAutomaton("[1-" + n + "]+0*")).post();
        model.sum(vars, "+", n).post();
        Solver solver = model.getSolver();
        while (solver.solve()) {

            System.out.println(solver.findSolution());

        }

    }

}

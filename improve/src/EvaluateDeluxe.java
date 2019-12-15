
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.TreeMap;
import java.util.Stack;

/**
 * Created by 11981 on 2017/4/8.
 */

/******************************************************************************
 *  Compilation:  javac EvaluateDeluxe.java
 *  Execution:    java EvaluateDeluxe
 *  Dependencies: Stack.java
 *
 *  Evaluates arithmetic expressions using Dijkstra's two-stack algorithm.
 *  Handles the following binary operators: +, -, *, / and parentheses.
 *
 *  % echo "3 + 5 * 6 - 7 * ( 8 + 5 )" | java EvaluateDeluxe
 *  -58.0
 *
 *
 *  Limitiations
 *  --------------
 *    -  can easily add additional operators and precedence orders, but they
 *       must be left associative (exponentiation is right associative)
 *    -  assumes whitespace between operators (including parentheses)
 *
 *  Remarks
 *  --------------
 *    -  can eliminate second phase if we enclose input expression
 *       in parentheses (and, then, could also remove the test
 *       for whether the operator stack is empty in the inner while loop)
 *    -  see http://introcs.cs.princeton.edu/java/11precedence/ for
 *       operator precedence in Java
 *
 ******************************************************************************/
public class EvaluateDeluxe {
    public static double eval(String op, double val1, double val2){
        if (op.equals("+")) return val1 + val2;
        if (op.equals("-")) return val1 - val2;
        if (op.equals("/")) return val1 / val2;
        if (op.equals("*")) return val1 * val2;
        throw new RuntimeException("Invalid operator");
    }

    public static void main(String[] args){
        TreeMap<String, Integer> precedence = new TreeMap<String, Integer>();
        precedence.put("(", 0);
        precedence.put(")", 0);
        precedence.put("+", 1);   // + and - have lower precedence than * and /
        precedence.put("-", 1);
        precedence.put("*", 2);
        precedence.put("/", 2);

        Stack<String> ops = new Stack<>();
        Stack<Double> vals = new Stack<>();

        In in = new In(args[0]);
        while (!in.isEmpty()){
            String s = in.readString();

            // token is a value
            if (!precedence.containsKey(s)){
                vals.push(Double.parseDouble(s));
                continue;
            }

            // token is an operator
            while (true){
                // the last condition ensures that the operator with higher precedence is evaluated first
                //当遇到优先级比ops中最高优先级低的运算符时，会计算ops中高优先级的结果
                if (ops.isEmpty() || s.equals("(") || (precedence.get(s) > precedence.get(ops.peek()))){
                    ops.push(s);
                    break;
                }

                // evaluate expression
                String op = ops.pop();

                // but ignore left parentheses
                if (op.equals("(")){
                    assert s.equals(")");
                    break;
                }
                // evaluate operator and two operands and push result onto value stack
                else{
                    double val2 = vals.pop();
                    double val1 = vals.pop();
                    vals.push(eval(op, val1, val2));
                }
            }
        }

        // finished parsing string - evaluate operator and operands remaining on two stacks
        while (!ops.isEmpty()){
            String op = ops.pop();
            double val2 = vals.pop();
            double val1 = vals.pop();
            vals.push(eval(op, val1, val2));
        }

        // last value on stack is value of expression
        StdOut.println(vals.pop());
        assert vals.isEmpty();
        assert ops.isEmpty();

    }
}

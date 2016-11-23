import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by 11981 on 2016/11/20.
 * web exercise 1.3_5
 */
public class TenTransferTwo {
    public static void main(String[] args){
        Stack<Integer> s = new Stack<Integer>();
        In in = new In(args[0]);
        int n = in.readInt();
        while (n > 0){
            s.push(n%2);
            n = n/2;
        }
        while (!s.isEmpty()){
            StdOut.print(s.pop());
        }
        StdOut.println();

    }
}

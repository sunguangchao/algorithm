import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by 11981 on 2016/10/16.
 */
public class TestCompare {
    public static void main(String[] args){
        double x,y;
        x = StdIn.readDouble();
        y = StdIn.readDouble();
        StdOut.print(compare(x)&&compare(y));
    }
    public static boolean compare(double a)
    {
        if(a < 1 && a > 0)
            return true;
        else
            return false;
    }

}

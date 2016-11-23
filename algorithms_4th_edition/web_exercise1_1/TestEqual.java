import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by 11981 on 2016/10/16.
 * 编写一个程序，从命令行得到三个整数参数。如果它们相等则打印equal，否则打印not equal
 */
public class TestEqual {
    public static void main(String[] args)
    {
        int a,b,c;
        //a = b = c = 0;
        StdOut.println("Please enter three numbers:");
        a = StdIn.readInt();
        b = StdIn.readInt();
        c = StdIn.readInt();
        if(equals(a,b,c) == 1){
            StdOut.print("equal");
        }else {
            StdOut.print("not equal");
        }
    }

    public static int equals(int a,int b,int c){
        if(a == b && b == c){
            return 1;
        }else{
            return 0;
        }
    }
}

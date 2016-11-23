import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by 11981 on 2016/10/16.
 */
public class TestPritnt {
    public TestPritnt() {}
    public static void main(String[] args)
    {
        boolean[][] a = new boolean[10][10];
        a = RandomInitial(a);
        plPrint(a);
    }

    public static void plPrint(boolean[][] a)
    {
        for(int i = 0;i < a.length;i++)
        {
            StdOut.print(" "+i);
        }
        StdOut.println(" ");
        for(int i = 0;i < 10;i++)
        {
            StdOut.print(i);
            for(int j = 0;j < 10;j++){
                if(a[i][j])
                    StdOut.print("*" + " ");
                else
                    StdOut.print(" " + " ");
            }
            StdOut.println(" ");
        }

    }
    public static boolean[][] RandomInitial(boolean[][] a)
    {
        for(int i = 0;i < a.length;i++) {
            for (int j = 0; j < a.length; j++) {
                if(StdRandom.bernoulli())
                    a[i][j] = true;
                else
                    a[i][j] = false;

            }
        }
        return a;
    }
}

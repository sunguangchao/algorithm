import edu.princeton.cs.algs4.StdDraw;

/**
 * Created by 11981 on 2016/11/4.
 * web exercise 1.1_3
 */
public class RightTriangle {
    public static void main(String[] args)
    {
        StdDraw.square(.5,.5,.5);
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.line(.5, .5, .9, .5);
        //StdDraw.line(.9, .5, .5, .8);
        StdDraw.line(.5, .8, .5, .5);
        StdDraw.circle(.7, .65, .25);

    }
}

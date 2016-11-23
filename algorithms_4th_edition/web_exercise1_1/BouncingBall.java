import edu.princeton.cs.algs4.StdDraw;

/**
 * Created by 11981 on 2016/11/6.
 * web exercise 1.1_4
 */
public class BouncingBall {
    public static void main(String[] args){
        // set the scale of the coordinate system
        StdDraw.setXscale(-1.0,1.0);
        StdDraw.setYscale(-1.0,1.0);
        StdDraw.enableDoubleBuffering();
        //initial values
        double rx =0.480,ry =0.860;
        double vx =0.015,vy =0.023;
        double radius = 0.05;
        //main animation loop
        while(true)
        {
            // bounce off wall according to law of elastic collision
            if(Math.abs(rx + vx) >1.0 - radius) vx = -vx;
            if(Math.abs(ry + vy) >1.0 - radius) vy = -vy;
            //update position
            rx += vx;
            ry += vy;
            // clear the background
            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.filledSquare(0,0,1.0);
            //draw ball on the screen
            StdDraw.setPenColor(StdDraw.BLUE);
            StdDraw.filledCircle(rx,ry,radius);
            // display and pause for 20 ms
            StdDraw.show();
            StdDraw.pause(20);



        }


    }
}

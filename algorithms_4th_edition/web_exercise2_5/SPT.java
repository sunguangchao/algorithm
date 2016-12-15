import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * Created by 11981 on 2016/12/15.
 * not success
 * Dependencies: Job.java
 * web exercise 2.5_12
 */
public class SPT {
    public static  void main(String[] args)
    {
        In in = new In(args[0]);
        int n = in.readInt();
        Job[] jobs = new Job[n];
        for(int i=0; i<n; i++){
            String name = in.readString();
            double time = in.readDouble();
            jobs[i] = new Job(name, time);
        }

        Arrays.sort(jobs);

        for(int i=0; i < n; i++)
            StdOut.println(jobs[i]);

    }
}

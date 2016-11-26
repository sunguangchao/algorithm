import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;



/**
 * Created by 11981 on 2016/11/24.
 * web exercise1.3_37
 */
public class Josephus {
    public static void main(String[] args){
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        Queue<Integer> queue = new Queue<Integer>();
        for(int i = 0;i < n;i++){
            queue.enqueue(i);
        }
        while (!queue.isEmpty()){
            for(int i = 0;i < m-1;i++)
                queue.enqueue(queue.dequeue());
            StdOut.print(queue.dequeue() + " ");

        }
        StdOut.println();

    }
}

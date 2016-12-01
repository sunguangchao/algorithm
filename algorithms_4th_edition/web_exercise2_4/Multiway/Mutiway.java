import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by 11981 on 2016/12/1.
 */
public class Mutiway {
    private Mutiway(){}

    private static void merge(In[] streams){
        int n = streams.length;
        IndexMinPQ<String> pq = new IndexMinPQ<String>(n);
        for(int i=0; i < n; i++)
            if(!streams[i].isEmpty())
                pq.insert(i, streams[i].readString());

        while (!pq.isEmpty()){
            StdOut.print(pq.minKey() + " ");
            int i = pq.delMin();
            if(!streams[i].isEmpty())
                pq.insert(i, streams[i].readString());
        }
        StdOut.println();
    }

    public static void main(String[] args){
        int n = args.length;
        In[] streams = new In[n];
        for(int i=0; i < n; i++)
            streams[i] = new In(args[i]);
        merge(streams);
    }
}

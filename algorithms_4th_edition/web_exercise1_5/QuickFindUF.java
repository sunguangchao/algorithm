import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by 11981 on 2016/12/29.
 */
public class QuickFindUF {
    private int[] id;
    private int count;

    public QuickFindUF(int n){
        count = n;
        id = new int[n];
        for (int i=0; i < n; i++)
            id[i] = i;
    }
    public int count(){
        return count;
    }
    public int find(int p){
        validate(p);
        return id[p];
    }
    private void validate(int p){
        int n = id.length;
        if (p < 0 || p >= n){
            throw new IndexOutOfBoundsException("index " + p + " is not between 0 and " + (n-1));
        }
    }
    public boolean connected(int p,int q){
        validate(p);
        validate(q);
        return id[p] == id[q];
    }

    public void union(int p, int q){
        validate(p);
        validate(q);
        int pID = id[p];
        int qID = id[q];
        if (pID == qID) return;
        for (int i=0; i < id.length; i++)
            if (id[i] == pID) id[i] = qID;
        count--;
    }

    public static void main(String[] args){
        In in = new In(args[0]);
        int n = in.readInt();
        QuickFindUF uf = new QuickFindUF(n);
        while (!in.isEmpty()){
            int p = in.readInt();
            int q = in.readInt();
            if (uf.connected(p,q)) continue;
            uf.union(p,q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count() + " components");
    }


}

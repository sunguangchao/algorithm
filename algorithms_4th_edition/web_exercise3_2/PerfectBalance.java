import edu.princeton.cs.algs4.BST;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * Created by 11981 on 2016/12/28.
 */
public class PerfectBalance{
    private static void perfect(BST bst, String[] a)
    {
        Arrays.sort(a);
        perfect(bst, a, 0, a.length-1);
        StdOut.println();
    }
    private static void perfect(BST bst, String[] a, int lo, int hi){
        if (hi < lo)return;
        int mid = lo + (hi-lo)/2;
        bst.put(a[mid],mid);
        StdOut.print(a[mid] + " ");
        perfect(bst, a, lo, mid-1);
        perfect(bst, a,mid+1, hi);
    }

    public static void main(String[] args){
        In in = new In(args[0]);
        String[] words = in.readAllStrings();
        BST<String,Integer> bst = new BST<String,Integer>();
        perfect(bst,words);

    }



}

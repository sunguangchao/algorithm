import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by 11981 on 2016/12/6.
 */
public class Quick3way {

    private Quick3way(){}

    private static void sort(Comparable[] a){
        StdRandom.shuffle(a);
        sort(a, 0, a.length-1);
        assert isSorted(a);
    }

    private static void sort(Comparable[] a, int lo, int hi){
        if(hi <= lo)return;
        int lt = lo, gt = hi;
        Comparable v = a[lo];
        int i = lo;
        while (i<gt){
            int cmp = a[i].compareTo(v);
            if     (cmp < 0) exch(a, lt++, i++);
            else if(cmp > 0) exch(a , i, gt--);
            else i++;
        }
        sort(a, lo, lt-1);
        sort(a, gt+1, hi);
        assert isSorted(a, lo, hi);
    }
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    // exchange a[i] and a[j]
    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }


    /***************************************************************************
     *  Check if array is sorted - useful for debugging.
     ***************************************************************************/
    private static boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }

    private static void show(Comparable[] a){
        for(int i = 0; i< a.length-1; i++)
            StdOut.println(a[i]);
    }

    public static void main(String[] args){
        In in = new In(args[0]);
        String[] a = in.readAllStrings();
        Quick3way.sort(a);
        show(a);
    }


}

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by 11981 on 2016/12/6.
 */
public class Quick {

    private Quick(){}
    public static void sort(Comparable[] a){
        StdRandom.shuffle(a);//随机打乱一个数组的顺序
        sort(a, 0, a.length-1);
        assert isSorted(a);
    }

    private static void sort(Comparable[] a, int lo, int hi){
        if(hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
        assert isSorted(a, lo, hi);

    }

    private static int partition(Comparable[] a, int lo, int hi){
        int i = lo;
        int j = hi+1;
        Comparable v = a[lo];
        while (true){
            while (less(a[++i], v))
                if(i == hi) break;
            while (less(v, a[--j]))
                if(j == lo) break;
            if(i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    public static Comparable select(Comparable[] a, int k){
        if(k < 0 || k > a.length){
            throw new IndexOutOfBoundsException("Selected element out of bounds");
        }
        StdRandom.shuffle(a);
        int lo = 0, hi = a.length-1;
        while (hi > lo){
            int i = partition(a, lo, hi);
            if     (i > k) hi = i-1;
            else if(i < k) lo = i+1;
            else return a[i];
        }
        return a[lo];
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

    private static boolean isSorted(Comparable[] a){
        return isSorted(a, 0, a.length-1);
    }
    private static boolean isSorted(Comparable[] a, int lo, int hi){
        for(int i = lo; i <= hi; i++){
            if(less(a[i], a[i-1])) return false;
        }
        return true;
    }
    private static void show(Comparable[] a){
        for(int i=0; i < a.length; i++){
            StdOut.println(a[i]);
        }
    }

    public static void main(String[] args){
        In in = new In(args[0]);
        String[] a = in.readAllStrings();
        Quick.sort(a);
        show(a);
        assert isSorted(a);

        StdRandom.shuffle(a);

        StdOut.println();
        for(int i=0; i < a.length; i++){
            String ith = (String) Quick.select(a, i);
            StdOut.println(ith);
        }
    }
}

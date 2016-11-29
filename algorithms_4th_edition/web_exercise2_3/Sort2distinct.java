import edu.princeton.cs.algs4.StdOut;

import java.awt.event.ComponentAdapter;
import java.util.Comparator;
import java.util.ConcurrentModificationException;

/**
 * Created by 11981 on 2016/11/29.
 */
public class Sort2distinct {
    public static void sort(Comparable[] a){
        int lt = 0, gt = a.length - 1;
        int i = 0;
        while (i <= gt){//三向切分快速排序
            int cmp = a[i].compareTo(a[lt]);
            if     (cmp < 0)      exch(a, lt++, i++);
            else if(cmp > 0)      exch(a, i, gt--);
            else i++;
        }
    }
    public  static void exch(Comparable[] a, int i, int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args){
        String s = args[0];
        int n = s.length();
        String[] a = new String[n];
        for(int i=0; i < n;i++)
            a[i] = s.substring(i,i+1);
        sort(a);
        for(int i=0; i < n; i++)
            StdOut.print(a[i]);
        StdOut.println();
    }
}

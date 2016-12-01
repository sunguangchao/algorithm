import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Comparator;

/**
 * Created by 11981 on 2016/11/30.
 */
public class MergeX {
    private static final int CUTOFF = 7;

    // This class should not be instantiated.
    private MergeX() {
    }

    private static void merge(Comparable[] src, Comparable[] dst, int lo, int mid, int hi) {
        // precondition: src[lo .. mid] and src[mid+1 .. hi] are sorted subarrays
        assert isSorted(src, lo, mid);
        assert isSorted(src, mid + 1, hi);

        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if      (i > mid)             dst[k] = src[j++];
            else if (j > hi)              dst[k] = src[i++];
            else if (less(src[j], src[i])) dst[k] = src[j++];   // to ensure stability
	    else                          dst[k] = src[i++];
        }
        // postcondition: dst[lo .. hi] is sorted subarray
        assert isSorted(dst, lo, hi);

    }

    private static void sort(Comparable[] src, Comparable[] dst, int lo, int hi) {
        // if (hi <= lo) return;
        if (hi <= lo + CUTOFF) {
            insertionSort(dst, lo, hi);
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(dst, src, lo, mid);
        sort(dst, src, mid + 1, hi);
        // if (!less(src[mid+1], src[mid])) {
        //    for (int i = lo; i <= hi; i++) dst[i] = src[i];
        //    return;
        // }

        // using System.arraycopy() is a bit faster than the above loop
        if (!less(src[mid + 1], src[mid])) {
            System.arraycopy(src, lo, dst, lo, hi - lo + 1);
            return;
        }
        merge(src, dst, lo, mid, hi);
    }

    public static void sort(Comparable[] a) {
        Comparable[] aux = a.clone(); //不将元素复制到辅助数组，sort()会多一个数组的参数
        sort(aux, a, 0, a.length - 1);
        assert isSorted(a);
    }

    // sort from a[lo] to a[hi] using insertion sort
    private static void insertionSort(Comparable[] a, int lo, int hi) {
        for (int i = lo; i <= hi; i++)
            for (int j = i; j > lo && less(a[j], a[j - 1]); j--)
                exch(a, j, j - 1);
    }

    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private static boolean less(Object a, Object b, Comparator comparator) {
        return comparator.compare(a, b) < 0;
    }

    public static void sort(Object[] a, Comparator comparator) {
        Object[] aux = a.clone();
        sort(aux, a, 0, a.length - 1, comparator);
        assert isSorted(a, comparator);
    }

    private static void merge(Object[] src, Object[] dst, int lo, int mid, int hi, Comparator comparator) {
        // precondition: src[lo .. mid] and src[mid+1 .. hi] are sorted subarrays
        assert isSorted(src, lo, mid, comparator);
        assert isSorted(src, mid + 1, hi, comparator);

        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if      (i > mid)                         dst[k] = src[j++];
            else if (j > hi)                          dst[k] = src[i++];
            else if (less(src[j], src[i],comparator)) dst[k] = src[j++];
            else                                      dst[k] = src[i++];
        }
        // postcondition: dst[lo .. hi] is sorted subarray
        assert isSorted(dst, lo, hi, comparator);
    }

    private static void sort(Object[] src, Object[] dst, int lo, int hi, Comparator comparator) {
        // if (hi <= lo) return;
        if (hi <= lo + CUTOFF) {
            insertionSort(dst, lo, hi, comparator);
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(dst, src, lo, mid, comparator);
        sort(dst, src, mid + 1, hi, comparator);

        // using System.arraycopy() is a bit faster than the above loop
        if (!less(src[mid + 1], src[mid], comparator)) {
            System.arraycopy(src, lo, dst, lo, hi - lo + 1);
            return;
        }
        merge(src, dst, lo, mid, hi, comparator);
    }

    // sort from a[lo] to a[hi] using insertion sort
    private static void insertionSort(Object[] a, int lo, int hi, Comparator comparator) {
        for (int i = lo; i <= hi; i++) //  <=
            for (int j = i; j > lo && less(a[j], a[j - 1], comparator); j--)
                exch(a, j, j - 1);
    }

    private static boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i - 1])) return false;
        return true;
    }

    private static boolean isSorted(Object[] a, Comparator comparator) {
        return isSorted(a, 0, a.length - 1, comparator);
    }

    private static boolean isSorted(Object[] a, int lo, int hi, Comparator comparator) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i - 1], comparator)) return false;
        return true;
    }

    private static void show(Object[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.println(a[i]);
        }
    }

    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        MergeX.sort(a);
        show(a);

    }
}

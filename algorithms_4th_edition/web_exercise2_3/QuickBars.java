import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by 11981 on 2016/11/30.
 */
public class QuickBars {
    private static int rows;
    private static int row = 0;
    private static final int VERTICAL = 70;
    private static final int CUTOFF = 8;

    private static int partition(double[] a, int lo, int hi){
        int i = lo;
        int j = hi + 1;
        double v = a[lo];
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

    public static void sort(double[] a){
        show(a, 0, 0, -1, a.length-1);
        sort(a, 0, a.length-1);
        show(a, 0, 0, -1, a.length-1);
    }
    private static void sort(double[] a, int lo, int hi){
        int n = hi - lo + 1;
        if(n <= CUTOFF){
            insertionSort(a, lo, hi);
            return;
        }
        int m = median3(a, lo, lo + n/2,hi);
        exch(a, m, lo);

        int j = partition(a, lo, hi);
        show(a, lo, j, j, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }

    private static void insertionSort(double[] a, int lo, int hi){
        for(int i=lo; i<=hi; i++)
            for(int j=i;j > lo && less(a[j], a[j-1]); j--)
                exch(a, j, j-1);
    }

    private static int median3(double[] a, int i, int j, int k){
        return (less(a[i],a[j]) ?
                (less(a[j], a[k]) ? j : less(a[i], a[k]) ? k:i):
                (less(a[k], a[j]) ? j : less(a[k], a[i]) ? k:i));
    }
    private static boolean less(double v,double w){
        return v < w;
    }
    private static void exch(double[] a, int i, int j){
        double t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    private static void show(double[] a,int lo, int lt, int gt, int hi){
        double y = rows - row - 1;
        for(int k = 0; k < a.length; k++){
            if (k < lo) StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
            else if(k > hi)StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
            else if(k >=lt && k <= gt) StdDraw.setPenColor(StdDraw.BOOK_RED);
            else  StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.filledRectangle(k, y + a[k] * 0.25, 0.25, a[k]*0.25);
        }
        row++;
    }
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        double[] a = new double[n];
        double[] b = new double[n];
        for (int i = 0; i < n; i++) {
            a[i] = (1 + StdRandom.uniform(m)) / (double) m;
            b[i] = a[i];
        }

        StdDraw.enableDoubleBuffering();

        // precompute the number of rows
        rows = 0;
        sort(b);
        rows = row;
        row = 0;
        StdDraw.clear();

        StdDraw.setCanvasSize(800, rows * VERTICAL);
        StdDraw.show();
        StdDraw.square(0.5, 0.5, 0.5);
        StdDraw.setXscale(-1, n);
        StdDraw.setYscale(-0.5, rows);
        StdDraw.show();
        sort(a);
        StdDraw.show();
    }
}

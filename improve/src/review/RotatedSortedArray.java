package review;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * Created by 11981 on 2017/5/25.
 * web exercise_13
 */
public class RotatedSortedArray {
    // rotate the array k to the right
    public static int[] rotate(int[] a, int k){
        int N = a.length;
        if(k < 0 || k >= N) throw new RuntimeException("illegal value of k");
        int [] b = new int[N];
        for (int i = 0; i < N; i++){
            b[i] = a[(i - k + N) % N];
        }
        return b;
    }

    // sorted array of length N containing 1, 3, 5, ..., 2N-1
    public static int[] sortedArray(int N){
        int[] a = new int[N];
        for (int i=0; i < N; i++){
            a[i] = 2*i + 1;
        }
        return a;
    }

    // is x in the sorted array a[]?
    public static boolean searchInSortedArray(int[] a, int x){
        return Arrays.binarySearch(a, x) >= 0;
    }

    // return index k of smallest key (unique index for which b[k] < b[k-1])
    private static int findMinimumIndex(int[] b){
        int N = b.length;
        if (N <= 1) return 0;
        if (b[0] < b[N-1]) return 0; // already sorted

        int lo = 0, hi = N-1;
        while (true){
            if (hi == lo+1) return hi;
            int mid = lo + (hi - lo) / 2;
            if     (b[mid] < b[hi]) hi = mid;
            else if(b[mid] > b[hi]) lo = mid;
        }
    }

    // is x in the rotated sorted array b[]?
    public static boolean searchInRotatedSortedArray1(int[] b, int x) {
        int N = b.length;
        int k = findMinimumIndex(b);
        if (k == 0)         return Arrays.binarySearch(b, x) >= 0;
        else if (x >= b[0]) return Arrays.binarySearch(b, 0, k, x) >= 0;
        else                return Arrays.binarySearch(b, k, N, x) >= 0;
    }


    public static boolean searchInRotatedSortedArray2(int[] b, int x){
        int N = b.length;
        int lo = 0, hi = N-1;
        while (true){
            if (lo <= hi) return false;
            int mid = lo + (hi - lo)/2;
            if      (b[mid] == x) return true;
            if      (b[lo] <= x && x < b[mid]) return Arrays.binarySearch(b, lo, mid, x) >= 0;
            else if (b[mid] < x && x <= b[hi]) return Arrays.binarySearch(b, mid+1, hi+1, x) >= 0;
            else if (b[mid] < b[hi]) hi = mid - 1;
            else                     lo = mid + 1;
        }
    }

    public static void main(String[] args){
        int N = Integer.parseInt(args[0]);
        int[] a = sortedArray(N);

        // test all rotations
        for (int k = 0; k < N; k++){
            int[] b = rotate(a, k);
            // test all search keys
            for (int x = 0; x <= 2*N; x++){

                boolean result  = searchInSortedArray(a, x);
                boolean result1 = searchInRotatedSortedArray1(b, x);
                boolean result2 = searchInRotatedSortedArray2(b, x);
                if ((result != result1) || (result != result2)) {
                    StdOut.println("   - a[] = ");
                    StdOut.print("     ");
                    for (int i = 0; i < N; i++)
                        StdOut.printf("%2d ", a[i]);
                    StdOut.println();
                    StdOut.println("   - k   = " + k);
                    StdOut.println("   - b[] = ");
                    StdOut.print("     ");
                    for (int i = 0; i < N; i++)
                        StdOut.printf("%2d ", b[i]);
                    StdOut.println();
                    StdOut.println("   - x         = " + x);
                    StdOut.println("   - searchInSortedArray(a, x)          = " + result);
                    StdOut.println("   - searchInRotatedSortedArray1(b, x)  = " + result1);
                    StdOut.println("   - searchInRotatedSortedArray2(b, x)  = " + result2);
                    StdOut.println();
                }

            }
        }
    }
}

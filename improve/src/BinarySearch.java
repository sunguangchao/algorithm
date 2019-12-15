import java.util.Arrays;

/**
 * Created by 11981 on 2017/4/29.
 */
public class BinarySearch {
    public static void main(String[] args){

        int[] a = {1,3,5,7,8,9,11,21,41};
        Arrays.sort(a);
        System.out.print(BinarySearch.rank(9,a));
    }

    public static int rank(int key, int[] a){
        int lo = 0;
        int hi = a.length-1;
        while (lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }
}

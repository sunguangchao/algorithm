/**
 * Created by 11981 on 2017/4/29.
 * 面试题36：数组中的逆序对
 * 归并排序：时间复杂度O(nlogn)
 * 空间复杂度O(n)
 */
public class InversePairs {
    public static void main(String[] args){
        int[] a = {7,5,6,4};
        int result = InversePairs.inversePairs(a);
        System.out.print(result);
    }
    public static int inversePairs(int[] a){
        if (a == null)
            return 0;
        int[] copy = a.clone();
        return mergeSort(a, copy, 0, a.length-1);
    }

    private static int mergeSort(int[] a, int[] copy, int lo, int hi){
        if (lo == hi){
            copy[lo] = a[lo];
            return 0;
        }
        int mid = lo + (hi - lo) / 2;
        int left = mergeSort(copy, a, lo, mid);
        int right = mergeSort(copy, a, mid+1, hi);
        int i = mid;
        int j = hi;
        int indexCopy = hi;
        int count = 0;
        while (i >= lo && j >= mid + 1){
            if (a[i] > a[j]){
                copy[indexCopy--] = a[i--];
                count += j - mid;
            }else{
                copy[indexCopy--] = a[j--];
            }
        }

        for (; i >= lo; --i)
            copy[indexCopy--] = a[i];
        for (; j >= mid+1; --j)
            copy[indexCopy--] = a[j];

        return left + right + count;

    }
}

/**
 * Created by 11981 on 2017/5/6.
 * 面试题38：数字在排序数组中出现的次数
 * 思路：二分查找进行变形，找到第一个和最后一个相同的值
 */
public class NumberOfK {
    public static void main(String[] args){
        NumberOfK test = new NumberOfK();
        int array[] = {1, 2, 3, 3, 3, 3, 4, 5};
        System.out.print(test.getNumberOfK(array,3));
    }


    private int getNumberOfK(int[] a, int k){
        int number = 0;
        if (a != null){
            int first = getFirstKey(a, k, 0, a.length-1);
            int last = getLastKey(a, k, 0, a.length-1);

            if (first > -1 && last > -1)
                return last - first + 1;
        }
        return number;
    }
    private int getFirstKey(int[] a, int k, int start, int end){
        if (start > end)
            return -1;
        int mid = (start + end) / 2;
        int midData = a[mid];
        if (midData == k){
            if ((mid > 0 && a[mid-1] != k) || mid == 0){
                return mid;
            }else
                end = mid - 1;
        }else if (midData > k)
            end = mid - 1;
        else
            start = mid + 1;
        return getFirstKey(a, k, start, end);
    }

    private int getLastKey(int[] a, int k, int start, int end){
        if (start > end)
            return -1;
        int mid = (start + end) / 2;
        int midData = a[mid];
        if (midData == k){
            if ((mid < a.length-1 && a[mid+1] != k) || mid == a.length-1){
                return mid;
            }else
                start = mid + 1;
        }else if (midData > k)
            end = mid - 1;
        else
            start = mid + 1;
        return getLastKey(a, k, start, end);
    }
}

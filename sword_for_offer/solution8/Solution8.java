package solution8;

/**
 * Created by 11981 on 2018/5/16.
 * 面试题8：旋转数组的最小数字
 * 主要思想：二分法的变形
 * 复杂度：log(n)
 *
 */
public class Solution8 {
    public static int minNumberInRotateArray(int[] array){
        int low = 0;
        int high = array.length - 1;
        while (low < high){
            int mid = low + (high - low) / 2;
            if (array[mid] > array[high]){
                low = mid + 1;
            }else if (array[mid] == array[high]){
                high = high - 1;
            }else {
                high = mid;
            }
        }
        return array[low];
    }

    public static void main(String[] args) {
        int[] array = {3,4,5,6,1,2};
//        int[] array = {1,0,1,1,1};
//        int[] array = {1,2,3,4,5};
        System.out.println(minNumberInRotateArray(array));
    }
}

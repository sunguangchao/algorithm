import com.sun.org.apache.regexp.internal.RE;

/**
 * Created by 11981 on 2017/3/25.
 * 面试题14：调整数组顺序使奇数位于偶数前面
 * 思路：
 * 模拟两个指针，一个从前面开始，一个从后面开始
 * 当第一个指针指向偶数，并且第二个指针指向奇数，就交换位置。
 * 边界条件
 * 第一个指针的位置在第二个指针之后的时候结束
 */
public class ReorderArray {
    public static void main(String[] args){
        int[] array = {1,2,3,4,5,6,7};
        ReorderArray reorderArray = new ReorderArray();
        reorderArray.order(array);
        for (int n : array)
            System.out.print(n);

    }
    public void order(int[] array){
        if (array == null || array.length == 0)
            return;
        int start = 0;
        int end = array.length - 1;
        while (start < end){
            while (start < end && !isEven(array[start])){
                start++;
            }
            while (start < end && isEven(array[end])){
                end--;
            }
            if (start < end){
                int temp = array[start];
                array[start] = array[end];
                array[end] = temp;
            }
        }
    }
    public boolean isEven(int n){
        return n%2 == 0;
    }


}

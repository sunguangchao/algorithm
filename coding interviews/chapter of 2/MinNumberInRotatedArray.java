/**
 * Created by 11981 on 2017/3/18.
 * 面试题8：旋转数组的最小数字
 * 时间复杂度log(n)
 * 二分查找的变形
 */
public class MinNumberInRotatedArray {

    public static void main(String[] args){
        MinNumberInRotatedArray m1 = new MinNumberInRotatedArray();
        //int[] array = {3,4,5,6,1,2};
        //int[] array = {1,0,1,1,1};
        int[] array = {1,2,3,4,5};
        System.out.printf(m1.findMinNum(array).toString());
    }

    public Integer findMinNum(int[] array){
        if (array == null) return null;

        int index1 = 0;
        int index2 = array.length - 1;
        int indexMid = 0;
        while (array[index1] >= array[index2]){
            if (index2 - index1 == 1){
                indexMid = index2;
                break;
            }
            indexMid = (index1 + index2) / 2;
            if (array[index1] == array[index2] && array[indexMid] == array[index1]){
                return MinInOrder(array, index1, index2);
            }

            if (array[index1] <= array[indexMid]){
                index1 = indexMid;
            }
            else if (array[index2] >= array[indexMid]){
                index2 = indexMid;
            }

        }
        return array[indexMid];
    }

    public Integer MinInOrder(int[] array, int index1, int index2){
        int result = array[index1];
        for (int i = index1 + 1;i <= index2; i++){
            if (array[i] < result){
                result = array[i];
            }
        }
        return result;
    }
}

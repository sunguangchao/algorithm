/**
 * Created by 11981 on 2017/4/16.
 * 面试题31：连续子数组的最大和
 * 思路：如果前面的和的值小于等于0，就舍弃
 * 保存这个过程中最大的值
 */
public class GreatestSumOfSubarrays {
    public static void main(String[] args){
        int[] array = {1,-2,3,10,-4,7,2,-5};
        GreatestSumOfSubarrays g = new GreatestSumOfSubarrays();
        System.out.println(g.findGreatestSubarrays(array));
    }
    public int findGreatestSubarrays(int[] array){
        if (array == null)
            return 0;
        int currentSum = 0;
        int greatestSum = 0;
        for (int i = 0; i < array.length; i++) {
            if (currentSum <= 0) {
                currentSum = array[i];
            }else{
                currentSum += array[i];
            }
            if (greatestSum < currentSum) {
                greatestSum = currentSum;
            }
        }
        return greatestSum;

    }
}

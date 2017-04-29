/**
 * Created by 11981 on 2017/4/17.
 * 面试题29：数组中出现次数超过一半的数字
 * 思路：保存两个值：一个是数组中的值，一个是次数
 *
 */
public class MoreThanHalfNumber {
    public static void main(String[] args){
        int[] array = {1,2,3,2,2,2,5,4,2};
        MoreThanHalfNumber m = new MoreThanHalfNumber();
        System.out.println(m.moreThanHalfNum(array));
    }
    public Integer moreThanHalfNum(int[] array){
        if (array == null)
            return null;
        Integer result = null;
        int count = 0;
        for (int i=0; i < array.length; i++){
            if (count == 0) {
                result = array[i];
                count = 1;
            }else if (array[i] == result)
                count++;
            else
                count--;
        }
        if (checkMoreThanHalf(array,result))
            return result;
        else
            return null;
    }

    private boolean checkMoreThanHalf(int[] array, Integer result){
        int times = 0;
        for (int i=0; i < array.length; i++) {
            if (array[i] == result)
                times++;
        }
        if (times*2 <= array.length)
            return false;
        else
            return true;
    }
}

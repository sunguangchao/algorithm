/**
 * Created by 11981 on 2017/5/7.
 * 面试题40：数组中只出现一次的数字
 * 一个整形数组里面除了两个数字之外，其他的数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。要求时间复杂度O(n)，空间复杂度O(1)
 * 思路：用到一个原理：两个相同的数字异或之后的结果为0
 * 主要是分组，根据异或的结果找到为1的最后一位
 */
public class NumbersAppearOnce {
    public static void main(String[] args){
        NumbersAppearOnce n = new NumbersAppearOnce();
        int[] array = {2,4,3,6,3,2,5,5};
        n.findNumsAppearOnce(array);
    }
    public void findNumsAppearOnce(int[] a){
        if (a == null)
            return;
        int number = 0;
        for (int i : a)
            number ^= i;
        int index = findFirstBitIs1(number);
        int number1 = 0;
        int number2 = 0;
        for (int i : a) {
            if (isBit1(i, index))
                number1 ^= i;
            else
                number2 ^= i;
        }
        System.out.println(number1);
        System.out.println(number2);
    }
    //找到二进制中第一个为1的位置
    private int findFirstBitIs1(int number){
        int indexBit = 0;
        while ((number&1) == 0){
            number = number >> 1;
            ++indexBit;
        }
        return indexBit;
    }

    //判断number的第index位是否为1。
    private boolean isBit1(int number, int index){
        number = number>>index;
        return (number&1) == 0;
    }
}

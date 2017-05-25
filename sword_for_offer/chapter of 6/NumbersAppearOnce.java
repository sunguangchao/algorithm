/**
 * Created by 11981 on 2017/5/7.
 * 面试题40：数组中只出现一次的数字
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
    private int findFirstBitIs1(int number){
        int indexBit = 0;
        while ((number&1) == 0){
            number = number >> 1;
            ++indexBit;
        }
        return indexBit;
    }

    private boolean isBit1(int number, int index){
        number = number>>index;
        return (number&1) == 0;
    }
}

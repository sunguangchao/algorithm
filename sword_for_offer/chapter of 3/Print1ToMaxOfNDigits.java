/**
 * Created by 11981 on 2017/3/25.
 * 面试题12：打印1到最大n位数
 * ??
 */
public class Print1ToMaxOfNDigits {
    public static void main(String[] args){
        Print1ToMaxOfNDigits p = new Print1ToMaxOfNDigits();
        p.print1ToMaxOfNDigits(1);

    }

    public void print1ToMaxOfNDigits(int n){
        int [] array = new int[n];
        if (n < 0) return;
        printArray(array, 0);
    }

    private void printArray(int[] array, int n){
        for (int i = 0; i < 10; i++){
            if (n != array.length){
                array[n] = i;
                printArray(array, n+1);
            }else{
                boolean isFirstNo0 = false;
                for (int j=0; j < array.length; j++){
                    if (array[j] != 0){
                        System.out.print(array[j]);
                        if (!isFirstNo0)
                            isFirstNo0 = true;
                    }else{
                        if (isFirstNo0)
                            System.out.print(array[j]);
                    }
                }
                System.out.println();
                return;
            }
        }
    }
}

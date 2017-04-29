/**
 * Created by 11981 on 2017/4/25.
 * 面试题33：把数组排成最小的数
 */
public class SortArrayForMinNumber {
    public static void main(String[] args){
        SortArrayForMinNumber test = new SortArrayForMinNumber();
        int[] array = {3,32,321};
        test.printMinNumber(array);

    }
    public void printMinNumber(int[] array){
        int[] clone = array.clone();
        printMinNumber(clone, 0, clone.length-1);
        for (int i : clone) {
            System.out.print(i);
        }
    }
    private void printMinNumber(int[] array, int start, int end){
        if (start < end) {
            int main_number = array[end];
            int small = start;
            for (int j = start; j < end; j++) {
                if (isSmall(String.valueOf(array[j]), String.valueOf(main_number))) {
                    int temp = array[j];
                    array[j] = array[small];
                    array[small] = temp;
                    small++;
                }
            }
            array[end] = array[small];
            array[small] = main_number;
            printMinNumber(array, 0, small-1);
            printMinNumber(array, small+1, end);
        }
    }
    private boolean isSmall(String m, String n){
        String left = m + n;
        String right = n + m;
        boolean result = false;
        for (int i=0; i < left.length(); i++) {
            if (left.charAt(i) < right.charAt(i)) {
                return true;
            }else if(left.charAt(i) > right.charAt(i)){
                return false;
            }
        }
        return result;
    }
}

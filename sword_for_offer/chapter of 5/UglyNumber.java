/**
 * Created by 11981 on 2017/4/25.
 * 面试题34：丑数
 */
public class UglyNumber {
    public static void main(String[] args){

        UglyNumber test = new UglyNumber();
        System.out.println(test.getUglyNumber(5));
    }
    public int getUglyNumber(int n){

        if (n <= 0)
            return 0;
        int[] uglyArray = new int[n];
        uglyArray[0] = 1;
        int multiply2 = 1;
        int multiply3 = 1;
        int multiply5 = 1;
        for (int i=1; i <uglyArray.length; i++) {
            int temp = min(multiply2*2, multiply3*3, multiply5*5);
            uglyArray[i] = temp;

            while (multiply2*2 <= temp)
                multiply2++;//这个++不清楚意义在哪里
            while (multiply3*3 <= temp)
                multiply3++;
            while (multiply5*5 <= temp)
                multiply5++;
        }
        return uglyArray[n-1];
    }

    private int min(int i, int j, int k){
        int temp = (i<j)?i:j;
        return (temp<k)?temp:k;
    }
}

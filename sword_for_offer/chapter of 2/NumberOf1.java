/**
 * Created by 11981 on 2017/3/19.
 * 10. 二进制中1的个数
 * 位运算
 */
public class NumberOf1 {
    public static void main(String[] args){

        NumberOf1 n = new NumberOf1();
        System.out.println(n.numberOf1(9));
        System.out.println(n.numberOf1_n(123));
    }

    //此方法的二进制有几个1就循环几次
    public int numberOf1(int n){
        int count = 0;
        while (n != 0){
            count++;
            n = (n-1) & n;

        }
        return count;
    }

    //这种方法有几位二进制就循环几次
    public int numberOf1_n(int n){
        int count = 0;
        int flag = 1;
        while (flag != 0){
            if ((n & flag) != 0){
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }
}

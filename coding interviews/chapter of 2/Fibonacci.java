/**
 * Created by 11981 on 2017/3/18.
 * 面试题9：斐波那契数列
 * 时间复杂度O(n)
 *
 */
public class Fibonacci {
    public long fibonacci(int n){
        int result = 0;
        int preOne = 0;
        int preTwo = 1;
        if (n == 0){
            return preOne;
        }
        if (n == 1){
            return preTwo;
        }

        for (int i=2; i < n; i++){
            result = preOne + preTwo;
            preOne = preTwo;
            preTwo = result;
        }
        return result;
    }

    public static void main(String[] args){
        Fibonacci f = new Fibonacci();
        System.out.print(f.fibonacci(10));
    }
}

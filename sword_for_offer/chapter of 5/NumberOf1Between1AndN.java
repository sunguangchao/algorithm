/**
 * Created by 11981 on 2017/4/25.
 * 面试题32：从1到n整数中1出现的次数
 * 思路：
 */
public class NumberOf1Between1AndN {
    public static void main(String[] args){
        NumberOf1Between1AndN test = new NumberOf1Between1AndN();
        System.out.println(test.NumberOf1(21345));
    }
    public long NumberOf1(long n){
        long count = 0;
        long i = 1;
        long current = 0, before = 0, after = 0;
        while (n/i != 0) {
            current = (n / i) % 10;
            before = n / (i * 10);
            after = n - (n / i) * i;

            if (current > 1) {
                count = count + (before + 1) * i;
            }else if (current == 0) {
                count = count + before * i;
            }else if (current == 1) {
                count = count + before * i + after + 1;
            }
            i = i * 10;
        }
        return count;

    }
}

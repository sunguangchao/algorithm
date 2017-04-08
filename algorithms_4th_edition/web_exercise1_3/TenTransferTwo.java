import java.util.Scanner;

/**
 * Created by 11981 on 2017/4/6.
 * 十进制转二进制
 * 如，50转为二进制为110010
 */
public class TenTransferTwo {
    public static void main(String[] args){
        Stack<Integer> stack = new Stack<>();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        while (n > 0){
            stack.push(n%2);
            n = n/2;
        }
        while (!stack.isEmpty()){
            System.out.print(stack.pop());
        }
    }
}

import java.util.Stack;

/**
 * Created by 11981 on 2017/4/8.
 * 面试题22：栈的压入、弹出队列
 */
public class StackPushPopOrder {

    public static void main(String[] args){
        int[] array1 = {1,2,3,4,5};
        int[] array2 = {4,3,5,2,1};
        StackPushPopOrder s = new StackPushPopOrder();
        System.out.println(s.isPopOrder(array1,array2));
    }

    public boolean isPopOrder(int[] line1, int[] line2){
        if (line1 == null && line2 == null)
            return false;

        int point1 = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i=0; i < line2.length; i++){
            if (!stack.isEmpty() && stack.peek() == line2[i]){
                stack.pop();
            }else{
                if (point1 == line1.length){
                    return false;
                }else{//一开始跳到这个循环里，直到stack.peek() == line[i]
                    do {
                        stack.push(line1[point1++]);
                    }while (stack.peek() != line2[i] && point1 != line1.length);
                    if (stack.peek() == line2[i])
                        stack.pop();
                    else
                        return false;
                }
            }

        }
        return true;
    }
}

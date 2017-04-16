import java.util.Stack;

/**
 * Created by 11981 on 2017/4/4.
 * 面试题21：包含min函数的栈
 * 思路：因为要保证O(1)的时间复杂度，可以采用两个栈来实现
 * 一个正常存放，另一个专门存放最小值
 * 如果存放的值比栈顶的值小，minstack和datastack都push这个值
 * 如果存放的值大于或等于栈顶值，那么datastack正常push，而minstack
 * 则要把minstack栈顶的值重新push一般遍，因为pop的时候会取出消耗栈顶
 * 的一个值。
 */
public class MinInStack{


    public static void main(String[] args) {
        MinInStack test=new MinInStack();
        test.push(3);
        test.push(2);
        test.push(4);
        test.push(5);
        test.push(1);
        test.pop();
        System.out.println(test.min());
    }
    private Stack<Integer> minstack = new Stack<>();
    private Stack<Integer> datastack = new Stack<>();
    public void push(Integer item){
        datastack.push(item);
        if (minstack.size() == 0 || item < minstack.peek())
            minstack.push(item);
        else
            minstack.push(minstack.peek());
    }

    public Integer pop(){
        if (minstack.size() == 0 || datastack.size() == 0)
            return null;
        minstack.pop();
         return datastack.pop();
    }

    public Integer min(){
        if (minstack.size() == 0)
            return null;
        return minstack.peek();
    }

}
package solution7;

import java.util.Stack;

/**
 * Created by 11981 on 2018/5/11.
 * 面试题7：用两个栈实现队列
 */
public class Solution7 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node){
        stack1.push(node);
    }
    public int pop() throws Exception{
        //最外层这个判断一开始没有考虑到
        if (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty()){
            throw new Exception("队列为空不能删除");
        }
        return stack2.pop();
    }
}

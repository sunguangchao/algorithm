import java.util.Stack;

/**
 * Created by 11981 on 2017/3/16.
 * 面试题7：用两个栈实现队列
 */
public class QueueWithTwoStacks<T> {
    private Stack<T> stack1 = new Stack<T>();
    private Stack<T> stack2 = new Stack<T>();

    public void appendTail(T t){
        stack1.push(t);
    }

    public T deleteHead() throws Exception{
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


    public static void main(String[] args) throws Exception{
        QueueWithTwoStacks<String> st = new QueueWithTwoStacks<String>();
        st.appendTail("1");
        st.appendTail("2");
        st.appendTail("3");
        st.deleteHead();
    }
}

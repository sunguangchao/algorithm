import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.NoSuchElementException;

/**
 * Created by 11981 on 2017/4/8.
 */
public class QueueWithTwoStack<Item> {
    private Stack<Item> stack1;
    private Stack<Item> stack2;

    public QueueWithTwoStack(){
        stack1 = new Stack<Item>();
        stack2 = new Stack<Item>();
    }

    private void moveStack1ToStack2(){
        while (!stack1.isEmpty())
            stack2.push(stack1.pop());
    }

    public boolean isEmpty(){
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public int size(){
        return stack1.size() + stack2.size();
    }

    public Item peek(){
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        if (stack2.isEmpty()) moveStack1ToStack2();
        return stack2.peek();
    }

    public void enqueue(Item item){
        stack1.push(item);
    }

    public Item dequeue(){
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        if (stack2.isEmpty()) moveStack1ToStack2();
        return stack2.pop();
    }

    public static void main(String[] args){
        QueueWithTwoStack<String> q = new QueueWithTwoStack<String>();
        while (!StdIn.isEmpty()){
            String item = StdIn.readString();
            if (!item.equals("-")) q.enqueue(item);
            else if (!q.isEmpty()) StdOut.print(q.dequeue() + " ");
        }
        StdOut.println("(" + q.size() + "left on queue");
    }
}

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by 11981 on 2016/11/17.
 */
public class ResizingArrayStack<Item> implements Iterable<Item> {
   private Item[] a;
    private int n;
    public ResizingArrayStack(){
        a= (Item[])new Object[2];
        n  = 0;
    }
    public boolean isEmpty(){
        return n == 0;
    }
    public int size(){
        return n;
    }
    private void resize(int capacity){
       //将栈移动到一个大小为capacity的新数组
        assert capacity >= 0;
        Item[] temp = (Item[])new Object[capacity];
        for(int i = 0;i<n;i++){
            temp[i] = a[i];
        }
        a = temp;
    }

    public void push(Item item){
       //将元素添加到栈顶
        if(a.length == n) resize(2*a.length);
        a[n++] = item;
    }
    public Item pop(){
       //从栈顶删除元素
        if(isEmpty()) throw new NoSuchElementException("Stack underflow");
        Item item = a[n-1];
        a[n-1] = null;//避免对象游离
        n--;
        if(n>0 && n == a.length/4) resize(a.length/2);
        return item;
    }
    public Item peek(){
        if(isEmpty()) throw new NoSuchElementException("Stack underflow");
        return a[n-1];
    }
    public Iterator<Item> iterator(){
        return new ReverseArrayIterator();
    }
    private class ReverseArrayIterator implements Iterator<Item>{
        private int i;
        public ReverseArrayIterator(){
            i = n-1;
        }
        public boolean hasNext(){
            return i >= 0;
        }
        public void remove(){
            throw new UnsupportedOperationException();
        }
        public Item next(){
            if(!hasNext()) throw new NoSuchElementException();
            return a[i--];
        }
    }
    public static void main(String[] args){
        ResizingArrayStack<String> stack = new ResizingArrayStack<>();
        while(!StdIn.isEmpty()){
            String item = StdIn.readString();
            if(!item.equals("-")) stack.push(item);
            else if(!stack.isEmpty()) StdOut.print(stack.pop() + "");
        }
        StdOut.println("(" + stack.size() + "left on stack");
    }
}

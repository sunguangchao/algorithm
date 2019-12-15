import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by 11981 on 2017/3/27.
 * Queue,先进先出
 */
public class Queue<Item> implements Iterable<Item> {
    private Node<Item> first;
    private Node<Item> last;
    private int N;

    private static class Node<Item>{
        private Item item;
        private Node<Item> next;
    }

    //显式注明构造函数,初始化参数
    public Queue(){
        first = null;
        last = null;
        N = 0;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public int size(){
        return N;
    }

    public Item peek(){
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        return first.item;
    }

    //入队，从队列的末尾插入
    public void enqueue(Item item){
        Node<Item> oldlast = last;
        last = new Node<Item>();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else oldlast.next = last;
        N++;
    }

    public Item dequeue(){
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        Item item = first.item;
        first = first.next;
        if (isEmpty()) last = null;// to avoid loitering
        N--;
        return item;
    }

    public String toString(){
        StringBuilder s = new StringBuilder();
        for (Item item : this){
            s.append(item + " ");
        }
        return s.toString();
    }

    public Iterator<Item> iterator(){
        return new ListIterator<Item>(first);
    }

    private class ListIterator<Item> implements Iterator<Item>{
        private Node<Item> current;

        public ListIterator(Node<Item> first){
            current = first;
        }

        public boolean hasNext() {
            return current != null;
        }
        public void remove() {
            throw new UnsupportedOperationException();
        }
        public Item next(){
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args){
        Queue<String> queue = new Queue<>();
        In in = new In(args[0]);
        while (!in.isEmpty()){
            String item = in.readString();
            if (!item.equals("-"))
                queue.enqueue(item);
            else if(!queue.isEmpty())
                StdOut.print(queue.dequeue() + " ");
        }
        StdOut.println("(" + queue.size() + "left on queue");
    }
}

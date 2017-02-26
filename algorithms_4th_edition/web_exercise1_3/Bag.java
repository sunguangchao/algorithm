import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/*
 * Created by 11981 on 2016/10/11.
 */
public class Bag<Item> implements Iterable<Item> {
    private Node<Item> first;
    private int N;
    private static class Node<Item>{
        private Item item;
        private Node<Item> next;
    }
    public Bag(){
        first = null;
        N = 0;
    }
    public boolean isEmpty(){
        return first ==null;
    }
    public int size(){
        return N;
    }
    public void add(Item item){
        Node<Item> oldfirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldfirst;
        N++;
    }
    public Iterator<Item> iterator(){
        return new ListIterator<Item>(first);
    }
    private class ListIterator<Item> implements Iterator<Item>{
        private Node<Item> current;   //记录链表的当前结点
        public ListIterator(Node<Item> first){
            current = first;
        }
        public boolean hasNext(){
            return current != null;
        }
        public void remove(){throw new UnsupportedOperationException();}
        public Item next(){
            if(!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
    public static void main(String[] args) {
        Bag<String> bag = new Bag<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            bag.add(item);
        }

        StdOut.println("size of bag = " + bag.size());
        for (String s : bag) {
            StdOut.println(s);
        }
    }
}

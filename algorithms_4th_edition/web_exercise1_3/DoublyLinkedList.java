import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * Created by 11981 on 2017/2/28.
 */
public class DoublyLinkedList<Item> implements Iterable<Item> {
    private int n;
    private Node pre;
    private Node post;

    public DoublyLinkedList(){
        pre = new Node();
        post = new Node();
        pre.next = post;
        post.prev = pre;
    }

    private class Node{
        private Item item;
        private Node next;
        private Node prev;
    }

    public boolean isEmpty(){return n == 0;}
    public int size() {return n;}

    public void add(Item item){
        Node last = post.prev;
        Node x = new Node();
        x.item = item;
        x.next = post;
        x.prev = last;
        post.prev = x;
        last.next = x;
        n++;
    }

    public ListIterator<Item> iterator() {return new DoublyLinkedListIterator();}

    private class DoublyLinkedListIterator implements ListIterator<Item> {
        private Node current = pre.next;
        private Node lastAccessd = null;
        private int index = 0;

        public boolean hasNext() {
            return index < n;
        }

        public boolean hasPrevious() {
            return index > 0;
        }


        public int previousIndex() {
            return index - 1;
        }

        public int nextIndex() {
            return index;
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            lastAccessd = current;
            Item item = current.item;
            current = current.next;
            index++;
            return item;
        }

        public Item previous() {
            if (!hasPrevious()) throw new NoSuchElementException();
            current = current.prev;
            index--;
            lastAccessd = current;
            return current.item;
        }

        public void set(Item item) {
            if (lastAccessd == null) throw new IllegalStateException();
            lastAccessd.item = item;
        }

        public void remove() {
            if (lastAccessd == null) throw new IllegalStateException();
            Node x = lastAccessd.prev;
            Node y = lastAccessd.next;
            x.next = y;
            y.prev = x;
            n--;
            if (current == lastAccessd)
                current = y;
            else
                index--;
            lastAccessd = null;
        }

        public void add(Item item) {
            Node x = current.prev;
            Node y = new Node();
            Node z = current;
            y.item = item;
            x.next = y;
            y.next = z;
            z.prev = y;
            y.prev = x;
            n++;
            index++;
            lastAccessd = null;
        }
    }
    public String toString(){
        StringBuilder s = new StringBuilder();
        for (Item item : this)
            s.append(item + " ");
        return s.toString();
    }

    public static void main(String[] args){
        int n = Integer.parseInt(args[0]);
        // add elements 1, ..., n
        StdOut.println(n + " random integers between 0 and 99");
        DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
        for (int i = 0; i < n; i++)
            list.add(StdRandom.uniform(100));
        StdOut.println(list);
        StdOut.println();

        ListIterator<Integer> iterator = list.iterator();

        // go forwards with next() and set()
        StdOut.println("add 1 to each element via next() and set()");
        while (iterator.hasNext()) {
            int x = iterator.next();
            iterator.set(x + 1);
        }
        StdOut.println(list);
        StdOut.println();

        // go backwards with previous() and set()
        StdOut.println("multiply each element by 3 via previous() and set()");
        while (iterator.hasPrevious()) {
            int x = iterator.previous();
            iterator.set(x + x + x);
        }
        StdOut.println(list);
        StdOut.println();


        // remove all elements that are multiples of 4 via next() and remove()
        StdOut.println("remove elements that are a multiple of 4 via next() and remove()");
        while (iterator.hasNext()) {
            int x = iterator.next();
            if (x % 4 == 0) iterator.remove();
        }
        StdOut.println(list);
        StdOut.println();


        // remove all even elements via previous() and remove()
        StdOut.println("remove elements that are even via previous() and remove()");
        while (iterator.hasPrevious()) {
            int x = iterator.previous();
            if (x % 2 == 0) iterator.remove();
        }
        StdOut.println(list);
        StdOut.println();


        // add elements via next() and add()
        StdOut.println("add elements via next() and add()");
        while (iterator.hasNext()) {
            int x = iterator.next();
            iterator.add(x + 1);
        }
        StdOut.println(list);
        StdOut.println();

        // add elements via previous() and add()
        StdOut.println("add elements via previous() and add()");
        while (iterator.hasPrevious()) {
            int x = iterator.previous();
            iterator.add(x * 10);
            iterator.previous();
        }
        StdOut.println(list);
        StdOut.println();

    }



}

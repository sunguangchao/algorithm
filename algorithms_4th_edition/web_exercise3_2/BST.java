import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;
import java.util.NoSuchElementException;

/**
 * Created by 11981 on 2016/12/22.
 */
public class BST<Key extends Comparable<Key>,Value> {
    private Node root;
    private class Node{
        private Key key;
        private Value val;
        private Node left,right;
        private int size;
        public Node(Key key,Value val,int size){
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }
    public BST(){}

    public boolean isEmpty(){
        return size() == 0;
    }

    public int size(){
        return size(root);
    }
    private int size(Node x){
        if (x == null)return 0;
        else return x.size;
    }

    public boolean contains(Key key){
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }

    public Value get(Key key){
        return get(root, key);
    }
    private Value get(Node x, Key key){
        if (x == null)return null;
        int cmp = key.compareTo(x.key);
        if      (cmp < 0)return get(x.left, key);
        else if (cmp > 0)return get(x.right, key);
        else return x.val;
    }

    public void put(Key key, Value val){
        if (key == null) throw new IllegalArgumentException("first argument to put() is null");
        if (val == null) {
            delete(key);
            return;
        }
        root = put(root, key, val);
        assert check();
    }
    private Node put(Node x,Key key, Value val){
        if (x == null)return  new Node(key,val,1);
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) x.left = put(x.left,key,val);//如果被查找的键小于根结点的键，在左子树插入
        else if (cmp > 0) x.right = put(x.right,key,val);//否则在右子树插入
        else              x.val = val;
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }

    public void deleteMin(){
        if (isEmpty()) throw new NoSuchElementException("Symbol table underflow");
        root = deleteMin(root);
        assert check();
    }
    private Node deleteMin(Node x){
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left); //深入根结点的左子树直到找到一个空链接，然后将指向该结点的链接指向右子树
        x.size = size(x.left)+ size(x.right) + 1;
        return x;
    }

    public void deleteMax(){
        if (isEmpty()) throw new NoSuchElementException("Symbol table underflow");
        root = deleteMax(root);
        assert check();
    }
    private Node deleteMax(Node x){
        if (x.right == null) return x.left;
        x.right = deleteMax(x.right);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
     }

    public void delete(Key key){
         if (key == null) throw new IllegalArgumentException("argument to delete() is null");
         root = delete(root,key);
         assert check();
    }
    private Node delete(Node x,Key key){
         if (x == null) return null;
         int cmp = key.compareTo(x.key);
         if      (cmp < 0) x.left = delete(x.left,key);
         else if (cmp > 0) x.right = delete(x.right,key);
         else{
             if (x.right == null) return x.left;
             if (x.left == null) return x.right;
             Node t = x;                    //将指向即将被删除的结点的链接保存为t
             x = min(t.right);              //将x指向它的后继结点min(t.right)
             x.right = deleteMin(t.right);  //将x的右链接指向deleteMin(t.right)，也就是在删除后所有的结点仍然大于x.key的子二叉查找树
             x.left = t.left;               //将x的左链接设为t.left
         }
         x.size = size(x.left) + size(x.right) + 1;
         return x;
    }
    public Key min(){
        if (isEmpty()) throw new NoSuchElementException("called min() with empty symbol table");
        return min(root).key;
    }

    private Node min(Node x){
        if (x.left == null) return x;//根结点的左链接为空，最小键就是根结点
        else return min(x.left);     //左链接非空，最小键就是左子树中的最小键
    }
    public Key max(){
        if (isEmpty()) throw new NoSuchElementException("called min() with empty symbol table");
        return max(root).key;
    }
    private Node max(Node x){
        if (x.right == null) return x;
        else return max(x.right);
    }
    public Key floor(Key key){//小于等于key的最大键
        if (key == null) throw new IllegalArgumentException("argument to floor() is null");
        if (isEmpty()) throw new NoSuchElementException("called floor() with empty symbol table");
        Node x = floor(root,key);
        if (x == null) return null;
        else return x.key;
    }
    private Node floor(Node x,Key key){
        if (x == null) return  null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp < 0)  return floor(x.left, key); //如果给定的键小于根结点，那么floor(key)一定在左子树中
        Node t = floor(x.right, key);
        if (t != null) return t;   //如果大于根结点，可能在右子树中，也可能是根节点
        else return x;
    }

    public Key ceiling(Key key){
        if (key == null) throw new IllegalArgumentException("argument to ceiling() is null");
        if (isEmpty()) throw new NoSuchElementException("called ceiling() with empty symbol table");
        Node x = ceiling(root, key);
        if (x == null) return null;
        else return x.key;

    }
    private Node ceiling(Node x,Key key){//大于等于key的最小键
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0)return x;
        if (cmp < 0){                      //给定的key小于根结点，要看根结点左子树中有没有大于等于key的结点
            Node t = ceiling(x.left,key);
            if (t != null) return t;       //如果有，就存在于此结点的左子树中
            else return x;                 //如果没有，ceiling(key)就等于根结点
        }
        return ceiling(x.right,key);
    }

    public Key select(int k){
        if (k < 0 || k >= size()) throw new IllegalArgumentException();
        Node x = select(root, k);
        return x.key;
    }
    private Node select(Node x, int k){
        if (x == null)return null;
        int t = size(x.left); //左子树中的结点数
        if      (t > k) return select(x.left, k);
        else if (t < k) return select(x.right, k-t-1);//递归地在右子树中查找排名为(k-t-1)的键，1代表根结点
        else return x;
    }
    public int rank(Key key){
        if (key == null) throw new IllegalArgumentException("argument to rank() is null");
        return rank(key, root);
    }
    private int rank(Key key, Node x){
        if (x == null)    return 0;
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) return rank(key, x.left);
        else if (cmp > 0) return 1+size(x.left)+rank(key, x.right);
        else              return size(x.left);
    }

    public Iterable<Key> keys(){//范围查找
        return keys(min(), max());
    }
    public Iterable<Key> keys(Key lo,Key hi){
        if (lo == null) throw new IllegalArgumentException("first argument to keys() is null");
        if (hi == null) throw new IllegalArgumentException("second argument to keys() is null");

        Queue<Key> queue = new Queue<Key>();
        keys(root, queue, lo, hi);
        return queue;

    }
    private void keys(Node x, Queue<Key> queue, Key lo, Key hi){
        if (x == null) return;
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);
        if (cmplo < 0) keys(x.left, queue,lo,hi);
        if (cmplo <= 0 && cmphi >= 0) queue.enqueue(x.key);
        if (cmphi > 0) keys(x.right, queue, lo, hi);
    }

    public int size(Key lo, Key hi){
        if (lo == null) throw new IllegalArgumentException("first argument to size() is null");
        if (hi == null) throw new IllegalArgumentException("second argument to size() is null");

        if (lo.compareTo(hi) > 0)return 0;
        if (contains(hi)) return rank(hi) - rank(lo) + 1;
        else return rank(hi) - rank(lo);

    }

    public int height(){
        return height(root);
    }
    private int height(Node x){
        if (x == null) return -1;
        return 1 + Math.max(height(x.left),height(x.right));
    }

    public Iterable<Key> levelOrder(){
        Queue<Key> keys = new Queue<Key>();
        Queue<Node> queue = new Queue<Node>();
        queue.enqueue(root);
        while (!queue.isEmpty()){
            Node x = queue.dequeue();
            if (x == null) continue;
            keys.enqueue(x.key);
            queue.enqueue(x.left);
            queue.enqueue(x.right);
        }
        return keys;
    }

    private boolean check(){
        if (!isBST())            StdOut.println("Not in symmetric order");
        if (!isSizeConsistent()) StdOut.println("Subtree counts not consistent");
        if (!isRankConsistent()) StdOut.println("Ranks not consistent");
        return isBST() && isSizeConsistent() && isRankConsistent();
    }

    private boolean isBST(){
        return isBST(root, null, null);
    }

    private boolean isBST(Node x, Key min, Key max){
        if (x == null) return true;
        if (min != null && x.key.compareTo(min) <=0)return false;
        if (max != null && x.key.compareTo(max) >=0)return false;
        return isBST(x.left, min, x.key) && isBST(x.right,x.key,max);
    }

    private boolean isSizeConsistent(){
        return isSizeConsistent(root);
    }
    private boolean isSizeConsistent(Node x){
        if (x == null) return true;
        if (x.size != size(x.left) + size(x.right) + 1) return false;
        return isSizeConsistent(x.left) && isSizeConsistent(x.right);
    }

    private boolean isRankConsistent(){
        for (int i=0; i < size(); i++)
            if (i != rank(select(i))) return false;
        for (Key key : keys())
            if (key.compareTo(select(rank(key))) != 0) return false;
        return true;
    }

    public static void main(String[] args){
        BST<String, Integer> st = new BST<String, Integer>();
        In in = new In(args[0]);
        for (int i=0; !in.isEmpty(); i++){
            String key = in.readString();
            st.put(key, i);
        }

        for (String s : st.levelOrder())
            StdOut.println(s + " " + st.get(s));
        StdOut.println();
        for (String s : st.keys())
            StdOut.println(s + " " + st.get(s) );
    }

}

import edu.princeton.cs.algs4.BST;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by 11981 on 2016/12/24.
 * exceptions
 */
public class TestBST {
    public static void main(String[] args) {
        String test = "S E A R C H E X A M P L E";
        String[] keys = test.split(" ");
        int n = keys.length;
        BST<String, Integer> bst = new BST<String, Integer>();
        for (int i = 0; i < n; i++)
            bst.put(keys[i], i);
        StdOut.println("size = " + bst.size());
        StdOut.println("min = " + bst.min());
        StdOut.println("max = " + bst.max());
        StdOut.println();

        // print keys in order using allKeys()
        StdOut.println("Testing keys()");
        StdOut.println("--------------------------------");
        for (String s : bst.keys())
            StdOut.println(s + " " + bst.get(s));
        StdOut.println();

        // print keys in order using select
        StdOut.println("Testing select");
        StdOut.println("--------------------------------");
        for (int i = 0; i <= bst.size(); i++)
            StdOut.println(i + " " + bst.select(i));
        StdOut.println();

        // test rank, floor, ceiling
        StdOut.println("key rank floor ceil");
        StdOut.println("-------------------");
        for (char i = 'A'; i <= 'Z'; i++) {
            String s = i + "";
            StdOut.printf("%2s %4d %4s %4s\n", s, bst.rank(s), bst.floor(s), bst.ceiling(s));

        }
        StdOut.println();

        // test range search and range count
        String[] from = { "A", "Z", "X", "0", "B", "C" };
        String[] to   = { "Z", "A", "X", "Z", "G", "L" };
        StdOut.println("range search");
        StdOut.println("-------------------");
        for (int i=0; i < from.length; i++){
            StdOut.printf("%s-%s (%2d) : ",from[i],to[i],bst.size(from[i],to[i]));
            for (String s : bst.keys(from[i],to[i]))
                StdOut.print(s + " ");
            StdOut.println();
        }
        StdOut.println();

        //delete the smallest keys
        for(int i=0; i < bst.size()/2; i++){
            bst.deleteMin();
        }
        StdOut.println("After deleting the smallest " + bst.size()/2 + " keys");
        StdOut.println("-------------------");
        for (String s:bst.keys())
            StdOut.println(s + " " + bst.get(s));
        StdOut.println();

        while (!bst.isEmpty()){
            bst.delete(bst.select(bst.size()/2));
        }
        StdOut.println("After deleting the remaining keys");
        StdOut.println("--------------------------------");
        for (String s:bst.keys())
            StdOut.println(s + " " + bst.get(s));
        StdOut.println();

        StdOut.println("After adding back the keys");
        StdOut.println("--------------------------------");
        for (int i=0; i<n; i++)
            bst.put(keys[i],i);
        for (String s : bst.keys())
            StdOut.println(s + " " + bst.get(s));
        StdOut.println();
    }




}


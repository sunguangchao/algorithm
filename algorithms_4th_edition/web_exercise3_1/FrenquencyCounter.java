import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by 11981 on 2016/12/17.
 * error:
 * Exception in thread "main" java.lang.NumberFormatException:
 * For input string: "F:\workspace\algs4-data\leipzig1M.txt"
 */
public class FrenquencyCounter {
    private FrenquencyCounter(){}

    public static void main(String[] args){
        int distinct = 0, words = 0;
        int minlen = Integer.parseInt(args[0]);
        ST<String, Integer> st = new ST<String, Integer>();
        In in = new In(args[0]);

        while (!in.isEmpty()){
            String key = in.readString();
            if(key.length() < minlen) continue;
            words++;
            if(st.contains(key)){
                st.put(key,st.get(key) + 1);
            }else{
                st.put(key,1);
                distinct++;
            }
        }

        String max = "";
        st.put(max,0);
        for(String word : st.keys()){
            if(st.get(word) > st.get(max))
                max = word;
        }

        StdOut.println(max + " " + st.get(max));
        StdOut.println("distinct = " + distinct);
        StdOut.println("words = " + words);
    }
}

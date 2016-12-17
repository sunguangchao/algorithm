import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * Created by 11981 on 2016/12/17.
 * program arguments-F:\workspace\algs4-data\domains.txt
 */
public class Domain implements Comparable<Domain> {

    private final String[] fields;
    private final int n;

    public Domain(String name){
        fields = name.split("\\.");
        n = fields.length;
    }
    public String toString(){
        if (n == 0)return "";
        String s = fields[0];
        for(int i=1; i<n;i++)
            s = fields[i] + "." + s;
        return s;
    }

    public int compareTo(Domain that){
        for(int i=0; i < Math.min(this.n,that.n); i++){
            String s = this.fields[this.n -i -1];//负责将数组反转
            String t = that.fields[that.n -i -1];
            int c = s.compareTo(t);
            if     (c < 0)return -1;
            else if(c > 0)return +1;
        }
        return this.n - that.n;
    }

    public static void main(String[] args){
        In in = new In(args[0]);
        String[] name = in.readAllStrings();
        Domain[] domains = new Domain[name.length];
        for(int i=0; i < domains.length;i++){
            domains[i] = new Domain(name[i]);
        }
        Arrays.sort(domains);
        for(int i=0; i<domains.length; i++){
            StdOut.println(domains[i]);
        }
    }
}

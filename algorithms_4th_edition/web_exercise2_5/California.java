import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by 11981 on 2016/12/17.
 * F:\workspace\algs4-data\california-gov.txt
 */
public class California {
    public static final Comparator<String> CANDIDATE_ORDER = new CandidateComparator();

    private static class CandidateComparator implements Comparator<String>{
        private static String order = "RWQOJMVAHBSGZXNTCIEKUPDYFL";//对照排序的模板
        /*
        * 两个字符串a和b，从第一个开始比较，根据在order的顺序的值的大小来返回1或者-1
        * */
        public int compare(String a,String b){//重写compare方法
            int n = Math.min(a.length(),b.length());
            for(int i=0; i < n; i++){
                int aindex = order.indexOf(a.charAt(i));
                int bindex = order.indexOf(b.charAt(i));
                if     (aindex < bindex)return -1;
                else if(aindex > bindex)return +1;
            }
            return a.length() - b.length();//?
        }
    }
    public static void main(String[] args){
        In in = new In(args[0]);
        String[] candidates = in.readAll().toUpperCase().split("\\n+");
        int n = candidates.length;
        Arrays.sort(candidates, California.CANDIDATE_ORDER);//key
        for(int i=0; i < n; i++)
            StdOut.println(candidates[i]);
    }
}

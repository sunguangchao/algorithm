import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by 11981 on 2016/12/18.
 */
public class GPA {
    public static void main(String[] args){
        ST<String, Double> st = new ST<String,Double>();
        st.put("A",  4.00);
        st.put("B",  3.00);
        st.put("C",  2.00);
        st.put("D",  1.00);
        st.put("F",  0.00);
        st.put("A+", 4.33);
        st.put("B+", 3.33);
        st.put("C+", 2.33);
        st.put("A-", 3.67);
        st.put("B-", 2.67);

        int n = 0;
        double total = 0.0;
        In in = new In(args[0]);
        for (n=0; !in.isEmpty(); n++){
            String grade = in.readString();
            double a = st.get(grade);
            total += a;
        }
        double gpa = total/n;
        StdOut.println("GPA = " + gpa);
    }

}

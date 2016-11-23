import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;

/**
 * Created by 11981 on 2016/10/13.
 * web exercise 1.1_2
 */
public class Wget {
    public static void main(String[] args) {

        // read in data from URL
        String url = args[0];
        In in = new In(url);
        String data = in.readAll();

        // write data to a file
        String filename = url.substring(url.lastIndexOf('/') + 1);
        Out out = new Out(filename);
        out.println(data);
        out.close();
    }
}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by 11981 on 2017/4/8.
 */
public class guang {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6};
        int index = 3;
        int j = a.length - index - 1;
        System.arraycopy(a,index-1, a, index, j);
        a[a.length-1] = 0;
        for (int i = 0; i < a.length; i++){
            System.out.print(a[i]);
        }
    }


}

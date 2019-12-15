import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * Created by 11981 on 2017/6/4.
 * 数组去重复
 * 其中Arrays.asList()是将一个数组转化成一个List对象，
 * 这个方法会返回一个ArrayList类型的对象，这个ArrayList类
 * 并非java.util.ArrayList类，而是Array类的静态内部类！
 * TreeSet可以实现输出排序的功能
 */
public class RemoveDuplicate {
    public static void main(String[] args){
        Integer[] nums = {5,5,5,6,7,7,9,3,};
        HashSet tset = new HashSet(Arrays.asList(nums));
        //TreeSet<Integer> tset = new TreeSet<Integer>(Arrays.asList(nums));
        Iterator i = tset.iterator();
        while (i.hasNext()){
            System.out.print(i.next() + " ");
        }
    }
}

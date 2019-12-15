package test;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by 11981 on 2017/10/17.
 */
public class LinkedHashMapTest {
    public static void main(String[] args) {
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("s1", 1);
        map.put("s2", 2);
        map.put("s3", 3);
        map.put("s4", 4);
        map.put("s5", 5);
        map.put(null, 9);
        map.put("s6", 6);
        map.put("s7", 7);
        map.put("s8", 8);
        map.put(null, 11);
        map.get("s6");

        for (Map.Entry<String, Integer> entry : map.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        /*下面是把accessOrder置为true的情况*/

        Map<String, Integer> map1 = new LinkedHashMap<>(16, 0.75f, true);
        map1.put("s1", 1);
        map1.put("s2", 2);
        map1.put("s3", 3);
        map1.put("s4", 4);
        map1.put("s5", 5);
        map1.put(null, 9);
        map1.put("s6", 6);
        map1.put("s7", 7);
        map1.put("s8", 8);
        map1.put(null, 11);
        map1.get("s6");
        System.out.println("---------------------------");

        for (Map.Entry<String, Integer> entry1 : map1.entrySet()){
            System.out.println(entry1.getKey() + " : " + entry1.getValue());
        }

    }
}
/**
 * output:
 s1 : 1
 s2 : 2
 s3 : 3
 s4 : 4
 s5 : 5
 null : 11
 s6 : 6
 s7 : 7
 s8 : 8
 ---------------------------
 s1 : 1
 s2 : 2
 s3 : 3
 s4 : 4
 s5 : 5
 s7 : 7
 s8 : 8
 null : 11
 s6 : 6


 */

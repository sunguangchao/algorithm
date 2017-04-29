import java.util.LinkedHashMap;

/**
 * Created by 11981 on 2017/4/25.
 * 面试题35：第一个只出现一次的字符
 * 思路：能想到LinkedHashMap基本可以解决问题
 */
public class FirstNotRepeatingChar {
    public static void main(String[] args){
        FirstNotRepeatingChar test = new FirstNotRepeatingChar();
        System.out.print(test.firstNotRepeatingChar("aabccdeff"));

    }
    public Character firstNotRepeatingChar(String str){
        if (str == null)
            return null;
        char[] strChar = str.toCharArray();
        LinkedHashMap<Character, Integer> hash = new LinkedHashMap<Character, Integer>();
        for (char item : strChar) {
            if (hash.containsKey(item))
                hash.put(item, hash.get(item) + 1);
            else
                hash.put(item, 1);
        }

        for (char key : hash.keySet()){
            if (hash.get(key) == 1) {
                return key;
            }

        }
        return null;
    }
}

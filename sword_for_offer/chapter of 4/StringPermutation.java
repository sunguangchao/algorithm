/**
 * Created by 11981 on 2017/4/16.
 * 面试题28：字符串的排列
 */
public class StringPermutation {
    public static void main(String[] args){
        StringPermutation s = new StringPermutation();
        String s1 = "abc";
        s.permutation(s1);
    }
    public void permutation(String str){
        int count = 0;
        if (str == null)
            return;
        int point = 0;
        char[] chars = str.toCharArray();
        System.out.print(chars);
        System.out.print(" ");
        count++;
        char temp1 = chars[point];
        chars[point] = chars[++point];
        chars[point] = temp1;
        while (!String.valueOf(chars).equals(str)){
            System.out.print(chars);
            System.out.print(" ");
            count++;
            if (point == chars.length-1){
                char temp = chars[point];
                chars[point] = chars[0];
                chars[0] = temp;
                point = 0;
            }else{
                char temp = chars[point];
                chars[point] = chars[++point];
                chars[point] = temp;
            }
        }
        System.out.print(count);

    }
}

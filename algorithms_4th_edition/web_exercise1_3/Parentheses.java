import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by 11981 on 2016/11/20.
 * web exercise 1.3_4
 */
public class Parentheses {
    private static final char LEFT_PAREN     = '(';
    private static final char RIGHT_PAREN    = ')';
    private static final char LEFT_BRACE     = '{';
    private static final char RIGHT_BRACE    = '}';
    private static final char LEFT_BRACKET   = '[';
    private static final char RIGHT_BRACKET  = ']';
    public static boolean isBalance(String s){
        Stack<Character> charater = new Stack<Character>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == LEFT_PAREN) charater.push(LEFT_PAREN);
            //charAt():返回指定索引位置的char值
            if(s.charAt(i) == LEFT_BRACE) charater.push(LEFT_BRACE);
            if(s.charAt(i) == LEFT_BRACKET) charater.push(LEFT_BRACKET);
            if(s.charAt(i) == RIGHT_PAREN){
                if(charater.isEmpty()) return false;
                if(charater.pop() != LEFT_PAREN) return false;
            }
            if(s.charAt(i) == RIGHT_BRACE){
                if(charater.isEmpty()) return false;
                if(charater.pop() != LEFT_PAREN) return false;
            }
            if(s.charAt(i) == RIGHT_BRACKET){
                if(charater.isEmpty())return false;
                if(charater.pop() != LEFT_BRACKET) return false;
            }

        }
        return charater.isEmpty();
    }
    public static void main(String[] args){
        In in = new In(args[0]);
        String s = in.readString();//trim():去除字符串两端的空格
        StdOut.println(isBalance(s));
    }

}

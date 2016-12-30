public class Solution {

	private static final char LEFT_PAREN     = '(';
    private static final char RIGHT_PAREN    = ')';
    private static final char LEFT_BRACE     = '{';
    private static final char RIGHT_BRACE    = '}';
    private static final char LEFT_BRACKET   = '[';
    private static final char RIGHT_BRACKET  = ']';

    public boolean isValid(String s) {
        Stack<Character> charater = new Stack<Character>();
        for(int i=0; i < s.length(); i++){
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
                if(charater.pop() != LEFT_BRACE) return false;
            }
            if(s.charAt(i) == RIGHT_BRACKET){
                if(charater.isEmpty())return false;
                if(charater.pop() != LEFT_BRACKET) return false;
            }
        }
        return charater.isEmpty();
    }
}

package leetcode.num17;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: sunguangchao
 * @Date: 2019/3/24 3:37 PM
 * 参考：https://zxi.mytechroad.com/blog/searching/leetcode-17-letter-combinations-of-a-phone-number/
 *
 */
public class LetterCombinations {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        //先塞一个空值
        res.add("");
        for (int i = 0; i < digits.length(); i++) {
            String[] strArray = getArrayByNum(String.valueOf(digits.charAt(i)));
            int size = res.size();
            //这里新建了一个list，保证最后的字符串的长度和前面数据的数字长度一致
            List<String> tmp = new ArrayList<>();

            for (int k = 0; k < strArray.length; k++) {
                for (int j = 0; j < size; j++) {
                    String tmpStr = new String(res.get(j));
                    tmp.add(tmpStr + strArray[k]);
                }
            }
            res = tmp;
        }
        return res;
    }

    private String[] getArrayByNum(String digit) {
        String[] result = null;
        switch (digit) {
            case "2":
                result = new String[]{"a", "b", "c"};
                break;
            case "3":
                result = new String[]{"d", "e", "f"};
                break;
            case "4":
                result = new String[]{"g", "h", "i"};
                break;
            case "5":
                result = new String[]{"j", "k", "l"};
                break;
            case "6":
                result = new String[]{"m", "n", "o"};
                break;
            case "7":
                result = new String[]{"p", "q", "r", "s"};
                break;
            case "8":
                result = new String[]{"t", "u", "v"};
                break;
            case "9":
                result = new String[]{"w", "x", "y", "z"};
                break;
            default:
                break;
        }
        return result;
    }

    public static void main(String[] args) {
        LetterCombinations letter = new LetterCombinations();
        System.out.println(letter.letterCombinations("2555"));
    }
}

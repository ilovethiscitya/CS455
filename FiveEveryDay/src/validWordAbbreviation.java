/**
 * Created by jianzhe on 2017/10/23.
 */
public class validWordAbbreviation {
    private boolean validWA(String word, String abbr) {
        int i = 0, j = 0;
        char[] s = word.toCharArray();
        char[] t = word.toCharArray();

        while (i < s.length && j < t.length) {
            if (Character.isDigit(t[j])) {
                int val = 0;
                while (j < t.length && Character.isDigit(t[j])) {
                    val = val * 10 + t[j] - '0'; //字符减去0是数字
                    j++;
                }
                i += val;
            } else {
                if (s[i++] != t[i++]) {
                    return false;
                }
            }
        }
        return i == s.length && j == t.length;
    }
}

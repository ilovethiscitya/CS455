/**
 * Created by jianzhe on 2017/11/13.
 * the sky is blue
 * ehe yks si eulb
 * blue is sky the
 */
public class ReverseWordsinStringII {
    private static void RWS(char[] s) {
        if (s == null || s.length == 0) {
            return;
        }
        int left = 0;
        int right = 0;
        while (right < s.length) {
            if (s[right] != ' ') {
                right++;
            } else {
                reverse(s,left,right - 1);
            }
            right++;
            left = right;
        }
        reverse(s,left,right - 1);
        reverse(s,0,s.length - 1);

        return;
    }
    private static void reverse(char[] s, int left, int right) {
        while (left < right) {
            char tmp = s[left];
            s[left++] = s[right];
            s[right --] = tmp;
        }
    }
}

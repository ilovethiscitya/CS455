/**
 * Created by jianzhe on 2017/10/8.
 */
public class LongestCommonPrefix {
    private static String longestCP(String[] strs) {
        if (strs == null || strs.length == 0) return null;
        int len = strs.length;
        String pre = strs[0];
        int i = 1;
        while (i < len) {
            while (strs[i].indexOf(pre) != 0) {
                pre = pre.substring(0,pre.length() - 1);
            }
            i++;
        }
        return pre;
    }
    public static void main(String[] args) {
        String[] strs = new String[3];
        strs[0] = "abcefdsadfg";
        strs[1] = "abcddf5";
        strs[2] = "abc6";

        System.out.println(longestCP(strs));
    }
}

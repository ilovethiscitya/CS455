/**
 * Created by jianzhe on 2017/10/23.
 */
public class stringHomomorphism {
    private static boolean isIsomorphic(String s, String c) {
        int[] map = new int[256];
        char[] sc = s.toCharArray();
        char[] tc = c.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (map[sc[i]] == 0) {
                map[sc[i]] = tc[i];
            } else {
                if (map[sc[i]] != tc[i]) {
                    return false;
                }
            }
        }
        int[] map2 = new int[256];
        for (int i = 0; i < c.length(); i++) {
            if (map2[tc[i]] == 0) {
                map2[tc[i]] = sc[i];
            } else {
                if (map2[sc[i]] != tc[i]) {
                    return false;
                }
            }
        }
        return true;
    }
}

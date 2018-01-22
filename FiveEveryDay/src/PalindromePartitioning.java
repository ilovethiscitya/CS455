import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by jianzhe on 2017/11/5.
 */
public class PalindromePartitioning {
    private static List<List<String>> partion(String s) {
        if (s == null || s.length() == 0) return null;
        List<List<String>> res = new ArrayList<>();
        List<String> list = new ArrayList<>();
        helper(s,res,list,0);
        return res;
    }
    private static void helper(String s, List<List<String>> res,List<String> list, int index) {
        if (index > s.length()) return;
        if (index == s.length()) {
            res.add(new ArrayList<>(list));
        }
        String str = "";
        for (int i = index; i < s.length(); i++) {
            str += s.charAt(i);
            if (isPa(str)) {
                list.add(str);
                helper(s,res,list,i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
    private static boolean isPa(String str) {
        int start = 0;
        int end = str.length() - 1;
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    public static void main(String[] args) {
        String s = "aab";
        List<List<String>> res = partion(s);
        for (int i = 0; i < res.size(); i++) {
            ListIterator<String> iterator = res.get(i).listIterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }

        }


    }
}

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by jianzhe on 2017/10/19.
 */
public class simplifyPath {
    private static String simplifyPath(String path) {
        if (path == null || path.length() == 0) {
            return new String();
        }
        Deque<String> deque = new LinkedList<>();
        for (String cur : path.split("/")) {
            if (cur.equals("..") && !deque.isEmpty()) {
                deque.pollLast();
            } else if (!cur.equals(".") && !cur.equals("")) {
                deque.offerLast(cur);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append("/").append(deque.pollFirst());
        }
        return sb.length() == 0 ? new String("/") :sb.toString();
    }
    public static void main(String[] args) {
        String path = "/abc/...";
        String path1 = "/home/";
        String[] strings = path.split("/");
        for (String a : strings) {
            System.out.print(a);
            System.out.println(strings.length);
        }
        System.out.println(simplifyPath(path));
        System.out.println(simplifyPath(path1));
    }
}

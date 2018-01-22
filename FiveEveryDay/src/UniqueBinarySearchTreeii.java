import java.util.ArrayList;
import java.util.List;

/**
 * Created by jianzhe on 2017/10/20.
 */
public class UniqueBinarySearchTreeii {
    private static List<TreeNode> generate(int n) {
        if (n == 0) return null;
        return helper(0,n);
    }
    private static List<TreeNode> helper(int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        if (start > end) return null;
        if (start == end) {
            list.add(new TreeNode(start));
            return list;
        }
        List<TreeNode> left,right;
        for (int i = start; i <= end; i++) {
            left = helper(start,i - 1);
            right = helper(i+1,end);
            for (TreeNode lnode : left) {
                for (TreeNode rnode: right) {
                    TreeNode root = new TreeNode(i);
                    root.left = lnode;
                    root.right = rnode;
                    list.add(root);
                }
            }
        }
        return list;
    }
}

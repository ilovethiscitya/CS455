/**
 * Created by jianzhe on 2017/10/9.
 */
public class ConstructStringBinaryTree {
    public static String tree2str(TreeNode t) {
        if (t == null) return "";
        String tree = t.val + "";
        String left = tree2str(t.left);
        String right = tree2str(t.right);
        if (t.left == null && t.right == null) return tree;
        if (t.left == null) return tree + "(" + ")" + "(" + right + ")";
        if (t.right == null) return tree + "(" + left + ")";
        else return tree + "(" + left + ")" + "(" + right + ")";

    }
}

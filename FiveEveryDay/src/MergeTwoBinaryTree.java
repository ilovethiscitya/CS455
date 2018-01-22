/**
 * Created by jianzhe on 2017/10/5.
 */
public class MergeTwoBinaryTree {
    private static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return null;

        int val = (t1 == null ? 0 : t1.val) + (t2 == null ? 0 : t2.val);
        TreeNode t3 = new TreeNode(val);

        mergeTrees(t1.left == null ? null : t1.left, t2.left == null ? null : t2.left);
        mergeTrees(t1.right == null ? null : t1.right, t2.right == null ? null : t2.right);

        return t3;
    }
}

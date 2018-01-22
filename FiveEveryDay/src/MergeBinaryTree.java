/**
 * Created by jianzhe on 2017/10/8.
 */
public class MergeBinaryTree {
    private static TreeNode MBT(TreeNode t1,TreeNode t2) {
        if (t1 == null && t2 == null) return null;

        int val = (t1 == null ? 0 : t1.val) + (t2 == null ? 0 : t2.val);
        TreeNode newNode = new TreeNode(val);

        newNode.left = MBT(t1.left == null ? null: t1.left, t2.left == null ? null : t2.left);
        newNode.right = MBT(t2.right == null ? null : t2.right, t2.right == null ? null : t2.right );

        return newNode;

    }
}

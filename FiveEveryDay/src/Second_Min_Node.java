/**
 * Created by jianzhe on 2017/10/8.
 */
public class Second_Min_Node {
    private static int FM(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return -1;
        int left = root.left.val;
        int right = root.right.val;
        if (left == root.val) {
            left = FM(root.left);
        }
        if (right == root.val) {
            right = FM(root.right);
        }
        if (left != -1 && right != -1) {
            return Math.min(left,right);
        } else if (left != -1) {
            return left;
        } else
            return right;
    }
}

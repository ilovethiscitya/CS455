/**
 * Created by jianzhe on 2017/10/28.
 */
public class SecondMin2 {
    private static int SM(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return -1;
        int left = root.left.val;
        int right = root.right.val;
        if (left == root.val)
            left = SM(root.left);
        if (right == root.val)
            right = SM(root.right);
        if (left != -1 && right != -1) {
            return left > right ? left : right;
        } else if (left != -1) {
            return left;
        } else {
            return right;
        }


    }
}

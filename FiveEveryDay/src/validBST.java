/**
 * Created by jianzhe on 2017/11/20.
 */
public class validBST {
    private static boolean validBST(TreeNode root) {
        return validHelper(root,Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private static boolean validHelper(TreeNode root, long maxVal, long minVal) {
        if (root == null) return true;
        if (root.val > maxVal || root.val < minVal) return false;
        return true;
    }
}

/**
 * Created by jianzhe on 2017/10/28.
 */
public class TrimTree {
    private static TreeNode TT(TreeNode root,int left, int right) {
        if (root == null) return null;
        if (right < root.val) {
            return TT(root.left,left,right);
        }
        if (left > root.val) {
            return TT(root.right,left,right);
        }
        root.left = TT(root.left,left,right);
        root.right = TT(root.right,left,right);
        return root;
    }
}

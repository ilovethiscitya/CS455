/**
 * Created by jianzhe on 2017/10/8.
 */
public class TrimABinarySearchTree {
    private static TreeNode Trims(TreeNode root,int L,int R) {
        if (root == null) return root;
        if (root.val > R) {
            return Trims(root.left,L,R);
        }
        if (root.val < L) {
            return Trims(root.right,L,R);
        }

        root.left = Trims(root.left,L,R);
        root.right = Trims(root.right,L,R);
        return root;
    }
    public static void main(String [] args) {

    }
}

/**
 * Created by jianzhe on 2017/10/2.
 */
public class InventBinaryTree {
    private static TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        final TreeNode left = root.left,right = root.right;
        root.right = invertTree(left);
        root.left = invertTree(right);
        return root;
    }
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(2);
        n1.left = n2;
        n1.right = n3;
        TreeNode n4 = new TreeNode(5);
        TreeNode n5 = new TreeNode(3);
        n2.left = n4;
        n2.right = n5;
        TreeNode n6 = new TreeNode(9);
        n3.right = n6;
        TreeNode n7 = new TreeNode(10);
        n6.left = n7;
        TreeNode root = invertTree(n1);
    }
}

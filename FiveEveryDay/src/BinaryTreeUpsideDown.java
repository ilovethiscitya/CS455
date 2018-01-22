/**
 * Created by jianzhe on 2017/11/19.
 */
public class BinaryTreeUpsideDown {
    private static TreeNode BT(TreeNode root) {
        if (root == null) return null;
        TreeNode cur = root;
        TreeNode parent = null;
        TreeNode sib = null;
        while (cur != null) {
            TreeNode left = cur.left; // To store the reference of left
            TreeNode right = cur.right;
            cur.right = parent;
            cur.left = sib;
            parent = cur;
            sib = right;
            cur = left;

        }
        return parent;
    }
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        n1.left = n2;
        n1.right = n3;
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        n2.left = n4;
        n2.right = n5;
        TreeNode res = BT(n1);
        System.out.println(" ");

    }
}

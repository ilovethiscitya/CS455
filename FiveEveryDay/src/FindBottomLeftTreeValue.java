/**
 * Created by jianzhe on 2017/9/30.
 */
public class FindBottomLeftTreeValue {
    private static int FBLT(TreeNode root) {
        if (root.left == null && root.right == null) return root.val;
        int result;
        int leftDepth = findDepth(root.left);
        int rightDepth = findDepth(root.right);
        if (leftDepth >= rightDepth) {
            result = FBLT(root.left);
        } else {
            result = FBLT(root.right);
        }
        return result; // how to evaluate the depth ? compare the depth of left and right;
    }
    private static int findDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(findDepth(root.left),findDepth(root.right)) + 1;
    }
    private static int findLeftMost(TreeNode root) {
       while (root != null) {
           if (root.left != null) {
               root = root.left;
           } else if (root.right != null) {
               root = root.right;
           } else break;
       }
       return root.val;
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
        System.out.println(FBLT(n1));
    }
}


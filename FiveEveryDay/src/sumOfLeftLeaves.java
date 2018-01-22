/**
 * Created by jianzhe on 2017/10/1.
 */
public class sumOfLeftLeaves {
    private static int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        int ans = 0;
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null)
                ans += root.left.val;
            else ans += sumOfLeftLeaves(root.right);
        } else {
            ans +=sumOfLeftLeaves(root.right);
        }
        return ans;

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
        System.out.println(sumOfLeftLeaves(n1));
    }
}

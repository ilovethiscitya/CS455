/**
 * Created by jianzhe on 2017/10/3.
 */
public class SumRoottoLeafNumbers {
    private static int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        int sum = 1;
        return dfsHelper(root,sum);


    }
    private static int dfsHelper(TreeNode root, int sum) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return sum*10 + root.val;
        return dfsHelper(root.left,sum * 10 + root.val) + dfsHelper(root.right,sum * 10 + root.val);


    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;

        System.out.println(sumNumbers(n1));
    }
}

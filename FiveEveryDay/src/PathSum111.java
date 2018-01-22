import java.util.ArrayList;
import java.util.List;

/**
 * Created by jianzhe on 2017/10/1.
 */
public class PathSum111 {
    private static int pathSum(TreeNode root,int sum) {
        if (root == null) return 0;
        return dfsHelper(root,sum) + pathSum(root.left,sum) + pathSum(root.right,sum);
    }
    private static int dfsHelper(TreeNode root,int sum) {
        if (root == null) return 0;
        return (root.val == sum ? 1 : 0) + dfsHelper(root.left,sum - root.val) + dfsHelper(root.right,sum - root.val);
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
        System.out.println(pathSum(n1,5));

    }
}

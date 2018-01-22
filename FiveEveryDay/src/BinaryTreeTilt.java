import java.util.*;

/**
 * Created by jianzhe on 2017/10/9.
 */
public class BinaryTreeTilt {
    public static int summ = 0;
    private static int BTT(TreeNode root) {
        find(root);
        return summ;
    }
    private static int find(TreeNode root) {
        if (root == null) return 0;


        int left = BTT(root.left);
        int right = BTT(root.right);
        summ += Math.abs(left - right);
        return root.val + left + right;
    }
    public static void main(String[] args) {
//        TreeNode n1 = new TreeNode(1);
//        TreeNode n2 = new TreeNode(2);
//        TreeNode n3 = new TreeNode(3);
//        n1.left = n2;
//        n1.right = n3;
//        System.out.println(BTT(n1));    
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(1);
        System.out.print(q.peek());

    }
}

import java.util.ArrayList;

/**
 * Created by jianzhe on 2017/10/2.
 */
public class KthSmallestElementBST {
    private static int kthSmallest(TreeNode root,int k) {
        if (root == null) return 0;
        ArrayList<Integer> list = new ArrayList<>();
        inorder(root,list);
        return list.get(k - 1);
    }
    private static void inorder(TreeNode root,ArrayList<Integer> list) {
        if (root == null) return;
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(3);
        n1.left = n2;
        n1.right = n3;
        System.out.println(kthSmallest(n1,3));

    }
}

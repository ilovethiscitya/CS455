import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

/**
 * Created by jianzhe on 2017/10/5.
 */
public class TrimBinarySearchTree {
    //只考虑第一层和最后一层，其他只是duplicate？
    private static TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) return null;

        if (R < root.val) return trimBST(root.left,L,R);
        if (L > root.val) return trimBST(root.right,L,R);

        root.left = trimBST(root.left,L,R);
        root.right = trimBST(root.right,L,R);

        return root;

    }
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(0);
        TreeNode n3 = new TreeNode(2);
        n1.left = n2;
        n1.right = n3;
        TreeNode res = trimBST(n1,1,2);

    }
}

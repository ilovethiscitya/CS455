import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by jianzhe on 2017/10/1.
 */
public class PrintBinaryTree {
    private static List<List<String>> printTree(TreeNode root) {
        List<List<String>> result = new LinkedList<>();
        if (root == null) return result;
        int depth = getDepth(root);
        int row = depth;
        int col = (int)Math.pow(2,depth) - 1;
        List<String> list = new LinkedList<>();
        for (int i = 0; i < col; i++) {
            list.add("");
        }
        for (int i = 0; i < row; i++) {
             result.add(new ArrayList<>(list)); //如果是result.add(list); list指向的是同一个内存空间
        }
        printHelper(root,result,0,0,col);
        return result;
    }
    private static int getDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(getDepth(root.left),getDepth(root.right) )+ 1;
    }
    private static void printHelper(TreeNode root, List<List<String>> res, int index, int i, int j ) {
        if (root == null) return;
        if (index == res.size()) return;
        int mid = (i + j) / 2;
        res.get(index).set(mid,Integer.toString(root.val));
        printHelper(root.left,res,index + 1,i,mid - 1);
        printHelper(root.right,res,index + 1,mid + 1, j);
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
        List<List<String>> res = new LinkedList<>();
        res = printTree(n1);
        for (List<String> i : res) {
            System.out.println(i);
        }
    }

}

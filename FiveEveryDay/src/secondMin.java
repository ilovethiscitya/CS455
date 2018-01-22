import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jianzhe on 2017/10/5.
 */
public class secondMin {
    private static int secondMin(TreeNode root) {
        if (root == null) return 0;

        List<Integer> list = new ArrayList<>();
        inorder(root,list);
        int res = 0;
        int[] arr = new int[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        Arrays.sort(arr);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                res = arr[i];
                break;
            }
        }
        if (res == 0) {
            return -1;
        } else
          return res;

    }
    private static void inorder(TreeNode root,List<Integer> list) {
        if (root == null) return;
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }
    public static void main(String[] args) {
        /*
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        TreeNode n4 = new TreeNode(5);
        TreeNode n5 = new TreeNode(7);
        n3.left = n4;
        n3.right = n5;
        */
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(2);
        n2.left = n1;
        n2.right = n3;
        System.out.println(secondMin(n2));
    }
}

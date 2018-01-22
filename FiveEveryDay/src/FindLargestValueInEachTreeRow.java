import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by jianzhe on 2017/9/30.
 */
public class FindLargestValueInEachTreeRow {
    private static List<Integer> LV(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int max = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur != null) {
                    max = Math.max(max,cur.val);
                    if (cur.left != null)
                       queue.offer(cur.left);
                    if (cur.right != null)
                       queue.offer(cur.right);
                }
            }
            result.add(max);
            max = Integer.MIN_VALUE;
        }
        return result;
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
        List<Integer> res = new ArrayList<>();
        res = LV(n1);
        System.out.println(res);

    }
}

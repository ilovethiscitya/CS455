import java.util.*;

/**
 * Created by jianzhe on 2017/10/28.
 */
public class AverageLevelsBinaryTree {
    private static List<Double> BT(TreeNode root) {
        if (root == null) return null;
        List<Double> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        double sum = 0.0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                sum += cur.val;
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            list.add(sum/ size);
        }
        return list;
    }
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        t1.left = t2;
        t1.right = t3;
        List<Double> res = new ArrayList<>();
        res = BT(t1);
        ListIterator<Double> iterator = res.listIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

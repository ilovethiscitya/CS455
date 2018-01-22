import java.util.Stack;

/**
 * Created by jianzhe on 2017/10/3.
 */
public class BinarySearchTreeIterator {
//    private static Stack<TreeNode> stack;
//    public BinarySearchTreeIterator(TreeNode root) {
//       stack = new Stack<>();
//       TreeNode cur = root;
//       while (cur != null) {
//           stack.push(cur);
//           if (cur.left != null)
//               cur = cur.left;
//           else break;
//       }
//    }
//
//    public boolean hasNext() {
//        return !stack.isEmpty();
//    }
//
//    public int next() {
//        TreeNode node = stack.pop();
//        TreeNode cur = node;
//        if (cur.right != null) {
//            cur = cur.right;
//            while (cur != null) {
//                stack.push(cur);
//                if (cur.left != null) {
//                    cur = cur.left;
//                } else break;
//            }
//        }
//        return node.val;
//    }
    
}

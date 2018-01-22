/**
 * Created by jianzhe on 2017/10/28.
 */
public class PopulatingNextRightPointer {
    class TreeLinkNode{
        TreeLinkNode left;
        TreeLinkNode right;
        TreeLinkNode next;
        int val;
        public TreeLinkNode(int x) {
             val = x;
        }
    }
//    private static void connect(TreeLinkNode root) {
//        TreeLinkNode start = root;
//        while (start != null) {
//            TreeLinkNode cur = start;
//            while (cur != null) {
//                if (cur.left != null) {
//                    cur.left.next = cur.right;
//                }
//                if (cur.right != null && cur.next != null) {
//                    cur.right.next = cur.next.left;
//                }
//            }
//            cur = cur.next;
//        }
//        start = start.left;
//    }
      private static void connect(TreeLinkNode root) {
        if(root == null) return;
        Queue<TreeLinkNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeLinkNode cur = q.poll();
                if(q.isEmpty() || i == size - 1) cur.next = null;
                else {
                    cur-> next = q.peek();
                }
                if(cur.left != null) q.offer(cur.left);
                if(cur.right != null) q.offer(cur.right);
            }
        }
    }
    public static void main(String[] args) {
        
    }
}

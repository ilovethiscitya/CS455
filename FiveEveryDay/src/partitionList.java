import java.util.List;

/**
 * Created by jianzhe on 2017/10/19.
 */
public class partitionList {
    private static ListNode PL(ListNode head, int val) {
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        ListNode cur1 = dummy1;
        ListNode cur2 = dummy2;
        while (head != null) {
            if (head.val < val) {
                cur1.next = head;
                head = cur1;
            } else {
                cur2.next = head;
                head = cur2;
            }
            head = head.next;
        }
        cur2.next = null;
        cur1.next = dummy2.next;
        return dummy1.next;
    }
}

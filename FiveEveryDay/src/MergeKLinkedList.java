import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by jianzhe on 2017/10/1.
 *
 */
public class MergeKLinkedList {
    private static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        int len = lists.length;
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(len, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val == o2.val) return 0;
                else return o1.val > o2.val ? 1 : -1;
            }
        });
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        for (ListNode listNode : lists) {
            if (listNode != null)
               priorityQueue.add(listNode);
        }
        while (priorityQueue.isEmpty()) {
            ListNode cur = priorityQueue.poll();
            if (cur.next != null) {
                priorityQueue.add(cur.next);
            }
            prev.next = cur;
            prev = prev.next;
        }
        return dummy.next;



    }
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(6);
        ListNode n6 = new ListNode(4);
        n4.next = n5;
        n5.next = n6;
        ListNode[] lists = new ListNode[2];
        lists[0] = n1;
        lists[1] = n4;
        ListNode result = mergeKLists(lists);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}

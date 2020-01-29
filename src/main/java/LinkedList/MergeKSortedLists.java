package LinkedList;

import javafx.scene.layout.Priority;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Definition for ListNode.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int val) {
 * this.val = val;
 * this.next = null;
 * }
 * }
 */

public class MergeKSortedLists {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        List<ListNode> lists = new ArrayList<>();
        lists.add(l1);
        lists.add(l2);
        lists.add(l3);

        ListNode solved = mergeKLists(lists);

        while (solved != null) {
            System.out.print(solved.val + " ");
            solved = solved.next;
        }
    }

    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public static ListNode mergeKLists(List<ListNode> lists) {
        ListNode result = new ListNode(0);
        if (lists.size() == 0 || lists == null) return result;

        ListNode head = result;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);

        for (ListNode ln : lists) {
            while (ln != null) {
                pq.offer(ln);
                ln = ln.next;
            }
        }

//        for (ListNode ln:pq){
//            System.out.println(ln.val);
//            ln = ln.next;
//        }

        while (!pq.isEmpty()){
            head.next = pq.poll();
            head = head.next;
        }

        return result.next;
    }
}

package LinkedList;

import java.util.ArrayList;
import java.util.List;

public class AddTwoNumbers {
    public static void main(String[] args) {
//        ListNode l1 = new ListNode(7);
//        l1.next = new ListNode(1);
//        l1.next.next = new ListNode(6);
//        ListNode l2 = new ListNode(5);
//        l2.next = new ListNode(9);
//        l2.next.next = new ListNode(2);

//        ListNode l1 = new ListNode(0);
//        ListNode l2 = new ListNode(0);

//        0->9->8->7->6->5->4->3->2->1->null
//        0->1->2->3->4->5->6->7->8->9->null
//        ListNode l1 = new ListNode(0);
//        l1.next = new ListNode(9);
//        l1.next.next = new ListNode(8);
//        l1.next.next.next = new ListNode(7);
//        l1.next.next.next.next = new ListNode(6);
//        l1.next.next.next.next.next = new ListNode(5);
//        l1.next.next.next.next.next.next = new ListNode(4);
//        l1.next.next.next.next.next.next.next = new ListNode(3);
//        l1.next.next.next.next.next.next.next.next = new ListNode(2);
//        l1.next.next.next.next.next.next.next.next.next = new ListNode(1);
//        ListNode l2 = new ListNode(0);
//        l2.next = new ListNode(1);
//        l2.next.next = new ListNode(2);
//        l2.next.next.next = new ListNode(3);
//        l2.next.next.next.next = new ListNode(4);
//        l2.next.next.next.next.next = new ListNode(5);
//        l2.next.next.next.next.next.next = new ListNode(6);
//        l2.next.next.next.next.next.next.next = new ListNode(7);
//        l2.next.next.next.next.next.next.next.next = new ListNode(8);
//        l2.next.next.next.next.next.next.next.next.next = new ListNode(9);

        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        ListNode l2 = new ListNode(9);

        ListNode solved = addLists(l1, l2);
        while (solved != null){
            System.out.print(solved.val);
            solved = solved.next;
        }

//        ListNode solved = solution(l1, l2);
//        while (solved != null){
//            System.out.print(solved.val);
//            solved = solved.next;
//        }
    }

    /**
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2
     */
    public static ListNode addLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        if (l1 == null && l2 == null)
            return result;

        ListNode p1 = l1, p2 = l2, headNode = result;
        int carry = 0;

        while (p1 != null || p2 != null){
            if (p1 != null){
                carry += p1.val;
                p1 = p1.next;
            }

            if (p2 != null){
                carry += p2.val;
                p2 = p2.next;
            }

            headNode.next = new ListNode(carry%10);
            headNode = headNode.next;
            carry /= 10;
        }

        if (carry > 0){
            headNode.next = new ListNode(carry);
        }

        return result.next;
    }
}

//      Definition for ListNode
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

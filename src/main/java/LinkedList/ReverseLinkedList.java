package LinkedList;

/**
 * Definition for ListNode
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */

public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        ListNode solved = reverse(head);

        while (solved != null) {
            System.out.print(solved.val + " ");
            solved = solved.next;
        }
    }

    /**
     * @param head: n
     * @return: The new head of reversed linked list.
     */
    public static ListNode reverse(ListNode head) {
        ListNode result = new ListNode(0);
        if (head == null) return result;

        ListNode next = head;
        ListNode tail = null;
        ListNode temp = null;

        while (next != null) {
            temp = tail;    // 임시 저장
            tail = next;    // 다음 노드 저장하고
            next = next.next;   // 다음에 빼낼꺼 준비하고
            tail.next = temp;   // 이전에 빼놨던거랑 연결

        }

        return tail;
    }
}

package ReverseLinkedList;

import main.java.ReverseLinkedList.ListNode;

/**
 * Created by ymkNK on 2020-04-27.
 */
public class ReverseLinkedList {

    public ListNode reverseList1(ListNode head) {
        ListNode current = head;
        ListNode result = null;
        while (current != null) {
            ListNode listNode = new ListNode(current.val);
            listNode.next = result;
            result = listNode;
            current = current.next;
        }
        return result;
    }

    // 将自己的下一个的next设置成自己，然后每次返回下一个，每一次结束需要将head的next设置为null
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList(head.next);
        head.next.next = head;
        // 断掉循环
        head.next = null;
        return p;
    }

//    if (head == null || head.next == null) return head;
//    ListNode p = reverseList(head.next);
//    head.next.next = head;
//    head.next = null;
//    return p;
//

    public static void main(String[] args) {

        int[] count = {1, 2, 3, 4, 5};
        ListNode iter = new ListNode();
        ListNode head = iter;
        for (int i : count) {
            iter.val = i;
            iter.next = new ListNode();
            iter = iter.next;
        }

        ListNode listNode = reverseList(head);
    }
}

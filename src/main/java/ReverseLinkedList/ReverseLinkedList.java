package ReverseLinkedList;

import main.java.ReverseLinkedList.ListNode;

/**
 * Created by ymkNK on 2020-04-27.
 */
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode result = null;
        while (current.next != null) {
            ListNode listNode = new ListNode(current.val);
            listNode.next=result;
            result = listNode;
            current = current.next;
        }
        return result;
    }


    public static void main(String[] args) {


    }
}

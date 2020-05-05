package MergeTwoSortedList;

import java.awt.*;

/**
 * Created by ymkNK on 2020-05-05.
 */
public class MergeTwoSortedList {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode cur = result;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                cur.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            if (l2 == null && l1!=null) {
                cur.next = new ListNode(l1.val);
                l1 = l1.next;
            }

            if (l1 != null && l2 != null) {
                if (l1.val > l2.val) {
                    cur.next = new ListNode(l2.val);
                    l2 = l2.next;
                } else {
                    cur.next = new ListNode(l1.val);
                    l1 = l1.next;
                }
            }
            cur = cur.next;

        }
        return result.next;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        else if (l2 == null) {
            return l1;
        }
        else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }

    public static void main(String[] args) {


    }
}

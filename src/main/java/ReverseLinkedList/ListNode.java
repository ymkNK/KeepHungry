package main.java.ReverseLinkedList;

import lombok.Data;

/**
 * Created by Yangmingkai on 2020-04-27.
 */
@Data
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) {
        val = x;
    }

    public ListNode() {

    }
}

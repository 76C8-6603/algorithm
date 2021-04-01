package main.com.ming;

import java.util.List;

/**
 * @author 78c8-6603
 */
public class ReverseLinkedSet {
    static class ListNode{
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }


    }

    public static void main(String[] args) {
         ListNode listNode1 = new ListNode(1);
        final ListNode listNode2 = new ListNode(2);
        listNode1.next = listNode2;
        final ListNode listNode3 = new ListNode(3);
        listNode2.next = listNode3;
        final ListNode listNode4 = new ListNode(4);
        listNode3.next = listNode4;
        final ListNode listNode5 = new ListNode(5);
        listNode4.next = listNode5;

        listNode1 = reverse(listNode1);

        StringBuilder stringBuilder = new StringBuilder();

        for (ListNode stepNext = listNode1; stepNext != null;stepNext = stepNext.next ) {
            stringBuilder.append(stepNext.val);
        }


        System.out.println(stringBuilder.toString());
    }

    public static ListNode reverse(ListNode listNode) {
        if (listNode == null || listNode.next == null) {
            return listNode;
        }
        final ListNode newHead = reverse(listNode.next);
        listNode.next.next = listNode;
        listNode.next = null;
        return newHead;
    }
}

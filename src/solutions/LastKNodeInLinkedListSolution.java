package solutions;

import pojo.ListNode;

import java.util.LinkedList;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class LastKNodeInLinkedListSolution {
    private LinkedList<ListNode> temp = new LinkedList<>();

    public ListNode FindKthToTail(ListNode head, int k) {
        ListNode c = head;
        if (c == null || k == 0)
            return null;

        int listSize = 0;
        while(c != null) {
            push(c, k);
            c = c.next;
            listSize++;
        }

        System.out.println(listSize);
        if (listSize < k)
            return null;

        return temp.getFirst();
    }

    private void push(ListNode n, int k) {
        temp.addLast(n);
        if (temp.size() > k) {
            temp.removeFirst();
        }
    }
}

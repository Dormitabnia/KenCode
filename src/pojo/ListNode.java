package pojo;

/**
 * 单向链表
 */
//public class ListNode {
//    public int val;
//    public ListNode next = null;
//
//    public ListNode(int val) {
//        this.val = val;
//    }
//}

public class ListNode<E> {
    public E val;
    public ListNode<E> next = null;

    public ListNode(E val) {
        this.val = val;
    }
}
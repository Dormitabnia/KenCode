package util;

import pojo.ListNode;

/**
 * 链表工具类
 */
public class ListUtils {

    /**
     * 将整数数组转换为ListNode
     * @param array 传入的数组
     * @return 返回单向链表的根节点
     */
    public static <E> ListNode<E> toListNode(E[] array) {
        ListNode<E> root = new ListNode<>(array[0]);
        ListNode p = root;
        for (int i = 1; i < array.length; i++) {
            ListNode<E> n = new ListNode<>(array[i]);
            p.next = n;
            p = n;
        }

        return root;
    }

    /**
     * 打印链表（需要链表元素重载toString()方法）
     * @param ln 链表根节点
     */
    public static void printListNode(ListNode ln) {
        ListNode p = ln;
        StringBuilder res = new StringBuilder("[");
        while(p != null) {
            res.append(p.val.toString()).append(" ");
            p = p.next;
        }
        res.append("\b").append("]");
        System.out.println(res);
    }

}

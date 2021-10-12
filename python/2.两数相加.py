#
# @lc app=leetcode.cn id=2 lang=python3
#
# [2] 两数相加
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        a1 = l1
        a2 = l2
        res_head = ListNode(val=a1.val + a2.val)
        
        res = res_head
        add_flag = 0
        if res.val >= 10:
            add_flag += 1
            res.val -= 10
        while a1.next is not None and a2.next is not None:
            a1 = a1.next
            a2 = a2.next
            new_node = ListNode()

            new_val = add_flag
            add_flag = 0
            if a1 is not None and a2 is not None:
                new_val += a1.val + a2.val
            elif a1 is None:
                new_val += a2.val
            elif a2 is None:
                new_val += a1.val

            if new_val >= 10:
                add_flag += 1
                new_val -= 10
            new_node.val = new_val
            
            res.next = new_node
            res = new_node
        
        while a1.next is not None:
            a1 = a1.next
            new_val = add_flag + a1.val
            if new_val >= 10:
                add_flag = 1
                new_val -= 10
            else:
                add_flag = 0

            new_node = ListNode(new_val)
            res.next = new_node
            res = new_node

        while a2.next is not None:
            a2 = a2.next
            new_val = add_flag + a2.val
            if new_val >= 10:
                add_flag = 1
                new_val -= 10
            else:
                add_flag = 0

            new_node = ListNode(new_val)
            res.next = new_node
            res = new_node
        
        if add_flag > 0:
            res.next = ListNode(1)
        
        return res_head
# @lc code=end


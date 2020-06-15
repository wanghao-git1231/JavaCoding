package 代码的鲁棒性;

/********************
 * 剑指offer:链表翻转
 * 题目描述
 * 输入一个链表，反转链表后，输出新链表的表头。
 ********************/


public class ReverseList {

    public static void main(String[] args) {

    }

    //翻转链表
    public static ListNode ReverseList(ListNode head) {
        ListNode tail = null;

        while (head != null) {
            ListNode temp = new ListNode(head.val);
            temp.next = tail;
            tail = temp;
            head = head.next;

        }
        return  tail;
    }
}

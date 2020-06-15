package Easy.Case141;

/**************************
 * LeetCode Case141:环形链表
 * 题目描述：
 * 给定一个链表，判断链表中是否有环。
 * 思路：快慢指针，相遇为有环
 *************************/

public class HasCycle {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l2;

        boolean b = hasCycle(l1);
        System.out.println(b);

    }
    public static boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null&&fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }
        return false;
    }
}

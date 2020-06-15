package Easy.Case160;

import java.util.HashSet;

/****************************
 * LeetCode Case160:相交链表
 *  题目描述：
 *  编写一个程序，找到两个单链表相交的起始节点。
 *  思路：
 *      思路一：双重遍历
 *      思路二：将一个链表存储，另一个链表遍历对比是否存在，存在即相交
 *      思路三：A+B = B+A,两个指针分别指向两个链表头，走到头时指向另一个，如果相遇即相交
 *  plus：思路三之前见过竟然没想起来，我是SB！！！
 ***************************/


public class GetIntersectionNode {
    public static void main(String[] args) {

    }

    //双指针法，同时往后走，a走到头就指向b,b走到头指向a,最终相遇即为重合，否则同时走到头，A+B=B+A
    public static ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        ListNode pA = headA;
        ListNode pB = headB;

        while (pA!=null||pB!=null){
            if(pA == pB) return pA;
            if(pA == null) pA = headB;
            else pA = pA.next;
            if(pB == null) pB = headA;
            else pB = pB.next;
        }
        return null;
    }

    //使用set存储，一个加入，一个查询是否存在，复杂度仍高
    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();
        while (headA!=null){
            set.add(headA);
            headA = headA.next;
        }
        while (headB!=null){
            if(set.contains(headB)) return headB;
            headB = headB.next;
        }
        return null;
    }
    //循环嵌套复杂度较高
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode t = headB;
        while (headA != null){
            while (t != null){
                if(headA == t) return headA;
                t = t.next;
            }
            t = headB;
            headA = headA.next;
        }

        return null;
    }
}

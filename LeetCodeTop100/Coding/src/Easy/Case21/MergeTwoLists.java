package Easy.Case21;

/*******************************
 *  LeetCode Case21:合并两个有序链表
 *  题目描述：将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *  思路：
 *       1.比较两个节点的大小，将小的返回
 *       2.确保返回值是头，确保两个头移动正确
 ******************************/

public class MergeTwoLists {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(4);

        l1.next = l2;
        l2.next = l3;

        ListNode p1 = new ListNode(1);
        ListNode p2 = new ListNode(3);
        ListNode p3 = new ListNode(4);

        p1.next = p2;
        p2.next = p3;
        ListNode listNode = mergeTwoLists2(l1, p1);
        while (listNode!=null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }

    //递归
    public static  ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode res = null;
        if(l1.val<=l2.val){
            res = l1;
            l1 = l1.next;
        }
        else {
            res = l2;
            l2 = l2.next;
        }

        res.next = mergeTwoLists2(l1,l2);
        return res;
    }

    //迭代
    public static  ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        ListNode newHead = null;
        if(l1.val<=l2.val){
            newHead = l1;
            l1 = l1.next;
        }
        else {
            newHead = l2;
            l2 = l2.next;
        }

        ListNode current = newHead;

        while (l1!=null&&l2!=null){
            if(l1.val<=l2.val){
                current.next = l1;
                l1 = l1.next;
            }else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        if(l1 == null) current.next = l2;
        if(l2 == null) current.next = l1;
        return newHead;
    }
}

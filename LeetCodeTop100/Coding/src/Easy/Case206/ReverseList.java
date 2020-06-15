package Easy.Case206;


/*****************************
 * LeetCode Case206:翻转一个列表
 * 题目要求：反转一个单链表
 * 思路：
 *      思路一：迭代
 *          1.需要记录当前值，当前的下一值
 *          2.直到指向null，结束
 *      思路二：递归
 *          1.关于返回，在链表到头的时候返回即新的头，一直返回该值
 *          2.对于访问到当前点的下一个节点时仍能找到当前节点
 *          3.在我的递归版本中，使用参数传入，在其他解中，直接next.next
 *****************************/

public class ReverseList {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        ListNode reverse = reverseList3(l1);
        while (reverse!=null){
            System.out.println(reverse.val);
            reverse = reverse.next;
        }
    }

    //递归实现
    public static ListNode reverseList3(ListNode head) {
        if(head == null||head.next == null) return head;
        ListNode p = reverseList3(head.next);
        //让当前节点next指向当前节点
        head.next.next = head;
        //当前节点清空,在递归返回后指向前一个节点
        head.next = null;
        return p;
    }

    //迭代方法翻转列表
    public static ListNode reverseList2(ListNode head) {

        if(head == null||head.next == null) return head;
        ListNode temp = null;  //指向下一个结点
        ListNode next = head;  //指向上一个结点

        while (next!= null){

            head = next;//确保temp ->head ->next 的属性，令head.next = temp即可
            next = next.next;
            head.next = temp;
            temp = head;
        }

        return head;
    }

    public static ListNode reverseList(ListNode head) {
        if(head == null) return head;
        return reverse(head,null);
    }

    //递归翻转，head 当前节点，next 上一个节点
    private static ListNode reverse(ListNode head,ListNode next){

        ListNode tem = head.next;
        head.next  = next;
        //走到头，返回新的头，而且此时next已经指向上一结点
        if(tem == null) return head;
        //返回值只有一个，新的头
        return reverse(tem,head);
    }



}

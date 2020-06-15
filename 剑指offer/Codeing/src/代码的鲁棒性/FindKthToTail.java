package 代码的鲁棒性;

/**********************************
 * 剑指offer：链表中倒数第k个节点
 * 题目描述
 * 输入一个链表，输出该链表中倒数第k个结点。
 ********************************/

import java.util.Stack;

public class FindKthToTail {


    public static void main(String[] args) {
        //不会动态建立java的这种链表！！！
        ListNode node= new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node.next = node2;
        node2.next = node3;
        node3.next = node4;

       node4 =  Find(node,1);
        System.out.println(node4.val);
    }
    //两指针法，一个指针提前移动K
    public static ListNode Find(ListNode head,int k) {
        if(head == null || k ==0 ){
            return null;
        }
        //快指针，提前移动k步
        ListNode fast = head;


        while (k>0){

            if(fast != null){
                fast = fast.next;
            }else {

               break;
            }
            k--;
        }
        if(k != 0) return null;
        while (fast!=null){
            head = head.next;
            fast = fast.next;
        }

        return head;

    }

    //返回结点，包含从该接地那开始的后序结点信息，是部分链表
    public static ListNode Find2(ListNode head,int k) {
        if (head == null || k == 0) return null;  //空链表，返回空
        //建立倒序链表
        ListNode tail = null;
        int i = 0;
        while (head != null) {
            ListNode temp = new ListNode(head.val);
            temp.next = tail;
            tail = temp;
            head = head.next;
            i++;
        }

        if(k>i) return null;

        ListNode res = null;
        //倒序方式，建立从尾结点到k的正序链表
        while (k-->0) {
            ListNode temp = new ListNode(tail.val);
            temp.next = res;
            res = temp;
            tail = tail.next;
            System.out.println(res.val);
        }

        return res;
    }



}

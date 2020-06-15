package 代码的鲁棒性;

/*********************
 *剑指offer:合并两个排序的链表
 * 题目描述
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 ********************/

public class Merge {
    public static void main(String[] args) {
        ListNode node= new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(7);
        node.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode head= new ListNode(2);
        ListNode head2 = new ListNode(4);
        ListNode head3 = new ListNode(6);
        ListNode head4 = new ListNode(8);
        ListNode head5 = new ListNode(10);
        head.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = head5;
        ListNode nu = null;
        ListNode n = Merge2(node,nu);

        while (n!=null){
            System.out.println(n.val);
            n = n.next;
        }

    }
    //java没有指针，建立链表过程不一样
    public static ListNode Merge2(ListNode list1,ListNode list2) {
        ListNode head = null;
        ListNode temp = null;
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        while(list2!=null&&list1!=null){

            if(list1.val>=list2.val){
                if(temp == null){
                    temp = head = new ListNode(list2.val);

                }else {
                    head.next = new ListNode(list2.val);
                    head = head.next;
                }

                list2 = list2.next;
            }else {
                if(temp == null){
                    temp = head = new ListNode(list1.val);

                }else {
                    head.next = new ListNode(list1.val);
                    head = head.next;
                }


                list1 = list1.next;
            }
        }

        if(list2!=null) head.next = list2;
        if(list1!=null) head.next = list1;
        return temp;
    }
}

package 时间空间效率的平衡;

/*****************************
剑指offer：两个链表的第一个公共节点
 题目描述
 输入两个链表，找出它们的第一个公共结点。
 （注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
 思路：
        1.双指针法：两个指针同时往前走，当指针当前链表走到头时，指向另一个链表，
         两个指针第一次相遇时，一定指向第一个共同的节点或null,返回即可
        2.遍历嵌套
 ***************************/
public class FirstCommonNode {
    public static void main(String[] args) {
        ListNode pHead1 = new ListNode(1);
        ListNode pHead2 = new ListNode(2);
        ListNode pHead3 = new ListNode(3);
        ListNode pHead4 = new ListNode(4);
        ListNode pHead5 = new ListNode(5);

        ListNode pHead21 = new ListNode(0);
        ListNode pHead22 = new ListNode(1);

        pHead1.next = pHead2;
        pHead2.next = pHead3;
        pHead3.next = pHead4;
        pHead4.next = pHead5;
        pHead21.next = pHead22;
        pHead22.next = pHead3;
        ListNode listNode = FindFirstCommonNode(pHead1, pHead21);
        System.out.println(listNode+" "+pHead3);
        while (listNode!=null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    /*
    // 别人更快的方法：双指针法，两个指针同时往前走，当指针当前链表走到头时，
    指向另一个链表，两个指针第一次相遇时，一定指向第一个共同的节点或null,返回即可
    */
    public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {

        if(pHead1 == null||pHead2 == null) return null;
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while (p1!=p2){
            p1 = p1.next;
            p2 = p2.next;
            if(p1 == null) p1 = pHead2;
            if(p2 == null) p2 = pHead1;

        }
        return p1;
    }

    //笨办法循环嵌套
    public static ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null||pHead2 == null) return null;
        ListNode temp = null;
        while (pHead1 != null){
            temp = pHead2;
            while (temp != null){

                if(pHead1==temp) return pHead1;
                temp = temp.next;
            }
            pHead1 = pHead1.next;

        }
        return null;
    }
}

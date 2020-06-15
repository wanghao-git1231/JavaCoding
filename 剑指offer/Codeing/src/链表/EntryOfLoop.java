package 链表;

/************************
 * 剑指offer：链表中环的入口结点
 * 题目描述
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 * 思路：
 *      1.判读是否有环，快慢指针，快的每次移动两个
 *      2.判断入口地址，相遇点与起头结点到入口距离相等
 **********************/


public class EntryOfLoop {
    public static void main(String[] args) {
        ListNode node= new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node3;
//        node5.next = node6;
//        node6.next = node3;
        ListNode listNode = EntryNodeOfLoop(node);
        System.out.println(listNode.val);

    }
    public static ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if(pHead == null) return null;
        ListNode slowPointer = pHead; //慢指针，每次移动一个
        ListNode fastPointer = pHead;//块指针，每次移动两个
        boolean isLoop = false;

        while (fastPointer != null&&fastPointer.next != null){

             slowPointer = slowPointer.next;

            fastPointer = fastPointer.next.next;
            //相遇
            if(fastPointer == slowPointer) {
                isLoop = true;
                break;
            }

        }

        if(isLoop == false) return null;
        //找到入口，头结点到入口的距离等于相遇的点到入口的距离，因此往下走就可以
        while (pHead != slowPointer){
            pHead = pHead.next;
            slowPointer = slowPointer.next;
        }
        return pHead;
    }
}

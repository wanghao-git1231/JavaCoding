package 链表;

/************************************
 * 剑指offer：删除链表中重复的结点
 * 题目描述
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * 思路：
 *      1.建立辅助指针，cun,next,last
 *      2.遇到重复的就一直走直到不重复并将赋给last.next,
 *      3.不重复的就领当前为last,并指向下一个
 *      4.循环直到结束
 ***********************************/


public class DeleteRepeateNode {
    public static void main(String[] args) {

        ListNode node= new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(1);
        ListNode node6 = new ListNode(1);
        node.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        ListNode newLinkedNode = deleteDuplication(node);
        while (newLinkedNode!=null){
            System.out.println(newLinkedNode.val);
            newLinkedNode = newLinkedNode.next;
        }
    }

    public static ListNode deleteDuplication(ListNode pHead)
    {
        if(pHead == null) return null;
        ListNode lastNode = null;  //上一个不重复的节点
        ListNode currentNode = pHead;  //当前节点
        ListNode nextNode = null;
        ListNode head = null;
        while (currentNode != null){
            int value = currentNode.val;
            nextNode = currentNode.next;

            if(nextNode == null||nextNode.val != value){
                if(head == null) head = currentNode;
                lastNode = currentNode;
                currentNode = currentNode.next;

            }
            else {
                while (nextNode!= null&&nextNode.val == value){
                    nextNode = nextNode.next;
                }
                currentNode = nextNode;
                if(lastNode != null) lastNode.next = nextNode;
            }

        }

        return head;
    }
}

package Medium.Case148;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


/********************************************************
 * LeetCode Case148:排序链表
 * 题目描述：在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 * 思路：
 *   思路一：使用list等容器存储链表原先值，sort排序，将排序后结果赋回去
 *   思路二：二分递归+归并排序
 *      1.使用归并排序的前提是能够将要排序的数组、队列等二分，但链表没法直接除
 *      2.使用快慢指针将链表分为两个，递归
 *      3.归并排序的实现
 *   思路三：迭代实现二分，没看懂去看题解吧
 *******************************************************/


public class SortList {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        ListNode p1 = new ListNode(2);
        ListNode p2 = new ListNode(4);
        ListNode p3 = new ListNode(6);

        l3.next = p1;
        p1.next = p2;
        p2.next = p3;

        ListNode listNode = sortList2(l1);
        while (listNode!=null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }


    }



    //二分递归实现，快慢指针，归并排序
    public static ListNode sortList2(ListNode head) {
        if(head.next == null) return head;

        ListNode rightHead = midNode(head);
        ListNode l1 = sortList2(head);
        ListNode l2 = sortList2(rightHead);
        ListNode res = mergeSort(l1, l2);
        return res;
    }

    //使用快慢指针找到链表的中间节点，并将前一半链表的最后一个节点指向null
    private static ListNode midNode(ListNode head){

        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = null;
        while (fast!=null&&fast.next!=null){
            pre  = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        //断开两段链表的联系
        pre.next = null;
        return slow;
    }

    //归并排序
    private static ListNode mergeSort(ListNode l1,ListNode l2){

        ListNode newHead = null;
        if(l1.val<=l2.val){
            newHead = l1;
            l1 = l1.next;
        }else {
            newHead = l2;
            l2 = l2.next;
        }
        ListNode res = newHead;

        while (l1!=null&&l2!=null){
            if(l1.val<=l2.val){
                newHead.next = l1;
                l1 = l1.next;
            }else {
                newHead.next = l2;
                l2 = l2.next;
            }
            newHead = newHead.next;
        }

        if(l1!=null) newHead.next = l1;
        if(l2!=null) newHead.next = l2;
        return res;
    }

    
    //使用list辅助存储值，排序后赋值回去
    public static ListNode sortList(ListNode head) {
        List<Integer> list = new ArrayList<>();

        ListNode temp = head;
        while (temp!=null){
            list.add(temp.val);
            temp = temp.next;
        }
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o2>o1) return -1;
                else if(o2<o1) return 1;
                else return 0;
            }
        });
        System.out.println(list.toString());
        temp = head;
        int i = 0;
        while (temp!=null){
            temp.val = list.get(i++);
            temp = temp.next;
        }
        return head;
    }
}

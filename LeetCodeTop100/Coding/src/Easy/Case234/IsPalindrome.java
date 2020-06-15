package Easy.Case234;

import java.util.Vector;

/***************************************
 * LeetCode Case234：回文链表
 * 题目描述：请判断一个链表是否为回文链表。
 * 思路：
 *      思路一：先将链表值存储在容器中，再使用双指针判读是否相同
 *      思路二：使用系统栈保存链表正序值，返回时开始按顺序返回链表，
 *      思路三：先将后半段链表翻转，比较，最后再把翻转的后半部分翻转并拼接回去
 *
 ***************************************/

public class IsPalindrome {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(2);
        ListNode l6 = new ListNode(1);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;

        boolean palindrome = isPalindrome3(l6);
        System.out.println(palindrome);


    }

    //将后半段链表翻转，再比较，再把翻转后的链表翻转并重新拼回去
    public static boolean isPalindrome3(ListNode head) {
        if(head == null) return true;
        ListNode slow = head;
        ListNode fast = head;
        ListNode endOfHalf  = head;
        //结束后slow指向后半部分开始
        while (fast!= null&&fast.next!=null){
            endOfHalf = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        //将链表翻转，翻转结束temp就是新的头
        ListNode temp = null;
        while (slow != null){
            fast = slow.next;

            slow.next = temp;
            temp = slow;
            slow = fast;
        }

        //比较链表正序与翻转后的后半链表
        fast = temp;
        slow = head;
        while (fast!=null){

            if(fast.val != slow.val) return false;
            fast = fast.next;
            slow = slow.next;
        }

        slow = temp;
        temp = null;
        //将翻转后链表翻转，翻转结束temp就是新的头
        while (slow != null){
            fast = slow.next;

            slow.next = temp;
            temp = slow;
            slow = fast;
        }
        //重新拼接复原链表
        endOfHalf.next = temp;

        return true;
    }

    //使用递归，让系统栈帮忙存储，但是系统栈深度有限，链表过大时不好用
    public static boolean isPalindrome2(ListNode head) {
        ListNode listNode = find(head, head);
        return flag;
    }

    private static boolean flag = true;
    //res在返回时开始从头到尾遍历，正好与head对称
    private static ListNode find(ListNode head,ListNode res){
        if(head == null) return res;
        ListNode b = find(head.next,res);
        if(b == null) {
            flag = false;
            return null;
        }
        if(b.val == head.val) return b.next;
        else return null;

    }

    //先将结果保存在vector，在头尾对称两两比较
    public static boolean isPalindrome(ListNode head) {
        Vector<Integer> vector = new Vector<>();
        while (head != null){
            vector.add(head.val);
            head = head.next;
        }

        int len = vector.size();
        int first = 0,second = len - 1;
        while (first<second){

            if(!vector.elementAt(first).equals(vector.elementAt(second)) )
                return false;
            first++;
            second--;
        }
        return true;
    }



}

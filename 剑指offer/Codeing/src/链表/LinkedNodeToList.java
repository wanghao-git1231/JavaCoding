package 链表;
import java.util.ArrayList;

/*********************************
 * 剑指offer：从头到尾打印链表
 * 题目描述
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 ********************************/

public class LinkedNodeToList {
    public static void main(String[] args) {
        //不会动态建立java的这种链表！！！
        ListNode node= new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node.next = node2;
        node2.next = node3;
        node3.next = node4;

        ArrayList<Integer>  l = printListFromTailToHead(node);
        System.out.println(l);
    }
    //函数
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        //Stack<Integer> mystack = new Stack<>();  不让用栈！！！
        ArrayList<Integer> old = new ArrayList<>();
        while (listNode!=null){

            old.add(listNode.val);
            listNode = listNode.next;

        }
        ArrayList<Integer> myList = new ArrayList<>();
        int j = old.size();
        Integer[] a = new Integer[j];
        old.toArray(a);
        for (int i = 0; i < j; i++) {
            myList.add(a[j-i-1]);
        }

        return myList;
    }


}

package 分解让复杂问题简单;

import java.util.HashMap;

/***********************
 * 剑指offer:复杂链表的赋值
 * 题目描述
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针random指向一个随机节点），
 * 请对此链表进行深拷贝，并返回拷贝后的头结点。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * 思路：使用map保存新旧链表对应节点，然后按照旧链表指向，对应建立新链表指向
 *
 **********************/


public class RandomListClone {

    public static void main(String[] args) {
        RandomListNode L1 = new RandomListNode(1);
        RandomListNode L2 = new RandomListNode(2);
        RandomListNode L3 = new RandomListNode(3);
        RandomListNode L4 = new RandomListNode(4);
        RandomListNode L5 = new RandomListNode(5);
        L1.next = L2;
        L2.next = L3;
        L3.next = L4;
        L4.next = L5;
        L1.random = L3;
        L2.random = L5;
        L3.random = L1;
        L4.random = L2;
        L5.random = L5;


        RandomListNode temp = Clone(L1);
        while (temp != null){
            System.out.println(temp+"     N:"+temp.next+"    R:"+temp.random);
            temp = temp.next;

        }

    }
    //存放原有链表中节点与新生成链表节点的一一对应关系
    private static HashMap<RandomListNode,RandomListNode> map = new HashMap<>();
    public static RandomListNode Clone(RandomListNode pHead)
    {
       if(pHead == null) return null;
       RandomListNode temp =  pHead.next;
       //建立新的头结点
       RandomListNode newList = new RandomListNode(pHead.label);
       map.put(pHead,newList);
       RandomListNode head = newList;
       //按照next顺序建立链表
       while (temp != null){

           //按顺序建立新的链表
           newList.next = new RandomListNode(temp.label);
           //将新旧节点对应加入map
           map.put(temp,newList.next);
           newList = newList.next;
           temp = temp.next;
       }

       temp = pHead;
       newList = head;
       //重写遍历链表，根据旧的链表random指向，确定新链表的random指向
       while (temp != null){
            if(map.size()>0&&temp.random!=null){
                newList.random = map.get(temp.random);
            }
           temp = temp.next;
            newList = newList.next;
       }
        return head;
    }


}

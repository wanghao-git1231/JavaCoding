package 举例让抽象具体化;

import java.util.Stack;

/*********************
 * 剑指offer:栈的压入、弹出序列
 * 题目描述：
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，
 * 序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等的）
 * 思路：
 * 栈特点：先入先出，但弹出不一定是都插入完再弹出；用一个辅助栈，模拟这个过程
 ********************/

public class IsPopOrder {
    public static void main(String[] args) {
        int[] pushA = {1,2,3,4,5},popA = {4,5,3,2,1},wrongA = {4,3,5,2,1},wrongB = {4,3,5,1,2};
        System.out.println(IsPopOrder(pushA,wrongB));
    }

    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack1 = new Stack<>();
        //模拟压栈过程
        int j = 1; //
        stack1.push(pushA[0]);//先将第一个压入
        for(int i = 0;i<popA.length;){
            //如果栈顶与popA不等，则说明再压入pushA中数据
            if(stack1.peek() != popA[i] ){
                //都已经压入，不能再压入了
                if(j == popA.length) break;
                stack1.push(pushA[j++]);
            }else{//相等则弹出，比较下一个弹出元素
                stack1.pop();
                i++;
            }


        }
        if(stack1.empty()) return true;
        else return false;
    }

}

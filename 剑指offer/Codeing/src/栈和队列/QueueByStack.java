package 栈和队列;

import java.util.Stack;

/*******************
 * 剑指offer:用两个栈实现队列
 * 题目描述
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 ******************/

public class QueueByStack {
     Stack<Integer> stack1 = new Stack<Integer>();  //数都放入
     Stack<Integer> stack2 = new Stack<Integer>();  //临时存储


    public  void push(int node) {
        stack1.push(node);



    }

    public  int pop() {
        stack2.clear();
        while (stack1.size() >1){

            stack2.push(stack1.peek());
            stack1.pop();
        }
        int a = stack1.peek();
        stack1.pop();
        while (!stack2.empty()){
            stack1.push(stack2.peek());
            stack2.pop();
        }
        return a;
    }
}

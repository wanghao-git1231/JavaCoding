package 举例让抽象具体化;
import java.util.Stack;

/*************************
 *剑指offe:包含min函数的栈
 * 题目描述
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 * 注意：保证测试中不会当栈为空的时候，对栈调用pop()或者min()或者top()方法。
 * 思路：
 * //应用一个辅助栈，压的时候，如果A栈的压入比B栈压入大，B栈不压，，，，
 * // 小于等于，AB栈同时压入，出栈，如果，AB栈顶元素不等，A出，B不出。
 *
 *************************/


public class MinStack {
    private Stack<Integer> s = new Stack<>();  //输入数据栈
    private Stack<Integer> temp = new Stack<>();//按顺序存储最小值

    public void push(int node) {
        s.push(node);
        if(s.size() == 1){
            temp.push(node);
        }else {
                //add(temp,node);
            if(temp.peek()>=node) temp.push(node);
        }
    }
    //minInt如果被弹出了呢
    public void pop() {
        //int t = s.peek();
        if(s.peek() == temp.peek()) temp.pop();
        s.pop();

        //out(temp,t);
    }

    public int top() {
        return s.peek();
    }

    public int min() {
        return temp.peek();
    }

    /*  最笨的办法，用辅助栈将栈排序
    private void add(Stack<Integer> s,int node){
        if(s.empty()||s.peek()>=node) {
            s.push(node);
            return;
        }
        else{
            int t = s.peek();
            s.pop();
            add(s,node);
            s.push(t);
            return;
        }

    }
    private void out(Stack<Integer> s,int node){
        if(s.peek()!=node){
            int t = s.peek();
            s.pop();
            out(s,node);
            s.push(t);
        }else{
            s.pop();
        }
    }*/
}

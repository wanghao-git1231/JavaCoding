package Easy.Case155;

import java.util.Stack;

/**************************
 * LeetCode Case 155:最小栈
 * 题目描述：
     * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
     * push(x) —— 将元素 x 推入栈中。
     * pop() —— 删除栈顶的元素。
     * top() —— 获取栈顶元素。
     * getMin() —— 检索栈中的最小元素。
 * 思路：
 *      思路一：同步辅助栈，与主栈长度相同，栈顶是当前主栈最小值，同步弹出
 *      思路二：非同步辅助栈，辅助栈长度与主栈不同，只有当更小值入栈时才入辅助栈，只有辅助栈顶出主栈时，辅助栈弹出
 *      思路三：使用数据对，存储当前数据对应最小值
 *      思路四：使用链表实现栈后进先出，添加min属性，类似数据对，记录当前数据加入后的最小值
 *      思路五：只使用一个栈，设置变量记录min,当有更小的加入时，同时入栈之前的最小值与当前值，更新min，
 *      当min弹出时，连续弹出两个值，第二个是前一阶段的min,赋给min

 *************************/


//同步辅助栈法
public class MinStack {
    /** initialize your data structure here. */
    //存储栈
    private Stack<Integer> stack = null;
    //同步辅助栈，当入栈一个数时，将栈中最小值，放入辅助栈
    private Stack<Integer> min = null;
    public MinStack() {
        stack = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if(min.size() == 0){
            min.push(x);
        }else {
            int m = min.peek();
            if(x<m) min.push(x);
            else min.push(m);
        }
    }

    public void pop() {
        stack.pop();
        min.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        if(min.size() == 0) return 0;
        else return min.peek();
    }
}

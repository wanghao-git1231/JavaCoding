package Easy.Case155;

public class TestMinStack {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(0);
        minStack.push(-2);
        int min = minStack.getMin();
        System.out.println(min);
        int top = minStack.top();
        System.out.println(top);
        minStack.pop();
        minStack.push(-3);
        min = minStack.getMin();
        System.out.println(min);
    }
}

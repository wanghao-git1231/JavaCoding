package 举例让抽象具体化;

public class TestMinStack {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(5);
        minStack.push(3);
        minStack.push(2);
        minStack.push(4);
        minStack.push(1);
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.min());
    }
}

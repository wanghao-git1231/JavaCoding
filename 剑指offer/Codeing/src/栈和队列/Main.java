package 栈和队列;

public class Main {
    public static void main(String[] args) {
        QueueByStack s = new QueueByStack();
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
    }
}

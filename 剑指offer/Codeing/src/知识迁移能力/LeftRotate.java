package 知识迁移能力;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Consumer;

/**************************
 * 剑指offer:左旋转字符串
 * 题目描述
 *      汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 *      对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 *      例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 * 思路：
 *      1.通过字符长度除以将要左移的次数 n%s，得到前几个数res应该放到后面，使用subString分割
 *      2.使用queue模拟左移过程
 **************************/

public class LeftRotate {
    public static void main(String[] args) {
        String s = "abcdef";
        String s1 = LeftRotateString(s, 3);
        System.out.println(s1);
    }

    //利用java String自带方法，截取新的子串
    public static String LeftRotateString(String str,int n) {
        if (str.length() == 0) return new String();
        if (n == 0) return str;
        int res = n%str.length();  //取余，结果放到后面
        String last = str.substring(0,res);
        String head = str.substring(res);

        return head+last;
    }


    //队列辅助先进先出
    public static String LeftRotateString2(String str,int n) {
        if(str.length()==0) return new String();
        if(n == 0) return str;
        LinkedBlockingQueue<Character> queue = new LinkedBlockingQueue<>();
        
        for (int i = 0;i<str.length();i++){
            queue.add(str.charAt(i));
        }
        for(int i = 0;i<n;i++){
            Character peek = queue.peek();
            queue.poll();
            queue.add(peek);
        }
        StringBuffer sb = new StringBuffer();
        queue.forEach(new Consumer<Character>() {
            @Override
            public void accept(Character character) {
                sb.append(character);
            }
        });
        return sb.toString();
    }
}

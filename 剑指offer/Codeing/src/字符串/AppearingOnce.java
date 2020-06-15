package 字符串;

/******************************
 *剑指offer:字符流中第一个不重复的字符
 * 题目描述
     * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
     * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
     * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 *  思路：
 *      1.把字符加入到一个容器中，数组，队列，vectot ....
 *      2.使用另一个容器，数组，队列等标识出现顺序和是否重复
 *      3.在这里，使用两个vector按第一次出现顺序存入，如果重复bool值置为true,返回第一个bool为false的即可
 *      4.其他方法字符一共128或256个设这个一个数组即可，这样使用队列返回最顶上的
 ******************************/

import java.util.Vector;

public class AppearingOnce {
    public static void main(String[] args) {

        char[] str = "helloworld".toCharArray();
        for (int i = 0; i < str.length; i++) {
            Insert(str[i]);
            char c = FirstAppearingOnce();
            System.out.println(c);
        }
    }

    private static Vector<Character> charVector = new Vector<>();
    private static Vector<Boolean> boolVector = new Vector<>();

    //Insert one char from stringstream
    public static  void Insert(char ch)
    {
            boolean isRepeat = false;
            for (int i = 0; i < charVector.size(); i++) {
                if(ch == charVector.get(i)){
                    boolVector.set(i,true);
                    isRepeat = true;
                }
            }
            if(isRepeat == false) {
                charVector.add(ch);
                boolVector.add(false);
            }

    }
    //return the first appearence once char in current stringstream
    public static char FirstAppearingOnce()
    {
        char res  = '#';
        for (int i = 0; i < boolVector.size(); i++) {
            if(boolVector.get(i) == false){
                res = charVector.get(i);
                break;
            }
        }
        return res;
    }
}

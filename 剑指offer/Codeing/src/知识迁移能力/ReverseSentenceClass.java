package 知识迁移能力;

/*********************
 * 剑指offer：翻转单词顺序列
 * 题目描述
     * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
     * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
     * 例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
     * Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 * 思路：
 *      1.使用split根据空格切分，多个子串，然后倒序组装
 *      2.可以使用队列存储单词，使用栈倒序输出
 *
 ********************/

public class ReverseSentenceClass {
    public static void main(String[] args) {
        String s = " I";
        String reverseSentence = ReverseSentence(s);
        System.out.println(reverseSentence);
    }

    public static String ReverseSentence(String str) {
        if(str == null) return new String();
        String[] s = str.split(" ");
        if(s.length == 0) return " ";
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length-1; i++) {
            sb.append(s[s.length-1-i]);
            sb.append(" ");
        }
        sb.append(s[0]);

        return sb.toString();
    }
}

package 字符串;

/******************************
 剑指offer：替换空格
题目描述
请实现一个函数，将一个字符串中的每个空格替换成“%20”。
例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 ******************************/

public class StringQuestion {

    public static void main(String[] args) {
        String s = "we jkj lk";
        String res = replaceSpace(new StringBuffer(s));

        System.out.println(res);
    }
    public static String replaceSpace(StringBuffer str) {


        for(int i = 0;i < str.length();i++){

            if(str.charAt(i) == ' '){
                str.replace(i,i+1,"%20");
            }
        }

        String s = str.toString();
        return  s;
    }
}

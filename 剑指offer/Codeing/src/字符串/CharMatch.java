package 字符串;

/****************************
 * 剑指offer：正则表达式匹配
 * 题目描述
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。
 * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 * 思路：递归+选与不选
 *      1.对于*有两种.*代表0次或1次
 *      2.要的是能够走到字符与正则表达式的结尾，而不需要知道具体怎样连续以及中间有几个无用的，而且能够退回
 ***************************/

public class CharMatch {
    public static void main(String[] args) {
      // char[] a = {'a','a','c','a'};
        char[] a = {'a','a','a','c'};
        //char[] b = {'a','b','*','b','*','a','c','*','a'};
        //char[] b = {'a','*','a'};
       // char[] b = {'a','a','.','a'};
         //char[] b = {'a','*','c'};
        //char[] b = {'a','*','b','*','c'};
        char[] b ={'a','*','b','*','c','*','a','c'};
      // char[] b = {'a','b','*','.','*','c','*','a','a','c','*','c','a','*'};

        boolean res = match(a, b);
        System.out.println(res);
    }

    //str:给定的字符串，pattern:正则表达式
    public static boolean match(char[] str, char[] pattern)
    {
        if(str == null||pattern == null) return false;
        return matchCore(str,0,pattern,0);


    }
    public static boolean matchCore(char[] str, int strIndex, char[] pattern,int patIndex){



        //正常结束应该是两个字符都走到最后一个
        if(strIndex == str.length&&patIndex == pattern.length)return true;
        //非正常结束
        if(strIndex < str.length&&patIndex == pattern.length) return false;

        System.out.println(strIndex+ " " +patIndex);
        //后面一个是*
        if(patIndex+1<pattern.length&&pattern[patIndex+1] == '*'){

            boolean ret = false;
            //重复一次或多次
            if(strIndex != str.length&&(str[strIndex] == pattern[patIndex]||pattern[patIndex] == '.') ){
                ret = matchCore(str,strIndex+1,pattern,patIndex);
            }

            //str走到头但是pattern没到头失败时，进入这里，所以不用去考虑*具体多少个，可以退回
            //0次
            return  ret ||matchCore(str,strIndex,pattern,patIndex+2);

        }
       System.out.println(strIndex + "--------------------" + patIndex);

        //后面没有*的情况
        if(strIndex != str.length&&(str[strIndex] == pattern[patIndex]||pattern[patIndex] == '.')){

            return matchCore(str,strIndex+1,pattern,patIndex+1);
        }else {
            System.out.println(strIndex + "************************" + patIndex);

            return false;
        }
    }
}

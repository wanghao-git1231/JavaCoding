package 分解让复杂问题简单;

import java.util.ArrayList;

/***************************
 * 剑指offer:字符串排列
 * 题目描述
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,
 * 则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 输入描述:
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 * 思路：
 *  1.深度优先遍历，每次去一个，知道全部取完
 *  2.注意同一位置重复选取，如果下一次与当前相同，跳过
 *  3.测试用例只存在重复两个的情况，连续三个相同没有判断
 **************************/

public class PermutationClass {
    public static void main(String[] args) {
        String s = "aaa";
        ArrayList<String> strings = Permutation(s);
        System.out.println(strings);
    }

    private static ArrayList<String> strings = new ArrayList<>();
    public static ArrayList<String> Permutation(String str) {

        if(str.length()==0||str == null) return strings;
        char[] chars =str.toCharArray();
        boolean[] flag = new boolean[chars.length];
        //将字符串按字典排序
        for(int i = 0;i < chars.length;i++){
            int t = i;
            for(int j = i+1;j < chars.length;j++){
                if(chars[j] <chars[t]){
                    t = j;
                }
            }
            char temp = chars[i];
            chars[i] = chars[t];
            chars[t] = temp;
        }
        //标记该字符是否已经使用过
        for(int i = 0;i < chars.length;i++){
            flag[i] = true;
        }

        Sort(chars,flag);
        return strings;
    }
    private static StringBuilder sb = new StringBuilder();
    private static void Sort(char[] chars,boolean[] flag){
        if(sb.length()==chars.length) strings.add(sb.toString());
        //按字典顺序，依次选取未被使用的字符
        for(int i = 0;i<chars.length;i++){

            if(flag[i] == true)
            {
                flag[i] = false;
                sb.append(chars[i]);

                Sort(chars,flag);

                flag[i] = true;
                sb.deleteCharAt(sb.length()-1);
                //连续n个值相同，同一个i位置连续只取一次
                int m = i+1;
                for(;m<chars.length;m++){
                    if(chars[m] != chars[i]) {

                        break;
                    }
                }
                i = m-1;
                //  这样只满足连续两个相同if(i+1<chars.length&&chars[i] == chars[i+1]) i++;
            }


        }
    }


}

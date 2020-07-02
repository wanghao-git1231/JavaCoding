package Medium.Case22;

import java.util.ArrayList;
import java.util.List;

/**********************************
 * LeetCode Case 22:括号生成
 * 题目描述：数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 思路：回溯
 *      1.确保放入的左右括号有效，先放入左后放入右，放入的右的个数小于等于左边个数
 *      2.放入后，递归后应有删除放入数据的方法
 *      3.第二种回溯，跟简洁，要掌握，两个变量控制递归
 *
 *********************************/


public class GenerateParenthesis {
    public static void main(String[] args) {
        List<String> strings = generateParenthesis2(5);
        System.out.println(strings.toString());
        System.out.println(strings.size());
    }


    //都是回溯
    public static List<String> generateParenthesis2(int n) {
        List<String> ans = new ArrayList<>();
        help(new String(),0,0,n,ans);
        return ans;
    }

    //递归，按顺序两个条件控制递归进入弹出
    private static void help(String t,int left,int right,int n,List<String> ans){
        if(right == n){
            ans.add(t);
            return;
        }
        //先把左括号都放进去
        if(left<n){

            help(t+"(",left+1,right,n,ans);
        }
        //在放右括号，且放入右括号的个数要小于已放入左括号的个数
        if(right<left){
            help(t+")",left,right+1,n,ans);
        }
    }

    //回溯，写的乱
    public static List<String> strings = new ArrayList<>();
    public static List<String> generateParenthesis(int n) {
        List<Character> temp = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        helper(0,0,n,sb);
        return strings;
    }

    private static int counter = 1;
    private static void helper(int left,int right,int n,StringBuilder sb){
        sb.append('(');
        left++;

        if(left == n){

            for (int j = 0;j<n-right;j++){
                sb.append(')');
            }
            strings.add(sb.toString());

            sb.delete(left+right,n*2);

            return;
        }
        for (int i = 0;i<n-right&&i+right<=left;i++){

            for (int j = 0;j<i;j++){
                sb.append(')');
            }
            helper(left,right+i,n,sb);
            sb.delete(left+right-1,left+right+i);

        }

    }

}

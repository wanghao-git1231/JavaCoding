package Medium.Case647;


/********************************************
 * LeetCode Case647：回文子串
 * 题目描述：
     * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
     * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
 * 思路：中心扩展法
 *  思路一：手动选择
 *  思路二：以公式的形式计算出了，中心的位置，更简洁吧
 *******************************************/

public class CountSubstrings {
    public static void main(String[] args) {

        int aaa = countSubstrings2("abccbaaaabc");
        System.out.println(aaa);

    }

    //官方题解：回文中心分为，单个字符与相邻两个字符，共2n-1种，可以通过一个公式算得
    public static int countSubstrings2(String s) {
        int ans = 0;
        int len = s.length();
        for (int i = 0;i<2*len-1;i++){
            //计算回文中心，left值为1-n-1,right为0时单个字符为中心，为1时与右边相邻为中心
            int left = i/2;
            int right = left +i%2;
            //比较对称位置上字符是否相等，相等则继续向左向右扩
            while (left>=0&&right<len&&(s.charAt(left) == s.charAt(right))){
                //在此处比价l-r的值就可以用于求最长回文子串
                ans++;
                left--;
                right++;
            }
        }

        return ans;
    }

    //个人版本，对于对称中心选择没有那么简洁，但是好像比官方的快点，哈哈哈
    public static int countSubstrings(String s) {
        int res = 0;
        char[] chars = s.toCharArray();
        for (int i = 0;i<chars.length;i++){
            //由于设计问题，l r第一次要相同
            res += helper(chars,i,i);

        }
        return res;
    }

    //从每个字符开始，比较左右两边的字符是否相等，相等继续递归，否则返回
    private static int helper(char[] chars,int l,int r){
        if(l<0||r>=chars.length) return 0;
        int res = 0;
        //相等加1
        if(chars[l] == chars[r]) {
            //在此处比价l-r的值就可以用于求最长回文子串
            res++;
            //如果l==r，当个字符，判断右边一个是不是相同
            if(l == r&&r+1<chars.length&&chars[l] == chars[r+1]){
                //相同加1
                res++;
                //向左移1位，右移2位
                res += helper(chars,l-1,r+2);

            }
            //判断字符向左右扩大一
            res += helper(chars,l-1,r+1);

        }else return 0;

        return res;
    }
}

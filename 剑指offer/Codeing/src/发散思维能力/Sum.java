package 发散思维能力;

/**************************
 *剑指offer:求1+2+3+...+n
 * 题目描述
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * 思路：短路原理----&&的前面不成立，不再执行后面的
 **************************/

public class Sum {

    public static void main(String[] args) {
        int i = Sum_Solution(100);
        System.out.println(i);
    }

    //人家的简洁---短路原理
    public static int Sum_Solution(int n) {
        int sum = n;
        //当n = 0 时，n>0不成立，不再往后走，递归结束，开始返回
        boolean stop = (n>0)&&((sum+=Sum_Solution(n-1))>0);
        return sum;
    }

    //自己的解决思路是对的但麻烦了一点，都是短路原理，即在返回时用与判断不为真直接返回不再进入下一个递归
    //还使用了数组传递地址，存储数据，
    public static int Sum_Solution2(int n) {
        if(n == 0) return 0;
        int[] res = new int[1];
        Sum_Loop(1,n,res);
        return res[0];
    }
    public static boolean Sum_Loop(int n,int m,int[] res) {

        res[0] += n;
        return n!=m&&Sum_Loop(n+1,m,res); //如果n == m就不会往后走了

    }
}

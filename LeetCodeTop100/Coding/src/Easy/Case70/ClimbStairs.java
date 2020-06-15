package Easy.Case70;

/***********************************
 * LeetCode Case70：爬楼梯
 * 题目描述：
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     * 注意：给定 n 是一个正整数。
 * 思路：
 *      思路一：暴力方法，每次爬1或2，递归实现，超时
 *      思路二：发现每次结果是斐波那契数列，用递归实现，超时
 *      思路三：斐波那契数列迭代实现，通过
 *
 ***********************************/


public class ClimbStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs2(6));
    }

    //斐波那契迭代
    public static int climbStairs3(int n) {

        if(n == 1) return 1;
        if(n == 2) return 2;
        int first = 1,second = 2;
        for (int i = 3;i <= n;i++){
            int t = first + second;
            first = second;
            second = t;
        }

        return second;
    }

    //斐波那契数列递归，超时
    public static int climbStairs2(int n) {

        if(n == 1) return 1;
        if(n == 2) return 2;
        int first = 1,second = 2;
        for (int i = 3;i <= n;i++){
            int t = first + second;
            first = second;
            second = t;
        }

        return second;
    }


    //类似DFS，超时
    public static int climbStairs(int n) {
        conter(n);
        return ways;
    }

    private static int ways = 0;
    private static void conter(int len){
        if(len == 0){
            ways++;
            return;
        }
        conter(len - 1);
        if(len - 2>=0) conter(len - 2);
    }
}

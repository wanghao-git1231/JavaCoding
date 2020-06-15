package 时间空间效率的平衡;

/*******************
 * 剑指offer:丑数
 * 题目描述
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 * 思路：三指针，动态规划，使用数组存储已经去除的结果
 *  1.第一个数是1，剩下的丑数都是在一定基础上乘以2,3，5，
 *  2.设立三个指针，代表要2,3,5的丑数的位置，初始指向dp[0]=1；
 *  3.每次求出一个丑数就将，可以得到改丑数的指针移向下一个丑数。
 ******************/

public class UglyNumber {
    public static void main(String[] args) {
        int res = GetUglyNumber_Solution(10);
        System.out.println(res);

    }
    public static int GetUglyNumber_Solution(int index) {

        int indexOf2 = 0,indexOf3 = 0,indexOf5 = 0; //三指针，分别指向要乘以2,3,5的数在dp中的位置
        int dp[] = new int[index];  //建立长度为index的数组，按顺序存储抽数
        dp[0]= 1;
        for(int i = 1;i<index;i++){
            //取小的丑数
            dp[i] = Math.min(dp[indexOf2]*2, Math.min(dp[indexOf3]*3, dp[indexOf5]*5));
            //如果当前三指针中任意指针指向的值*2或3或5是丑数，则指向下一丑数
            if(dp[i] == dp[indexOf2]*2) indexOf2++;
            if(dp[i] == dp[indexOf3]*3) indexOf3++;
            if(dp[i] == dp[indexOf5]*5) indexOf5++;

        }

        return dp[index-1];
    }
}

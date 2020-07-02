package Medium.Case338;

/*********************************
 * LeetCode Case_338:比特位计数
 * 题目描述
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 * 思路：
 *      思路一：一个数的二进制1的个数，右移并与1按位与后1的个数
 *      思路二：从第2的n次方到2的n+1次方的值等于0-2的n次方之间值加1
 *      思路三:去看题解，但请理解  n&n-1
 ********************************/


public class CountBits {
    public static void main(String[] args) {


        int[] ints = countBits2(5);
        for (int i = 0;i < ints.length;i++){
            System.out.println(ints[i]);
        }

    }

    //动态规划 + 最高有效位:后面的数可以通过前面的数得到
    public static int[] countBits2(int num) {
        int[] res = new int[num +1];
        res[0] = 0;
        if(num == 0) return res;
        if(num >=1) res[1] = 1;
        int n = 2,i = 2,m = 2*n;
        while (i<=num){
            if(i == m) {
                n = m;
                m = m<<1;
            }
            res[i] = 1+res[i-n];
            i++;
        }
        return res;
    }

    //遍历每个数，对每个数按位与求每个数的二进制中1的个数
    public static int[] countBits(int num) {
        int[] res = new int[num +1];
        res[0] = 0;
        if(num == 0) return res;

        for (int i = 1;i <= num;i++){
            int t = i;
            //当前值按位与计算每个数的二进制中1的个数
            while (t!=0){
                if((t&1) == 1) res[i]++;
                t = t>>1;

            }
        }
        return res;
    }
}

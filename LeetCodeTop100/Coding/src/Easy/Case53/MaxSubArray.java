package Easy.Case53;

/********************************
 * LeetCode Case53：最大子序列和
 * 题目描述：
 *      给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 思路：
 *      思路一：
 *          1.使用动态规划，记录以当前点为结尾的子序列和
 *          2.如果当前值加入前一段子序列的和大于自身值，加入他们，否则以自己为头开始新的子序列
 *      思路二：分治算法，据说根据线段树设计，没看懂！！！
 *******************************/


public class MaxSubArray {
    public static void main(String[] args) {
        int[] a = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray2(a));
    }

    //动态规划简版
    public static int maxSubArray2(int[] nums) {
        if(nums.length == 0) return 0;
        //以当前值结尾的子序和
        int pre = nums[0];
        //最大子序和
        int max = nums[0];

        for (int i = 1;i < nums.length;i++){
            pre = pre + nums[i] >nums[i]?pre + nums[i]:nums[i];
            max = pre>max?pre:max;
        }

        return max;
    }


    //动态规划，如果前面的最大子序列和加上当前大于当前值，令最大子序列和为当前值+之前和，否则令为当前值
    public static int maxSubArray(int[] nums) {
        if(nums.length == 0) return 0;
        //状态记录当前值加入的最大序列和
        int[] dp = new int[nums.length];
        int max = nums[0];
        dp[0] = nums[0];
        for (int i = 1;i < nums.length;i++){
            //如果加入之前的最大子序列值大于当前值自身，加入他，否则从自己开始重新开头
            if(dp[i-1] + nums[i]>nums[i]) dp[i] = dp[i-1] + nums[i];
            else dp[i] = nums[i];
            if(dp[i]>max) max = dp[i];
        }

        return max;
    }
}

package Easy.Case198;


import java.util.Stack;

/**************************
 * LeetCode Case198：打家劫舍
 * 题目描述：
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是
 * 相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。给定
 * 一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 * 思路：
 *  思路一：
 *      不能相邻的意思是，至少隔一个抢，但是如果隔着3个就是隔1个子情况了，所以只有隔1、2情况,递归超时
 *  思路二：动态规划
 *  Plus:本来就不熟悉动态规划，这个题更无法将想到动态规划，体会不出动态规划的意思来，还是蠢！！！
 *
 *************************/



public class Rob {
    public static void main(String[] args) {

        //int[] nums = {114,117,207,117,235,82,90,67,143,146,53,108,200,91,80,223,58,170,110,236,81,90,222,160,165,195,187,199,114,235,197,187,69,129,64,214,228,78,188,67,205,94,205,169,241,202,144,240};
       int[] nums = {226,174,214,16,218,48,153,131,128,17,157,142,88,43,37,157,43,221,191,68,206,23,225,82,54,118,111,46,80,49,245,63,25,194,72,80,143,55,209,18,55,122,65,66,177,101,63,201,172,130,103,225,142,46,86,185,62,138,212,192,125,77,223,188,99,228,90,25,193,211,84,239,119,234,85,83,123,120,131,203,219,10,82,35,120,180,249,106,37,169,225,54,103,55,166,124};
      // int[] nums = {2,1,1,2};
        int rob = rob3(nums);
        System.out.println(rob);

    }

    //优化，动态规划+滚动数组
    public static int rob3(int[] nums) {
        if(nums == null||nums.length == 0) return 0;

        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0],nums[1]);
        int first = nums[0],second = nums[1];

        for (int i = 2;i < nums.length;i++){
            int t = second;
            second = Math.max(first + nums[i],second);
            first = t;
        }
        return second;
    }

    //动态规划
    public static int rob2(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        if(nums.length >= 2)dp[1] = Math.max(nums[0],nums[1]);
        for (int i = 2;i < nums.length;i++){
            dp[i] = Math.max(dp[i-2] + nums[i],dp[i - 1]);
        }
        return dp[nums.length - 1];
    }

    static Stack<Integer> stack = new Stack<>();
    //递归，超时
    public static int rob(int[] nums) {
        stack.add(0);
        find(nums,0,0);
        stack.pop();
        stack.add(1);
        find(nums,1,0);
        stack.pop();
        return max;

    }

    private static int max = 0;
    public static void find(int[] nums,int index,int sum) {


        sum += nums[index];
        if(index == nums.length - 1||index == nums.length - 2){
            if(sum > max) max = sum;
            System.out.println(stack.toString());
            return;
        }
       // System.out.println(index+"----"+sum);
        stack.add(index+2);
        find(nums,index+2,sum);
        stack.pop();
        if(index + 3 < nums.length){
            stack.add(index+3);
            find(nums,index+3,sum);
            stack.pop();
        }

    }
}

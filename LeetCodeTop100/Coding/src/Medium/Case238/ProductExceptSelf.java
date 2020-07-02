package Medium.Case238;

/*******************************************
 * LeetCode Case_238:除自身以外数组的乘积
 * 题目描述：
     * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，
     * 其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 * 思路：
 *      1.第一遍正序，pre得到第i前的数的乘积
 *      2.第二遍倒序，pre得到第i后的数的乘积
 *      3.二者的乘积即是除自身之外的乘积
 *****************************************/

public class ProductExceptSelf {
    public static void main(String[] args) {
        int[] a = {1,2,3,4};
        int[] ints = productExceptSelf(a);
        for (int i = 0;i < ints.length;i++){
            System.out.println(ints[i]);
        }
    }

    //两遍，第一遍得到第i的前缀积，第二遍倒序，得到第i的后缀积
    public static int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];

        for (int i = 0;i < res.length;i++){
            res[i] = 1;
        }
        //做前缀积
        int pre = 1;
        for (int i = 0;i < nums.length;i++){
            res[i] *= pre;
            pre *= nums[i];
        }
        //做后缀积
        pre = 1;
        for (int i = nums.length - 1;i >= 0;i--){
            res[i] *= pre;
            pre *= nums[i];
        }

        return res;
    }
}

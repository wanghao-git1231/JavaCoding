package Easy.Case1;

import java.util.HashMap;

/*******************************
 * LeetCode Case1：两数之和
 * 题目描述：
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，
     * 并返回他们的数组下标。你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * 思路：
 *      思路一：暴力双重遍历
 *      思路二：使用hashmap保存已经遍历的值与索引
 ******************************/

public class TwoSum {
    public static void main(String[] args) {

        int[] num = {2, 7, 11, 15};
        int target = 9;
        int[] ints = twoSum2(num, target);
        for (int i = 0;i < ints.length;i++){
            System.out.println(ints[i]);
        }

    }

    //使用map保存已经访问的值
    public static int[] twoSum2(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0;i < nums.length;i++){
            if(map.get(target - nums[i])!=null) {
                res[0] = map.get(target - nums[i]);
                res[1] = i;
                return res;
            }
            else {
                map.put(nums[i],i);
            }
        }
        return res;
    }
    //循环嵌套
    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for (int i = 0;i < nums.length;i++){
            for (int j = 0;j < nums.length;j++){
                if(i == j) continue;
                if(nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }

        return res;
    }
}

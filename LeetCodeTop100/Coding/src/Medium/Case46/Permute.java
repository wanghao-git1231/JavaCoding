package Medium.Case46;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/***************************************
 * LeetCode Case 46:全排列
 * 题目描述：
    * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * 思路：
 *  思路一：回溯，dfs,递归，标志位
 *  思路二：交换法
 *      1.对每个位置交换
 *      2.对后面的位置进行全排列
 **************************************/



public class Permute {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> permute = permute2(nums);
        System.out.println(permute.toString());
        System.out.println(permute.size());
    }


    //交换法：通过交换位置实现全排列
    public static List<List<Integer>> permute2(int[] nums) {
        if(nums.length == 0) return lists;
        List<Integer> t = new ArrayList<>();
        for (int i = 0; i < nums.length;i++){
            t.add(nums[i]);
        }

        help(t,0,nums.length - 1);
        return lists;
    }

    //对某一个位置进行全排列
    private static void help(List<Integer> t,int start,int end){
        if(start == end){
            lists.add(new ArrayList<>(t));
        }

        for (int i = start;i <= end;i++){
            Collections.swap(t,i,start);
            help(t,start + 1,end);
            Collections.swap(t,i,start);
        }

    }


    //回溯：递归，使用标志位，dfs
    private static List<List<Integer>> lists = new ArrayList<>();
    private static List<Integer> temp = new ArrayList<>();
    public static List<List<Integer>> permute(int[] nums) {
        if(nums.length == 0) return lists;
        boolean[] flag = new boolean[nums.length];  //默认false

        for (int i = 0;i < nums.length;i++){
            if(!flag[i]){
                temp.add(nums[i]);
                flag[i] = true;
                helper(nums,flag);
                flag[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
        return lists;
    }

    //每次将还没访问过的数，挑一个放入列表
    private static void helper(int[] nums,boolean[] flag){
        if(temp.size() == nums.length){
            lists.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0;i < nums.length;i++){
            if(!flag[i]){
                temp.add(nums[i]);
                flag[i] = true;
                helper(nums,flag);
                flag[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }
}

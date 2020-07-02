package Medium.Case39;

import java.util.*;
import java.util.function.Consumer;

/***************************************
 * LeetCode Case39：组合总和
 * 题目描述：
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 * 说明：
     * 所有数字（包括 target）都是正整数。
     * 解集不能包含重复的组合。 
 * 思路：回溯+剪枝
 *  1.先将先于target的值找出并排序
 *  2.从0位置开始，加上本身或后面的数如果小于target继续递归，直到累加和等于target
 *
 **************************************/

public class CombinationSum {
    public static void main(String[] args) {
        int[] nums = {2,3,5};
        List<List<Integer>> lists = combinationSum(nums, 8);
        System.out.println(lists.toString());
    }


    //先查找小于target的值加入list，
    //从index出开始，加上本身或后面的数如果小于target继续递归，直到累加和等于target
    private static List<Integer> list = new ArrayList<>();
    private static List<List<Integer>> res = new ArrayList<>();
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        //先查找小于等于target的值加入list
        for (int i = 0;i < candidates.length;i++){
            if(candidates[i] <= target)list.add(candidates[i]);
        }
        //如果没有小于等于，则直接返回
        if(list.size() == 0) return res;
        //将list从小到大排序
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1<o2) return 1;
                return 0;
            }
        });
        helper(target,0,0);

        return res;
    }
    //从index出开始，加上本身或后面的数如果小于target继续递归，直到累加和等于target
    private static Stack<Integer> stack = new Stack<>();  //保存复合递归条件的值
    private static void helper(int target,int sum,int index){
        if(sum == target){
            List<Integer> temp = new ArrayList<>();
            stack.forEach(new Consumer<Integer>() {
                @Override
                public void accept(Integer integer) {
                    temp.add(integer);
                }
            });
            res.add(temp);
        }
        //加上本身或之后的值所以递归时传入index不变
        for (int i = index;i<list.size();i++){
            //累加和小于target,有机会累加和等于target，继续
            if(list.get(i) + sum <=target) {
                stack.add(list.get(i));
                helper(target,sum+list.get(i),i);
                stack.pop();
            }
        }
    }
}

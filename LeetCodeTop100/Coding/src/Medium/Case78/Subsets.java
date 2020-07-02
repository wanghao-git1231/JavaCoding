package Medium.Case78;

import java.util.ArrayList;
import java.util.List;

/***********************************
 * LeetCode Case 78:子集
 * 题目描述：
     * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
     * 说明：解集不能包含重复的子集。
 * 思路：
 *  思路一：递归？还是叫动态规划
 *      1.加入以nums[i]结尾的子集
 *      2.在之前已经加入的子集的结果上添加当前nums[i]
 *      3.之前子集通过深拷贝，再添加
 *  思路二：回溯？还是叫递归
 *      1.按照子集中数的个数分类，0，1,2...n
 *      2.个数也是递归的边界
 *      3.每种都是头与其后的组合，递归
 *      4.递归进入出来时，子集加入和删除数
 *   思路三：二进制位
 *      1.总的子集个数为2的n次方
 *      2.制造数范围0-2的n次方
 *      3.遍历数的每一位，为1就加入集合
 *      4.位运算：左移、右移、按位与
 **********************************/



public class Subsets {
    public static void main(String[] args) {
        int[] a = {1,2,3,5,6};
        List<List<Integer>> subsets = subsets3(a);
        System.out.println(subsets.size());
        System.out.println(subsets.toString());

    }

    //方法三：由于子集大小是2的n次方，则每种解如1011，即是对应1的位置的nums[i]，加入集合
    public static List<List<Integer>> subsets3(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        //遍历2的N次方
        for (int i = 0;i < 1<<nums.length;i++){
            List<Integer> list = new ArrayList<>();
            //判断i第j位是不是1，通过右移以及按位与实现
            for (int j = 0;j<nums.length;j++){
                if(((i>>j) & 1) == 1) list.add(nums[j]);
            }
            lists.add(list);
        }

        return lists;
    }


    //方法二：官方说是回溯，但感觉更应该叫递归或DFS,只是深度由人控制，对于n个中去m个进行排列组合，使用递归，竟然忘了
    public static List<List<Integer>> subsets2(int[] nums) {

        //i代表子集的大小
        for (int i = 0;i < nums.length + 1;i++){
            helper(0,i ,nums);
        }
        return res;
    }
    //结果集与临时变量
    private static List<List<Integer>> res = new ArrayList<>();
    private static List<Integer> temp = new ArrayList<>();

    //进行排列的函数
    private static void helper(int i,int len,int[] nums){
        //如果临时子集长度等于当前要求子集大小，加入结果集并返回
        if(temp.size() == len){
            res.add(new ArrayList<>(temp));
            return;
        }

        //向子集添加当前i为数，并递归，以及弹出
        for (int j = i ;j < nums.length;j++){
            temp.add(nums[j]);
            helper(j+1,len,nums);
            temp.remove(temp.size() - 1);
        }

    }

    //就会这一种
    //第一种方法：官方说是递归？感觉更像动态规划，以当前nums[i]结尾,在之前值上加当前值即可，只需深拷贝之前并添加
    public static List<List<Integer>> subsets(int[] nums) {
        //要返回的结果
        List<List<Integer>> subset = new ArrayList<>();
        //空
        subset.add(new ArrayList<>());
        //数组为空返回
        if(nums.length == 0) return subset;

        //根据前面的子集，得到以nums[i]为结尾的子集
        for (int i = 0;i<nums.length;i++){
            //获取前面数组成的子集大小
            int len = subset.size();
            //依次取出并深拷贝之前子集，并在结尾加入nums[i]
            for (int j = 0;j<len;j++){

                List<Integer> list = new ArrayList<>(subset.get(j));
                list.add(nums[i]);
                subset.add(list);
            }
        }

        return subset;
    }
}

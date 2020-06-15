package Easy.Case448;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/*****************************************
 *LeetCode Case448: 找到所有数组中消失的数字
 * 题目描述：
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 * 思路：
 *      思路一：先排序，通过比较每一个数找出确的值返回
 *      思路二：将将所有正数作为数组下标，置对应数组值为负值。那么，仍为正数的位置即为（未出现过）消失的数字。
 ****************************************/


public class FindDisappearedNumbers {
    public static void main(String[] args) {
        int[] a = {1,4,3,2,7,8,2,3,1};
        int[] b = {1,1};
        List<Integer> disappearedNumbers = findDisappearedNumbers(a);

        disappearedNumbers.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });
    }

    //自己的
    public static List<Integer> findDisappearedNumbers2(int[] nums) {
        //先排序
        Arrays.sort(nums);
        int len = nums.length;
        List<Integer> list = new ArrayList<>();
        int order = 1;
        //没有缺失应是i与order 同时加，缺失则出现num[i]>order即缺失order，当某两位重复，出现小于
        for (int i = 0;i < len;){
            if(nums[i]>order) list.add(order++);
            else if(nums[i] == order) {
                order++;
                i++;
            }else{
                i++;
            }
        }

        for (int i = order;i<=len;i++){
            list.add(i);
        }

        return list;
    }

    //人家的
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        //将num[i]-1位置上的数置为负值
        for (int i = 0; i < nums.length;i++){
            nums[Math.abs(nums[i]) - 1] = -Math.abs(nums[Math.abs(nums[i]) - 1]);
        }

        List<Integer> list = new ArrayList<>();
        //如果某一位值是正，即为缺失
        for (int i = 0;i<nums.length;i++){
            if(nums[i]>0) list.add(i+1);
        }
        return list;
    }
}

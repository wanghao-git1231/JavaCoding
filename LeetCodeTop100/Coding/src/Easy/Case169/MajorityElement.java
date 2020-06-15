package Easy.Case169;

import java.util.Arrays;
import java.util.HashMap;

/*******************************************
 * LeetCode Case169:多数元素
 * 题目描述：
     * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
     *你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * 思路：
 *      思路一：使用hashmap遍历统计每个元素，统计出现次数，返回多数元素
 *      思路二：摩尔投票法
 *          1.多数减少数结果一定>0
 *          2.每个候选人，遇到相同的加一，遇到不同的减一，减0时重新选一个计票
 *      思路三：先排序，拍完后第n/2个一定是多数元素
 *
 *******************************************/


public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,1};
        int i = majorityElement(nums);
        System.out.println(i);
    }

    //排序法
    public int majorityElement3(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    //摩尔投票法，多数减少数结果一定>0;每个候选人，遇到相同的加一，遇到不同的减一，减0时重新选一个计票
    public int majorityElement2(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            //如果等于0重新选一个
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }

    //使用map存储次数
    public static int majorityElement(int[] nums) {
        float half = nums.length/2;
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i = 0;i < nums.length;i++){
            if(map.containsKey(nums[i]))
            {
                int size = map.get(nums[i])+1;
                if(size>half) return nums[i];
                map.put(nums[i],size);
            }else map.put(nums[i],1);
        }
        //当只有一个元素时，返回第一个
        return nums[0];
    }
}

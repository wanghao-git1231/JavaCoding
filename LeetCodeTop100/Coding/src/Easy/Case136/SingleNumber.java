package Easy.Case136;

import java.util.*;

/********************************
 * LeetCode Case136：只出现一次的数字
 * 题目描述：
 *      给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 说明：
 *      你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *  思路：
 *      思路一：不受空间限制下，可以使用map 哈希表等存储
 *      思路二：异或三个性质
 *          1.任何数和 0 做异或运算，结果仍然是原来的数
 *          2.任何数和其自身做异或运算，结果是 0
 *          3.异或运算满足交换律和结合律
 *
 *受空间限制下一般都要想到“位运算”，与或非异或
 ********************************/


public class SingleNumber {
    public static void main(String[] args) {
        int[] a = {1,2,1,2,6};
        System.out.println(singleNumber2(a));
    }

    //位运算，异或，自动进行交换律
    public static int singleNumber2(int[] nums) {
        int single = 0;
        for (int i = 0;i < nums.length;i++){
            single ^= nums[i];
        }
        return single;
    }
    //使用hashset唯一标志，重复清除，留下的就是只出现一次的
    public static int singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0;i<nums.length;i++){

            if(set.add(nums[i])==false) set.remove(nums[i]);
        }
        Iterator<Integer> iterator = set.iterator();
        return iterator.next();
    }
}

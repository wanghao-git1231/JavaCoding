package Easy.Case283;


/*****************************
 * LeetCode Case:移动0
 * 题目描述：
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 思路：----可能跟快排思路差不多
 *      1.两个指针，一个一次指向所有非0的数current，一个指不含0部分下一个order
 *      2.如果current 不为0，令order位置值等于current位置值
 *****************************/

public class MoveZeros {
    public static void main(String[] args) {
        int[] nums = {1};
        moveZeroes(nums);
        for (int i = 0;i < nums.length;i++){
            System.out.println(nums[i]);
        }
    }

    public static void moveZeroes(int[] nums) {

        int order = 0,current = 0;

        //找到第一个0位置
        while (order<nums.length&&nums[order]!=0) order++;
        current = order;

        //order位置值必须是非零，currrnt正常向前走，把非零值赋给order位置
        while (order<nums.length&&++current!= nums.length){

            if(nums[current] != 0)nums[order++] = nums[current];

        }
        //把后面几位赋为0
        while (order!=nums.length) nums[order++] = 0;

    }

}

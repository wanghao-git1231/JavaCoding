package Medium.Case287;


/****************************************
 * LeetCode Case287:寻找重复数
 * 题目描述：
     * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。
     * 假设只有一个重复的整数，找出这个重复的数。
 * 说明：
     * 不能更改原数组（假设数组是只读的）。
     * 只能使用额外的 O(1) 的空间。
     * 时间复杂度小于 O(n2) 。
     * 数组中只有一个重复的数字，但它可能不止重复出现一次。
 * 思路：
 *      思路一：使用双重循环遍历
 *      思路二：使用Floyd判圈法，认为数组存储的值是指向下一个位置的指针，存在重复就是有圈
 *          1.快慢指针找到重复
 *          2.快慢指针同时移动找到圈的入口

 ***************************************/
public class FindDuplicate {
    public static void main(String[] args) {
        int[] nums = {3,1,3,4,2};
        int duplicate = findDuplicate2(nums);
        System.out.println(duplicate);

    }

    //快慢指针判圈
    public static int findDuplicate2(int[] nums) {
        int slow = 0;
        int fast = 0;
        //快慢指针头次相遇
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while (slow!=fast);
        //同时移动找到圈的入口
        slow = 0;
        while (slow!=fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
    //双重循环
    public static int findDuplicate(int[] nums) {

        for (int i = 0;i < nums.length;i++){
            for (int j = 0;j < nums.length;j++){
                if(j == i) continue;
                if(nums[j] - nums[i] == 0) return nums[i];
            }
        }

        return 0;
    }
}

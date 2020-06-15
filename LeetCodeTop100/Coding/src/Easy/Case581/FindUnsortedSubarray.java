package Easy.Case581;

/*********************************
 * LeetCode Case 581：最短无序连续子数组
 * 题目描述：
     * 给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
     * 你找到的子数组应是最短的，请输出它的长度。
 * 思路： 总时间复杂度O(2n),空间复杂度O(1)
 *      1.通过一次遍历，找到不再自己正确顺序的最小值与最大值
 *      2.再次遍历，找到min与max应该待的位置start end
 *      3.返回end - start + 1即是
 ********************************/


public class FindUnsortedSubarray {
    public static void main(String[] args) {
        int[] nums = {0,1,5,10,0,11};
        int unsortedSubarray = findUnsortedSubarray(nums);
        System.out.println(unsortedSubarray);
    }

    public static int findUnsortedSubarray(int[] nums) {
        if(nums.length == 1) return 0;
        //标志位，判断是不是把遍历时i = 0
        boolean first = false;
        //找到不再自己位置上的最大值与最小值
        int max = 0,min = 0;
        for (int i = 0;i < nums.length - 1;i++){
            if(nums[i] > nums[i + 1]){

                if(first == false){
                    max = nums[i];
                    min = nums[i+1];
                    first = true;
                    continue;
                }
                if(nums[i + 1] <min) min = nums[i + 1];
                if(nums[i] > max) max = nums[i];

            }
        }
        //排好序的，不需要改
        if(first == false) return 0;
        //默认将
        int start = 0,end = nums.length - 1;
        for (int i = 0;i < nums.length;i++){
            //找到第一个待遇min的，即是min应该待的位置
            if(first == true&&nums[i] > min) {
                start = i;
                first = false;
            }
            //找到最后一个小于max的，即是max应该待的位置
            if(nums[i] < max) end = i;

        }

        return end - start + 1;
    }
}

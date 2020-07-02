package Medium.Case215;

public class TestQuickSort {
    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        My_Quick_Sort.quickSort(nums,0,nums.length - 1);
        for (int i = 0;i < nums.length;i++){
            System.out.println(nums[i]);
        }
    }

}

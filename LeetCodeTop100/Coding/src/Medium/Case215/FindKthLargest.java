package Medium.Case215;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

/*****************************************
 * LeetCode Case215：数组中第K大元素
 * 题目描述：
     * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，
     * 而不是第 k 个不同的元素。
 * 思路：
 *  思路一：先使用java自带排序方法，然后返回第K大结果即可
 *  思路二：使用小顶堆，存储前K大的值，每次放入一个值，入股堆容量大于K弹出堆顶最小值，最后堆顶就是要找到值
 *  思路三：
 *      1.使用快速排序排序，每次排序完后返回当前排序值的索引位置
 *      2.如果排序中排序元素的索引是K,返回，不再递归
 *      3.快速排序需要将数组首元素与后面随机元素交换位置，以防止有序数组导致复杂度过高
 *  Plus:不会自己实现大顶堆或小顶堆
 ****************************************/

public class FindKthLargest {
    public static void main(String[] args) {
        int[] nums = {1};
        int kthLargest = findKthLargest3(nums, 1);
        System.out.println(kthLargest);
    }

    public static int findKthLargest3(int[] nums, int k){
        return find(nums,k,0,nums.length - 1);
    }

    private static int find(int[] nums,int k,int l,int r){
        if(l == r) return nums[l];
        randomSwap(nums,l,r);
        int index = quickSort(nums, l, r);

        if(index == nums.length - k) return nums[index];

        return index>nums.length - k?find(nums,k,l,index - 1):find(nums,k,index+1,r);
    }

    //将数组第一个数与后面随机一个值交换，防止出现有序数组，复杂度是n方
    private static void randomSwap(int[] nums,int l,int r){
        Random random = new Random();
        int i = random.nextInt(r - l);
        int temp = nums[l];
        nums[l] = nums[l+i];
        nums[l+i] = temp;
    }
    //单次快速排序，把l位置的值放在应该在的地方
    private static int quickSort(int[] nums,int l,int r){
        if(l == r) return l;
        int i = l,j = r,temp = nums[l];
        while (i<j){
            while (i<j&&nums[j]>temp) j--;
            if(i<j){
                nums[i++] = nums[j];
            }

            while (i<j&&nums[i]<temp) i++;
            if(i<j){
                nums[j--] = nums[i];
            }
        }
        nums[i] = temp;
        return i;
    }


    //使用小顶堆存储前K大的数据，遍历完一遍后，堆顶就是第K大的数
    public static int findKthLargest2(int[] nums, int k){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0;i < nums.length;i++){
            priorityQueue.add(nums[i]);
            if(priorityQueue.size()>k) priorityQueue.poll();

        }
        return priorityQueue.peek();
    }

    //调用java的排序方法，数组排序后直接输出就可以了
    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);

        return nums[nums.length - k];
    }
}

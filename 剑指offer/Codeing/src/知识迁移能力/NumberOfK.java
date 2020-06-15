package 知识迁移能力;

/*****************************
 *剑指offer：数字在排序数组中出现的次数
 * 题目描述
 * 统计一个数字在排序数组中出现的次数。
 * 思路：
 *      1.笨办法：直接变量
 *      2.见到有序想到二分！！！：先通过二分法找到一个k,再向左向右知道不等于k
 *****************************/

public class NumberOfK {
    public static void main(String[] args) {
        int[] nums = {1,2,2,3,3,3};
        int i = GetNumberOfK(nums, 3);
        System.out.println(i);
    }

    //二分法先找到一个k再找出所有k
    public static int GetNumberOfK(int [] array , int k) {
        if(array.length == 0||array[array.length-1] < k) return 0;
        int fisrtK = FisrtK(array, 0, array.length - 1, k);
        int start = fisrtK,end = fisrtK;

        while (array[start--]==k){
        }
        while (array[end]==k){
            if(end == array.length-1) break;
            end++;

        }

        return end - start -1;
    }
  //二分法找到一个k
    public static int FisrtK(int[] arr,int start,int end,int k){

        if(start == end&&arr[start]!=k) return 0;
        int mid = (end + start)/2;
        if(mid == k) return mid;
        else if(mid>k) return FisrtK(arr,start,mid-1,k);
        else return FisrtK(arr,mid+1,end,k);
    }
    //笨办法遍历
    public static int GetNumberOfK2(int [] array , int k) {
        if(array.length == 0||array[array.length-1] < k) return 0;
        int start = -1,end = array.length;

        for (int i = 0; i < array.length; i++) {
            if(array[i] == k&&start == -1) start = i;
            if(array[i] > k &&start != -1) {
                end = i;
                break;
            }
        }
        if(start!=-1) return end - start;
        else return 0;
    }
}

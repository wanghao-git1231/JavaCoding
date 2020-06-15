package 栈和队列;

import java.util.ArrayList;

/**********************************************
 * 剑指offer：滑动窗口的最大值
 * 题目描述
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}
 * 及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 * 思路：
 *      1.保存滑动窗口的值，求最大值
 *      2.在此处保存使用的是保存窗口开始结束的序号，用单独的方法计算，可能比较麻烦
 *      3.其他办法：使用双端队列LinkedList 按保存下标，是最左边是最大的后面一次减小，同时判断是否有效，更快吧
 * *******************************************/

public class SlideWindow {
    public static void main(String[] args) {
        int[] a = {2,3,4,2,6,2,5,1};
        ArrayList<Integer> arrayList = maxInWindows(a, 3);
        System.out.println(arrayList.toString());
    }
    public static ArrayList<Integer> maxInWindows(int [] num, int size)
    {

        ArrayList<Integer> arrayList = new ArrayList<>();
        if(num.length == 0||size == 0||size>num.length) return arrayList;
        int s = 0,e = size-1;

        while (e<num.length){
            arrayList.add(FindMax(num,s,e));
            s++;
            e++;
        }
        return arrayList;
    }

    private static int FindMax(int[] nums,int s,int e){
        System.out.println(s+"   "+e);
        int max = nums[s];
        for (int i = s;i<=e;i++){
            if(nums[i] > max) max = nums[i];
        }
        return max;
    }

}

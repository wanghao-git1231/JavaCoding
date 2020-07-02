package Medium.Case11;

/*********************************
 * LeetCode Case11:盛最多水的容器
 * 题目描述：
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * 思路：
 *  思路一：双重循环，计算当前边与后面每个边形成的矩形的面积，返回最大值
 *  思路二：双指针
 *      1.一开始指向最外面两条边，宽度最宽，逐渐缩短宽度增加高度，以高度换长度
 *      2.每次移动最小的边，向内移动直到找到跟高的边，计算面积，
 *      3.最小边的移动过程与快速排序的过程类似，找更大的值，直到找到
 *   Plus:使用快排类似找法，直到找打更高的边的方法更快比官方的快

 ********************************/


public class MaxArea {
    public static void main(String[] args) {
        int[] h = {2,3,10,5,7,8,9};
        int i = maxArea2(h);
        System.out.println(i);
    }

    //官方题解，双指针
    public static int maxArea3(int[] height) {
        int l = 0, r = height.length - 1;
        int ans = 0;
        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            ans = Math.max(ans, area);
            if (height[l] <= height[r]) {
                ++l;
            }
            else {
                --r;
            }
        }
        return ans;

    }

    //双指针，根据官方题解写的，查找更高的边使用快速排序的思路
    public static int maxArea2(int[] height) {
        int l = 0,r = height.length - 1;
        int max = (r-l)*Math.min(height[l],height[r]);
        int i = l,j = r;
        while (i<j){
            //找到到跟高的边
            if(height[i]<height[j]) {
                while (i<j&&height[i]<=height[l]) i++;
                int area = (j-i)*Math.min(height[j],height[i]);
                if(area>max) max = area;
                l = i;
                continue;
            }
            else {
                while (i<j&&height[j]<=height[r]) j--;
                int area = (j-i)*Math.min(height[j],height[i]);
                if(area>max) max = area;
                r = j;
                continue;
            }

        }
        return max;
    }


    //双重循环，当前点与后面每个点都组成矩形，计算并比较面积
    public static int maxArea(int[] height) {
        int max = 0;
        for (int i = 0;i<height.length;i++){
            for (int j = i+1;j<height.length;j++){
                int area = (j-i)*Math.min(height[j],height[i]);
                if(area>max) max = area;
            }
        }
        return max;
    }
}

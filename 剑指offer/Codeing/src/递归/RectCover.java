package 递归;

/*****************
 * 剑指offer:矩形覆盖
 * 题目描述
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，
 * 总共有多少种方法？
 *比如n=3时，2*3的矩形块有3种覆盖方法
 *
 * 思路：实际是跳台阶问题的变形，将两个水平放置的矩形看做是一个整体，就是跳台阶问题，长度为n,长度可以是1或2
 ****************/

public class RectCover {
    public static int nums = 0;
    public static void main(String[] args) {
        System.out.println(Cover(3));
    }

    public static int Cover(int target) {
        Choice(target);
        return nums;
    }
    //思路：转化为长为n,每次选择-1 或-2 ，直到0
    public static void Choice(int n){
        if(n == 0) {
            nums++;
            return;
        }
        Choice(n-1);
        if(n-2>=0)  Choice(n-2);  //如果减n-2=-1,错误
    }
}

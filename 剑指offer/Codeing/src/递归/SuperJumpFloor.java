package 递归;

/****************************
剑指offer:变态跳台阶
 题目描述
 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 ***************************/
public class SuperJumpFloor {
    public static int nums = 0;
    public static void main(String[] args) {
        System.out.println(JumpFloor(4));
    }

    public static int JumpFloor(int target) {

        Choice(target);
        return nums;
    }
    //思路：每次选择-1 或-2 -n，直到0，穷举
    public static void Choice(int n){
        if(n == 0) {
            nums++;
            return;
        }
        for(int i = 1;i <= n;i++){

            if(n-i>=0)  Choice(n-i);  //如果减n-i=-1,错误
        }

    }
}

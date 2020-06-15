package 递归;

/****************************
剑指offer:跳台阶
 题目描述
 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 ***************************/
public class JumpFloor {
    public static int nums = 0;
    public static void main(String[] args) {
        System.out.println(JumpFloor(4));
    }

    public static int JumpFloor(int target) {

        Choice(target);
        return nums;
    }
    //思路：每次选择-1 或-2 ，直到0,DFS
    public static void Choice(int n){
        if(n == 0) {
            nums++;
            return;
        }
        Choice(n-1);
        if(n-2>=0)  Choice(n-2);  //如果减n-2=-1,错误
    }
}

package 发散思维能力;

/*********************
 *剑指offer:不用加减乘除做加法
 * 题目描述
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 * 思路：----没想出来
     * 在计组中，半加器、全加器中：
     * 两个二进制的相加结果是用一个异或门实现的；
     * 两个二进制的进位结果是用一个与门来实现的。
 ********************/

public class AddClass {
    public static void main(String[] args) {
        int add = Add(10, 11);
        System.out.println(add);
    }
    public static int Add(int num1,int num2) {

        int result, ans;
        do {
            result = num1 ^ num2;       // 每一位相加
            ans = (num1 & num2) << 1;   // 进位
            num1 = result;
            num2 = ans;
        } while (ans != 0);
        return result;
    }
}

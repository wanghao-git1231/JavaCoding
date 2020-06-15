package 动态规划与贪婪;

/****************************
 * 剑指offer：剪绳子
 * 题目描述
 *      给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为k[0],k[1],...,k[m]。请问k[0]xk[1]x...xk[m]可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * 思路：
 *      1.在此处使用将n开方向上取整的方法，得到m,然后n/m得到每段的长度l，即y余数n%m,结果就是 段数m的l次方，
 *      如果y不等于0，乘上与；2是个例外单独计算返回1
 *      2.其他方法：当结果大于3时，查找3 2 的个数，尽可能多的3 不够的算2
 *      3.递归与动态规划，先剪一刀l,再剩下n - l,递归所有可能，动态规划就是把之前计算的结果放在表里
 ****************************/

public class CutLine {
    public static void main(String[] args) {
        int i = cutRope(60);
        System.out.println(i);
    }
    public static int cutRope(int target) {
        if(target == 2) return 1;
        //绳子切分的段数，向上取整
        int pieces = (int)Math.ceil(Math.sqrt(target));
        int a = target%pieces;
        int b = target/pieces;
        System.out.println(pieces+"--------------"+b);
        if(a == 0) return (int)Math.pow(pieces,b);
        else return (int)Math.pow(pieces,b)*a;

    }
}

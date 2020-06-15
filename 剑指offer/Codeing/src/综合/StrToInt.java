package 综合;

/*******************************
 * 剑指offer:把字符串转换成整数
 * 题目描述
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 * 思路：
 * 1.能转化成整数字符只能是第一位为 + - 或所有位为数字
 * 2.通过从字符最高位开始计算对应整数
 * 3.由于题目设置有问题，2147483649查出java int范围，无法通过
 *
 ******************************/

public class StrToInt {
    public static void main(String[] args) {
        int i = StrToInt("-2147483646");
        System.out.println(i);
    }
    public static int StrToInt(String str) {
        if(str.length()==0) return 0;
        int s = 0;
        if((str.charAt(0) == '+')||(str.charAt(0) =='-')){
            s = 1;
        }else s = 0;

        for (int i = s;i<str.length();i++){
            if(str.charAt(i)<'0'||str.charAt(i)>'9')
                return 0;
        }
        int sum = 0;

        for(int i = s;i<str.length();i++){

            sum = sum*10 + (str.charAt(i)-'0');

        }

        if (str.charAt(0) =='-') return 0-sum;
        else return sum;
    }
}

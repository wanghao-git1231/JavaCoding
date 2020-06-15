package 字符串;


/*************************
 * 剑指offer:表示数值的字符串
 * 题目描述
     * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
     * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
     * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 * 思路：遍历
 *************************/

public class Numeric {
    public static void main(String[] args) {
        char[] str = {'+','1','0','0'};
        String s = "123.45e+6";

        boolean res = isNumeric(s.toCharArray());
        System.out.println(res);
    }

    public static boolean isNumeric(char[] str) {
        boolean flagE = false; //e或E出现标志
        boolean flagPoint = false; // .出现标志

        if(str == null) return false;

        for (int i = 0; i < str.length; i++) {
            System.out.println(i);
            //数字正常
            if(str[i]>='0'&&str[i]<= '9') continue;

            //e E出现,不能出现在两头
            if(str[i] == 'e'||str[i] == 'E') {
                if(flagE == true) return false;
                if(i == 0||i == str.length-1) return false;
                else {
                    flagE = true;
                    continue;
                }
            }

            //+ - 出现,第一个，或e，E后面

            if(str[i] == '+'||str[i] == '-'){
                if(i == 0) continue;
                if(str[i-1] == 'e'||str[i-1]=='E') continue;
                return false;
            }



            //. 出现，一定不是出现在e E后面，已即只能是位移一个.

            if(str[i] == '.'){
                if(i == 0||flagPoint == true||i == str.length) return false;

                if (flagE == false) {
                    flagPoint = true;
                    continue;
                }
                else return false;

            }
            return false;
        }
        return true;

    }
}

package 进制转换;

/*********************************
 * 剑指offer:二进制中1的个数
 * 题目描述
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 ********************************/

public class NumberOf1 {

    public static void main(String[] args) {
        System.out.println(NumberOf1(-1));

    }
    //正数转化二进制中1的个数
    public static int NumberOfPostive(int n){
        int sum = 0;
        while(n!=1){
            sum += n%2;
            n /= 2;
        }
        return sum+1;
    }
    //负数
    public static int NumberOfNative(int n){
        int[] flag = new int[32];

        int i = 0;
        while (i<32){
            flag[i++] = 1;
        }

        i = 0;
        while(n!=1){
            if( n%2 == 0) flag[i++] = 1;
             else flag[i++] = 0;
            n /= 2;
        }
        flag[i] = 0;

        int carry = 1;
        for (int j = 0;j < 32;j++){

            flag[j] = flag[j] + carry;

            if(flag[j] == 2){
                flag[j] = 0;

            }else{

                break;
            }
        }

        i = 0;
        for (int j = 0; j < 32; j++) {
            i += flag[j];
        }
        return i;
    }
    public static int NumberOf1(int n) {
        if(n <= -2147483648){
            return 1;
        }else if(n>0){

           return  NumberOfPostive(n);

       }else if(n<0){
           return NumberOfNative(Math.abs(n));
       } else{
           return 0;
       }

    }
}

package 时间效率;

/*************************
 * 剑指offer:整数中1出现的次数（从1到n中1出现的次数）
 *题目描述
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
 * ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数
 * （从1 到 n 中1出现的次数）。
 * 思路：分别统计各位、十位、百位中，1出现的次数
 ************************/

public class NumberOf1 {
    public static void main(String[] args) {
        int res = NumberOf1Between1AndN_Solution(10);
        System.out.println(res);
    }
    public static int NumberOf1Between1AndN_Solution(int n) {


        int sum = 0;
        int carry = 1;

        while (n>=carry){
            sum += (n/(10*carry))*(carry)+Count(n%(carry*10),carry);
            carry*=10;
        }

//        int ge = n/10*1+Count(n%10,1);  //个位上1的个数，是n包含的10的个数*1+1
//        十位上1的个数。是n包含的100的个数*10，与余数跟10-19的区间比较的结果，
//        int shi = n/100*10+Count(n%100,10);
//        百位上1的个数。是n包含的1000的个数*100，与余数跟100-199的区间比较的结果
//        int bai = n/1000*100+Count(n%1000,100);
//        类推
//        int qian = n/10000*1000+Count(n%10000,1000);
//        System.out.println(ge+shi+bai);


        return sum;
    }
    //计算 n%100在10-19,n%1000在100-199 ...中的个数
    private static int Count(int n,int flag){
        //判断除10取余的值在10-19区间还是大于

        if(n<flag) return 0;
        else if(n>=flag&&n<=(2*flag-1)) return n-flag+1;
        else return flag;
    }
}

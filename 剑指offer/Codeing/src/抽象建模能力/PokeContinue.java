package 抽象建模能力;

import java.util.HashSet;

/***************************
 * 剑指offer：扑克牌顺子
 * 题目描述：略
 * 思路：
 *  1.给出五个数，0可以是任意值
 *  2.如果有重复false
 *  3.如果五个或4个0，必定对
 *  4.不重复只要最大值-最小值<5,就可以
 **************************/

public class PokeContinue {
    public static void main(String[] args) {
        int[] num = {1,2,0,0,3};
        boolean continuous = isContinuous(num);
        System.out.println(continuous);
    }

    public static boolean isContinuous(int [] numbers) {
        if(numbers.length!= 5) return false;
        int numOfZero = 0;  //0的个数
        HashSet<Integer> set = new HashSet<>();  //用于判断是否有重复
        for (int i = 0; i < numbers.length; i++) {
           if(numbers[i] != 0) {
               set.add(numbers[i]);
           }else {
               numOfZero++;
           }
        }

        int numOfNotZero = set.size();
        if(numOfZero+numOfNotZero != 5) return false;  //有重复，false
        if(numOfNotZero == 1||numOfZero == 5) return true;  //只有一个数或五个都是0，必定可以
        Integer[] a = new Integer[set.size()];
        set.toArray(a);  //set转数组
        int first = a[0],last = a[a.length-1];  //得到最大值和最小值

        if(last - first<5) return true;  //如果相差大于等于5，即无法成功
        return false;

    }

}

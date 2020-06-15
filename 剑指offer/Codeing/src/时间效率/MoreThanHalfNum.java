package 时间效率;

import java.util.HashMap;

/*******************
 *剑指offer:数组中出现次数超过一半的数字
 * 题目描述：
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，
 * 因此输出2。如果不存在则输出0。
 * 使用map记录；
 *******************/

public class MoreThanHalfNum {

    public static void main(String[] args) {
        int[] a = {1,2};
       int b =  MoreThanHalfNum_Solution(a);
        System.out.println(b);
    }
    public static int MoreThanHalfNum_Solution(int [] array) {
        if(array.length == 0) return 0;
        if(array.length == 1) return array[0];
        int halfLen = array.length/2;  //自动向下取整
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<array.length;i++){

            if(map.get(array[i]) == null) {
                map.put(array[i],1);
            }else{
                int t = map.get(array[i])+1;
                if(t>halfLen) return array[i];
                map.put(array[i],t);

            }
        }


        return 0;
    }
}

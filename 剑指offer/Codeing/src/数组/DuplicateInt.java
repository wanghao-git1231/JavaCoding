package 数组;

/**********************
 * 剑指offer:数组中重复的数字
 * 题目描述
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。
 * 请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 * 思路：找出一个flag存储次数，如果之前已经有一次了直接返回结果，否则返回false
 **********************/


public class DuplicateInt {
    public static void main(String[] args) {
        int[] a = {};
        int len = a.length;
        int[] res = new int[1];
        boolean isDuplicate = duplicate(a, len, res);
        System.out.println(res[0]);
        System.out.println(isDuplicate);

    }

    //duplication:返回值
    public static boolean duplicate(int numbers[],int length,int [] duplication) {
        if(numbers == null||length ==0||length!=numbers.length) {
            duplication[0] = -1;
            return false;
        }
        int[] flag = new int[10];
        for (int i = 0;i<length;i++){
            System.out.println(numbers[i]);
            if(flag[numbers[i]] == 0) {
                flag[numbers[i]] = 1;
                continue;
            }
            if(flag[numbers[i]] == 1){
                duplication[0] = numbers[i];
                return true;
            }


        }
        return false;
    }
}

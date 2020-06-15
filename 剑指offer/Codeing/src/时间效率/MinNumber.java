package 时间效率;


import java.util.Arrays;

import java.util.Comparator;

/**************************
 * 剑指offer:把数组排成最小的数
 * 题目描述
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 * 思路：
 * 1.先将数组转化为字符串数组
 * 2.然后比较字符串
 * 3.字符串
 *      1.按从头到尾比较，首数字小的往前放
 *      2.相同的比较后一个
 *      3.短的用最后一个与长的后续比较
 *      4.如果短的最后一个与长的最后几个都相同，则去长的
 **************************/

public class MinNumber {
    public static void main(String[] args) {
        int[] nums = {3,5,1,4,2};
        String minNumber = PrintMinNumber(nums);
        System.out.println(minNumber);
    }


    public static String PrintMinNumber(int [] numbers) {
        if(numbers.length == 0) return new String();
        String[] arrayList = new String[numbers.length];
        //将数字转化为字符串
        for (int i = 0; i < numbers.length; i++) {
            arrayList[i] = String.valueOf(numbers[i]);
        }
        //对字符串按排序
        Arrays.sort(arrayList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int len1 = o1.length(),len2 = o2.length();
                int maxLen = len1>=len2?len1:len2;

                for (int i = 0; i < maxLen; i++) {
                    char c1,c2;
                    if(i<=len1-1) c1 = o1.charAt(i);
                    else c1 = o1.charAt(len1-1);
                    if(i<=len2-1) c2 = o2.charAt(i);
                    else c2 = o2.charAt(len2-1);
                    //小的放前面
                    if(c1<c2) return -1;
                    if(c1>c2) return 1;
                    //如果遍历到最长的结尾，且两个字符串结尾都相同，返回最长的
                    if(c1 ==c2&&i == maxLen) {
                        if(len1>=len2) return -1;
                        else return 1;
                    }
                }
                return 0;
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0;i < arrayList.length;i++){
            sb.append(arrayList[i]);
        }

        return sb.toString();
    }
}

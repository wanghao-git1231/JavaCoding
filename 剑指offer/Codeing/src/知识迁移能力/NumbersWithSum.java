package 知识迁移能力;

import java.util.ArrayList;

/****************
 * 剑指offer:和为S的两个数字
 * 题目描述
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 输出描述:
 * 对应每个测试案例，输出两个数，小的先输出。
 * 思路：双指针
 *  1.自己使用了指向中间两个值的方法：比较慢和麻烦
 *  2.指向第一个和最后一个：小于右边加
 ***************/

public class NumbersWithSum {
    public static void main(String[] args) {
        int[] array = {1,2,5,8,10,12};
        ArrayList<Integer> arrayList = FindNumbersWithSum(array, 7);
        System.out.println(arrayList.toString());
    }

    //双指针指向两段
    public static ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        if(array.length == 1||array.length == 0) return  new ArrayList<>();
        ArrayList<Integer> arrayList = new ArrayList<>(2);

        int first = 0,last = array.length-1;
        while (first < last){

            if((array[first]+array[last])>sum){
                last--;
            }
            if((array[first]+array[last])<sum){

                first++;
            }
            if((array[first]+array[last])== sum){//第一次符合条件的一定是乘积最小的

                arrayList.add(0,array[first]);
                arrayList.add(1,array[last]);
                break;

            }
        }


        return arrayList;
    }
    //双指针指向中间值
    public static ArrayList<Integer> FindNumbersWithSum2(int [] array, int sum) {
        if(array.length == 1||array.length == 0) return  new ArrayList<>();
        ArrayList<Integer> arrayList = new ArrayList<>(2);
        int mid = array.length/2;
        int first = mid-1,last = mid;
        while (first !=0||last!=array.length-1){

            if((array[first]+array[last])>sum){
                if(first == 0) last++ ;
                else first--;
            }
            if((array[first]+array[last])<sum){

                if(last == array.length-1) first--;
                else last++;
            }
            if((array[first]+array[last])== sum){

                if(arrayList.size() == 0){
                    arrayList.add(0,array[first]);
                    arrayList.add(1,array[last]);
                }else{
                    if((array[first]*array[last])<arrayList.get(0)*arrayList.get(1)){
                        arrayList.set(0,array[first]);
                        arrayList.set(1,array[last]);
                    }
                }
                if(first == 0||last == array.length-1) {

                    break;
                }
                first--;

            }
        }


        return arrayList;
    }
}

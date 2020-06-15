package 时间效率;

import java.util.ArrayList;
import java.util.Comparator;

/**************************
 * 剑指offer:最小的k个数
 * 题目描述
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 * 思路：建立k长度的list,先把前k个加入并排序，从k+1开始比较list中最后一个，小于则加入，并从新排序
 **************************/

public class GetLeastNumbers {
    public static void main(String[] args) {
            int[] a = {4,5,1,6,2,7,3,8};
            GetLeastNumbers_Solution(a,4);
    }
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {

        if(k == 0||input.length == 0||k>input.length) return new ArrayList<>();
        //建立长度为k 的list ,将前k个放入并排序
        ArrayList<Integer> arrayList = new ArrayList<>(k);
        for(int i = 0;i<k;i++){
            arrayList.add(input[i]);
        }
       // arrayList.sort(new MyComparator());
        //排序
        arrayList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1<o2) return -1;
                else return 1;
            }
        });
        //从k+1开始，与list中最大值比较，小于加入
        for(int i = k;i<input.length;i++){
            if(input[i]<arrayList.get(k-1)){
                arrayList.remove(k-1);
                arrayList.add(input[i]);
                //arrayList.set(k-1, input[i]);  比先移除再添加还要慢

               // arrayList.sort(new MyComparator());
                arrayList.sort(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        if(o1<o2) return -1;
                        else return 1;
                    }
                });
            }
        }
        System.out.println(arrayList);
        return arrayList;
    }
}

package 树;

/*******************************
 * 剑指offer:数据流中的中位数
 * 题目描述
 *      如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 * 思路：
 *      1.在输入时排序
 *      2.get时根据奇数偶数获取即可
 *      3.在这里使用的是自己二分遍历出入得到Vector
 *      4.其他人思路普遍是使用大顶堆存储输入的前半段，小顶堆存储输入分后半段
 ******************************/

import java.util.Vector;

public class MiddleInStream {
    public static void main(String[] args) {

        int[] a = {1,5,3,8,6};
        for (int i = 0; i < a.length; i++) {
            Insert(a[i]);
            System.out.println(arrayList.toString());
            Double aDouble = GetMedian();
            System.out.println(aDouble);
        }
    }

    private static Vector<Integer> arrayList = new Vector<>();

    public static void Insert(Integer num) {
        if(num == null) return;
        if(arrayList.size() == 0) {
            arrayList.add(num);

            return;
        }
        int len = arrayList.size();
        int mid = arrayList.get(len/2);

        int index = len/2;
        //当前值与中间值比较，二分遍历插入合适的位置
        if(num>=mid){
            while (index<arrayList.size()){
                if(num<arrayList.get(index)){
                    arrayList.insertElementAt(num,index);
                    break;
                }
                index++;
            }
            if(index == arrayList.size()) arrayList.add(num);
        }else {
            index = len/2;
            while (index>=0){

                if(num>arrayList.get(index)){
                    arrayList.insertElementAt(num,index+1);
                    break;
                }
                index--;
            }
            if(index == -1) arrayList.insertElementAt(num,0);
        }

    }
    //根据奇偶数返回结果
    public static Double GetMedian() {
        int size = arrayList.size();
        if (size == 0) return null;
        if(size%2 == 0) return (arrayList.get(size/2)+arrayList.get(size/2-1))/2.0;
        return arrayList.get(size/2)*1.0;
    }
}

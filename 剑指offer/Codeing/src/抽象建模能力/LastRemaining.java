package 抽象建模能力;

import java.util.ArrayList;

/******************************
 *剑指offer：孩子们的游戏(圆圈中最后剩下的数)
 * 题目描述：略
 * 思路:
 *    1.个人理解是循环左移的问题，使用ArrayList不断取第一个放到最后一个直至里面只剩一个值
 ******************************/


public class LastRemaining {
    public static void main(String[] args) {

        int i = LastRemaining_Solution(5, 3);
        System.out.println(i);
    }

    public static int LastRemaining_Solution(int n, int m) {
        if(m == 0||n == 0) return -1;
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i = 0;i<n;i++){
            arrayList.add(i);
        }

        while (arrayList.size()!=1){
            int len = arrayList.size();
            int first;
            if(len >m) first = m%len;  //数组长度大于m时，要移除值为余数，在0-len之间可以直接得到
            else first = m;   //数组长度小于等于m时，要一直循环移动m-1次，无法直接算的
            //循环左移，每次取出最上面的值放到后面
            for(int i = 0;i<first-1;i++){
                int t = arrayList.get(0);
                arrayList.remove(0);
                arrayList.add(t);

            }
            //此时最顶上的即为要移除的
            if(arrayList.size()!=1){
                arrayList.remove(0);

            }
            System.out.println(arrayList.toString());
        }

        return arrayList.get(0);
    }
}

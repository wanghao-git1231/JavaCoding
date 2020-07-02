package Medium.Case406;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/***********************************
 * LeetCode Case406:根据身高重建队列
 * 题目描述：
     * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，
     * k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。
 * 思路：
 *  1.先对输入数组排序，h升序，k降序
 *  2.从头循环遍历 当前这个人就是剩下未安排的人中最矮的人，他的k值就代表他在剩余空位的索引值
 *  3.如果有多个人高度相同，要按照k值从大到小领取索引值
 *  Plus:实在看不懂为什么!!!
 **********************************/


public class ReconstructQueue {
    public static void main(String[] args) {
        int[][] people = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};

        int[][] ints = reconstructQueue(people);
        for (int i = 0;i<ints.length;i++){
            System.out.println(ints[i][0]+"--"+ints[i][1]);
        }
    }
    public static int[][] reconstructQueue(int[][] people) {
        int len = people.length;
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]>o2[0]) return 1;
                else if(o1[0]<o2[0]) return -1;
                else {
                    if(o1[1] > o2[1]) return -1;
                    else return 1;
                }
            }
        });

        List<Integer> list = new ArrayList<>();
        for (int i = 0;i < len;i++){
            list.add(i);
        }
        int[][] res = new int[len][2];
        for (int i = 0;i <len;i++){
            int first = people[i][0];
            int second = people[i][1];

            int index = list.get(second);

            res[index][0] = first;
            res[index][1] = second;
            list.remove(second);
        }
        return res;
    }
}

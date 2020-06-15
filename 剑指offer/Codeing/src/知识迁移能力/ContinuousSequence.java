package 知识迁移能力;

import java.util.ArrayList;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Consumer;

/*************************
 * 剑指offer：和为S的连续正数序列
 * 题目描述
 *      小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 *      但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 *      没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 *      现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 * 输出描述:
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 * 思路：
 *      1.使用队列往里加数，直至和大于等于sum，
 *      2.大于则弹出顶上的即最早的，并从和减去
 *      3.相等则记录并弹出最早的值
 * ps:别人都是使用双指针，与队列相同，指向一段区间，可能跟快
 ************************/


public class ContinuousSequence {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> arrayLists = FindContinuousSequence(1);
        System.out.println(arrayLists.toString());
    }


    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        if(sum <= 0) return null;
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>();
        queue.add(1);
        int index = 1;
        int total = 1;
        while (index < (sum/2+1)){

            if(total<sum){
                queue.add(++index);
                total+=index;
            }
            if(total > sum){
                Integer peek = queue.peek();
                queue.poll();
                total -= peek;

            }
            if(total == sum&&queue.size()>=2){

                ArrayList<Integer> arrayList = new ArrayList<>();
                queue.forEach(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) {
                        arrayList.add(integer);
                    }
                });
                arrayLists.add(arrayList);
                Integer peek = queue.peek();
                queue.poll();
                total -= peek;
            }
        }
        return arrayLists;
    }
    
}

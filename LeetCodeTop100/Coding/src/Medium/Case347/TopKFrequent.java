package Medium.Case347;

import java.util.*;

/***********************************
 * LeetCode Case347:前K个高频元素
 * 题目描述：给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * 思路：
 *  1.使用HashMap存储出现的数及其次数
 *  2.根据出现次数找出前K高频元素
 *  3.返回结果
 *  Plus:根据次数找的时候会使用最小堆或优先队列，不太会用，特别是使用呢堆排序，自建堆
 ***********************************/


public class TopKFrequent {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int[] ints = topKFrequent(nums, 2);
        for (int i = 0;i<ints.length;i++){
            System.out.println(ints[i]);
        }
    }

    //使用hashmap存储数与出现的次数，但是将前k多的数的提取出太繁琐
    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();

        for (int i = 0;i<nums.length;i++){
            if(!hashMap.containsKey(nums[i])) hashMap.put(nums[i],0);
            int value = hashMap.get(nums[i]);
            hashMap.put(nums[i],value+1);

        }

        Integer[] val = new Integer[hashMap.size()];
        hashMap.values().toArray(val);
        Arrays.sort(val);
        int t = val[val.length  - k];
        int[] res = new int[k];
        Set<Integer> keySet = hashMap.keySet();
        int i = 0;
        for (Integer ks :
                keySet) {
            if (hashMap.get(ks)>=t) res[i++] = ks;
        }
        return res;
    }
}

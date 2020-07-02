package Medium.Case49;

import java.util.*;

/****************************************
 * LeetCode Case49:字母异位词分租
 * 题目：
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * 思路：
 *  思路一：通过将字符串转化为字符数组并排序得到位移的字符串，作为key，
 *  思路二：通过统计每个字符串中没个字符出现的次数，也可以确定是不是排列，组装成字符串key
 *  Plus:list与hashmap的转换
 ***************************************/

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strings = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = groupAnagrams2(strings);
        for (List<String> l:
             lists) {
            for (String s:
            l){
                System.out.print(s+"--");
            }
            System.out.println();
        }

    }

    //不同排列以为着同一个字符出现的次数相同，一次可以通过统计每个字符出现的次数并组装成字符串，得到key
    public static List<List<String>> groupAnagrams2(String[] strs){
        HashMap<String,List<String >> map = new HashMap<>();
        int[] conunter = new int[26];
        for (int i = 0;i<strs.length;i++){
            Arrays.fill(conunter,0);
            char[] chars = strs[i].toCharArray();
            for (int j = 0;j<chars.length;j++) conunter[chars[j] - 'a']++;
            StringBuilder sb = new StringBuilder();
            for (int m = 0;m<26;m++){
                sb.append('#');
                sb.append(conunter[m]);
            }

            String key = sb.toString();

            if(!map.containsKey(key)) map.put(key,new ArrayList<>());
            map.get(key).add(strs[i]);
        }

        return new ArrayList<>(map.values());
    }

    //不会自己搞字符的哈希值的情况下使用排序后的字符串做key
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> lists = new ArrayList<>();
        //根据字符存储list
        HashMap<String,List<String>> map = new HashMap<>();

        for (int i = 0;i<strs.length;i++){
            String key = getKey(strs[i]);
            List<String> list = map.get(key);
            if(list == null){
                list = new ArrayList<>();
            }

            list.add(strs[i]);
            map.put(key,list);
        }

        return new ArrayList<>(map.values());
    }

    //将字符串字符按从小到大顺序排序，返回一个新的字符串，这样不同排列的返回值相同，做hashmap的key
    private static String getKey(String string){
        char[] chars = string.toCharArray();
        Arrays.sort(chars);
        return new String(chars);

    }
}

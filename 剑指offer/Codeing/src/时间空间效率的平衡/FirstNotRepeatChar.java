package 时间空间效率的平衡;


/****************************
 *剑指offer:第一个只出现一次的字符
 * 题目描述
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置,
 * 如果没有则返回 -1（需要区分大小写）.（从0开始计数）
 * 思路：
 * 1.将A-z转化为0-52，记录每个第一次出现的位置，如果重复出现，令重复出现为真
 * 2.字符串遍历完后比较记录的第一次出现的位置，返回最小的
 *
 ****************************/

public class FirstNotRepeatChar {
    public static void main(String[] args) {
        String s = "aaaaaaab";
        int index = FirstNotRepeatingChar(s);
        System.out.println(index);

    }

    public static int FirstNotRepeatingChar(String str) {
        if(str == null||str.length() == 0) return -1;
        boolean[] isRepeat = new boolean[52];   //标识是否重复
        int[] fistTimes = new int[52];  //记录每个字母第一次出现的位置
        for (int i = 0; i < fistTimes.length; i++) {
            fistTimes[i] = -1;
        }
        char[] chars = str.toCharArray();
        char c;
        int index;
        for (int i = 0; i < chars.length; i++) {
             c = chars[i];
             if(c>='a'){  //小写字母
                 index = c-'a'+26;

             }else {
                 index = c - 'A';

             }
             //记录该字母第一次出现的位置，如果已经出现过，令重复为真
             if(fistTimes[index] == -1) fistTimes[index] = i;
             else isRepeat[index] = true;
        }
        c = 'a';
        int intOfChar = 0; //用于将0-52转化为字符
        index = -1;
        for (int i = 0;i<52;i++){
            //只出现过一次比较第一次出现的位置
            if(isRepeat[i] == false&&fistTimes[i]!=-1){
                if(index == -1) {
                    index = fistTimes[i];
                    intOfChar = i;
                    continue;
                }
                if(fistTimes[i]<index){
                    index = fistTimes[i];
                    intOfChar = i;
                }
            }

        }

        if(index != -1){
            //字符转化

            if(intOfChar<=25) c = (char)(intOfChar+'A');
            else c = (char)(intOfChar -26+'a');
            System.out.println(c);
            System.out.println(index);
            return index;
        }
        return -1;

    }
}





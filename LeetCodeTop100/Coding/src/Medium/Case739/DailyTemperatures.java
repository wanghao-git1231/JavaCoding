package Medium.Case739;


import java.util.Stack;

/*****************************
 * LeetCode Case739:每日温度
 * 题目描述：
     * 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。
     * 如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * 思路：
 *      思路一：先后遍历
 *          1.判断向后走几步找到比自己大的，向后走直到遇到大的值或走到尽头
 *          2.一旦遇到比自己大的就将结果对应位置赋为走到部署
 *      思路二：单调栈
 *          1.维护一个存储下标的单调栈
 *          2.从栈底到栈顶的下标对应的温度列表中的温度依次递减
 *          3.如果一个下标在单调栈里，则表示尚未找到下一次温度更高的下标。
 *       Plus:理解自然形成的单调栈
 ****************************/

public class DailyTemperatures {
    public static void main(String[] args) {
        int[] t = {89,62,70,58,47,47,46,76,100,70};
        int[] ints = dailyTemperatures3(t);
        for (int i = 0;i<ints.length;i++){
            System.out.println(ints[i]);
        }
    }

    public static int[] dailyTemperatures3(int[] T) {
        int len = T.length;
        int[] res = new int[len];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0;i < len;i++){
            if(stack.isEmpty()) {
                stack.add(i);
                continue;
            }
            else {
                while (!stack.isEmpty()&&T[i]>T[stack.peek()]){
                    int top = stack.pop();
                    res[top] = i - top;
                }
                stack.add(i);
            }
        }
        return res;
    }

        //使用原数组存储结果
    public static int[] dailyTemperatures2(int[] T) {
        int len = T.length;

        for (int i = 0;i < len;i++){
            int hasBiger = 0;
            //标识是否有更大的值

            for (int j = i+1;j<len;j++){
                hasBiger++;
                //遇到更大的就设为负值
                if(T[j]>T[i]) {
                    T[i] = -hasBiger;
                    break;
                }
            }
            //如果是负值就是找到了，去个反就是，没有就设为0
            T[i] = T[i] <0?-T[i]:0;
        }
        return T;
    }

    //使用新的数组存储结果
    public static int[] dailyTemperatures(int[] T) {
        int len = T.length;
        int[] res = new int[len];

        for (int i = 0;i < len;i++){
            int hasBiger = 0;
            //标识是否有更大的值

            for (int j = i+1;j<len;j++){
                hasBiger++;
                //遇到更大的就
                if(T[j]>T[i]) {
                    res[i] = hasBiger;
                    break;
                }
            }

        }
        return res;
    }
}

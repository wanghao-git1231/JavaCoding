package Easy.Case20;

import java.util.Stack;

/****************************
 * LeetCode Case：20有效的括号
 * 题目描述：
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     * 有效字符串需满足：
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 注意空字符串可被认为是有效字符串。
 * 思路：使用辅助栈，左边括号入栈，遇到右边括号比较出栈，注意最后栈应是空的
 *
 ***************************/

public class IsValid {
    public static void main(String[] args) {

        boolean valid = isValid("]");
        System.out.println(valid);

    }

    //使用栈辅助，判断
    public static boolean isValid(String s) {
        if(s == null) return true;
        Stack<Character> stack1 = new Stack<>();

        for (int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            //左边入栈
            if(c == '('||c == '['||c == '{'){
                stack1.add(c);
                continue;
            }
            //右边，比较栈顶是否可以匹配，匹配出栈，否则匹配失败
            if(c == ')'&&!stack1.isEmpty()&&stack1.peek() == '('){
                stack1.pop();
                continue;
            }


            if(c == ']'&&!stack1.isEmpty()&&stack1.peek() == '['){
                stack1.pop();
                continue;
            }


            if(c == '}'&&!stack1.isEmpty()&&stack1.peek() == '{'){
                stack1.pop();
                continue;
            }

            return false;
        }
        //凡是成对出现栈应该为空
        if(!stack1.isEmpty()) return false;
        return true;
    }
}

package Medium.Case94;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/********************************
 * LeetCode Case94:中序遍历
 * 题目描述：给定一个二叉树，返回它的中序 遍历。
 * 思路：
 *  思路一：递归
 *  思路二：迭代：先向左直走，到头输出，往右转再往左走
 *  思路三：其他骚操作去题解中看吧
 *******************************/

public class InorderTraversal {
    public static void main(String[] args) {

    }

    //迭代中序
    public static List<Integer> inorderTraversal2(TreeNode root) {

        //使用栈辅助
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> lists = new ArrayList<>();
        if(root == null) return lists;
        //当栈为空时root可能不为null，root为null时，栈不一定为空
        while (root != null||!stack.isEmpty()) {
            //先往左走
            while (root != null) {
                stack.add(root);
                root = root.left;
            }

            //到头了，弹出栈顶并输出
            TreeNode top = stack.pop();
            lists.add(top.val);
            //往右转
            root = top.right;

        }

        return lists;
    }


    //使用递归中序遍历
    public static List<Integer> inorderTraversal(TreeNode root) {
        midOrder(root);
        return list;
    }

    private static List<Integer> list = new ArrayList<>();
    public static void midOrder(TreeNode root){
        if(root == null) return;
        midOrder(root.left);
        if(root != null) list.add(root.val);
        midOrder(root.right);
    }
}

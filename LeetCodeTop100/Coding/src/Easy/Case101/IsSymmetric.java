package Easy.Case101;

import java.util.Stack;

/*******************************
 * LeetCode Case 101:对称二叉树
 * 题目描述：
 *      给定一个二叉树，检查它是否是镜像对称的。
 * 思路：
 *      1.两个子树的根节点值相同
 *      2.每个树的左子树又与另一个树的右子树相同
 *
 *******************************/

public class IsSymmetric {
    public static void main(String[] args) {

    }

    //迭代版本，往栈中放入的两个值是要比较的值，两个子树左右子树
    public static boolean isSymmetric2(TreeNode root) {
        if(root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root.left);
        stack.add(root.right);
        while (!stack.isEmpty()){

            TreeNode first = stack.pop();
            TreeNode second = stack.pop();
            if(first == null&&second == null) continue;
            if(first == null||second == null) return false;
            if(first.val != second.val) return false;
            stack.add(first.left);
            stack.add(second.right);
            stack.add(first.right);
            stack.add(second.left);

        }

        return true;
    }

    public static boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return judge(root.left,root.right);
    }

    //递归，
    private static boolean judge(TreeNode t1,TreeNode t2){
        boolean res = false;
        if(t1 == null&&t2 == null) return true;
        if(t1 == null||t2== null) return false;
        if(t1.val == t2.val) res = true;
        res = res && judge(t1.left,t2.right);
        res = res && judge(t1.right,t2.left);
        return res;
    }
}

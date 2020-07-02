package Medium.Case114;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

/**************************************
 * LeetCode Case_114:二叉树展开为链表
 * 题目描述：给定一个二叉树，原地将它展开为一个单链表。
 * 思路：首先是展开的方式，进过实验，是按照先序顺序展开
 *  思路一：
 *      1.将每个节点的左子树变为有子树，将右子树头结点入栈，指向新的右子树
 *      2.当左子树走到尽头时，将栈顶的右子树头置为当前尽头节点的右子树，指向新的右子树
 *      3.知道栈为空结束
 *  思路二：递归
 *      1.通过观察，结果是先序遍历二叉树的顺序，则逆先序遍历二叉树
 *      2.即先右再左再将访问过的节点设为下一个节点的右子
 *  思路三：类似中序遍历的Morris方法
 *      1.知道每个节点的左子树的最右节点
 *      2.将节点的右子树头结点接到最右节点的右子
 *      3.将节点的左子树头放到右，并指向新的右子树头结点
 *************************************/

public class Flatten {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(5);
        TreeNode t4 = new TreeNode(3);
        TreeNode t5 = new TreeNode(4);
        TreeNode t6 = new TreeNode(6);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.right = t6;
        Show(t1);
        flatten3(t1);
        System.out.println("*****************");
        Show(t1);

    }

    //类似94题的中序遍历的Morris题解， 将右子树接到左子树的最右节点的右子节点
    public static void flatten3(TreeNode root) {

        TreeNode temp = null;
        while (root != null){
            if(root.left == null){
                root = root.right;
                continue;
            }else {
                //找到左子树最右边节点
                temp = root.left;
                while (temp.right != null){
                    temp = temp.right;
                }
                //将右子树接到左子树最右节点的右子节点
                temp.right = root.right;
                root.right = root.left;
                root.left = null;
                root = root.right;
            }

        }

    }

    //先序遍历的倒序，注意此处先右子树后左子树，倒序访问，访问完都接到下一个的右子节点
    private static TreeNode pre = null;
    public static void flatten2(TreeNode root) {
        if(root == null) return;
        flatten2(root.right);
        flatten2(root.left);

        root.left = null;
        root.right = pre;
        pre = root;
    }


    //使用栈迭代，保存每个右子树节点
    public static void flatten(TreeNode root) {
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<>();

        while (root!=null||!stack.isEmpty()){
            //右子树头结点入栈
            if(root.right!=null) stack.add(root.right);
            //左子节点放到右子节点
            if(root.left!=null) root.right = root.left;
            else {
                //栈为空就结束
                if(stack.isEmpty()) {
                    break;
                }
                root.right = stack.pop();
            }
            //左子节点置为null,root指向右子节点
            root.left = null;
            root = root.right;
        }

    }

    //层遍历
    private static void Show(TreeNode root){
        Queue<TreeNode> stack = new LinkedBlockingQueue<>();
        stack.add(root);
        while (!stack.isEmpty()){
            TreeNode top = stack.poll();
            System.out.println(top.val+"------");
            if(top.left!=null) stack.add(top.left);
            if(top.right!=null) stack.add(top.right);
        }

    }
}

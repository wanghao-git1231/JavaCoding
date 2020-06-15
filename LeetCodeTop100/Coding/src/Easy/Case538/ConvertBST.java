package Easy.Case538;

import java.util.Stack;

/**********************************
 * LeetCode Case538:把二叉搜索树转换为累加数
 * 题目描述：
 *      给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，
 * 使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 * 思路：
 *      思路一：递归，把按右->中->左顺序，当前节点值与之前顺序节点的值都累加，并重新赋给当前节点
 *      思路二：迭代，先往右，到头弹出，累加赋值，进入左子树，弹出，直至结束；注意理解左边遍历顺序
 *      思路三：Morris遍历，没看懂,蠢
 *
 *********************************/

public class ConvertBST {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(4);
        t1.left = t2;
        t1.right = t3;
        show(t1);
        TreeNode treeNode = convertBST2(t1);
        show(treeNode);



    }

    //迭代，每个节点都入栈一次，往右是倒序加，往左是正序加
    public static TreeNode convertBST2(TreeNode root) {
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty()||node!=null){
            //每个节点均入栈
            while (node!=null){
                stack.add(node);
                node = node.right;
            }
            //节点没有有子树，弹出累加并赋值
            node = stack.pop();
            carry += node.val;
            node.val = carry;
            //进入左子树
            node = node.left;
        }

        return root;
    }


    public static TreeNode convertBST(TreeNode root) {
        convert(root);
        return root;
    }



    private static int carry = 0;
    private static void convert(TreeNode root){

        if(root == null) {
            carry += 0;
            return;
        }
        convert(root.right);
        carry += root.val;
        root.val = carry;
        convert(root.left);

    }


    private static void show(TreeNode root){
        if(root == null) return;
        show(root.left);
        System.out.println(root.val);
        show(root.right);
    }

}

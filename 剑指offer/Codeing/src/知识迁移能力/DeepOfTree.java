package 知识迁移能力;

import java.util.Stack;

/*************************
 * 剑指offer：二叉树的深度
 * 题目描述
 * 输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 * 思路：从叶结点开始加一，每个节点取左右节点最大值加一
 ************************/

public class DeepOfTree {
    private static int deep = 0;

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        t2.right = new TreeNode(3);
        t2.left = new TreeNode(4);
        TreeNode t3 = new TreeNode(5);

        t1.left = t2;
        t1.right = t3;
        int i = TreeDepth(t1);
        System.out.println(i);
    }
    private static Stack<TreeNode> stack = new Stack<>();


    //别人答案
    public static int TreeDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int left=TreeDepth(root.left);
        int right=TreeDepth(root.right);
        return Math.max(left,right)+1;  //选择较长的子树
    }
    //蠢
    public static int TreeDepth2(TreeNode root) {

        if(root.left == null && root.right == null) {
            if(stack.size()>deep) deep = stack.size();
            return  1;
        }
        if(root.left!=null){
            stack.push(root.left);
            TreeDepth(root.left);
            stack.pop();
        }


        if(root.right != null){
            stack.push(root.right);
            TreeDepth(root.right);
            stack.pop();
        }


        return deep+1;
    }
}

package Easy.Case226;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/*******************************
 * LeetCode Case226:翻转二叉树
 * 题目描述：
 *      翻转一棵二叉树。
 * 思路：遍历每个节点，交换该结点的左右子树
 *      方法1：递归
 *      方法2：迭代，广度优先遍历
 *
 ******************************/

public class InvertTree {
    public static void main(String[] args) {

        TreeNode t1 = new  TreeNode(1);
        TreeNode t2 = new  TreeNode(2);
        TreeNode t3 = new  TreeNode(3);
        TreeNode t4 = new  TreeNode(4);
        TreeNode t5 = new  TreeNode(5);
        TreeNode t6 = new  TreeNode(6);
        TreeNode t7 = new  TreeNode(7);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        TreeNode treeNode = invertTree2(t1);
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        queue.add(treeNode);
        while (!queue.isEmpty()){
            TreeNode top = queue.peek();
            queue.poll();
            System.out.println(top.val);
            if(top.left!=null) queue.add(top.left);
            if(top.right!=null) queue.add(top.right);
        }

    }

    //迭代方法，BFS广度优先遍历
    public static TreeNode invertTree2(TreeNode root) {
        if(root == null) return root;
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        queue.add(root);

        while (!queue.isEmpty()){
            TreeNode top = queue.peek();
            queue.poll();
            TreeNode temp = top.left;
            top.left = top.right;
            top.right = temp;
            if(top.left!=null) queue.add(top.left);
            if(top.right!=null) queue.add(top.right);

        }
        return root;

    }

    //递归方法
    public static TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
    
    
    
}

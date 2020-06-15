package Easy.Case104;

import java.util.LinkedList;
import java.util.Queue;


/********************************
 * LeetCode Case104：二叉树的最大深度
 * 题目描述：
     * 给定一个二叉树，找出其最大深度。
     * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
     * 说明: 叶子节点是指没有子节点的节点。
 * 思路：
 *      1.迭代，BFS广度优先遍历
 *      2.递归，返回结点最大子树+1
 *******************************/

public class MaxDepth {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        System.out.println(maxDepth2(t1));
    }

    //迭代，广度优先遍历，竟然慢
    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        //深度
        int deep = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            deep++;
            while (size-- > 0) {
                TreeNode top = queue.peek();
                queue.poll();
                if (top.left != null) queue.add(top.left);
                if (top.right != null) queue.add(top.right);

            }
        }
        return deep;
    }

    //递归，返回子树中深度较深的加一，DFS加分治
    public static int maxDepth2(TreeNode root) {
        if(root == null) return 0;

        int res1 = maxDepth2(root.left);
        int res2 = maxDepth2(root.right);
        return Math.max(res1,res2)+1;
    }


}

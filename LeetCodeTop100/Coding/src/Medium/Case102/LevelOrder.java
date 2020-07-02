package Medium.Case102;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/******************************************
 * LeetCode Case102:二叉树的层序遍历
 * 题目描述：给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * 思路：广度优先遍历，使用队列存储节点
 *****************************************/


public class LevelOrder {
    public static void main(String[] args) {

    }

    //使用队列存储的层序遍历
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if(root == null) return lists;
        //也可用list代替queue
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();

        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0;i < size;i++){
                TreeNode top = queue.poll();
                list.add(top.val);
                if(top.left!=null) queue.add(top.left);
                if(top.right!=null) queue.add(top.right);
            }
            lists.add(list);
        }

        return lists;
    }
}

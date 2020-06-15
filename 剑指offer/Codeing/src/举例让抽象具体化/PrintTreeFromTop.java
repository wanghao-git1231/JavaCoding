package 举例让抽象具体化;

import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

/*******************
 * 剑指offer:从上往下打印二叉树
 * 题目描述
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * 思路：广度优先遍历，使用队列存储树的左右节点
 ******************/

public class PrintTreeFromTop {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        t2.right = new TreeNode(3);
        t2.left = new TreeNode(4);
        TreeNode t3 = new TreeNode(5);
        t3.right = new TreeNode(6);
        t3.left = new TreeNode(7);
        t1.left = t2;
        t1.right = t3;
        TreeNode t6 = null;
        ArrayList<Integer> integers = PrintFromTopToBottom(t6);
        System.out.println(integers);
    }

    //bfs广度优先
    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {

        ArrayList<Integer> a = new ArrayList<>();
        if(root == null) return a;
        LinkedBlockingQueue<TreeNode> s = new LinkedBlockingQueue<>();
        s.add(root);
        while (!s.isEmpty()){
            TreeNode temp = s.peek();
            s.poll();
            a.add(temp.val);
            if(temp.left != null){
                s.add(temp.left);
            }

            if(temp.right != null){
                s.add(temp.right);
            }
        }
        return a;

    }
}

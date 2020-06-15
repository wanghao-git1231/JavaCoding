package 树;

import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

/*******************************
 * 剑指offer：把二叉树打印成多行
 * 题目描述
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 *思路：
 *      1.使用队列存储
 *      2.取出一层放入下一层
 *
 ******************************/

public class PrintTree2 {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        t2.left = new TreeNode(1);
        t2.right = new TreeNode(2);

        TreeNode t3 = new TreeNode(5);
        t3.left = new TreeNode(3);
        t3.right = null;
        t1.left = t2;
        t1.right = t3;
        ArrayList<ArrayList<Integer>> print = Print(t1);
        System.out.println(print.toString());
    }
    public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        if(pRoot == null) return arrayLists;
        LinkedBlockingQueue<TreeNode> queue = new LinkedBlockingQueue<>();
        queue.add(pRoot);
        while (queue.size() != 0){
            int size = queue.size();
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int i = 0;i<size;i++){
                TreeNode t = queue.peek();
                queue.poll();
                if(t != null) {
                    arrayList.add(t.val);
                    if(t.left!= null)  queue.add(t.left);
                    if(t.right!= null) queue.add(t.right);
                }

            }
            arrayLists.add(arrayList);
        }
        return arrayLists;
    }
}

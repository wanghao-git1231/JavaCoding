package 树;

/*************************
 * 剑指offer：按之字形顺序打印二叉树
 * 题目描述
 *   请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 * 思路：
 *      1.设置标志自左向右还是相反，依次输出
 *      2.将当前层取出，加入下一层
 ************************/

import java.util.ArrayList;
import java.util.Vector;

public class PrintTree {
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
        //标识自作向右
        boolean LToR = true;
        Vector<TreeNode> vector = new Vector<>();
        vector.add(pRoot);

        while (vector.size()!=0){
            ArrayList<Integer> arrayList = new ArrayList<>();
            //层序遍历
            for (int i = 0;i<vector.size();i++){
                TreeNode t = null;
                //如果自左向右
                if(LToR == true) {
                     t = vector.get(i);
                }else t = vector.get(vector.size()-1-i);  //自右向左
                if(t != null) arrayList.add(t.val);
            }
            arrayLists.add(arrayList);
            //取反
            LToR = !LToR;
            int size = vector.size();
            //将当前层取出，加入子节点
            for (int i = 0;i<size;i++){
                TreeNode t = vector.get(0);
                if(t.left != null) vector.add(t.left);
                if(t.right != null) vector.add(t.right);
                vector.remove(0);
            }

        }
        return arrayLists;
    }


}

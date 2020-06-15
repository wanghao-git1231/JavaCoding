package 树;

/*************************************
 * 剑指offer：对称的二叉树
 * 题目描述
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 * 思路：
 *      1.将同一层节点入vector，比较同一级节点是否对称
 *      2.如果对称将其子节点加入vector，同时将其弹出
 *      3.其他思路，善用递归
 ************************************/

import java.util.Vector;

public class MirrorClass {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        t2.left = new TreeNode(3);
        t2.right = new TreeNode(4);

        TreeNode t3 = new TreeNode(5);
        t3.left = new TreeNode(4);
        t3.right = new TreeNode(3);
        t1.left = t2;
        t1.right = t3;
        boolean symmetrical = isSymmetrical(t1);
        System.out.println(symmetrical);
    }
    public static boolean  isSymmetrical(TreeNode pRoot)
    {
        if(pRoot == null) return false;
        //根节点的左右子如vector
        Vector<TreeNode> vector = new Vector<>();
        vector.add(pRoot.left);
        vector.add(pRoot.right);
        //如果为0即为都相同且没有子节点了
        while (vector.size() != 0){
            int levelTotal = vector.size();

            //看同一层是否对称
            for (int i = 0;i<levelTotal/2;i++){
               if(vector.get(i) == null|| vector.get(levelTotal-1-i) == null){
                   if(vector.get(i) == null&&vector.get(levelTotal-1-i) == null){
                       continue;
                   }else {
                       return false;
                   }
               }
               if(vector.get(i).val == vector.get(levelTotal-1-i).val) continue;
               else return false;

            }
            //当前层对称，将当前层的子节点如vector，同时移除当前层
            for (int j = 0; j < levelTotal; j++) {

                TreeNode temp = vector.get(0);

                if(temp!= null) {
                    vector.add(temp.left);
                    vector.add(temp.right);
                }
                vector.remove(0);
            }

        }
        return true;
    }
}

package 知识迁移能力;

/***************************
 *剑指offer：平衡二叉树
 * 题目描述
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * 在这里，我们只需要考虑其平衡性，不需要考虑其是不是排序二叉树
 * 思路：
 *      1.平衡二叉树的平衡性：左右子树高度差不大于1；
 *      2.使用前面的求树的深度
 *      3.如果遇到节点的左右子树高度差是二，则返回-1，即不平衡
 ***************************/

public class IsBalancedTree {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        t2.right = new TreeNode(3);
        t2.left = new TreeNode(4);
        TreeNode t3 = new TreeNode(5);

        t1.left = t2;
        t1.right = t3;
        boolean b = IsBalanced_Solution(t1);
        System.out.println(b);
    }
    public static boolean IsBalanced_Solution(TreeNode root) {
        if(root == null) return true;
        int i = TreeDepth(root);
        if(i == -1) return false;
        else return true;
    }
    //求树的深度，如果遇到节点左右子树高度差为0，返回-1
    public static int TreeDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int left=TreeDepth(root.left);
        if(left == -1) return  -1;
        int right=TreeDepth(root.right);
        if(right == -1) return  -1;
        if (Math.abs(left - right)==2) return -1;
        return Math.max(left,right)+1;  //选择较长的子树
    }
}

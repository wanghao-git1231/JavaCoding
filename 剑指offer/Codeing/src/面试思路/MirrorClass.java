package 面试思路;

/*******************************
 * 剑指offer:二叉树的镜像
 * 题目描述
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 *******************************/

public class MirrorClass {
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
        Show(t1);
        System.out.println( );
        Mirror(t1);
        Show(t1);
    }

    public static void Show(TreeNode root){
        System.out.print(root.val);
        if(root.left != null) Show(root.left);
        if(root.right != null) Show(root.right);
    }
    //镜像交换
    public static void Mirror(TreeNode root) {
        if(root == null) return;
        if(root.left == null&&root.right == null) return;
        TreeNode temp = null;  //中间变量

        temp = root.left;
        root.left = root.right;
        root.right = temp;
        if(root.left!=null) Mirror(root.left);
        if(root.right!=null) Mirror(root.right);

    }
}

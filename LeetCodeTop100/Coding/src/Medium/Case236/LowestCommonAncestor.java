package Medium.Case236;

/*****************************
 * LeetCode Case236:二叉树的最近公共祖先
 * 题目描述：
     * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
     * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，
     * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。
 * 思路：dfs
 *  1.当当前节点时要找的之一时，标志位加1
 *  2.继续递归左右子节点，标志位加上左右返回值
 *  3.判断，如果标志位等于2，意味着找到了，同时如果node==null，意味着是最近公共祖先
 *  4.返回标志位结果
 *  Plus:递归的精髓是返回前子节点已经处理完问题了
 ****************************/

public class LowestCommonAncestor {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        t1.right = t3;
        t1.left = t2;
        t2.left = t4;
        t3.right = t6;
        t3.left = t5;
        TreeNode treeNode = lowestCommonAncestor(t1, t3, t5);
        System.out.println(treeNode.val);

    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root,p,q);
        return node;
    }
    private static TreeNode node = null;
    //dfs
    private static int helper(TreeNode root, TreeNode p,TreeNode q){
        if(root == null) return 0;
        int flag = 0;
        if(root == p||root ==q) flag++;
        flag += helper(root.left,p,q);
        flag += helper(root.right,p,q);

        if(flag == 2&&node==null)node = root;
        return flag;
    }
}

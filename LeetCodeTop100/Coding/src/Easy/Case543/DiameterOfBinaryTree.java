package Easy.Case543;

/*************************
 * LeetCode Case 543:二叉树的直径
 * 题目描述：
 *      给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。
 * 这条路径可能穿过也可能不穿过根结点。
 * 思路：
 *      1.最长直径一定是某个节点左右子树深度之和，所以只要计算每个节点的左右子树深度之和并返回最大值即可
 *      2.树的深度计算，左右子树深度最大值加一
 *      3.节点为null返回0
 ************************/


public class DiameterOfBinaryTree {
    public static void main(String[] args) {

    }
    public static int diameterOfBinaryTree(TreeNode root) {
        findDeep(root);
        return max;
    }
    private static int max = 0;
    private static int findDeep(TreeNode root){
        if(root == null) return 0;

        int d1 = findDeep(root.left);
        int d2 = findDeep(root.right);
        if(d1 + d2 > max) max = d1 + d2;
        return Math.max(d1,d2)+1;

    }
}

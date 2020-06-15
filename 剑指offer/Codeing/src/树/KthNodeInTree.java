package 树;

/*****************************
 * 剑指offer：二叉搜索树的第k个结点
 * 题目描述
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。
 * 例如， （5，3，7，2，4，6，8）中，按结点数值大小顺序第三小结点的值为4。
 * 思路：
 *      1.二叉搜索树，中序遍历即是从小到大排序
 *      2.中序遍历，每次遍历当前节点是加一，知道K,返回即可
 ****************************/

public class KthNodeInTree {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        t2.left = new TreeNode(12);
        t2.right = new TreeNode(25);

        TreeNode t3 = new TreeNode(522);
        t3.left = new TreeNode(36);
        t3.right = null;
        t1.left = t2;
        t1.right = t3;
        TreeNode treeNode = KthNode(t1, 7);
        System.out.println(treeNode);

    }

    public static TreeNode KthNode(TreeNode pRoot, int k)
    {
        if(k == 0||pRoot == null) return treeNode;
        First(pRoot,k);

        return treeNode;
    }
    //用来计算中序遍历的顺序，存储第K个
    private static int count = 0;
    private static TreeNode treeNode =null;
    private static void First(TreeNode root, int size){
        if(root == null) {

            return ;
        }

        First(root.left,size);
        //中序访问，即从小到大访问只到K
        count++;
        if(count == size) {
            treeNode = root;
            return;
        }

        First(root.right,size);

    }
}

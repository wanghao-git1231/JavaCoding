package 分解让复杂问题简单;


/**********************
 *剑指offer:二叉搜索树与双向链表
 * 题目描述
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 *  自己的思路：---即先从最底层节点开始排序
 *      二叉搜索树是有序树，则根节点左边指向左子树最大值，右节点指向右子树最小值，递归实现即可；
 *      注意：
 *      1.二叉搜索树可能只有右边或左边子树，
 *      2.遍历边界是当前子树的左右节点为null或下一次递归值是当前找到的找到的最大或最小值，如果再递归会陷入循环
 *
 *  其他人思路：
 *      1.将二叉搜索树按中序遍历存入list，顺序即是排序结果
 *      2.遍历令当前节点right = 下一个节点，下一个左节点即为当前节点。
 **********************/

public class TreeToList {

    public static void main(String[] args) {
        /*
        TreeNode t1 = new TreeNode(4);
        TreeNode t2 = new TreeNode(2);
        t2.right = new TreeNode(3);
        t2.left = new TreeNode(1);
        TreeNode t3 = new TreeNode(6);
        t3.right = new TreeNode(7);
        t3.left = new TreeNode(5);
        t1.left = t2;
        t1.right = t3;*/

        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        t4.right = new TreeNode(5);
        t1.right = t2;
        t2.right = t3;
        t3.right = t4;

        TreeNode node = Convert(t1);
        while (node != null){
            System.out.println(node.val);
            node = node.right;
        }
    }
    public static TreeNode Convert(TreeNode pRootOfTree) {

        if(pRootOfTree == null) return null;

        LinkedMax(pRootOfTree);

        while (pRootOfTree.left != null){
            pRootOfTree = pRootOfTree.left;
        }

        return pRootOfTree;
    }

    public static void LinkedMax(TreeNode pRootOfTree){
        TreeNode temp = null;
        TreeNode temp2 = null;

        if(pRootOfTree.left != null){
            TreeNode max = FindMax(pRootOfTree.left);
            temp = pRootOfTree.left;

            if(max != temp||temp!=null) LinkedMax(temp);
            max.right = pRootOfTree;
            pRootOfTree.left = max;
        }

        if(pRootOfTree.right != null){
            TreeNode min = FindMin(pRootOfTree.right);
            temp2 = pRootOfTree.right;
            if(min!=temp2||temp2!=null) LinkedMax(temp2);
            min.left = pRootOfTree;
            pRootOfTree.right = min;
        }

    }
    //找到左子树最大值
    public static TreeNode FindMax(TreeNode Root){

        while (Root.right!=null){
            Root = Root.right;
        }
        return Root;
    }

    //找到右子树最小值
    public static TreeNode FindMin(TreeNode Root){

        while (Root.left!=null){
            Root = Root.left;
        }
        return Root;
    }
}

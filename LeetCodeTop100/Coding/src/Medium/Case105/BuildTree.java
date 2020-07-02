package Medium.Case105;


/***************************************
 * LeetCode Case_105:从前序与中序遍历序列构造二叉树
 * 题目描述：根据一棵树的前序遍历与中序遍历构造二叉树。
 * 思路：
 *  思路一：通过找到先序中第一个数在中序的位置，找到左右子树的范围，递归重建
 *  思路二：用栈，看题解，没大看懂，笨。
 **************************************/

public class BuildTree {
    public static void main(String[] args) {

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return rebuild(preorder,inorder,0,preorder.length - 1,0,inorder.length - 1);
    }

    private TreeNode rebuild(int[] preorder,int[] inorder,int pL,int pR,int iL,int iR){
        if(pL>pR) return null;
        TreeNode root = new TreeNode(preorder[pL]);
        int index = 0;
        for (int i = iL;i<=iR;i++){
            if(inorder[i] == preorder[pL]) {
                index = i;
                break;
            }
        }
        int lenOfL = index - iL;
        root.left = rebuild(preorder,inorder,pL+1,pL+lenOfL,iL,index - 1);
        root.right = rebuild(preorder,inorder,pL+lenOfL+1,pR,index+1,iR);
        return root;
    }
}

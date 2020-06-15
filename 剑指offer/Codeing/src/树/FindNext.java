package 树;


/*********************************
 * 剑指offer:二叉树的下一个结点
 * 题目描述
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 * 思路：
 *      1.中序遍历：左->根->右
 *      2.当前结点可能是父节点或子节点
 *      3.当前为某个父节点时下一个节点是右子树的最左边一个节点
 *      4.当前是子节点时，当前节点或当前节点父系节点的父结点是下一个节点的左子节点
 *      5.注意最根节点的父是null,不再继续
 ********************************/

public class FindNext {
    public static void main(String[] args) {

    }
    public static TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if(pNode == null) return null;
        //当前为某个节点，下一个为其右子树的最左一个节点
        if(pNode.right!=null){
            pNode = pNode.right;
            while (pNode.left!=null){
                pNode = pNode.left;
            }
            return pNode;
        }else {
            //当前节点或当前节点父系节点的父结点是下一个节点的左子节点
            TreeLinkNode father = pNode.next;
            //根节点的父是null，注意
            while (father!= null&&father.left != pNode){
                pNode = father;
                father = father.next;
            }
            return father;
        }
    }
}

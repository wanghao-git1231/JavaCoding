package Easy.Case617;

import java.util.Queue;

import java.util.concurrent.LinkedBlockingQueue;


/**********************************
 *  LeetCode 617：合并二叉树
 *  题目：
 *     给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
     *      你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的
 *      新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
 *  思路：递归
 *      思路一：
 *          1.完全重建一个二叉树
 *          2.要判断树一或树二是不是null
 *      思路二：
 *          1.在原有树的基础上合并
 *      思路三：
 *          1.迭代，需要注意两个点有一个是null的情况，不用栈或队列，没做
 *
 *
 *********************************/

public class MergeTrees {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        t1.left = t2;
        t1.right = t3;

        TreeNode p1 = new TreeNode(1);
        TreeNode p2 = new TreeNode(2);
        TreeNode p3 = new TreeNode(3);
        p1.left = p2;
        p1.right = p3;

        TreeNode treeNode = mergeTrees(t1, p1);
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        queue.add(treeNode);
        while (!queue.isEmpty()){
            TreeNode top = queue.peek();
            queue.poll();
            System.out.println(top.val);
            if(top.left!=null) queue.add(top.left);
            if(top.right!=null) queue.add(top.right);
        }

    }

    //在原有t1树的基础上进行合并
    public static TreeNode mergeTrees2(TreeNode t1, TreeNode t2) {
        if(t1 == null)
            return t2;
        if(t2 == null)
            return t1;
        t1.val = t1.val + t2.val;
        t1.left = mergeTrees(t1.left,t2.left);
        t1.right = mergeTrees(t1.right,t2.right);
        return t1;
    }

    //使用递归并完全重建一棵树
    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        return mergeedTree(t1,t2);
    }

    //递归重建一颗树
    private static TreeNode mergeedTree(TreeNode t1,TreeNode t2){
        //递归到头
        if(t1 == null&&t2 == null) return null;

        //新结点初始化赋值
        TreeNode root = new TreeNode((t1 == null?0:t1.val)+(t2 == null?0:t2.val));
        //继续遍历树
        root.left = mergeedTree(t1==null?null:t1.left,t2==null?null:t2.left);
        root.right = mergeedTree(t1==null?null:t1.right,t2==null?null:t2.right);
        return root;
    }

}

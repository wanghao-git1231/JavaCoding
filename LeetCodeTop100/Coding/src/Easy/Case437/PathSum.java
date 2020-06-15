package Easy.Case437;

import java.util.Vector;

/******************************
 * LeetCode Case 437:路径总和iii
 * 题目描述：
     * 给定一个二叉树，它的每个结点都存放着一个整数值。
     * 找出路径和等于给定数值的路径总数。
     * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
     * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 * 思路：
 *      思路一：遍历树，以当前节点为结尾，着累加计算是否有连续和等于sum
 *          1.倒序前提将树的某一路径上值均存储，在此存储在vector，以及及时删除，类似queue但还可以遍历
 *          2.每次进入find函数时，当前节点已经存储，只需要倒序累加
 *      思路二：遍历树，以当前节点为起点，累加到头，看是否有连续和等于sum
 *
 *
 ******************************/

public class PathSum {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(5);
        TreeNode t2 = new TreeNode(4);
        TreeNode t3 = new TreeNode(8);
        TreeNode t4 = new TreeNode(11);
        TreeNode t5 = new TreeNode(13);
        TreeNode t6 = new TreeNode(0);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(0);
        TreeNode t9 = new TreeNode(1);
        TreeNode t10 = new TreeNode(1);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;

        t3.right = t5;
        t3.left = t6;
        t4.left = t7;
        t4.right = t8;
        t6.right = t10;
        t6.left = t9;

        int i = pathSum2(t6, 0);
        System.out.println(i);
//        Integer[] a = {-2,-3};
//        int num = getNum(a, -3);
//        System.out.println(num);


    }
    /****************
     * 方法二：正序
     *****************/
    public static int pathSum2(TreeNode root, int sum) {
        if(root == null) return 0;

        int res = helper(root,sum);
        int a = pathSum2(root.left,sum);
        int b = pathSum2(root.right,sum);

        return res+a+b;
    }

    private static int helper(TreeNode root,int sum){
        int res = 0;
        if(root == null) return 0;
        sum = sum - root.val;
        if(sum ==0) res = 1;
        return res + helper(root.left,sum) + helper(root.right,sum);

    }


    /****************
     * 方法一：倒序-快
     *****************/
    private static Vector<Integer> vector = new Vector<>();
    private static int n = 0;
    public static int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        vector.add(root.val);
        find(root,sum);
        return n;
    }

    //计算以当前节点为结尾的路径上是否有和为sum的子路
    private static void find(TreeNode root,int sum){
        System.out.println(vector.toString());
        //每次进入find时，当前节点值已经放入vector，所以开始倒序累加，每次加完看是否等于sum
        int res = 0;
        int len = vector.size()-1;
        while (len>=0){
            res += vector.elementAt(len--);
            if(res == sum) n++;
        }
        //走到叶结点
        if(root == null&&root.right == null) return;
        //将左右子节点值放入vector中，递归后删除
        if(root.left!=null) {
            vector.add(root.left.val);
            find(root.left,sum);
            vector.removeElementAt(vector.size()-1);
        }

        if(root.right!=null){
            vector.add(root.right.val);
            find(root.right,sum);
            vector.removeElementAt(vector.size()-1);
        }
    }



    //寻找一个数组中，连续和为n的组合数,只能算数组与sum均大于0
    private static int getNum(Integer[] a,int sum){
        int fast = 0,slow = 0,num = 0,total = 0;

        while (slow<a.length){

            if(fast < a.length){
                total+=a[fast];
                fast++;
            }else {
                total -= a[slow++];
                if(slow == a.length) break;
            }

            if(total<sum){
                continue;
            }else if(total>sum){
                total -= a[slow++];
                continue;
            }else {
                num++;
                continue;
            }

        }
        return num;
    }
}

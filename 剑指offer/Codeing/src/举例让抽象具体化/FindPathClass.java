package 举例让抽象具体化;

import java.util.*;

import java.util.function.Consumer;

/************************
 *剑指offer:二叉树中和为某一值的路径
 * 题目描述
 * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 *
 *
 ************************/


public class FindPathClass {
    public static void main(String[] args) {

        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        t2.right = new TreeNode(3);
        t2.left = new TreeNode(4);
        TreeNode t3 = new TreeNode(5);
        TreeNode t4 = new TreeNode(1);
        t3.right = t4;
        t3.left = new TreeNode(7);
        t1.left = t2;
        t1.right = t3;

        t4.right = new TreeNode(6);

        ArrayList<ArrayList<Integer>> arrayLists = FindPath(t1,13);
        System.out.println(arrayLists.toString());

    }
    private static Stack<Integer> stack = new Stack<>();
    private static ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
    
    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if(root == null) return     new ArrayList<>();
        if(root.val > target) return new ArrayList<>();
        //提前将根节点加入栈
        stack.push(root.val);
        int sum = 0; //和
        Find(root,target,sum);
        stack.pop();
        //按长度排序，对arrayLists排序，使用sort函数，定义比较器的比较部分
        Collections.sort(arrayLists, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                //-1代表不调整，1代表调整顺序
                if(o1.size()>o2.size()) return  -1; //
                else return 1;

            }
        });

        return arrayLists;
    }
    //遍历二叉树
    public static void Find(TreeNode root,int target,int sum){

        sum += root.val;
        if(sum > target) return;

        if(sum == target) {
            if(root.left == null&&root.right == null){ //判断是不是叶结点，没有子节点
                ArrayList<Integer> arrayList = new ArrayList<>();
                //遍历栈，将栈中的数全部加入arrayList
                stack.forEach(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) {
                        arrayList.add( integer);
                    }
                });
                arrayLists.add(arrayList);
            }else return;


        }

        if(sum < target){
            if(root.left != null)
            {
                stack.push(root.left.val);
                Find(root.left,target,sum);
                stack.pop();
            }
            if(root.right != null)
            {
                stack.push(root.right.val);
                Find(root.right,target,sum);
                stack.pop();
            }
        }
    }
    

}

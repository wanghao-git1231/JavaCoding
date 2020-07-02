package Medium.Case96;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**************************************
 * LeetCode Case96:不同的二叉搜索树
 * 题目描述：给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 * 思路：
 *      思路一：超时
 *          1.输入n,二叉搜索树中序1,2....n
 *          2.将1-n全排列，认定为二叉树的先序
 *          3.根据之前重建二叉树的方法，判断根据先序和中序能否重建，能重建则是符合条件的二叉搜索树
 *      思路二：动态规划
 *          //1.1-n中每个数轮流做二叉搜索树的根，i左子树节点个数为i-1,i右子树节点个数为n-i
 *          //2.第i做根的树个数等于G(i-1)*G(n-i)
 *          //3.G(n) = G(1)+...G(n)
 *      思路三：数学归纳法总结的公式，见题解
 *************************************/


public class NumTrees {
    public static void main(String[] args) {

        int i = numTrees2(11);
        System.out.println(i);

    }

    //数学归纳法得到结果
    public int numTrees3(int n) {
        // Note: we should use long here instead of int, otherwise overflow
        long C = 1;
        for (int i = 0; i < n; ++i) {
            C = C * 2 * (2 * i + 1) / (i + 2);
        }
        return (int) C;
    }

    //1.1-n中每个数轮流做二叉搜索树的根，i左子树节点个数为i-1,i右子树节点个数为n-i
    //2.第i做根的树个数等于G(i-1)*G(n-i)
    //3.G(n) = G(1)+...G(n)
    public static int numTrees2(int n) {
        int[] res = new int[n+1];
        res[0] = 1;
        res[1] = 1;
        for (int i = 2;i<=n;++i){
            for (int j = 1;j<=i;++j){
                res[i] += res[j - 1]*res[i - j];
            }
        }
        return res[n];
    }

    //先生成1-n的数组即中序结果，再将该数组进行全排列，则排列结果即为某二叉搜索树的先序结果，
    // 再根据二叉树重建原理，判断先序结果是否对，统计结果，但是超时
    public static int numTrees1(int n) {
        if(n == 0||n == 1) return 1;
        int[] nums = new int[n];
        for (int i = 1;i<=n;i++){
            nums[i-1] = i;
        }
        permute(nums);
        return counter;
    }

    private static void permute(int[] nums) {

        List<Integer> t = new ArrayList<>();
        for (int i = 0; i < nums.length;i++){
            t.add(nums[i]);
        }

        help(t,0,nums.length - 1,nums);

    }

    private static int counter = 0;
    private static void help(List<Integer> t,int start,int end,int[] nums){
        if(start == end){

            Integer[] res = new Integer[t.size()];
            t.toArray(res);
            boolean judge = judge(res, nums, 0, res.length - 1, 0, nums.length - 1);
            if(judge == true) counter++;
        }

        for (int i = start;i <= end;i++){
            Collections.swap(t,i,start);
            help(t,start + 1,end,nums);
            Collections.swap(t,i,start);
        }

    }

    private static boolean judge(Integer[] preorder, int[] inorder, int pL, int pR, int iL, int iR){
        if(pL>pR) return true;

        int index = -1;
        for (int i = iL;i<=iR;i++){
            if(inorder[i] == preorder[pL]) {
                index = i;
                break;
            }
        }
        if(index == -1) return false;
        int lenOfL = index - iL;

        return judge(preorder,inorder,pL+1,pL+lenOfL,iL,index - 1)&&judge(preorder,inorder,pL+lenOfL+1,pR,index+1,iR);
    }

}

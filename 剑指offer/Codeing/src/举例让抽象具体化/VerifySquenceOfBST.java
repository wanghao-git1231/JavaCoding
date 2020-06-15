package 举例让抽象具体化;

/************************
 * 剑指offer:二叉搜索树的后序遍历序列
 * 题目描述
 * 输入一个非空整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 *
 * 思路：二叉搜索树----左子树均小于等于根节点，右子树均大于等于根节点
 * 实现：只要不断找到左子树，右子树范围，判断左子树均先于等于根节点，右子树均大于根节点即可
 * 找到第一个大于根的值
 *
 ***********************/


public class VerifySquenceOfBST {

    public static void main(String[] args) {
        //int[] s = {7,4,6,5}; //[]

       int[] s = {3, 4, 9, 5, 12, 11, 10};
        //int[] s = {5,4,3,2,1}; //[]
        //int[] s = {};
        System.out.println(VerifySquenceOfBST(s));
    }
    public static boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length == 0) return false;

        int len = sequence.length; //找到最后一个
        boolean verify = isBST(sequence, 0, len - 1);

        return verify;
    }


    //别人快速方法
    private static boolean isBST(int[] seq, int start, int end) {
        if (start >= end) {
            return true;
        }
        int val = seq[end];
        int split = start;  //右子树开始的坐标
        //通过循环找到第一个大于根的值
        for (; split < end && seq[split] <= val; split++) ;
        //由于之前循环确定左子树均小于等于根节点，只要确保右子树均大于根即可
        for (int i = split; i < end; i++) {
            if (seq[i] < val) {
                return false;
            }
        }
        //
        return isBST(seq, start, split - 1) &&
                isBST(seq, split, end - 1);
    }

    //较麻烦
    public static boolean Verify(int[] sequence,int s,int e){
        boolean flag = true;
        if(s >= e) return true;
        int last = sequence[e];
        int mid = -1;

        for(int i = s;i<e;i++){
          /*
            if(sequence[i]>last){
                mid = i-1;
                break;
            }*/

            if(sequence[i]<= last&&(sequence[i+1]>last||i+1==e)){
                mid = i;
                break;
            }
            if(i == s&&sequence[i] >last){
                mid = i;
                break;
            }
        }

        for(int i = s;i<mid;i++){
            if(sequence[i]>last) {
                flag = false;
                break;
            }
        }
        for (int i = mid+1;i<e;i++){
            if(sequence[i]<=last){
                flag = false;
                break;
            }
        }
        if(flag == true ){
            boolean res1 = Verify(sequence,s,mid);
            boolean res2 = Verify(sequence,mid+1,e-1);
            flag = res1 && res2;
        }

        return flag;

    }
}





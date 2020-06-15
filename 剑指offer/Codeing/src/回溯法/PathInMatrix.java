package 回溯法;

import java.util.Stack;

/***********************************
 * 剑指offer：矩阵中的路径
 * 题目描述：略
 * 思路：
 *      1.广度优先遍历，回溯
 *      2.一维数组与二维数组的转换
 *      3.边界判定
 **********************************/

public class PathInMatrix {
    public static void main(String[] args) {
        char[] matrix = {'a','b','c','e','s','f','c','s','a','d','e','e'};
        char[] str = "esecbasas".toCharArray();
        boolean b = hasPath(matrix, 3, 4, str);
        System.out.println(b);
    }

    //row行cols列
    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {

        if(matrix.length == 0||str.length == 0||rows == 0||cols == 0||str.length>matrix.length) return false;
        char head = str[0];
        for (int i = 0; i < matrix.length; i++) {
            //找出与目标字符串第一个字符，匹配的字符位置
            if(matrix[i] == head){

                stack.push(i);
                boolean path = findPath(matrix, rows, cols, str, i, 0);
                stack.pop();
                if(path == true) return true;
            }
        }
        return false;
    }

    //存储已经匹配的字符的下标
    private static Stack<Integer> stack = new Stack<>();
    //matrIndex:当前已经匹配的字符位置，strIndex:当前已经匹配的str字符位置
    public static boolean findPath(char[] matrix, int rows, int cols, char[] str,int matrIndex,int strIndex){

        boolean flag = false;
        //str走到头，匹配成功返回true
        if(strIndex == str.length - 1) {

            return true;
        }
        //将一维转换为二维
        int rowOfIndex = matrIndex/cols,colsOfIndex = matrIndex%cols;  //行列
        //上下左右移动
        int[][] move = {{-1, 0},{0, 1},{1, 0},{0, -1}};

        //继续匹配当前值的上下左右
        for (int i = 0; i < 4; i++) {
           int  newrow = rowOfIndex + move[i][0];
           int newcols = colsOfIndex + move[i][1];
           //边界条件
           if(newrow<rows&&newcols<cols&&newrow>=0&&newcols>=0){
                //二维转化为一维
               matrIndex = newrow * cols+newcols;
               System.out.println(matrix[matrIndex]+"------------"+str[strIndex+1]);
               //上下左右中有匹配的，且没有重复，递归
               if(matrix[matrIndex] == str[strIndex+1]&&!stack.contains(matrIndex)) {
                   stack.push(matrIndex);
                   flag = findPath(matrix,rows,cols,str,matrIndex,strIndex+1);
                   stack.pop();
                   if(flag == true) return true;
               }

           }
        }
        return false;
    }
}

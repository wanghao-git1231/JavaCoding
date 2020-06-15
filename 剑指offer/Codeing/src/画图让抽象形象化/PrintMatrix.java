package 画图让抽象形象化;

import java.util.ArrayList;

/*****************************
 * 剑指offer:顺时针打印矩阵
 * 题目描述
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 *****************************/


public class PrintMatrix {
    public static void main(String[] args) {
        int[][] m = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        //int[][] m = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        //int[][] m = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        //int[][] m = {{1}};
        ArrayList<Integer> a =  printMatrix(m);
        System.out.println(a);
    }

    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        int hang = matrix.length;

        int lie = matrix[0].length;
        //只有一行
        if(hang == 1) {
            for (int i = 0; i < lie; i++) {
                res.add(matrix[0][i]);
            }
            return res;
        }
        int i = 0,j = 0,k = 0;  //k循环的圈数
        boolean flag = true;

        while (flag == true) {
            flag = false;

            //每次向右移动条件，也是每次循环的开始
            if(i == k&&j == k){
                for (; j < lie - k;) {

                    flag = true;
                    res.add(matrix[i][j]);
                    //System.out.print(matrix[i][j] + " ");
                    //到达最右端结束
                    if (j == lie - k-1) {
                        break;
                    }
                    j++;
                }
            }

            //向下移动条件，到达最右端
            if(i == k&&j == (lie - k-1)){
                i++;  //向下移动一格
                for (; i < hang - k; ) {

                    flag = true;

                    res.add(matrix[i][j]);
                    //System.out.print(matrix[i][j] + " ");
                    //到达最下端
                    if (i == hang - k-1) {

                        break;
                    }
                    i++;
                }

            }
            //向左移动条件，到达最下端
           if(i == (hang - k -1)&& j == (lie - k-1)){
               j--;//向左移动一格
               for (; j >= k; ) {
                   flag = true;

                   res.add(matrix[i][j]);
                   //System.out.print(matrix[i][j] + " ");
                    //到达最左端
                   if (j == k) {

                       break;
                   }

                   j--;
               }

           }
            //向上移动条件。到达最左端
           if(i == (hang - k -1)&&j == k){
               i--;//向上移动一格
               for (; i > k; ) {
                   flag = true;

                   res.add(matrix[i][j]);
                   //System.out.print(matrix[i][j] + " ");
                   //到达最上端，向左移动一格
                   if (i== k+1) {
                       j++;
                       break;
                   }

                   i--;
               }

           }
            k++;
        }



        return res;
    }
}

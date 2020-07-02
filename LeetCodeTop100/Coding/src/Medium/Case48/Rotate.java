package Medium.Case48;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**************************************************
 * LeetCode Case48：旋转图像
 * 题目描述：
     * 给定一个 n × n 的二维矩阵表示一个图像。
     * 将图像顺时针旋转 90 度。
     * 说明：
     * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 * 思路：
 *      思路一：使用辅助矩阵，新旧举证关系是 x = y,y = len - 1 - x;
 *      思路二：使用队列，按照每列，从下往上读取，然后再将队列中元素一次放入原来矩阵
 *      思路三：需要移动的数据都是4个为一组，从左上角开始四个一组开始移动
 *************************************************/

public class Rotate {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        rotate3(matrix);
        for (int i = 0;i < matrix.length;i++){
            for (int j = 0;j<matrix.length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }


    }

    //只使用一个值，从（i,i到i,len - 1-i)的值，做依次移动90度
    public static void rotate3(int[][] matrix) {
        int len = matrix.length;

        for (int i = 0;i < len -1;i++){
            for (int j = i;j < len - 1 -i;j++){

                int x = i,y = j;
                int temp = matrix[x][y],last = 0;
                for (int m = 0;m < 4;m++){

                    int newX = y;
                    int newY = len - 1 - x;

                    last = matrix[newX][newY];
                    matrix[newX][newY] = temp;

                    x = newX;
                    y = newY;
                    temp = last;
                }


            }
        }
    }

    //使用队列辅助
    public static void rotate2(int[][] matrix) {
        Queue<Integer> queue = new LinkedBlockingQueue<>();
        int len = matrix.length;
        for (int i = 0;i < len;i++){
            for (int j = len - 1;j>=0;j--){
                queue.add(matrix[j][i]);
            }
        }

        for (int i = 0;i < len;i++){
            for (int j = 0;j<len;j++){
                matrix[i][j] = queue.poll();
           }
        }
    }

    //使用了另一个矩阵
    public static void rotate(int[][] matrix) {
        int len = matrix.length;
        int[][] newMatrix = new int[len][len];
        for (int i = 0;i < len;i++){
            for (int j = 0;j<len;j++){
                //新旧旋转90坐标关系
                newMatrix[i][j] = matrix[len - 1 - j][i];
            }
        }

        //将旋转后的值赋给原矩阵
        for (int i = 0;i < len;i++){
            for (int j = 0;j<len;j++){
                matrix[i][j] = newMatrix[i][j];
            }

        }


    }
}

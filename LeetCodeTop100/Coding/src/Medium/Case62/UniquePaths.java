package Medium.Case62;

import java.util.Arrays;

/**************************
 * LeetCode Case62：不同路径
 * 题目描述：
     * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
     * 问总共有多少条不同的路径？
 * 思路：
 *  思路一：DFS暴力递归但是超时
 *  思路二：使用m*n的数组记录从起点到达当前点的路径数，起点默认为1，当前点加上每个点向右下的点的路径，即为该点路径
 *  思路三：对于思路二使用m*n可以简化为只是用一行或一列，都赋初值为1，然后后面的值加等于前面的值
 *************************/


public class UniquePaths {
    public static void main(String[] args) {
        int i = uniquePaths3(7, 3);
        System.out.println(i);
    }

    //方法二的优化，只是用一列，即代表先向下走，再向右走，向右走时，头不变，下面依次加上上面的值
    public static int uniquePaths3(int m, int n) {

        int[] res = new int[n];
        Arrays.fill(res,1);
        for (int i = 1;i<m;i++){
            for (int j = 1;j<n;j++){
                res[j] += res[j-1];
            }
        }
        return res[n - 1];
    }


    //使用辅助矩阵记录到达每个点走过的路径数，最后直接返回最右下角点即可
    public static int uniquePaths2(int m, int n) {
        int[][] res = new int[n][m];
        //初始值设为1，才能累加
        res[0][0] = 1;
        for (int i = 0;i<n;i++){
            for (int j = 0;j<m;j++){
                //向下走，如果能到达，经过该点的路径数加上当前点的路径数
                int y = i+1,x = j;
                if(y<n) res[y][x] += res[i][j];
                //向右走，如果能到达，经过该点的路径数加上当前点的路径数
                y = i;
                x = j+1;
                if(x<m) res[y][x] += res[i][j];

            }
        }
        return res[n - 1][m - 1];
    }

    //暴力递归，超时
    public static int uniquePaths(int m, int n) {
        return helper(m,n,0,0);
    }
    public static int helper(int m, int n,int x,int y) {
        if(x>=m||y>=n) return 0;
        if(x == m - 1&&y == n - 1) return 1;

        return helper(m,n,x+1,y)+helper(m,n,x,y+1);

    }

}

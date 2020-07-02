package Medium.Case64;

/*******************************************
 * LeetCode Case64：最小路径和
 * 题目描述：
     * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
     * 说明：每次只能向下或者向右移动一步。
 * 思路：
 *  思路一：动态规划
 *      1.使用同等大小的数组存储到达该点的最小路径
 *      2.遍历每个点更新其向右向下的最小路径
 *  思路二：递归，但是超时了
 *      1.类似广度优先遍历
 *  思路三：动态规划还可以继续优化只是用一行数组存储状态或使用原数组存储状态
 ******************************************/


public class MinPathSum {
    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        int i = minPathSum3(grid);
        System.out.println(i);
    }

    //动态规划，使用原数组存储路径和
    public static int minPathSum3(int[][] grid) {

        //数组行列数
        int hang = grid.length;
        if(hang == 0) return 0;
        int lie = grid[0].length;
        if(lie == 0) return 0;

        //从左上出发，依次刷新到达相邻点的最小路径

        for (int i = 0;i<hang;i++){
            for (int j = 0;j<lie;j++){
                if(i - 1<0&&j-1>=0) grid[i][j] += grid[i][j-1];
                if(j - 1<0&&i-1>=0) grid[i][j] += grid[i-1][j];
                if(i-1>=0&&j-1>=0) grid[i][j] += Math.min(grid[i][j-1],grid[i-1][j]);
            }
        }
        return grid[hang - 1][lie - 1];
    }

    //递归超时！！！
    public static int minPathSum2(int[][] grid) {

        //数组行列数
        int hang = grid.length;
        if(hang == 0) return 0;
        int lie = grid[0].length;
        if(lie == 0) return 0;
        helper(grid,0,0,0,hang,lie);
        return min;
    }

    private static int min = Integer.MAX_VALUE;
    private static void helper(int[][] grid,int sum,int x,int y,int hang,int lie){
        if(x<0||x>=hang||y<0||y>=lie) return;
        sum += grid[x][y];
        if(sum>min) return;
        if(x == hang - 1&&y == lie -1){
            if(sum<min) min = sum;
            return;
        }

        helper(grid,sum,x,y+1,hang,lie);
        helper(grid,sum,x+1,y,hang,lie);

    }


    //动态规划：使用矩阵存储每种走法经过每个节点的最小路径和
    public static int minPathSum(int[][] grid) {

        //向右或向下移动
        int[][] move = {{0,1},{1,0}};
        //数组行列数
        int hang = grid.length;
        if(hang == 0) return 0;
        int lie = grid[0].length;
        if(lie == 0) return 0;
        //存储左右移动结果的数组，并初始化为极大值
        int[][] res = new int[hang][lie];
        for (int i = 0;i<hang;i++){
            for (int j = 0;j<lie;j++){
                res[i][j] = Integer.MAX_VALUE;
            }
        }
        //从左上出发，依次刷新到达相邻点的最小路径
        res[0][0] = grid[0][0];
        for (int i = 0;i<hang;i++){
            for (int j = 0;j<lie;j++){
                for (int m = 0;m < 2;m++){
                    int x = i + move[m][0];
                    int y = j + move[m][1];
                    //计算经过当前点到达相邻点的路径和，如果小于之前则更新
                    if(x>=0&&x<hang&&y>=0&&y<lie){
                        if(res[i][j]+grid[x][y]<res[x][y]) res[x][y] = res[i][j]+grid[x][y];
                    }
                }
            }
        }
        return res[hang - 1][lie - 1];
    }
}

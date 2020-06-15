package 回溯法;


/*******************************
 * 剑指offer：机器人的运动范围
 * 题目描述
 *      地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），
 * 因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 * 思路：判断坐标数位和是否大于k,否则加1，遍历
 ******************************/

public class Moving {
    public static void main(String[] args) {
        int i = movingCount(5, 10, 10);
        System.out.println(i);
    }


    //rows行，cols列
    public static int movingCount(int threshold, int rows, int cols)
    {

        boolean[][] matrix = new boolean[rows][cols];

        Counting(threshold, rows, cols, 0, 0, matrix);

        return maxPath;
    }

    private static int maxPath = 0;

    public static void Counting(int threshold, int rows, int cols,int row,int col,boolean[][] matrix)
    {

        //str走到头，匹配成功返回true
        if(isCanMov(threshold,row,col)) return ;
        if(row<rows&&col<cols&&row>=0&&col>=0&&matrix[row][col] ==false){
            maxPath++;
            matrix[row][col] = true;
            //上下左右移动
            int[][] move = {{-1, 0},{0, 1},{1, 0},{0, -1}};

            //继续匹配当前值的上下左右
            for (int i = 0; i < 4; i++) {
                int  newrow = row + move[i][0];
                int newcol = col + move[i][1];
                //边界条件
                Counting(threshold,rows,cols,newrow,newcol,matrix);
            }

        }else return ;

    }

    private static boolean isCanMov(int threshold,int row,int col){
        int total = 0;
        while (row != 0){
            total += row %10;
            row /= 10;
        }
        while (col != 0){
            total += col %10;
            col /= 10;
        }

        if(total>threshold) return true;
        else return false;
    }
}

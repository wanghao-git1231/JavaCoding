package 回溯法;

/****************
 * 根据剑指offer：机器人的运动范围，自己写的，想的负杂了，使用回溯，返回可以连续移动的格子数
 **************/

public class RobotMove {
    public static void main(String[] args) {
        int i = movingCount(5, 10, 10);
        System.out.println(i);
    }
    public static int movingCount(int threshold, int rows, int cols)
    {
        boolean[][] matrix = new boolean[rows][cols];
        maxPath ++;
        Counting(threshold, rows, cols, 0, 0, matrix);
        maxPath--;

        return path;
    }
    private static int maxPath = 0,path = 0;

    public static boolean Counting(int threshold, int rows, int cols,int row,int col,boolean[][] matrix)
    {


        //str走到头，匹配成功返回true
        if(isCanMov(threshold,row,col)) return false;
        if(row<rows&&col<cols&&row>=0&&col>=0&&matrix[row][col] ==false){

            matrix[row][col] = true;
            //上下左右移动
            int[][] move = {{-1, 0},{0, 1},{1, 0},{0, -1}};
            boolean[] res = {false,false,false,false};

            //继续匹配当前值的上下左右
            for (int i = 0; i < 4; i++) {
                int  newrow = row + move[i][0];
                int newcol = col + move[i][1];
                //边界条件
                maxPath++;
                res[i] = Counting(threshold,rows,cols,newrow,newcol,matrix);
                maxPath--;
            }
            if(res[0]||res[1]||res[2]||res[3]){
                return true;
            }else {
                if(maxPath > path) path = maxPath;

                return false;
            }


        }else return false;

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
